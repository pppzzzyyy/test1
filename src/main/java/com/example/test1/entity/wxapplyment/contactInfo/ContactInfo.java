package com.example.test1.entity.wxapplyment.contactInfo;

import com.example.test1.entity.wxapplyment.aop.WxSensitiveInformation;
import com.example.test1.entity.wxapplyment.wxenum.ContactTypeEnum;
import lombok.Data;

/**
 * 联系人信息
 *
 * @author : panzhenye
 * @date : 2022/9/8 16:04
 */
@Data
public abstract class ContactInfo {
    /**
     * 联系人类型
     */
    private ContactTypeEnum contact_type;

    /**
     * 姓名
     */
    @WxSensitiveInformation
    private String name;

    /**
     * 联系人证件号码
     */
    @WxSensitiveInformation
    private String id_card_number;

    /**
     * 联系人手机号
     */
    @WxSensitiveInformation
    private String mobile;
}
