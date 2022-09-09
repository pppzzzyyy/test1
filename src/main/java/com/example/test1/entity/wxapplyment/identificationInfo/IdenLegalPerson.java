package com.example.test1.entity.wxapplyment.identificationInfo;

import com.example.test1.entity.wxapplyment.aop.WxSensitiveInformation;
import com.example.test1.entity.wxapplyment.wxenum.ContactTypeEnum;
import com.example.test1.entity.wxapplyment.wxenum.IdDocTypeEnum;
import lombok.Data;

/**
 * 法人
 *
 * @author : panzhenye
 * @date : 2022/9/9 15:27
 */
@Data
public class IdenLegalPerson extends IdentificationInfo {

    /**
     * 证件类型
     */
    private IdDocTypeEnum identification_type;

    /**
     * 证件姓名
     */
    @WxSensitiveInformation
    private String identification_name;

    /**
     * 联系人证件号码
     */
    @WxSensitiveInformation
    private String identification_number;

    private String identification_valid_date;

    @WxSensitiveInformation
    private String identification_address;

    private String identification_front_copy;

    private String identification_back_copy;

    /**
     * 经营者/法人是否为受益人
     */
    private Boolean owner;



    public IdenLegalPerson() {
        setId_holder_type(ContactTypeEnum.LEGAL);
    }
}
