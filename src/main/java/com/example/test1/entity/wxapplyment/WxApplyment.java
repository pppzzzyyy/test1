package com.example.test1.entity.wxapplyment;

import com.example.test1.entity.wxapplyment.contactInfo.ContactInfo;
import com.example.test1.entity.wxapplyment.identificationInfo.IdentificationInfo;
import com.example.test1.entity.wxapplyment.subjectInfo.SubjectInfo;
import lombok.Data;

/**
 * @author : panzhenye
 * @date : 2022/9/8 15:46
 */
@Data
public abstract class WxApplyment {
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

}
