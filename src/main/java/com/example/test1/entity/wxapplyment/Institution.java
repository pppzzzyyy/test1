package com.example.test1.entity.wxapplyment;

import lombok.Data;

/**
 * 从业机构
 *
 * @author : panzhenye
 * @date : 2022/9/8 15:50
 */
@Data
public class Institution extends WxApplyment {
    /**
     * 渠道商户号
     */
    private String channel_id;

}
