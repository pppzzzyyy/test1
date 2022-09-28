package com.jd.test1;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author : panzhenye
 * @date : 2022/9/23 15:29
 */
@Service
public class Consumer1 {

    @Resource
    private TestApi testApi;

    public void test(String a) {
        String test = testApi.test(a);
        System.out.println("test = " + test);
    }

    public void test1(String a) {
        JdUser jdUser = new JdUser();
        jdUser.setJdUserId(a);
        String test = testApi.test1(jdUser);
        System.out.println("test = " + test);
    }

    public void test2(String a) {
        JdUser jdUser = new JdUser();
        jdUser.setJdUserId(a);
        String test = testApi.test2(jdUser);
        System.out.println("test = " + test);
    }
}
