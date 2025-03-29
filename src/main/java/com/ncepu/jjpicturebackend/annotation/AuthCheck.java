package com.ncepu.jjpicturebackend.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author simon_jiang
 * @version 1.0
 */
@Target(ElementType.METHOD)
/**
 * @Retention 是 Java 中的一个元注解（用于注解其他注解的注解），它主要用于指定
 * 被它注解的注解的保留策略，也就是决定了被注解的注解在什么阶段还存在。下面详细介绍其作用和使用方式。
 * 1. RetentionPolicy.SOURCE
 * 注解仅存在于源文件中，在编译阶段会被编译器丢弃，不会包含在编译后的 .class 文件中。
 * 2. RetentionPolicy.CLASS
 * 注解会保留在编译后的 .class 文件中，但在运行时不会被虚拟机保留，也就是
 * 在运行时无法通过反射获取该注解信息。这是注解的默认保留策略。
 * 3. RetentionPolicy.RUNTIME
 * 注解会保留在编译后的 .class 文件中，并且在运行时会被虚拟机保留，因此可以在运行时通过反射机制获取注解信息。
 * 常用于需要在运行时根据注解信息进行动态处理的场景
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface AuthCheck {

    /**
     * 必须有某个角色
     */
    String mustRole() default "";
}

