package com.taw.Dao;

import com.taw.bean.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserMapper {

    User findUserByloginNameAndPassword(@Param("loginName") String loginName, @Param("password") String password);
    User findUser(String loginName,String password);
}
