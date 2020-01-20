package com.example.bootDemo.user.mapper;

import com.example.bootDemo.user.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {

    List<User> listUsers(@Param("name") String name);

    int addUser(@Param("user") User user);

    void deleteUser(@Param("user") User user);

    void updateUser(@Param("user") User user);

    void reSetPwd(@Param("user") User user);
}
