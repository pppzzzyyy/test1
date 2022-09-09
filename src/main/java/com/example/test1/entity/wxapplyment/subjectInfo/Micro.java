package com.example.test1.entity.wxapplyment.subjectInfo;

import com.example.test1.entity.wxapplyment.subjectInfo.information.AssistProveInfo;
import com.example.test1.entity.wxapplyment.wxenum.SubjectTypeEnum;
import lombok.Data;

/**
 * @author : panzhenye
 * @date : 2022/9/8 21:36
 */
@Data
public class Micro extends SubjectInfo {

    /**
     * 辅助证明材料信息
     */
    private AssistProveInfo assist_prove_info;

    public Micro() {
        setSubject_type(SubjectTypeEnum.SUBJECT_TYPE_MICRO);
    }

}
