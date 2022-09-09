package com.example.test1.entity.wxapplyment.subjectInfo;

import com.example.test1.entity.wxapplyment.subjectInfo.information.CertificateInfo;
import com.example.test1.entity.wxapplyment.wxenum.SubjectTypeEnum;
import lombok.Data;

/**
 * 政府机关
 *
 * @author : panzhenye
 * @date : 2022/9/8 21:21
 */
@Data
public class Government extends SubjectInfo {
    /**
     * 登记证书信息
     */
    private CertificateInfo certificate_info;
    /**
     * 单位证明函照片
     */
    private String company_prove_copy;

    public Government() {
        setSubject_type(SubjectTypeEnum.SUBJECT_TYPE_GOVERNMENT);
    }

}
