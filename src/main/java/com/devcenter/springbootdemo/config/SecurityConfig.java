package com.devcenter.springbootdemo.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.authentication.DefaultAuthenticationEventPublisher;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.util.HashMap;
import java.util.Map;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    @ConditionalOnMissingBean(AuthenticationEventPublisher.class)
    DefaultAuthenticationEventPublisher defaultAuthenticationEventPublisher(ApplicationEventPublisher delegate) {
        return new DefaultAuthenticationEventPublisher(delegate);
    }

    @Bean
    public static PasswordEncoder passwordEncoder() {
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        encoders.put("noop", NoOpPasswordEncoder.getInstance());
        return new DelegatingPasswordEncoder("noop", encoders);
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) {
        http.authorizeHttpRequests(authorize -> authorize
                // 公开接口，无需授权
                .requestMatchers("/", "/home", "/public/**", "/login.html", "/login", "/index.html").permitAll()
                // 需要 USER 角色
                .requestMatchers("/users/**", "/userList.html").hasRole("USER")
                // 需要 ADMIN 角色
                .requestMatchers("/admin/**").hasRole("ADMIN")
                // 其他请求需要认证
                .anyRequest().authenticated()
        ).formLogin(form -> form
                // serve a static login page at /login.html and post credentials to /login
                .loginPage("/login.html")
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/userList.html")
                .permitAll()
        ).logout(logout -> logout.permitAll())
                .csrf(csrf -> csrf.disable());

        return http.build();
    }
}
