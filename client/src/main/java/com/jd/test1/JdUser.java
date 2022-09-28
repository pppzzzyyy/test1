package com.jd.test1;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : panzhenye
 * @date : 2022/9/7 19:38
 */
@Data
public class JdUser implements Serializable {
    private static final long serialVersionUID = 4974643722319640361L;
    private String jdUserId;
    private String jdUserName;
    private String jdUserText1;
    private String jdUserText2;
    private String jdUserText3;
}
