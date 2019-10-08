package com.taw.Service;

import com.taw.bean.Dept;

import java.util.List;

public interface DeptService {
    List<Dept> findAll();
    Dept findById(int pid);
    void deleteDeptById(int did);
}
