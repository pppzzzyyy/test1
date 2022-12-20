package com.example.test1.service;

import com.example.test1.entity.JdUser;
import org.springframework.scheduling.annotation.Async;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : panzhenye
 * @date : 2022/9/7 18:14
 */
public interface TestService {
    void test4(JdUser jdUser) throws InterruptedException;

    @Async
    void test41(JdUser jdUser) throws InterruptedException;

    void updateBatch(ArrayList<JdUser> jdUsers);

    /**
     * 给集合分组
     * @param list
     * @param size
     * @param <T>
     * @return
     */
    static <T> List<List<T>> groupingList(List<T> list, int size) {
        ArrayList<List<T>> lists = new ArrayList<>();
        for (int i = 0; i <= (list.size() - 1) / size; i++) {
            List<T> ts = list.subList(i * size, Math.min((i + 1) * size, list.size()));
            lists.add(ts);
        }
        return lists;
    }
}
