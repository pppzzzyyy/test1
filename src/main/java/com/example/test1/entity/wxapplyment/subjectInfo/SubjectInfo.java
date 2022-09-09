package com.example.test1.entity.wxapplyment.subjectInfo;

import com.example.test1.entity.wxapplyment.subjectInfo.information.FinanceInstitutionInfo;
import com.example.test1.entity.wxapplyment.subjectInfo.information.SpecialOperationList;
import com.example.test1.entity.wxapplyment.wxenum.SubjectTypeEnum;
import lombok.Data;

import java.util.List;

/**
 * 主体信息
 *
 * @author : panzhenye
 * @date : 2022/9/8 19:26
 */
@Data
public abstract class SubjectInfo {

    /**
     * 主体类型
     */
    private SubjectTypeEnum subject_type;

    /**
     * 是否金融机构
     */
    private Boolean is_finance_institution;

    /**
     * 当主体是金融机构时，必填
     */
    private FinanceInstitutionInfo finance_institution_info;

    /**
     * 经营许可证(非必填)
     */
    private List<SpecialOperationList> special_operation_list;
}
