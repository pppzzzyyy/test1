package com.example.test1.entity.wx.wxapplyment.subjectInfo;

import lombok.Data;

import java.util.List;

/**
 * 经营许可证
 *
 * @author : panzhenye
 * @date : 2022/9/8 21:43
 */
@Data
public class SpecialOperation {
    /**
     * 行业类目id
     */
    private Integer category_id;
    /**
     * 行业经营许可证资质照片
     */
    private List<String> operation_copy_list;
}
