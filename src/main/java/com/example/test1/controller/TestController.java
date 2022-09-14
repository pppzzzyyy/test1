package com.example.test1.controller;

import com.example.test1.entity.wx.WxApplyment;
import com.example.test1.entity.wx.aop.NotBlank;
import com.example.test1.entity.wx.aop.WxUtil;
import com.example.test1.entity.wx.wxapplyment.ContactInfo;
import com.example.test1.entity.wx.wxapplyment.IdentificationInfo;
import com.example.test1.entity.wx.wxapplyment.wxenum.ContactTypeEnum;
import com.example.test1.entity.wx.wxapplyment.wxenum.SubjectTypeEnum;
import com.example.test1.service.TestService;
import com.example.test1.service.WxApplymentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @NotBlank
    public String test1(WxApplyment wxApplyment) {
        String msg = checkParams(wxApplyment);
        if (StringUtils.isNotBlank(msg)) {
            System.out.println(msg);
            return "success";
        }

        wxApplymentService.applyment(wxApplyment);

        return "success";
    }



    public static String checkParams(WxApplyment wxApplyment) {
        StringBuilder returnMsg = new StringBuilder();
        String msg = WxUtil.checkParamsNotBlank(wxApplyment);
        returnMsg.append(msg);
        String regex = "[\\d\\w_]+";
        String business_code = wxApplyment.getBusiness_code();
        if (!business_code.matches(regex)) {
            returnMsg.append("业务申请编号只能由数字、字母或下划线组成;\n");
        }
        ContactInfo contact_info = wxApplyment.getContact_info();
        IdentificationInfo identification_info = wxApplyment.getIdentification_info();
        if (!contact_info.getContact_type().equals(ContactTypeEnum.LEGAL)
                || !contact_info.getName().equals(identification_info.getIdentification_name())) {
            returnMsg.append("联系人姓名需与法人姓名一致;\n");
        }
        if (wxApplyment.getSubject_info().getSubject_type().equals(SubjectTypeEnum.SUBJECT_TYPE_ENTERPRISE)
                && StringUtils.isBlank(identification_info.getIdentification_address())){
            returnMsg.append("法人证件居住地址为空;\n");
        }
        return returnMsg.toString();
    }

    public static void main(String[] args) {
        StringBuilder returnMsg = new StringBuilder();
        String s = returnMsg.toString();
        System.out.println("StringUtils.isNotBlank(s) = " + StringUtils.isNotBlank(s));
    }


}
