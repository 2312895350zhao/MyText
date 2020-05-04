package com.itheima.controller;

import com.itheima.domain.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * com.itheima.controller
 * Created on 2020/3/13.
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/find/{id}")
    public User findById(@PathVariable(value = "id") Integer id){
        User user = userService.findUserById(id);
        user.setUsername(user+"     user-provider");
        return user;
    }
}
