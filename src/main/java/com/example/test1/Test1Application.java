package com.example.test1;

import com.alibaba.fastjson.JSON;
import com.example.test1.controller.TestController;
import com.example.test1.entity.wx.WxApplyment;
import com.example.test1.entity.wx.wxapplyment.ContactInfo;
import com.example.test1.entity.wx.wxapplyment.IdentificationInfo;
import com.example.test1.entity.wx.wxapplyment.SubjectInfo;
import com.example.test1.entity.wx.wxapplyment.UboInfo;
import com.example.test1.entity.wx.wxapplyment.subjectInfo.*;
import com.example.test1.entity.wx.wxapplyment.wxenum.ContactTypeEnum;
import com.example.test1.entity.wx.wxapplyment.wxenum.FinanceTypeEnum;
import com.example.test1.entity.wx.wxapplyment.wxenum.IdDocTypeEnum;
import com.example.test1.entity.wx.wxapplyment.wxenum.SubjectTypeEnum;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author : panzhenye
 * @date : 2022/9/7 18:14
 */
@SpringBootApplication
public class Test1Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(Test1Application.class, args);
        TestController testController = (TestController) run.getBean("testController");
        WxApplyment wxApplyment = getWxApplyment();
        String msg = testController.test1(wxApplyment);
        System.out.println("msg = " + msg);
    }

    public static WxApplyment getWxApplyment() {
        WxApplyment wxApplyment = new WxApplyment()
                .setChannel_id("20001111")
                .setBusiness_code("1900013511_10000")
                .setBusiness_code("1900013511_10000,")
//                .setBusiness_code("")
                .setContact_info(new ContactInfo()
                        .setName("李四要加密的")
                        .setMobile("13812345678要加密的")
                        .setId_card_number("362302200010101234要加密的")
                        .setContact_type(ContactTypeEnum.LEGAL)
//                        .setContact_type(ContactTypeEnum.SUPER)
                        .setContact_id_doc_type(IdDocTypeEnum.IDENTIFICATION_TYPE_IDCARD)
                        .setContact_id_doc_copy("jTpGmxUXqRTvDujqhThn4ReFxikqJ5YW6zFQ")
                        .setContact_id_doc_copy_back("jTpGmxUXqRTvDujqhThn4ReFxikqJ5YW6zFQ")
                        .setContact_period_begin("2019-06-06")
                        .setContact_period_end("2026-06-06")
                )
//                .setContact_info(null)
//                .setContact_info(new ContactInfo())
                .setSubject_info(new SubjectInfo()
                        .setSubject_type(SubjectTypeEnum.SUBJECT_TYPE_ENTERPRISE)
//                        .setSubject_type(SubjectTypeEnum.SUBJECT_TYPE_INDIVIDUAL)
//                        .setSubject_type(SubjectTypeEnum.SUBJECT_TYPE_GOVERNMENT)
//                        .setSubject_type(SubjectTypeEnum.SUBJECT_TYPE_INSTITUTIONS_CLONED)
//                        .setSubject_type(SubjectTypeEnum.SUBJECT_TYPE_OTHERS)
//                        .setSubject_type(SubjectTypeEnum.SUBJECT_TYPE_MICRO)
                        .setIs_finance_institution(false)
//                        .setIs_finance_institution(true)
                        .setBusiness_licence_info(new BusinessLicenceInfo()
                                .setLicence_number("914201123033363296")
                                .setLicence_copy("0P3ng6KTIW4-Q_l2FjKLZuhHjBWoMAjmVtCz7ScmhEIThCaV-4BBgVwtNkCHO_XXqK5dE5YdOmFJBZR9FwczhJehHhAZN6BKXQPcs-VvdSo")
                                .setMerchant_name("李四网络有限公司")
                                .setLegal_person("李四")
                                .setCompany_address("广东省深圳市南山区xx路xx号")
                                .setLicence_valid_date("[\"2017-10-28\",\"2037-10-28\"]")
                        )
//                        .setBusiness_licence_info(new BusinessLicenceInfo())
//                        .setCertificate_info(new CertificateInfo()
//                                .setCert_type(CertTypeEnum.CERTIFICATE_TYPE_2388)
//                                .setCert_number("111111111111")
//                                .setCert_copy("0P3ng6KTIW4-Q_l2FjKLZuhHjBWoMAjmVtCz7ScmhEIThCaV-4BBgVwtNkCHO_XXqK5dE5YdOmFJBZR9FwczhJehHhAZN6BKXQPcs-VvdSo")
//                                .setMerchant_name("xx公益团体")
//                                .setLegal_person("李四")
//                                .setCompany_address("广东省深圳市南山区xx路xx号")
//                                .setCert_valid_date("[\"2017-10-28\",\"2037-10-28\"]")
//                        )
                        .setCertificate_info(new CertificateInfo())
                        .setAssist_prove_info(new AssistProveInfo())
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
//                .setSubject_info(null)
//                .setSubject_info(new SubjectInfo())
                .setIdentification_info(new IdentificationInfo()
                        .setId_holder_type(ContactTypeEnum.LEGAL)
//                        .setId_holder_type(ContactTypeEnum.SUPER)
                        .setIdentification_type(IdDocTypeEnum.IDENTIFICATION_TYPE_IDCARD)
                        .setIdentification_name("李四1要加密的")
                        .setIdentification_number("362302200010101234要加密的")
                        .setIdentification_valid_date("[\"2017-10-28\",\"forever\"]")
                        .setIdentification_address("广东省深圳市南山区xx路xx号要加密的")
                        .setIdentification_front_copy("0P3ng6KTIW4-Q_l2FjKLZuhHjBWoMAjmVtCz7ScmhEIThCaV-4BBgVwtNkCHO_XXqK5dE5YdOmFJBZR9FwczhJehHhAZN6BKXQPcs-VvdSo")
                        .setIdentification_back_copy("0P3ng6KTIW4-Q_l2FjKLZuhHjBWoMAjmVtCz7ScmhEIThCaV-4BBgVwtNkCHO_XXqK5dE5YdOmFJBZR9FwczhJehHhAZN6BKXQPcs-VvdSo")
                        .setOwner(false)
                )
//                .setIdentification_info(null)
//                .setIdentification_info(new IdentificationInfo())
                .setUbo_info_list(Collections.singletonList(new UboInfo()
                        .setUbo_id_doc_address("要加密的")
                        .setUbo_id_doc_copy("jTpGmxUXqRTvDujqhThn4ReFxikqJ5YW6zFQ")
                        .setUbo_id_doc_copy_back("jTpGmxUXqRTvDujqhThn4ReFxikqJ5YW6zFQ")
                        .setUbo_id_doc_name("李四要加密的")
                        .setUbo_id_doc_number("362302200010101234要加密的")
                        .setUbo_id_doc_type(IdDocTypeEnum.IDENTIFICATION_TYPE_IDCARD)
                        .setUbo_period_begin("2019-06-06")
                        .setUbo_period_end("2026-06-06")
                ))
                .setUbo_info_list(Collections.singletonList(new UboInfo()))
                .setUbo_info_list(null)
                ;

        System.out.println("JSON.toJSONString(wxApplyment) = " + JSON.toJSONString(wxApplyment));
        return wxApplyment;
    }

}
