package com.taw.Service.impl;

import com.taw.Dao.UserMapper;
import com.taw.Service.UserService;
import com.taw.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        List<User> userList = userMapper.findAll();
        return userList;
    }

    //登录
    @Override
    public User login(String loginName, String password) {
        System.out.println("doing: service login");
        User user = new User();
        System.out.println("loginName："+loginName);
        user = userMapper.findUserByloginNameAndPassword(loginName, password);
        return user;
    }
}
