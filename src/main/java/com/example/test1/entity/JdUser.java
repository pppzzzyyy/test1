package com.example.test1.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author : panzhenye
 * @date : 2022/9/7 19:38
 */
@Data
public class JdUser {
    @TableId
    private String jdUserId;
    private String jdUserName;
    private String jdUserText1;
    private String jdUserText2;
    private String jdUserText3;
}
