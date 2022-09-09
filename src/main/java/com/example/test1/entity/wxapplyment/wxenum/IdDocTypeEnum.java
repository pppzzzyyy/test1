package com.example.test1.entity.wxapplyment.wxenum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 证件类型
 *
 * @author : panzhenye
 * @date : 2022/9/8 17:30
 */
@NoArgsConstructor
@AllArgsConstructor
public enum IdDocTypeEnum {
    /**
     * 中国大陆居民-身份证
     */
    IDENTIFICATION_TYPE_IDCARD("中国大陆居民-身份证"),

    /**
     * 其他国家或地区居民-护照
     */
    IDENTIFICATION_TYPE_OVERSEA_PASSPORT("其他国家或地区居民-护照"),

    /**
     * 中国香港居民-来往内地通行证
     */
    IDENTIFICATION_TYPE_HONGKONG_PASSPORT("中国香港居民-来往内地通行证"),

    /**
     * 中国澳门居民-来往内地通行证
     */
    IDENTIFICATION_TYPE_MACAO_PASSPORT("中国澳门居民-来往内地通行证"),

    /**
     * 中国台湾居民-来往大陆通行证
     */
    IDENTIFICATION_TYPE_TAIWAN_PASSPORT("中国台湾居民-来往大陆通行证"),

    /**
     * 外国人居留证
     */
    IDENTIFICATION_TYPE_FOREIGN_RESIDENT("外国人居留证"),

    /**
     * 港澳居民证
     */
    IDENTIFICATION_TYPE_HONGKONG_MACAO_RESIDENT("港澳居民证"),

    /**
     * 台湾居民证
     */
    IDENTIFICATION_TYPE_TAIWAN_RESIDENT("台湾居民证");

    /**
     * 描述
     */
    @Getter
    @Setter
    private String desc;
}
