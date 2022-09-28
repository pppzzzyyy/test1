package com.jd.test1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author : panzhenye
 * @date : 2022/9/28 15:00
 */
@Service
public class JdUserServiceImpl {

    @Autowired
    private JdUserApi jdUserApi;

    public void test(){
        JdUser jdUser = new JdUser();
        jdUser.setJdUserId("1");
        jdUser.setJdUserName("1");
        jdUser.setJdUserText1("1");
        jdUser.setJdUserText2("1");
        jdUser.setJdUserText3("1");
        String add = jdUserApi.add(jdUser);
        System.out.println("add = " + add);
        JdUser jdUser1 = jdUserApi.get(jdUser);
        System.out.println("jdUser1 = " + jdUser1);
        String update = jdUserApi.update(jdUser);
        System.out.println("update = " + update);
        String delete = jdUserApi.delete("1");
        System.out.println("delete = " + delete);

    }
}
