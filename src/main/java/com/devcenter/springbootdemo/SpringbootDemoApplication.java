package com.devcenter.springbootdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 应用程序的主类，负责启动应用程序。
 * 使用 @SpringBootApplication 注解标记，表示这是一个 Spring Boot 应用程序
 * ，并启用自动配置和组件扫描功能。
 * 主方法调用 SpringApplication.run() 方法，传入当前类和命令行参数，启动 Spring 应用程序上下文。
 * @SpringBootApplication 是一个复合注解，包含了以下三个注解的功能：
 * 1. @Configuration：表示该类可以使用 Spring IoC 容器作为配置类。
 * 2. @EnableAutoConfiguration：启用 Spring Boot 的自动配置机制
 * 3. @ComponentScan：启用组件扫描，自动发现和注册应用程序中的 Spring 组件（如 @Controller、@Service、@Repository 等）。
 */
@SpringBootApplication
public class SpringbootDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }
}
