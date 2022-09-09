package com.example.test1.entity.wxapplyment.subjectInfo;

import com.example.test1.entity.wxapplyment.subjectInfo.information.CertificateInfo;
import com.example.test1.entity.wxapplyment.wxenum.SubjectTypeEnum;
import lombok.Data;

/**
 * 社会组织
 *
 * @author : panzhenye
 * @date : 2022/9/8 21:21
 */
@Data
public class Others extends SubjectInfo {
    private CertificateInfo certificate_info;

    public Others() {
        setSubject_type(SubjectTypeEnum.SUBJECT_TYPE_OTHERS);
    }

}
