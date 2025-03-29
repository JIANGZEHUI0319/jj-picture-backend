package com.ncepu.jjpicturebackend.model.enums;

import cn.hutool.core.util.ObjUtil;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * 用户角色枚举
 * @author simon_jiang
 * @version 1.0
 */
@Getter
public enum UserRoleEnum {

    USER("用户", "user"),
    ADMIN("管理员", "admin");

    private final String text;

    private final String value;

    private final static Map<String, UserRoleEnum> MAP = new HashMap<>();

    static {
        MAP.put(USER.value, USER);
        MAP.put(ADMIN.value, ADMIN);
    }

    UserRoleEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    /**
     * 根据 value 获取枚举
     * @param value 枚举值的value
     * @return 枚举值
     */
    public static UserRoleEnum getEnumByValue(String value) {
        if(ObjUtil.isEmpty(value)) {
            return null;
        }
        return MAP.getOrDefault(value, null);
//        for(UserRoleEnum userRoleEnum : UserRoleEnum.values()) {
//            if(userRoleEnum.value.equals(value)) {
//                return userRoleEnum;
//            }
//        }
//        return null;
    }

}
