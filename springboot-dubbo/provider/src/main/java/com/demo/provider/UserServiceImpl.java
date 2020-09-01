package com.demo.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.demo.api.User;
import com.demo.api.UserService;

@Service(version = "1.0.0")
public class UserServiceImpl implements UserService {

    @Override
    public User getUser() {
        User user = new User();
        user.setId(1L);
        user.setUsername("没想到吧");
        user.setPassword("123456");
        return user;
    }
}
