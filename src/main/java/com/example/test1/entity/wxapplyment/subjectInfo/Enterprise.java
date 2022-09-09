package com.example.test1.entity.wxapplyment.subjectInfo;

import com.example.test1.entity.wxapplyment.subjectInfo.information.BusinessLicenceInfo;
import com.example.test1.entity.wxapplyment.wxenum.SubjectTypeEnum;
import lombok.Data;

/**
 * 企业
 *
 * @author : panzhenye
 * @date : 2022/9/8 20:29
 */
@Data
public class Enterprise extends SubjectInfo {

    /**
     * 营业执照信息
     */
    private BusinessLicenceInfo business_licence_info;

    public Enterprise() {
        setSubject_type(SubjectTypeEnum.SUBJECT_TYPE_ENTERPRISE);
    }

}
