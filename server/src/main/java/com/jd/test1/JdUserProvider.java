package com.jd.test1;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : panzhenye
 * @date : 2022/9/28 14:53
 */
@RestController
@RequestMapping("jd/user")
public class JdUserProvider {

    private static final List<JdUser> JD_USERS = new ArrayList<>();

    @PostMapping
    public String add(@RequestBody JdUser jdUser){
        System.out.println("add-----------jdUser = " + jdUser);
        boolean add = JD_USERS.add(jdUser);
        System.out.println("JD_USERS = " + JD_USERS);
        return add+"";
    }

    @DeleteMapping
    public String delete(@RequestParam String jdUserId){
        System.out.println("delete-----------jdUserId = " + jdUserId);
        for (int i = 0; i < JD_USERS.size(); i++) {
            if (JD_USERS.get(i).getJdUserId().equals(jdUserId)) {
                JD_USERS.remove(i--);
            }
        }
        System.out.println("JD_USERS = " + JD_USERS);
        return "success";
    }

    @PutMapping
    public String update(@RequestBody JdUser jdUser){
        System.out.println("update-----------jdUser = " + jdUser);
        System.out.println("JD_USERS = " + JD_USERS);
        return "success";
    }

    @GetMapping
    public JdUser get(JdUser jdUser){
        System.out.println("get-----------jdUser = " + jdUser);
        System.out.println("JD_USERS = " + JD_USERS);
        return jdUser;
    }
}
