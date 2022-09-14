package com.example.test1.entity.wx.wxapplyment;

import com.example.test1.entity.wx.aop.NotBlank;
import com.example.test1.entity.wx.aop.WxSensitiveInformation;
import com.example.test1.entity.wx.wxapplyment.wxenum.IdDocTypeEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 最终受益人信息列表(UBO)
 *
 * @author : panzhenye
 * @date : 2022/9/13 10:46
 */
@Data
@Accessors(chain = true)
public class UboInfo implements Serializable {
    private static final long serialVersionUID = 7418677977313058860L;
    /**
     * 证件类型
     */
    @NotBlank("证件类型")
    private IdDocTypeEnum ubo_id_doc_type;
    /**
     * 证件正面照片
     */
    @NotBlank(value = "证件正面照片")
    private String ubo_id_doc_copy;
    /**
     * 证件反面照片
     */
    @NotBlank(value = "证件反面照片", condition = "ubo_id_doc_type", conditionValue = {"IDENTIFICATION_TYPE_IDCARD", "IDENTIFICATION_TYPE_HONGKONG_PASSPORT",
            "IDENTIFICATION_TYPE_MACAO_PASSPORT", "IDENTIFICATION_TYPE_TAIWAN_PASSPORT", "IDENTIFICATION_TYPE_FOREIGN_RESIDENT",
            "IDENTIFICATION_TYPE_HONGKONG_MACAO_RESIDENT", "IDENTIFICATION_TYPE_TAIWAN_RESIDENT"})
    private String ubo_id_doc_copy_back;
    /**
     * 证件姓名
     */
    @NotBlank(value = "证件姓名")
    @WxSensitiveInformation
    private String ubo_id_doc_name;
    /**
     * 证件号码
     */
    @NotBlank(value = "证件号码")
    @WxSensitiveInformation
    private String ubo_id_doc_number;
    /**
     * 证件居住地址
     */
    @NotBlank(value = "证件居住地址")
    @WxSensitiveInformation
    private String ubo_id_doc_address;
    /**
     * 证件有效期开始时间
     */
    @NotBlank(value = "证件有效期开始时间")
    private String ubo_period_begin;
    /**
     * 证件有效期结束时间
     */
    @NotBlank(value = "证件有效期结束时间")
    private String ubo_period_end;


}
