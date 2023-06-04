package org.example.impl;

import org.example.entity.User;
import org.example.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public User getUser(Long id) {
        User user = new User();
        user.setId(id);
        user.setName("zhangsan");
        user.setSex("男");
        return user;
    }
}
