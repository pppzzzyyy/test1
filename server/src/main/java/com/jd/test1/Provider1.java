package com.jd.test1;

import org.springframework.stereotype.Service;

/**
 * @author : panzhenye
 * @date : 2022/9/23 15:23
 */
@Service
public class Provider1 implements TestJsfApi {
    @Override
    public String test(String a) {
        System.out.println("a = " + a);
        return "success";
    }
}
