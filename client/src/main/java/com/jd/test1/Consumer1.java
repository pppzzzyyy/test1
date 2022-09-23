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
    private TestJsfApi testJsfApi;

    public void test(String a) {
        String test = testJsfApi.test(a);
        System.out.println("test = " + test);
    }
}
