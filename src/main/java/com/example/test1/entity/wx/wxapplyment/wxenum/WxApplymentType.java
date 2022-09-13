package com.example.test1.entity.wx.wxapplyment.wxenum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 调用方
 *
 * @author : panzhenye
 * @date : 2022/9/8 20:40
 */
@NoArgsConstructor
@AllArgsConstructor
public enum WxApplymentType {
    /**
     * 从业机构
     */
    Institution("从业机构"),
    /**
     * 渠道商户
     */
    ChannelMerchant("渠道商户");

    /**
     * 描述
     */
    @Getter
    @Setter
    private String desc;
}
