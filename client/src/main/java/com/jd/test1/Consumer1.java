package com.jd.test1;

import com.jd.jsf.gd.config.annotation.Consumer;
import org.springframework.stereotype.Service;

/**
 * @author : panzhenye
 * @date : 2022/9/23 15:29
 */
@Service
public class Consumer1 {
    
    @Consumer(alias = "test1",url = "127.0.0.1:220001")
    private TestJsfApi testJsfApi;

    public void test(String a) {
        String test = testJsfApi.test(a);
        System.out.println("test = " + test);
    }
}
