package com.demo.consumer;

import com.alibaba.dubbo.config.annotation.Reference;
import com.demo.api.User;
import com.demo.api.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Reference(version = "1.0.0")
    private UserService userService;

    @RequestMapping("/getUser")
    public User getUserList() {
        return userService.getUser();
    }
}
