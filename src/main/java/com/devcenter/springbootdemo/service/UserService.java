package com.devcenter.springbootdemo.service;

import com.devcenter.springbootdemo.domain.User;

import java.util.List;

/**
 * UserService 接口，定义了与用户相关的业务逻辑方法。
 * 有两个实现类：UserServiceJPAImpl 和 UserServiceMyBatisImpl，分别使用 JPA 和 MyBatis 实现数据访问。
 * 默认使用 JPA 实现，可以通过配置属性 app.user.service=mybatis 切换到 MyBatis 实现。
 */
public interface UserService {
    /**
     * 获取所有用户的信息列表。
     * @return
     */
    List<User> getAllUsers();

    /**
     * 根据用户 ID 获取用户信息。
     * @param id
     * @return
     */
    User getUserById(Integer id);

    /**
     * 创建新用户。
     * @param user
     * @return
     */
    User createUser(User user);

    /**
     * 更新现有用户的信息。
     * @param id
     * @param user
     * @return
     */
    User updateUser(Integer id, User user);

    /**
     * 删除用户。
     * @param id
     */
    void deleteUserById(Integer id);
}
