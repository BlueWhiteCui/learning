package org.example.impl;

import org.apache.dubbo.config.annotation.DubboService;
import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.stereotype.Component;

@DubboService
//@Component
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
