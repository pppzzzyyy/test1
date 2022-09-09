package com.example.test1.entity.wxapplyment.wxenum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 小微经营类型
 *
 * @author : panzhenye
 * @date : 2022/9/8 21:40
 */
@NoArgsConstructor
@AllArgsConstructor
public enum MicroBizTypeEnum {

    /**
     * 门店场所
     */
    MICRO_TYPE_STORE("门店场所"),
    /**
     * 流动经营/便民服务
     */
    MICRO_TYPE_MOBILE("流动经营/便民服务"),
    /**
     * 线上商品/服务交易
     */
    MICRO_TYPE_ONLINE("线上商品/服务交易");
    /**
     * 描述
     */
    @Getter
    @Setter
    private String desc;
}
