package com.example.test1.entity.wx.wxapplyment;

import com.example.test1.entity.wx.aop.NotBlank;
import com.example.test1.entity.wx.aop.WxSensitiveInformation;
import com.example.test1.entity.wx.wxapplyment.wxenum.ContactTypeEnum;
import com.example.test1.entity.wx.wxapplyment.wxenum.IdDocTypeEnum;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 联系人信息
 *
 * @author : panzhenye
 * @date : 2022/9/8 16:04
 */
@Data
@Accessors(chain = true)
public class ContactInfo {
    /**
     * 联系人类型
     */
    @NotBlank("联系人类型")
    private ContactTypeEnum contact_type;

    /**
     * 联系人姓名
     */
    @WxSensitiveInformation
    @NotBlank("联系人姓名")
    private String name;

    /**
     * 联系人证件类型
     */
    @NotBlank(value = "联系人证件类型",condition = "contact_type",conditionValue = "SUPER")
    private IdDocTypeEnum contact_id_doc_type;

    /**
     * 联系人证件号码
     */
    @WxSensitiveInformation
    private String id_card_number;

    /**
     * 联系人证件正面照片
     */
    @NotBlank(value = "联系人证件正面照片",condition = "contact_type",conditionValue = "SUPER")
    private String contact_id_doc_copy;

    /**
     * 联系人证件反面照片
     */
    @NotBlank(value = "联系人证件反面照片",condition = "contact_type",conditionValue = "SUPER")
    private String contact_id_doc_copy_back;

    /**
     * 联系人证件有效期开始时间
     */
    @NotBlank(value = "联系人证件有效期开始时间",condition = "contact_type",conditionValue = "SUPER")
    private String contact_period_begin;

    /**
     * 联系人证件有效期结束时间
     */
    @NotBlank(value = "联系人证件有效期结束时间",condition = "contact_type",conditionValue = "SUPER")
    private String contact_period_end;

    /**
     * 业务办理授权函
     */
    @NotBlank(value = "业务办理授权函",condition = "contact_type",conditionValue = "SUPER")
    private String business_authorization_letter;

    /**
     * 联系人手机号
     */
    @WxSensitiveInformation
    @NotBlank("联系人手机号")
    private String mobile;
}
