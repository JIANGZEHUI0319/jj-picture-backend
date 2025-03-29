package com.ncepu.jjpicturebackend.model.dto.user;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户登录请求
 * @author simon_jiang
 * @version 1.0
 */
@Data
public class UserLoginRequest implements Serializable {


    private static final long serialVersionUID = -1153367376108607832L;
    /**
     * 账号
     */
    private String userAccount;

    /**
     * 密码
     */
    private String userPassword;

}

