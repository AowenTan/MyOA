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

    @Override
    public List<Dept> findAll(){
        return deptMapper.findAll();
    }

    @Override
    public Dept findByid(int pid) {
        return deptMapper.findByid(pid);
    }

    @Override
    public void deleteDeptById(int did) { deptMapper.deleteDeptById(did); }

    @Override
    public List<Dept> findSonByPid(Integer pid) { return deptMapper.findSonByPid(pid);}
}
