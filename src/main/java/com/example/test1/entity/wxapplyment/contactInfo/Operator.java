package com.example.test1.entity.wxapplyment.contactInfo;

import com.example.test1.entity.wxapplyment.wxenum.IdDocTypeEnum;
import com.example.test1.entity.wxapplyment.wxenum.ContactTypeEnum;
import lombok.Data;

/**
 * 经办人
 *
 * @author : panzhenye
 * @date : 2022/9/8 16:09
 */
@Data
public class Operator extends ContactInfo {

    public Operator() {
        setContact_type(ContactTypeEnum.SUPER);
    }

    /**
     * 联系人证件类型
     */
    private IdDocTypeEnum contact_id_doc_type;

    /**
     * 联系人证件正面照片
     */
    private String contact_id_doc_copy;

    /**
     * 联系人证件反面照片
     */
    private String contact_id_doc_copy_back;

    /**
     * 联系人证件有效期开始时间
     */
    private String contact_period_begin;

    /**
     * 联系人证件有效期结束时间
     */
    private String contact_period_end;

    /**
     * 业务办理授权函
     */
    private String business_authorization_letter;


}
