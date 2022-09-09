package com.example.test1.service.impl;
import com.alibaba.fastjson.JSON;
import com.example.test1.controller.TestController;
import com.example.test1.entity.wxapplyment.ChannelMerchant;
import com.example.test1.entity.wxapplyment.Institution;
import com.example.test1.entity.wxapplyment.WxApplyment;
import com.example.test1.entity.wxapplyment.aop.WxUtil;
import com.example.test1.entity.wxapplyment.contactInfo.ContactInfo;
import com.example.test1.entity.wxapplyment.contactInfo.LegalPerson;
import com.example.test1.entity.wxapplyment.contactInfo.Operator;
import com.example.test1.entity.wxapplyment.dto.ParamDTO;
import com.example.test1.entity.wxapplyment.identificationInfo.IdenLegalPerson;
import com.example.test1.entity.wxapplyment.identificationInfo.IdenOperator;
import com.example.test1.entity.wxapplyment.identificationInfo.IdentificationInfo;
import com.example.test1.entity.wxapplyment.subjectInfo.*;
import com.example.test1.entity.wxapplyment.subjectInfo.information.AssistProveInfo;
import com.example.test1.entity.wxapplyment.subjectInfo.information.BusinessLicenceInfo;
import com.example.test1.entity.wxapplyment.subjectInfo.information.CertificateInfo;
import com.example.test1.entity.wxapplyment.subjectInfo.information.FinanceInstitutionInfo;
import com.example.test1.entity.wxapplyment.wxenum.CertTypeEnum;
import com.example.test1.entity.wxapplyment.wxenum.ContactTypeEnum;
import com.example.test1.entity.wxapplyment.wxenum.SubjectTypeEnum;
import com.example.test1.entity.wxapplyment.wxenum.WxApplymentType;
import com.example.test1.service.WxApplymentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author : panzhenye
 * @date : 2022/9/9 13:23
 */
@Service
public class WxApplymentServiceImpl implements WxApplymentService {
    @Override
    public void applyment(ParamDTO paramDTO) {

        WxApplyment wxApplyment = Optional.ofNullable(getWxApplyment(paramDTO)).orElse(new Institution());
        wxApplyment.setContact_info(getContactInfo(paramDTO));
        wxApplyment.setSubject_info(getSubjectInfo(paramDTO));
        wxApplyment.setIdentification_info(getIdentificationInfo(paramDTO));
        WxUtil wxUtil = new WxUtil();
        wxUtil.doEncryptOrDecrypt(wxApplyment, wxApplyment.getClass(), 1);
        System.out.println(JSON.toJSONString(wxApplyment));

    }

    private static WxApplyment getWxApplyment(ParamDTO paramDTO) {
        WxApplymentType wxApplymentType = paramDTO.getWxApplymentType();
        switch (wxApplymentType) {
            case Institution:
                Institution institution = new Institution();
                institution.setChannel_id(paramDTO.getChannel_id());
                institution.setBusiness_code(paramDTO.getBusiness_code());
                return institution;
            case ChannelMerchant:
                ChannelMerchant channelMerchant = new ChannelMerchant();
                channelMerchant.setBusiness_code(paramDTO.getBusiness_code());
                return channelMerchant;
            default:
        }
        return null;
    }

    private static ContactInfo getContactInfo(ParamDTO paramDTO) {
        ContactTypeEnum contactType = paramDTO.getContactType();
        switch (contactType) {
            case LEGAL:
                LegalPerson legalPerson = new LegalPerson();
                legalPerson.setName(paramDTO.getName());
                legalPerson.setId_card_number(paramDTO.getId_card_number());
                legalPerson.setMobile(paramDTO.getMobile());
                return legalPerson;
            case SUPER:
                Operator operator = new Operator();
                operator.setContact_id_doc_type(paramDTO.getContact_id_doc_type());
                operator.setContact_id_doc_copy(paramDTO.getContact_id_doc_copy());
                operator.setContact_id_doc_copy_back(paramDTO.getContact_id_doc_copy_back());
                operator.setContact_period_begin(paramDTO.getContact_period_begin());
                operator.setContact_period_end(paramDTO.getContact_period_end());
                operator.setBusiness_authorization_letter(paramDTO.getBusiness_authorization_letter());
                operator.setName(paramDTO.getName());
                operator.setId_card_number(paramDTO.getId_card_number());
                operator.setMobile(paramDTO.getMobile());
                return operator;
            default:
                return null;
        }
    }

