package com.example.test1.entity.wxapplyment.contactInfo;

import com.example.test1.entity.wxapplyment.wxenum.ContactTypeEnum;
import lombok.Data;

/**
 * 法人
 *
 * @author : panzhenye
 * @date : 2022/9/8 16:07
 */
@Data
public class LegalPerson extends ContactInfo {

    public LegalPerson() {
        setContact_type(ContactTypeEnum.LEGAL);
    }
}
