package com.example.test1.entity.wx.wxapplyment;

import com.example.test1.entity.wx.wxapplyment.subjectInfo.*;
import com.example.test1.entity.wx.wxapplyment.wxenum.SubjectTypeEnum;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * 主体信息
 *
 * @author : panzhenye
 * @date : 2022/9/8 19:26
 */
@Data
@Accessors(chain = true)
public class SubjectInfo {

    /**
     * 主体类型
     */
    private SubjectTypeEnum subject_type;

    /**
     * 是否金融机构
     */
    private Boolean is_finance_institution;

    /**
     * 营业执照信息
     */
    private BusinessLicenceInfo business_licence_info;
    /**
     * 登记证书信息
     */
    private CertificateInfo certificate_info;
    /**
     * 单位证明函照片
     */
    private String company_prove_copy;
    /**
     * 辅助证明材料信息
     */
    private AssistProveInfo assist_prove_info;
    /**
     * 经营许可证
     */
    private List<SpecialOperation> special_operation_list;

    /**
     * 金融机构许可证
     */
    private FinanceInstitutionInfo finance_institution_info;

}
