package com.devcenter.springbootdemo.service.impl;

import com.devcenter.springbootdemo.domain.User;
import com.devcenter.springbootdemo.mapper.UserMapper;
import com.devcenter.springbootdemo.service.UserService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务类，处理与用户相关的业务逻辑。
 * @Service 注解表示该类是一个服务组件，Spring 会将其作为一个 Bean 注入到应用程序上下文中。
 */
@Service
@ConditionalOnProperty(name="app.user.service", havingValue="mybatis", matchIfMissing=false)
public class UserServiceMyBatisImpl implements UserService {

    /**
     * 用户映射器对象，用于与数据库进行交互。
     */
    private final UserMapper userMapper;

    /**
     * 构造方法，使用依赖注入将 UserMapper 注入到服务类中。
     * @param userMapper
     */
    public UserServiceMyBatisImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    /**
     * 获取所有用户的信息列表。
     * 调用 UserMapper 的 findAll() 方法从数据库中检索所有用户记录。
     * @return 所有用户列表
     */
    @Override
    public List<User> getAllUsers() {
        return userMapper.findAll();
    }

    /**
     * 根据用户 ID 获取用户信息。
     * 调用 UserMapper 的 findById() 方法从数据库中检索指定 ID 的用户记录。
     * @param id
     * @return
     */
    @Override
    public User getUserById(Integer id) {
        return userMapper.findById(id);
    }

    /**
     * 创建新用户。
     * 调用 UserMapper 的 save() 方法将新用户保存到数据库中。
     * @param user
     * @return
     */
    @Override
    public User createUser(User user) {
        // userMapper.save 返回受影响行数 (int)，但 useGeneratedKeys 会把生成的主键写回到 user.userId
        int affected = userMapper.save(user);
        if (affected > 0) {
            // 返回数据库中最新的记录，确保包含数据库端可能的默认值
            return userMapper.findById(user.getUserId());
        }
        return null;
    }

    /**
     * 更新现有用户的信息。
     * 调用 UserMapper 的 update() 方法将更新后的用户信息保存到数据库中。
     * @param id
     * @param user
     * @return
     */
    @Override
    public User updateUser(Integer id, User user) {
        user.setUserId(id);
        int affected = userMapper.update(user);
        if (affected > 0) {
            return userMapper.findById(id);
        }
        return null;
    }

    /**
     * 删除用户。
     * 调用 UserMapper 的 deleteById() 方法从数据库中删除指定 ID 的用户记录。
     * @param id
     */
    @Override
    public void deleteUserById(Integer id) {
        int affected = userMapper.deleteById(id);
        if (affected == 0) {
            throw new RuntimeException("User not found");
        }
    }
}
