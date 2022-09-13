package com.example.test1.entity.wx.wxapplyment.subjectInfo;

import com.example.test1.entity.wx.wxapplyment.wxenum.CertTypeEnum;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 登记证书信息
 *
 * @author : panzhenye
 * @date : 2022/9/8 21:29
 */
@Data
@Accessors(chain = true)
public class CertificateInfo {
    /**
     * 证书类型
     */
    private CertTypeEnum cert_type;
    /**
     * 证书编号
     */
    private String cert_number;
    /**
     * 证书照片
     */
    private String cert_copy;
    /**
     * 商户名称
     */
    private String merchant_name;
    /**
     * 法人姓名
     */
    private String legal_person;
    /**
     * 注册地址
     */
    private String company_address;
    /**
     * 证书有效日期
     */
    private String cert_valid_date;

}
