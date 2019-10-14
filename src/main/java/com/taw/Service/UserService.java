package com.taw.Service;

import com.taw.bean.User;

import java.util.List;

public interface UserService {
    User login(String loginName, String password);

    List<User> findAll();

    void deleteUserById(int uid);

    void deleteUserByDid(int did);

    User findByUid(int uid);

    void resetPassword(int uid);

    void updateUser(User user);

    User check(User user);
}
