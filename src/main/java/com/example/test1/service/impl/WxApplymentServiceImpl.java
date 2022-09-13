package com.example.test1.service.impl;
import com.alibaba.fastjson.JSON;
import com.example.test1.controller.TestController;
import com.example.test1.entity.wx.WxApplyment;
import com.example.test1.entity.wx.aop.WxUtil;
import com.example.test1.service.WxApplymentService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * @author : panzhenye
 * @date : 2022/9/9 13:23
 */
@Service
public class WxApplymentServiceImpl implements WxApplymentService {
    @Override
    public void applyment(WxApplyment wxApplyment) {

        WxUtil wxUtil = new WxUtil();
        wxUtil.doEncryptOrDecrypt(wxApplyment, wxApplyment.getClass(), 1);
        System.out.println("JSON.toJSONString(wxApplyment) = " + JSON.toJSONString(wxApplyment));

    }

    public static void main(String[] args) {

        WxApplyment wxApplyment = TestController.getWxApplyment();

        if (StringUtils.isNotBlank(TestController.checkParams(wxApplyment))) {
            System.out.println("TestController.checkParams(wxApplyment) = " + TestController.checkParams(wxApplyment));
            return;
        }

        WxApplymentServiceImpl wxApplymentService = new WxApplymentServiceImpl();
        wxApplymentService.applyment(wxApplyment);

    }
}
