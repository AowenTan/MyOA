package com.taw.Dao;

import com.taw.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface UserMapper {

    User findUserByloginNameAndPassword(@Param("loginName") String loginName, @Param("password") String password);
    List<User> findAll();
    void deleteUserById(@Param("uid") int uid);
    void deleteUserByDid(@Param("did") int did);
    User findByUid(@Param("uid") int uid);
    void resetPassword(@Param("uid") int uid);
    void updateUser(@Param("user") User user);
    User check(@Param("user") User user);
    void register(@Param("user") User user);
}
