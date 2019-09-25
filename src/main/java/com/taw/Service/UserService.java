package com.taw.Service;

import com.taw.bean.User;

public interface UserService {
    User login(String loginName, String password);
}
