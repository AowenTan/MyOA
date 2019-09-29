package com.taw.Dao;

import com.taw.bean.Dept;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface DeptMapper {
    List<Dept> findAll();
    Dept findById(@Param("pid") int pid);
}
