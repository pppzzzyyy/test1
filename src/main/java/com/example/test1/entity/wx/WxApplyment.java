package com.example.test1.entity.wx;

import com.example.test1.entity.wx.wxapplyment.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author : panzhenye
 * @date : 2022/9/8 15:46
 */
@Data
@Accessors(chain = true)
public class WxApplyment {
    /**
     * 渠道商户号
     */
    private String channel_id;
    /**
     * 业务申请编号
     */
    private String business_code;

    /**
     * 联系人信息
     */
    private ContactInfo contact_info;

    /**
     * 主体信息
     */
    private SubjectInfo subject_info;

    /**
     * 法人身份信息
     */
    private IdentificationInfo identification_info;

    /**
     * 最终受益人信息列表(UBO)
     */
    private List<UboInfo> ubo_info_list;

    /**
     * 补充材料
     */
    private AdditionInfo addition_info;
}
