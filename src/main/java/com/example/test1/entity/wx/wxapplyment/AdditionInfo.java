package com.example.test1.entity.wx.wxapplyment;

import lombok.Data;

import java.util.List;

/**
 * @author : panzhenye
 * @date : 2022/9/13 10:51
 */
@Data
public class AdditionInfo {
    /**
     * 待确认商户号列表
     */
    private List<String> confirm_mchid_list;
}
