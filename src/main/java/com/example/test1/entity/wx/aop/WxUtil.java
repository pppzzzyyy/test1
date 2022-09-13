package com.example.test1.entity.wx.aop;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.cert.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;
import java.util.List;

/**
 * 微信敏感信息加解密工具类
 * <p>
 * {@link WxSensitiveInformation}
 *
 * @author : panzhenye
 * @date : 2022/9/8 16:26
 */
@Data
@Slf4j
public class WxUtil {
    /**
     * 证书路径
     */
    private String cerFilename;
    /**
     * 商户私钥路径
     */
    private String priFilename;
    private static final String TEST_FIELDS = "pzy";

    /**
     * 敏感信息加解密
     *
     * @param type 1.加密；2.解密；（默认加密，其他加密）
     */
    public void doEncryptOrDecrypt(Object t, Class<?> aClass, int type) {
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            log.debug("加解密字段：{}", declaredField.getName());
            declaredField.setAccessible(true);
            Object o = null;
            try {
                o = declaredField.get(t);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
            if (o == null) {
                continue;
            }
            //枚举
            if (declaredField.getType().equals(aClass)) {
                log.debug(o + "是枚举类");
                return;
            }
            //判断类型
            if (o instanceof String) {
                if (declaredField.isAnnotationPresent(WxSensitiveInformation.class)) {
                    log.info("{}字段加解密", declaredField.getName());
                    String str = o.toString();
                    if (type != 2) {
//                        doEncrypt(t, declaredField, str);
                        doEncryptTest(t, declaredField, str);
                    } else {
//                        doDecrypt(t, declaredField, str);
                        doDecryptTest(t, declaredField, str);
                    }
                } else {
                    log.debug("{}字段无需加解密", declaredField.getName());
                }
            } else if (o instanceof List) {
                log.debug("{}是List", declaredField.getName());
            } else {
                log.debug("加解密{}字段里面的字段", declaredField.getName());
                doEncryptOrDecrypt(o, o.getClass(), type);
            }
        }
        //父类
        Class<?> superclass = aClass.getSuperclass();
        if (superclass != null && aClass.getPackage().getName().equals(superclass.getPackage().getName())) {
            log.debug("加解密{}父类{}里面的字段", aClass.getSimpleName(), superclass.getSimpleName());
            doEncryptOrDecrypt(t, superclass, type);
        }
    }

    private <T> void doEncrypt(T t, Field declaredField, String str) {
        try {
            X509Certificate certificate = getCertificate(cerFilename);
            String s = rsaEncryptOAEP(str, certificate);
            declaredField.set(t, s);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private <T> void doEncryptTest(T t, Field declaredField, String str) {
        try {
            declaredField.set(t, str + TEST_FIELDS);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private <T> void doDecrypt(T t, Field declaredField, String str) {
        try {
            PrivateKey privateKey = getPrivateKey(priFilename);
            String s = rsaDecryptOAEP(str, privateKey);
            declaredField.set(t, s);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    private <T> void doDecryptTest(T t, Field declaredField, String str) {
        if (str.endsWith(TEST_FIELDS)) {
            try {
                declaredField.set(t, str.substring(0, str.length() - 3));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取证书。
     *
     * @param filename 证书文件路径  (required)
     * @return X509证书
     */
    public static X509Certificate getCertificate(String filename) throws IOException {
        InputStream fis = new FileInputStream(filename);
        BufferedInputStream bis = new BufferedInputStream(fis);

        try {
            CertificateFactory cf = CertificateFactory.getInstance("X509");
            X509Certificate cert = (X509Certificate) cf.generateCertificate(bis);
            cert.checkValidity();
            return cert;
        } catch (CertificateExpiredException e) {
            throw new RuntimeException("证书已过期", e);
        } catch (CertificateNotYetValidException e) {
            throw new RuntimeException("证书尚未生效", e);
        } catch (CertificateException e) {
            throw new RuntimeException("无效的证书文件", e);
        } finally {
            bis.close();
        }
    }

    public static String rsaEncryptOAEP(String message, X509Certificate certificate) throws IllegalBlockSizeException, IOException {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, certificate.getPublicKey());

            byte[] data = message.getBytes("utf-8");
            byte[] cipherdata = cipher.doFinal(data);
            return Base64.getEncoder().encodeToString(cipherdata);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
            throw new RuntimeException("当前Java环境不支持RSA v1.5/OAEP", e);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException("无效的证书", e);
        } catch (IllegalBlockSizeException | BadPaddingException e) {
            throw new IllegalBlockSizeException("加密原串的长度不能超过214字节");
        }
    }

    /**
     * 获取私钥。
     *
     * @param filename 私钥文件路径  (required)
     * @return 私钥对象
     */
    public static PrivateKey getPrivateKey(String filename) throws IOException {

        String content = new String(Files.readAllBytes(Paths.get(filename)), "utf-8");
        try {
            String privateKey = content.replace("-----BEGIN PRIVATE KEY-----", "")
                    .replace("-----END PRIVATE KEY-----", "")
                    .replaceAll("\\s+", "");

            KeyFactory kf = KeyFactory.getInstance("RSA");
            return kf.generatePrivate(
                    new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey)));
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("当前Java环境不支持RSA", e);
        } catch (InvalidKeySpecException e) {
            throw new RuntimeException("无效的密钥格式");
        }
    }

    public static String rsaDecryptOAEP(String ciphertext, PrivateKey privateKey) throws BadPaddingException, IOException {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);

            byte[] data = Base64.getDecoder().decode(ciphertext);
            return new String(cipher.doFinal(data), "utf-8");
        } catch (NoSuchPaddingException | NoSuchAlgorithmException e) {
            throw new RuntimeException("当前Java环境不支持RSA v1.5/OAEP", e);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException("无效的私钥", e);
        } catch (BadPaddingException | IllegalBlockSizeException e) {
            throw new BadPaddingException("解密失败");
        }
    }
}
