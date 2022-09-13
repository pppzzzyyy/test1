package com.example.test1.controller;

import com.alibaba.fastjson.JSON;
import com.example.test1.entity.wx.WxApplyment;
import com.example.test1.entity.wx.wxapplyment.*;
import com.example.test1.entity.wx.wxapplyment.subjectInfo.BusinessLicenceInfo;
import com.example.test1.entity.wx.wxapplyment.subjectInfo.CertificateInfo;
import com.example.test1.entity.wx.wxapplyment.subjectInfo.FinanceInstitutionInfo;
import com.example.test1.entity.wx.wxapplyment.subjectInfo.SpecialOperation;
import com.example.test1.entity.wx.wxapplyment.wxenum.*;
import com.example.test1.service.TestService;
import com.example.test1.service.WxApplymentService;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : panzhenye
 * @date : 2022/9/7 18:14
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private WxApplymentService wxApplymentService;

    @RequestMapping("test1")
    public String test1() {
        WxApplyment wxApplyment = getWxApplyment();

        if (StringUtils.isNotBlank(checkParams(wxApplyment))) {
            System.out.println(checkParams(wxApplyment));
            return "success";
        }

        wxApplymentService.applyment(wxApplyment);

        return "success";
    }

    public static WxApplyment getWxApplyment() {
        WxApplyment wxApplyment = new WxApplyment()
                .setChannel_id("20001111")
                .setBusiness_code("1900013511_10000")
                .setContact_info(new ContactInfo()
                        .setName("李四要加密的")
                        .setMobile("13812345678要加密的")
                        .setId_card_number("362302200010101234要加密的")
                        .setContact_type(ContactTypeEnum.LEGAL)
                        .setContact_id_doc_type(IdDocTypeEnum.IDENTIFICATION_TYPE_IDCARD)
                        .setContact_id_doc_copy("jTpGmxUXqRTvDujqhThn4ReFxikqJ5YW6zFQ")
                        .setContact_id_doc_copy_back("jTpGmxUXqRTvDujqhThn4ReFxikqJ5YW6zFQ")
                        .setContact_period_begin("2019-06-06")
                        .setContact_period_end("2026-06-06")
                )
                .setSubject_info(new SubjectInfo()
                        .setSubject_type(SubjectTypeEnum.SUBJECT_TYPE_ENTERPRISE)
                        .setIs_finance_institution(false)
                        .setBusiness_licence_info(new BusinessLicenceInfo()
                                .setLicence_number("914201123033363296")
                                .setLicence_copy("0P3ng6KTIW4-Q_l2FjKLZuhHjBWoMAjmVtCz7ScmhEIThCaV-4BBgVwtNkCHO_XXqK5dE5YdOmFJBZR9FwczhJehHhAZN6BKXQPcs-VvdSo")
                                .setMerchant_name("李四网络有限公司")
                                .setLegal_person("李四")
                                .setCompany_address("广东省深圳市南山区xx路xx号")
                                .setLicence_valid_date("[\"2017-10-28\",\"2037-10-28\"]")
                        )
                        .setCertificate_info(new CertificateInfo()
                                .setCert_type(CertTypeEnum.CERTIFICATE_TYPE_2388)
                                .setCert_number("111111111111")
                                .setCert_copy("0P3ng6KTIW4-Q_l2FjKLZuhHjBWoMAjmVtCz7ScmhEIThCaV-4BBgVwtNkCHO_XXqK5dE5YdOmFJBZR9FwczhJehHhAZN6BKXQPcs-VvdSo")
                                .setMerchant_name("xx公益团体")
                                .setLegal_person("李四")
                                .setCompany_address("广东省深圳市南山区xx路xx号")
                                .setCert_valid_date("[\"2017-10-28\",\"2037-10-28\"]")
                        )
                        .setCompany_prove_copy("0P3ng6KTIW4-Q_l2FjKLZuhHjBWoMAjmVtCz7ScmhEIThCaV-4BBgVwtNkCHO_XXqK5dE5YdOmFJBZR9FwczhJehHhAZN6BKXQPcs-VvdSo")
                        .setSpecial_operation_list(Stream.generate(() -> new SpecialOperation()
                                .setCategory_id(100)
                                .setOperation_copy_list(Collections.singletonList("0P3ng6KTIW4-Q_l2FjKLZuhHjBWoMAjmVtCz7ScmhEIThCaV-4BBgVwtNkCHO_XXqK5dE5YdOmFJBZR9FwczhJehHhAZN6BKXQPcs-VvdSo"))
                        ).limit(1).collect(Collectors.toList())
                        )
                        .setFinance_institution_info(new FinanceInstitutionInfo()
                                .setFinance_type(FinanceTypeEnum.BANK_AGENT)
                                .setFinance_license_pics(Collections.singletonList("0P3ng6KTIW4-Q_l2FjKLZuhHjBWoMAjmVtCz7ScmhEIThCaV-4BBgVwtNkCHO_XXqK5dE5YdOmFJBZR9FwczhJehHhAZN6BKXQPcs-VvdSo"))
                        )
                )
                .setIdentification_info(new IdentificationInfo()
                        .setId_holder_type(ContactTypeEnum.LEGAL)
                        .setIdentification_type(IdDocTypeEnum.IDENTIFICATION_TYPE_IDCARD)
                        .setIdentification_name("李四要加密的")
                        .setIdentification_number("362302200010101234要加密的")
                        .setIdentification_valid_date("[\"2017-10-28\",\"forever\"]")
                        .setIdentification_address("广东省深圳市南山区xx路xx号要加密的")
                        .setIdentification_front_copy("0P3ng6KTIW4-Q_l2FjKLZuhHjBWoMAjmVtCz7ScmhEIThCaV-4BBgVwtNkCHO_XXqK5dE5YdOmFJBZR9FwczhJehHhAZN6BKXQPcs-VvdSo")
                        .setIdentification_back_copy("0P3ng6KTIW4-Q_l2FjKLZuhHjBWoMAjmVtCz7ScmhEIThCaV-4BBgVwtNkCHO_XXqK5dE5YdOmFJBZR9FwczhJehHhAZN6BKXQPcs-VvdSo")
                        .setOwner(false))
                .setUbo_info_list(Collections.singletonList(new UboInfo()
                        .setUbo_id_doc_address("要加密的")
                        .setUbo_id_doc_copy("jTpGmxUXqRTvDujqhThn4ReFxikqJ5YW6zFQ")
                        .setUbo_id_doc_copy_back("jTpGmxUXqRTvDujqhThn4ReFxikqJ5YW6zFQ")
                        .setUbo_id_doc_name("李四要加密的")
                        .setUbo_id_doc_number("362302200010101234要加密的")
                        .setUbo_id_doc_type(IdDocTypeEnum.IDENTIFICATION_TYPE_IDCARD)
                        .setUbo_period_begin("2019-06-06")
                        .setUbo_period_end("2026-06-06")
                ));

        System.out.println("JSON.toJSONString(wxApplyment) = " + JSON.toJSONString(wxApplyment));
        return wxApplyment;
    }

    public static String checkParams(WxApplyment wxApplyment) {
        return null;
    }

    /**
     * 模拟前端传参
     *
     * @return
     */
    public static ParamDTO getParamDTO() {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("0P3ng6KTIW4-Q_l2FjKLZuhHjBWoMAjmVtCz7ScmhEIThCaV-4BBgVwtNkCHO_XXqK5dE5YdOmFJBZR9FwczhJehHhAZN6BKXQPcs-VvdSo");
        strings.add("0P3ng6KTIW4-Q_l2FjKLZuhHjBWoMAjmVtCz7ScmhEIThCaV-4BBgVwtNkCHO_XXqK5dE5YdOmFJBZR9FwczhJehHhAZN6BKXQPcs-VvdSo");
        //-----------------------------
        ParamDTO paramDTO = new ParamDTO();
        //-----------------------------
        paramDTO.setBusiness_code("1900013511_10000");
        int flag = RandomUtils.nextInt(0, 2);
        if (flag == 0) {
            paramDTO.setWxApplymentType(WxApplymentType.Institution);
            paramDTO.setChannel_id("20001111");
        } else {
            paramDTO.setWxApplymentType(WxApplymentType.ChannelMerchant);
        }
        //-----------------------------
        flag = RandomUtils.nextInt(0, 2);
        if (flag == 0) {
            paramDTO.setIs_finance_institution(false);
        } else {
            paramDTO.setIs_finance_institution(true);
            int i1 = RandomUtils.nextInt(0, FinanceTypeEnum.values().length);
            for (int i = 0; i < FinanceTypeEnum.values().length; i++) {
                if (i == i1) {
                    paramDTO.setFinance_type(FinanceTypeEnum.values()[i]);
                }
            }
            paramDTO.setFinance_license_pics(strings);
        }
        //-----------------------------主体
        flag = RandomUtils.nextInt(0, 6);
        if (flag == 0) {
            paramDTO.setSubject_type(SubjectTypeEnum.SUBJECT_TYPE_ENTERPRISE);
            paramDTO.setMerchant_name("李四网络有限公司");
        } else if (flag == 1) {
            paramDTO.setSubject_type(SubjectTypeEnum.SUBJECT_TYPE_INDIVIDUAL);
            paramDTO.setMerchant_name("个体户张三");
        } else if (flag == 2) {
            paramDTO.setSubject_type(SubjectTypeEnum.SUBJECT_TYPE_GOVERNMENT);
            paramDTO.setCompany_prove_copy("0P3ng6KTIW4-Q_l2FjKLZuhHjBWoMAjmVtCz7ScmhEIThCaV-4BBgVwtNkCHO_XXqK5dE5YdOmFJBZR9FwczhJehHhAZN6BKXQPcs-VvdSo");
        } else if (flag == 3) {
            paramDTO.setSubject_type(SubjectTypeEnum.SUBJECT_TYPE_INSTITUTIONS_CLONED);
            paramDTO.setCompany_prove_copy("0P3ng6KTIW4-Q_l2FjKLZuhHjBWoMAjmVtCz7ScmhEIThCaV-4BBgVwtNkCHO_XXqK5dE5YdOmFJBZR9FwczhJehHhAZN6BKXQPcs-VvdSo");

        } else if (flag == 4) {
            paramDTO.setSubject_type(SubjectTypeEnum.SUBJECT_TYPE_OTHERS);
            int i1 = RandomUtils.nextInt(1, CertTypeEnum.values().length);
            for (int i = 1; i < CertTypeEnum.values().length; i++) {
                if (i == i1) {
                    paramDTO.setCert_type(CertTypeEnum.values()[i]);
                }
            }
        } else if (flag == 5) {
            paramDTO.setSubject_type(SubjectTypeEnum.SUBJECT_TYPE_MICRO);
            int i1 = RandomUtils.nextInt(0, MicroBizTypeEnum.values().length);
            for (int i = 0; i < MicroBizTypeEnum.values().length; i++) {
                if (i == i1) {
                    paramDTO.setMicro_biz_type(MicroBizTypeEnum.values()[i]);

                }
            }
            paramDTO.setStore_name("大郎烧饼");
            paramDTO.setStore_address_code("440305");
            paramDTO.setStore_address("广东省深圳市南山区xx大厦x层xxxx室");
            paramDTO.setStore_header_copy("0P3ng6KTIW4-Q_l2FjKLZuhHjBWoMAjmVtCz7ScmhEIThCaV-4BBgVwtNkCHO_XXqK5dE5YdOmFJBZR9FwczhJehHhAZN6BKXQPcs-VvdSo");
            paramDTO.setStore_indoor_copy("0P3ng6KTIW4-Q_l2FjKLZuhHjBWoMAjmVtCz7ScmhEIThCaV-4BBgVwtNkCHO_XXqK5dE5YdOmFJBZR9FwczhJehHhAZN6BKXQPcs-VvdSo");
        }

        if (paramDTO.getSubject_type().equals(SubjectTypeEnum.SUBJECT_TYPE_ENTERPRISE) || paramDTO.getSubject_type().equals(SubjectTypeEnum.SUBJECT_TYPE_INDIVIDUAL)) {
            flag = RandomUtils.nextInt(0, 2);
            if (flag == 0) {
                paramDTO.setLicence_valid_date("[\"2017-10-28\",\"2037-10-28\"]");
            } else {
                paramDTO.setLicence_valid_date("forever");
            }
            paramDTO.setLicence_number("914201123033363296");
            paramDTO.setLicence_copy("0P3ng6KTIW4-Q_l2FjKLZuhHjBWoMAjmVtCz7ScmhEIThCaV-4BBgVwtNkCHO_XXqK5dE5YdOmFJBZR9FwczhJehHhAZN6BKXQPcs-VvdSo");
            paramDTO.setLegal_person("李四");
            paramDTO.setCompany_address("广东省深圳市南山区xx路xx号");
        } else if (paramDTO.getSubject_type().equals(SubjectTypeEnum.SUBJECT_TYPE_GOVERNMENT) || paramDTO.getSubject_type().equals(SubjectTypeEnum.SUBJECT_TYPE_INSTITUTIONS_CLONED)
                || paramDTO.getSubject_type().equals(SubjectTypeEnum.SUBJECT_TYPE_OTHERS)) {
            paramDTO.setCert_number("111111111111");
            paramDTO.setCert_copy("0P3ng6KTIW4-Q_l2FjKLZuhHjBWoMAjmVtCz7ScmhEIThCaV-4BBgVwtNkCHO_XXqK5dE5YdOmFJBZR9FwczhJehHhAZN6BKXQPcs-VvdSo");
            paramDTO.setMerchant_name("xx公益团体");
            paramDTO.setLegal_person("李四");
            paramDTO.setCompany_address("广东省深圳市南山区xx路xx号");
            flag = RandomUtils.nextInt(0, 2);
            if (flag == 0) {
                paramDTO.setCert_valid_date("[\"2017-10-28\",\"2037-10-28\"]");
            } else {
                paramDTO.setCert_valid_date("forever");
            }
        }
        //------------------------------联系人信息
        paramDTO.setName("翠花");
        paramDTO.setMobile("13812345678");
        paramDTO.setId_card_number("362302200010011234");
        flag = RandomUtils.nextInt(0, 2);
        if (!paramDTO.getSubject_type().equals(SubjectTypeEnum.SUBJECT_TYPE_OTHERS) && flag == 0) {
            paramDTO.setContactType(ContactTypeEnum.SUPER);
            int i1 = RandomUtils.nextInt(0, IdDocTypeEnum.values().length);
            for (int i = 0; i < IdDocTypeEnum.values().length; i++) {
                if (i == i1) {
                    paramDTO.setContact_id_doc_type(IdDocTypeEnum.values()[i]);
                }
            }
            paramDTO.setContact_id_doc_copy("jTpGmxUXqRTvDujqhThn4ReFxikqJ5YW6zFQ");
            paramDTO.setContact_id_doc_copy_back("jTpGmxUXqRTvDujqhThn4ReFxikqJ5YW6zFQ");
            paramDTO.setContact_period_begin("2019-06-06");
            paramDTO.setContact_period_end("2026-06-06");
            paramDTO.setBusiness_authorization_letter("47ZC6GC-vnrbEny_Ie_An5-tCpqxucuxi-vByf3Gjm7KEIUv0OF4wFNIO4kqg05InE4d2I6_H7I4");
        } else {
            //小微
            paramDTO.setContactType(ContactTypeEnum.LEGAL);
        }
        //---------------------法人身份信息
        if (paramDTO.getSubject_type().equals(SubjectTypeEnum.SUBJECT_TYPE_ENTERPRISE) ||
                paramDTO.getSubject_type().equals(SubjectTypeEnum.SUBJECT_TYPE_INDIVIDUAL) ||
                paramDTO.getSubject_type().equals(SubjectTypeEnum.SUBJECT_TYPE_OTHERS)) {
            paramDTO.setId_holder_type(ContactTypeEnum.LEGAL);
        } else {
            if ((flag = RandomUtils.nextInt(0, 2)) == 0) {
                paramDTO.setId_holder_type(ContactTypeEnum.LEGAL);
            } else {
                paramDTO.setId_holder_type(ContactTypeEnum.SUPER);
            }
        }

        if (paramDTO.getId_holder_type().equals(ContactTypeEnum.LEGAL)) {
            //当证件持有人类型为法人时，填写。
            if (paramDTO.getSubject_type().equals(SubjectTypeEnum.SUBJECT_TYPE_ENTERPRISE) ||
                    paramDTO.getSubject_type().equals(SubjectTypeEnum.SUBJECT_TYPE_INDIVIDUAL) ||
                    paramDTO.getSubject_type().equals(SubjectTypeEnum.SUBJECT_TYPE_OTHERS) ||
                    paramDTO.getSubject_type().equals(SubjectTypeEnum.SUBJECT_TYPE_INSTITUTIONS_CLONED)
            ) {
                for (int i = 0; i < IdDocTypeEnum.values().length; i++) {
                    if ((flag = RandomUtils.nextInt(0, IdDocTypeEnum.values().length)) == i) {
                        paramDTO.setIdentification_type(IdDocTypeEnum.values()[i]);
                    }
                }
            } else {
                //政府机关、小微仅支持中国大陆居民-身份证类型
                paramDTO.setIdentification_type(IdDocTypeEnum.IDENTIFICATION_TYPE_IDCARD);
            }

        } else {
            paramDTO.setAuthorize_letter_copy("0P3ng6KTIW4-Q_l2FjKLZuhHjBWoMAjmVtCz7ScmhEIThCaV-4BBgVwtNkCHO_XXqK5dE5YdOmFJBZR9FwczhJehHhAZN6BKXQPcs-VvdSo");
        }

        return paramDTO;
    }

}
