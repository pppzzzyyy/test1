package com.example.test1.entity.wxapplyment.wxenum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author : panzhenye
 * @date : 2022/9/8 19:27
 */
@NoArgsConstructor
@AllArgsConstructor
public enum SubjectTypeEnum {
    /**
     * 企业
     */
    SUBJECT_TYPE_ENTERPRISE("企业"),
    /**
     * 事业单位
     */
    SUBJECT_TYPE_INSTITUTIONS_CLONED("事业单位"),
    /**
     * 个体工商户
     */
    SUBJECT_TYPE_INDIVIDUAL("个体工商户"),
    /**
     * 社会组织
     */
    SUBJECT_TYPE_OTHERS("社会组织"),
    /**
     * 小微商户
     */
    SUBJECT_TYPE_MICRO("小微商户"),
    /**
     * 政府机关
     */
    SUBJECT_TYPE_GOVERNMENT("政府机关");

    /**
     * 描述
     */
    @Getter
    @Setter
    private String desc;
}
