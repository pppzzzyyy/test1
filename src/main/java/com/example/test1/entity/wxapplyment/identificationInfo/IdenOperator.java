package com.example.test1.entity.wxapplyment.identificationInfo;

import com.example.test1.entity.wxapplyment.wxenum.ContactTypeEnum;
import lombok.Data;

/**
 * 经办人
 *
 * @author : panzhenye
 * @date : 2022/9/9 15:28
 */
@Data
public class IdenOperator extends IdentificationInfo {
    /**
     * 法定代表人说明函
     */
    private String authorize_letter_copy;
    public IdenOperator() {
        setId_holder_type(ContactTypeEnum.SUPER);
    }
}
