package com.example.test1.entity.wx.wxapplyment.subjectInfo;

import com.example.test1.entity.wx.aop.NotBlank;
import com.example.test1.entity.wx.wxapplyment.wxenum.MicroBizTypeEnum;
import lombok.Data;

/**
 * 辅助证明材料信息
 *
 * @author : panzhenye
 * @date : 2022/9/8 21:36
 */
@Data
public class AssistProveInfo {
    /**
     * 小微经营类型
     */
    @NotBlank("小微经营类型")
    private MicroBizTypeEnum micro_biz_type;
    /**
     * 门店名称
     */
    @NotBlank("门店名称")
    private String store_name;
    /**
     * 门店省市编码
     */
    @NotBlank("门店省市编码")
    private String store_address_code;
    /**
     * 门店地址
     */
    @NotBlank("门店地址")
    private String store_address;
    /**
     * 门店门头照片
     */
    @NotBlank("门店门头照片")
    private String store_header_copy;
    /**
     * 店内环境照片
     */
    @NotBlank("店内环境照片")
    private String store_indoor_copy;

}
