package com.example.test1.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : panzhenye
 * @date : 2022/9/7 19:38
 */
@Data
public class JdUser implements Serializable {
    private static final long serialVersionUID = -2230689147998647690L;
    @TableId
    private String jdUserId;
    private String jdUserName;
    private String jdUserText1;
    private String jdUserText2;
    private String jdUserText3;
}
