package com.ncepu.jjpicturebackend.utils;

/**
 * @author simon_jiang
 * @version 1.0
 */

import java.awt.*;

/**
 * 颜色转换
 */
public class ColorTransformUtils {

    public ColorTransformUtils() {}

    /**
     * 获取标准颜色 （将数据万象的 5 位色值转为6位）
     * @param color
     * @return
     */
    public static String getStandardColor(String color) {
        if(color.length() == 7) {
            color = color.substring(0, 4) + "0" + color.substring(4);
        }
        return color;
    }
}
