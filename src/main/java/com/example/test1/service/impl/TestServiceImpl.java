package com.example.test1.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.test1.entity.JdUser;
import com.example.test1.service.JdUserService;
import com.example.test1.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author : panzhenye
 * @date : 2022/9/7 18:14
 */
@Service
@Slf4j
public class TestServiceImpl implements TestService {

    @Autowired
    private JdUserService jdUserService;

    @Override
    @Async
    public void test4(JdUser jdUser) throws InterruptedException {
        synchronized (TestService.class) {
            //有线程安全问题
            JdUser byId = jdUserService.getById(10);
            log.info("byId{}", JSON.toJSONString(byId));
            if (byId == null) {
                jdUserService.save(jdUser);
            } else {
                byId.setJdUserText1((Integer.parseInt(byId.getJdUserText1()) + 1) + "");
                jdUserService.updateById(byId);
            }
        }
    }

    @Override
    @Async
    public void test41(JdUser jdUser) throws InterruptedException {
//        synchronized (TestService.class) {
        //有线程安全问题
            jdUserService.saveOrUpdate(jdUser, Wrappers.lambdaUpdate(JdUser.class)
                    .set(JdUser::getJdUserText1, (Integer.parseInt(jdUser.getJdUserText1()) + 1) + "")
                    .eq(JdUser::getJdUserId, jdUser.getJdUserId()));
//        }
    }
}
