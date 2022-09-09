package com.example.test1.entity.wxapplyment.subjectInfo;

import com.example.test1.entity.wxapplyment.subjectInfo.information.BusinessLicenceInfo;
import com.example.test1.entity.wxapplyment.wxenum.SubjectTypeEnum;
import lombok.Data;

/**
 * 个体工商户
 *
 * @author : panzhenye
 * @date : 2022/9/8 20:30
 */
@Data
public class Individual extends SubjectInfo {

    /**
     * 营业执照信息
     */
    private BusinessLicenceInfo business_licence_info;

    public Individual() {
        setSubject_type(SubjectTypeEnum.SUBJECT_TYPE_INDIVIDUAL);
    }

}
