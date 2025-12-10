package com.devcenter.springbootdemo.service;

import com.devcenter.springbootdemo.domain.User;
import com.devcenter.springbootdemo.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务类，处理与用户相关的业务逻辑。
 * @Service 注解表示该类是一个服务组件，Spring 会将其作为一个 Bean 注入到应用程序上下文中。
 */
@Service
public class UserService {

    /**
     * 用户存储库对象，用于与数据库进行交互。
     * 通过构造方法注入 UserRepository，实现依赖注入。
     */
    private final UserRepository userRepository;

    /**
     * 构造方法，使用依赖注入将 UserRepository 注入到服务类中。
     * @param userRepository
     */
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 获取所有用户的信息列表。
     * 调用 UserRepository 的 findAll() 方法从数据库中检索所有用户记录。
     * @return 所有用户列表
     */
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * 根据用户 ID 获取用户信息。
     * 调用 UserRepository 的 findById() 方法从数据库中检索指定 ID 的用户记录。
     * @param id
     * @return
     */
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    /**
     * 创建新用户。
     * 调用 UserRepository 的 save() 方法将新用户保存到数据库中。
     * @param user
     * @return
     */
    public User createUser(User user) {
        return userRepository.save(user);
    }

    /**
     * 更新现有用户的信息。
     * 调用 UserRepository 的 save() 方法将更新后的用户信息保存到数据库中。
     * @param id
     * @param user
     * @return
     */
    public User updateUser(Integer id, User user) {
        user.setUserId(id);
        return userRepository.save(user);
    }

    /**
     * 根据用户 ID 删除用户。
     * 调用 UserRepository 的 deleteById() 方法从数据库中删除指定 ID 的用户记录。
     * @param id
     */
    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }
}
