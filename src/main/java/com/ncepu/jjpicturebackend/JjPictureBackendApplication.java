package com.ncepu.jjpicturebackend;

import org.apache.shardingsphere.spring.boot.ShardingSphereAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication(exclude = {ShardingSphereAutoConfiguration.class})
@EnableAsync
/**
 * @EnableAsync 注解是 Spring 框架中用于开启异步方法执行功能的重要注解
 * 在 Spring 里，若要使用 @Async 注解将方法标记为异步方法，就必须先使用 @EnableAsync 注解开启异步方法的支持。
 * 这是因为 @EnableAsync 注解会触发 Spring 的自动配置机制，创建必要的基础设施来支持异步方法的执行。
 * 工作原理
 * AOP 代理：@EnableAsync 注解会促使 Spring 运用 AOP（面向切面编程）来创建代理对象。
 * 当调用被 @Async 注解标记的方法时，实际上调用的是代理对象的方法，代理对象会负责在新的线程中执行该方法。
 * 线程池管理：Spring 会创建一个线程池来管理异步方法的执行。默认情况下，
 * Spring 使用 SimpleAsyncTaskExecutor，不过你也可以通过配置自定义线程池。
 */
@MapperScan("com.ncepu.jjpicturebackend.mapper")
@EnableAspectJAutoProxy(exposeProxy = true)
public class JjPictureBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(JjPictureBackendApplication.class, args);
    }
}
