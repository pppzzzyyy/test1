package com.example.test1.entity.wxapplyment.identificationInfo;

import com.example.test1.entity.wxapplyment.wxenum.ContactTypeEnum;
import lombok.Data;

/**
 * 法人身份信息
 *
 * @author : panzhenye
 * @date : 2022/9/9 15:22
 */
@Data
public abstract class IdentificationInfo {
    /**
     * 证件持有人类型
     */
    private ContactTypeEnum id_holder_type;
}