    private static SubjectInfo getSubjectInfo(ParamDTO paramDTO) {
        SubjectTypeEnum subject_type = paramDTO.getSubject_type();
        SubjectInfo subjectInfo = null;

        BusinessLicenceInfo businessLicenceInfo = new BusinessLicenceInfo();
        businessLicenceInfo.setLicence_number(paramDTO.getLicence_number());
        businessLicenceInfo.setLicence_copy(paramDTO.getLicence_copy());
        businessLicenceInfo.setMerchant_name(paramDTO.getMerchant_name());
        businessLicenceInfo.setLegal_person(paramDTO.getLegal_person());
        businessLicenceInfo.setCompany_address(paramDTO.getCompany_address());
        businessLicenceInfo.setLicence_valid_date(paramDTO.getLicence_valid_date());

        CertificateInfo certificateInfo = new CertificateInfo();
        certificateInfo.setCert_number(paramDTO.getCert_number());
        certificateInfo.setCert_copy(paramDTO.getCert_copy());
        certificateInfo.setMerchant_name(paramDTO.getMerchant_name());
        certificateInfo.setLegal_person(paramDTO.getLegal_person());
        certificateInfo.setCompany_address(paramDTO.getCompany_address());
        certificateInfo.setCert_valid_date(paramDTO.getCert_valid_date());

        AssistProveInfo assistProveInfo = new AssistProveInfo();
        assistProveInfo.setMicro_biz_type(paramDTO.getMicro_biz_type());
        assistProveInfo.setStore_name(paramDTO.getStore_name());
        assistProveInfo.setStore_address_code(paramDTO.getStore_address_code());
        assistProveInfo.setStore_address(paramDTO.getStore_address());
        assistProveInfo.setStore_header_copy(paramDTO.getStore_header_copy());
        assistProveInfo.setStore_indoor_copy(paramDTO.getStore_indoor_copy());

        switch (subject_type) {
            case SUBJECT_TYPE_ENTERPRISE:
                Enterprise enterprise = new Enterprise();
                enterprise.setBusiness_licence_info(businessLicenceInfo);
                subjectInfo = enterprise;
                break;
            case SUBJECT_TYPE_INDIVIDUAL:
                Individual individual = new Individual();
                individual.setBusiness_licence_info(businessLicenceInfo);
                subjectInfo = individual;
                break;
            case SUBJECT_TYPE_GOVERNMENT:
                Government government = new Government();
                certificateInfo.setCert_type(CertTypeEnum.CERTIFICATE_TYPE_2389);
                government.setCertificate_info(certificateInfo);
                government.setCompany_prove_copy(paramDTO.getCompany_prove_copy());
                subjectInfo = government;
                break;
            case SUBJECT_TYPE_INSTITUTIONS_CLONED:
                InstitutionsCloned institutionsCloned = new InstitutionsCloned();
                certificateInfo.setCert_type(CertTypeEnum.CERTIFICATE_TYPE_2388);
                institutionsCloned.setCertificate_info(certificateInfo);
                institutionsCloned.setCompany_prove_copy(paramDTO.getCompany_prove_copy());
                subjectInfo = institutionsCloned;
                break;
            case SUBJECT_TYPE_OTHERS:
                Others others = new Others();
                certificateInfo.setCert_type(paramDTO.getCert_type());
                others.setCertificate_info(certificateInfo);
                subjectInfo = others;
                break;
            case SUBJECT_TYPE_MICRO:
                Micro micro = new Micro();
                micro.setAssist_prove_info(assistProveInfo);
                subjectInfo = micro;
                break;
            default:
        }

        if (paramDTO.getIs_finance_institution() != null && paramDTO.getIs_finance_institution()) {
            subjectInfo.setIs_finance_institution(true);
            FinanceInstitutionInfo financeInstitutionInfo = new FinanceInstitutionInfo();
            financeInstitutionInfo.setFinance_type(paramDTO.getFinance_type());
            financeInstitutionInfo.setFinance_license_pics(paramDTO.getFinance_license_pics());
            subjectInfo.setFinance_institution_info(financeInstitutionInfo);
        } else {
            subjectInfo.setIs_finance_institution(false);
        }

        subjectInfo.setSpecial_operation_list(paramDTO.getSpecial_operation_list());
        return subjectInfo;
    }

    private IdentificationInfo getIdentificationInfo(ParamDTO paramDTO) {
        IdentificationInfo ident = null;
        SubjectTypeEnum subject_type = paramDTO.getSubject_type();
        ContactTypeEnum id_holder_type = paramDTO.getId_holder_type();

        IdenLegalPerson idenLe = new IdenLegalPerson();
        idenLe.setIdentification_type(paramDTO.getIdentification_type());

        IdenOperator idenOpe = new IdenOperator();
        idenOpe.setAuthorize_letter_copy(paramDTO.getAuthorize_letter_copy());

        switch (id_holder_type) {
            case LEGAL:
                ident = idenLe;
                idenLe.setIdentification_name(paramDTO.getIdentification_name());
                idenLe.setIdentification_number(paramDTO.getIdentification_number());
                idenLe.setIdentification_valid_date(paramDTO.getIdentification_valid_date());
                break;
            case SUPER:
                ident = idenOpe;
                break;
            default:
        }
        switch (subject_type) {
            case SUBJECT_TYPE_ENTERPRISE:
                idenLe.setIdentification_address(paramDTO.getIdentification_address());
                idenLe.setOwner(paramDTO.getOwner());
                ident = idenLe;
                break;
            case SUBJECT_TYPE_INDIVIDUAL:
                ident = idenLe;

                break;
            case SUBJECT_TYPE_OTHERS:
                ident = idenLe;

                break;
            case SUBJECT_TYPE_MICRO:

                break;
            case SUBJECT_TYPE_GOVERNMENT:
                break;
            case SUBJECT_TYPE_INSTITUTIONS_CLONED:
                break;
            default:
        }
        return ident;
    }

    public static void main(String[] args) {

        ParamDTO paramDTO = TestController.getParamDTO();

        if (StringUtils.isNotBlank(TestController.checkParams(paramDTO))) {
            System.out.println(TestController.checkParams(paramDTO));
            return;
        }

        WxApplyment wxApplyment = Optional.ofNullable(getWxApplyment(paramDTO)).orElse(new Institution());
        wxApplyment.setContact_info(getContactInfo(paramDTO));
        wxApplyment.setSubject_info(getSubjectInfo(paramDTO));
        WxUtil wxUtil = new WxUtil();
        wxUtil.doEncryptOrDecrypt(wxApplyment, wxApplyment.getClass(), 1);
        System.out.println(JSON.toJSONString(wxApplyment));

    }
}
