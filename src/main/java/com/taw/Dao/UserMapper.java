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
}
