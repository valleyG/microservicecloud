package com.mysit.springclond.service.impl;

import com.mysit.springclond.mapper.DepartmentMapper;
import com.mysit.springclond.pojos.Department;
import com.mysit.springclond.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;


    @Override
    public boolean addDepartment(Department department) {
        if (department == null) {
            throw new IllegalArgumentException("参数不合法");
        }
        return this.departmentMapper.addDepartment(department);
    }

    @Override
    public Department findDepartmentById(Integer id) {
        return this.departmentMapper.findById(id);
    }

    @Override
    public List<Department> findAllDepartment() {
        return this.departmentMapper.findAll();
    }
}
