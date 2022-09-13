package com.example.test1.entity.wx.wxapplyment.subjectInfo;

import com.example.test1.entity.wx.wxapplyment.wxenum.FinanceTypeEnum;
import lombok.Data;

import java.util.List;

/**
 * 金融机构许可证
 *
 * @author : panzhenye
 * @date : 2022/9/8 21:46
 */
@Data
public class FinanceInstitutionInfo {
    /**
     * 金融机构类型
     */
    private FinanceTypeEnum finance_type;
    /**
     * 金融机构许可证图片
     */
    private List<String> finance_license_pics;

}
