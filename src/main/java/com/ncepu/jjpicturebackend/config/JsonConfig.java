package com.ncepu.jjpicturebackend.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

/**
 * Spring MVC Json 配置
 */
@JsonComponent
public class JsonConfig {

    /**
     * 添加 Long 转 json 精度丢失的配置
     */
    /**
     * @Bean 是 Spring 框架中的一个重要注解，主要用于在 Java 配置类中定义 Spring Bean
     * @Bean 注解的主要作用是告诉 Spring 容器，通过一个方法来创建一个 Bean 实例，并将其
     * 注册到 Spring 容器中，Spring 容器会对这些 Bean 进行生命周期管理。通常，@Bean 注解
     * 与 @Configuration 注解一起使用，@Configuration 注解用于标识一个配置类，而 @Bean 注解则在这个配置类中定义具体的 Bean。
     * @param builder
     * @return
     */
    @Bean
    public ObjectMapper jacksonObjectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        SimpleModule module = new SimpleModule();
        module.addSerializer(Long.class, ToStringSerializer.instance);
        module.addSerializer(Long.TYPE, ToStringSerializer.instance);
        objectMapper.registerModule(module);
        return objectMapper;
    }
}
