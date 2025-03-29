package com.ncepu.jjpicturebackend.model.enums;

import cn.hutool.core.util.ObjUtil;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public enum SpaceTypeEnum {

    PRIVATE("私有空间", 0),
    TEAM("团队空间", 1);

    private final String text;

    private final int value;

    private final static Map<Integer, SpaceTypeEnum> MAP = new HashMap<>();

    static {
        MAP.put(PRIVATE.value, PRIVATE);
        MAP.put(TEAM.value, TEAM);
    }

    SpaceTypeEnum(String text, int value) {
        this.text = text;
        this.value = value;
    }

    /**
     * 根据 value 获取枚举
     */
    public static SpaceTypeEnum getEnumByValue(Integer value) {
        if (ObjUtil.isEmpty(value)) {
            return null;
        }
        return MAP.getOrDefault(value, null);
//        for (SpaceTypeEnum spaceTypeEnum : SpaceTypeEnum.values()) {
//            if (spaceTypeEnum.value == value) {
//                return spaceTypeEnum;
//            }
//        }
//        return null;
    }
}
