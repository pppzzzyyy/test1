package com.example.test1.entity.wxapplyment.subjectInfo;

import com.example.test1.entity.wxapplyment.subjectInfo.information.CertificateInfo;
import com.example.test1.entity.wxapplyment.wxenum.SubjectTypeEnum;
import lombok.Data;

/**
 * 事业单位
 * @author : panzhenye
 * @date : 2022/9/8 21:20
 */
@Data
public class InstitutionsCloned extends SubjectInfo{
    /**
     * 登记证书信息
     */
    private CertificateInfo certificate_info;
    /**
     * 单位证明函照片
     */
    private String company_prove_copy;

    public InstitutionsCloned() {
        setSubject_type(SubjectTypeEnum.SUBJECT_TYPE_INSTITUTIONS_CLONED);
    }

}
