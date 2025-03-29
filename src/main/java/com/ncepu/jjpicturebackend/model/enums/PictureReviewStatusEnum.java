package com.ncepu.jjpicturebackend.model.enums;

import cn.hutool.core.util.ObjUtil;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;


/**
 * 图片审核状态枚举
 */
@Getter
public enum PictureReviewStatusEnum {  
    REVIEWING("待审核", 0),  
    PASS("通过", 1),  
    REJECT("拒绝", 2);  
  
    private final String text;  
    private final int value;

    private final static Map<Integer, PictureReviewStatusEnum> MAP = new HashMap<>();

    static {
        MAP.put(REVIEWING.value, REVIEWING);
        MAP.put(PASS.value, PASS);
        MAP.put(REJECT.value, REJECT);
    }
  
    PictureReviewStatusEnum(String text, int value) {  
        this.text = text;  
        this.value = value;  
    }  
  
    /**  
     * 根据 value 获取枚举  
     */  
    public static PictureReviewStatusEnum getEnumByValue(Integer value) {  
        if (ObjUtil.isEmpty(value)) {
            return null;  
        }
        return MAP.getOrDefault(value, null);
//        for (PictureReviewStatusEnum pictureReviewStatusEnum : PictureReviewStatusEnum.values()) {
//            if (pictureReviewStatusEnum.value == value) {
//                return pictureReviewStatusEnum;
//            }
//        }
//        return null;
    }  
}
