package com.example.test1.entity.wxapplyment.dto;

import com.example.test1.entity.wxapplyment.subjectInfo.information.SpecialOperationList;
import com.example.test1.entity.wxapplyment.wxenum.*;
import lombok.Data;

import java.util.List;

/**
 * @author : panzhenye
 * @date : 2022/9/8 20:36
 */
@Data
public class ParamDTO {
    private WxApplymentType wxApplymentType;
    private String channel_id;
    private String business_code;

    private ContactTypeEnum contactType;
    private String name;
    private String id_card_number;
    private String mobile;

    private IdDocTypeEnum contact_id_doc_type;
    private String contact_id_doc_copy;
    private String contact_id_doc_copy_back;
    private String contact_period_begin;
    private String contact_period_end;
    private String business_authorization_letter;

    private SubjectTypeEnum subject_type;
    private Boolean is_finance_institution;
    private String licence_number;
    private String licence_copy;
    private String merchant_name;
    private String legal_person;
    private String company_address;
    private String licence_valid_date;

    private String company_prove_copy;

    private CertTypeEnum cert_type;

    private List<SpecialOperationList> special_operation_list;

    private FinanceTypeEnum finance_type;
    private List<String> finance_license_pics;
    private String cert_number;
    private String cert_copy;
    private String cert_valid_date;

    private MicroBizTypeEnum micro_biz_type;
    private String store_name;
    private String store_address_code;
    private String store_address;
    private String store_header_copy;
    private String store_indoor_copy;

    private ContactTypeEnum id_holder_type;
    private IdDocTypeEnum identification_type;
    private String authorize_letter_copy;
    private String identification_name;
    private String identification_number;
    private String identification_valid_date;
    private String identification_address;
    private Boolean owner;

}
