package com.example.test1.entity.wx.wxapplyment.wxenum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author : panzhenye
 * @date : 2022/9/8 16:13
 */
@NoArgsConstructor
@AllArgsConstructor
public enum ContactTypeEnum {
    /**
     * 小微/个人卖家,个体工商户/企业/政府机关/事业单位/社会组织
     */
    LEGAL("经营者/法人"),
    /**
     * 经商户授权办理微信支付业务的人员
     */
    SUPER("经办人");

    /**
     * 描述
     */
    @Getter
    @Setter
    private String desc;

}
