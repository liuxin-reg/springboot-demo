package com.devcenter.springbootdemo.controller;

import com.devcenter.springbootdemo.domain.User;
import com.devcenter.springbootdemo.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 用户控制器，处理与用户相关的 HTTP 请求。
 * @RestController 注解表示该类是一个 RESTful 控制器，能够处理 HTTP 请求并返回 JSON 或 XML 格式的数据。
 * @RequestMapping("/users") 注解指定了该控制器处理的基础 URL 路径为 /users。
 * UserService 被注入到控制器中，以便处理与用户相关的业务逻辑。
 */
@RestController
@RequestMapping("/users")
public class UserController {

    /**
     * 用户服务对象，用于处理用户相关的业务逻辑。
     * @Autowired 注解用于将 UserService 自动注入到控制器中。
     * 构造方法注入是一种推荐的依赖注入方式，有助于提高代码的可测试性和可维护性。
     */
    private final UserService userService;

    /**
     * 构造方法，使用依赖注入将 UserService 注入到控制器中。
     * Autowired 注解可以省略，因为只有一个构造方法时，Spring 会自动进行注入。
     * @param userService
     */
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Get 请求处理方法，返回所有用户的信息列表。
     * @GetMapping() 注解表示该方法处理对 /users 的 GET 请求。
     * @return 所有用户列表
     */
    @GetMapping()
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}
