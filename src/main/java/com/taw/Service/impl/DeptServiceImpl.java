package com.taw.Service.impl;

import com.taw.Dao.DeptMapper;
import com.taw.Service.DeptService;
import com.taw.bean.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("DeptService")
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;


    public List<Dept> findAll(){
        return deptMapper.findAll();
    }

    @Override
    public Dept findById(int pid) {
        return deptMapper.findById(pid);
    }
}
