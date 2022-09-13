package com.example.test1.entity.wx.wxapplyment.wxenum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author : panzhenye
 * @date : 2022/9/9 10:48
 */
@NoArgsConstructor
@AllArgsConstructor
public enum CertTypeEnum {

    /**
     * 事业单位法人证书
     */
    CERTIFICATE_TYPE_2388("事业单位法人证书"),
    /**
     * 统一社会信用代码证书
     */
    CERTIFICATE_TYPE_2389("统一社会信用代码证书"),
    /**
     * 社会团体法人登记证书
     */
    CERTIFICATE_TYPE_2394("社会团体法人登记证书"),
    /**
     * 民办非企业单位登记证书
     */
    CERTIFICATE_TYPE_2395("民办非企业单位登记证书"),
    /**
     * 基金会法人登记证书
     */
    CERTIFICATE_TYPE_2396("基金会法人登记证书"),
    /**
     * 执业许可证/执业证
     */
    CERTIFICATE_TYPE_2520("执业许可证/执业证"),
    /**
     * 基层群众性自治组织特别法人统一社会信用代码证
     */
    CERTIFICATE_TYPE_2521("基层群众性自治组织特别法人统一社会信用代码证"),
    /**
     * 农村集体经济组织登记证
     */
    CERTIFICATE_TYPE_2522("农村集体经济组织登记证"),
    /**
     * 宗教活动场所登记证
     */
    CERTIFICATE_TYPE_2399("宗教活动场所登记证"),
    /**
     * 政府部门下发的其他有效证明文件
     */
    CERTIFICATE_TYPE_2400("政府部门下发的其他有效证明文件");

    /**
     * 描述
     */
    @Getter
    @Setter
    private String desc;
}
