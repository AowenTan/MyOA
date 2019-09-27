package com.taw.Service;

import com.taw.bean.User;

import java.util.List;

public interface UserService {
    User login(String loginName, String password);

    List<User> findAll();
}
