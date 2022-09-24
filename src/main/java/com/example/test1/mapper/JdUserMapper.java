package com.example.test1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.test1.entity.JdUser;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : panzhenye
 * @date : 2022/9/7 19:49
 */
@Repository
public interface JdUserMapper extends BaseMapper<JdUser> {
    default List<JdUser> getListByName(String name){
        return selectList(Wrappers.lambdaQuery(JdUser.class)
        .select(JdUser::getJdUserId,JdUser::getJdUserName)
//        .eq(StringUtils.isNotBlank(name),JdUser::getJdUserName,name));
                .eq(JdUser::getJdUserName,name));

    }

    default JdUser getListById(String id){
        return selectOne(Wrappers.lambdaQuery(JdUser.class)
                .eq(JdUser::getJdUserId,id));

    }
}
