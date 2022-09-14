package com.example.test1.entity.wx.wxapplyment;

import com.example.test1.entity.wx.aop.NotBlank;
import com.example.test1.entity.wx.aop.WxSensitiveInformation;
import com.example.test1.entity.wx.wxapplyment.wxenum.ContactTypeEnum;
import com.example.test1.entity.wx.wxapplyment.wxenum.IdDocTypeEnum;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 法人身份信息
 *
 * @author : panzhenye
 * @date : 2022/9/9 15:22
 */
@Data
@Accessors(chain = true)
public class IdentificationInfo {
    /**
     * 证件持有人类型
     */
    private ContactTypeEnum id_holder_type;
    /**
     * 证件类型
     */
    @NotBlank(value = "证件类型", condition = "id_holder_type", conditionValue = "LEGAL")
    private IdDocTypeEnum identification_type;
    /**
     * 法定代表人说明函
     */
    @NotBlank(value = "法定代表人说明函", condition = "id_holder_type", conditionValue = "SUPER")
    private String authorize_letter_copy;

    /**
     * 证件姓名
     */
    @WxSensitiveInformation
    @NotBlank(value = "证件姓名", condition = "id_holder_type", conditionValue = "LEGAL")
    private String identification_name;

    /**
     * 证件号码
     */
    @WxSensitiveInformation
    @NotBlank(value = "证件号码", condition = "id_holder_type", conditionValue = "LEGAL")
    private String identification_number;

    /**
     * 证件有效日期
     */
    @NotBlank(value = "证件有效日期", condition = "id_holder_type", conditionValue = "LEGAL")
    private String identification_valid_date;

    /**
     * 证件居住地址
     */
    @WxSensitiveInformation
    private String identification_address;
    /**
     * 证件正面照片
     */
    @NotBlank(value = "证件正面照片", condition = "id_holder_type", conditionValue = "LEGAL")
    private String identification_front_copy;
    /**
     * 证件反面照片
     */
    @NotBlank(value = "证件反面照片", condition = "id_holder_type", conditionValue = "LEGAL")
    private String identification_back_copy;

    /**
     * 经营者/法人是否为受益人
     */
    private Boolean owner;
}
