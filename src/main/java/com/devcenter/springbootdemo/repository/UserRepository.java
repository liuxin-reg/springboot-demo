package com.devcenter.springbootdemo.repository;

import com.devcenter.springbootdemo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring 将会自动实现该接口，并将其作为一个 Bean （userRepository）注入到应用程序上下文中。
 * 通过继承 JpaRepository，UserRepository 接口继承了一系列用于操作 User 实体的 CRUD 方法。
 * CRUD: Create, Read, Update, Delete
 * JpaRepository 接口提供了许多内置的方法，例如：
 * - save(S entity)：保存一个实体。
 * - findById(ID id)：根据 ID 查找一个实体。
 * - findAll()：查找所有实体。
 * - deleteById(ID id)：根据 ID 删除一个实体。
 * 这些方法使得开发人员可以轻松地进行数据库操作，而无需编写大量的样板代码。
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {}
