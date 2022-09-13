package com.example.test1.entity.wx.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 微信敏感信息
 * <p>
 * {@link WxUtil}
 *
 * @author : panzhenye
 * @date : 2022/9/8 16:24
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface WxSensitiveInformation {
}
