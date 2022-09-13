package com.example.test1.entity.wx.wxapplyment.subjectInfo;

import lombok.Data;

/**
 * 营业执照信息
 *
 * @author : panzhenye
 * @date : 2022/9/8 21:27
 */
@Data
public class BusinessLicenceInfo {
    /**
     * 营业执照注册号
     */
    private String licence_number;
    /**
     * 营业执照照片
     */
    private String licence_copy;
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
     * 营业执照有效日期
     */
    private String licence_valid_date;
}
