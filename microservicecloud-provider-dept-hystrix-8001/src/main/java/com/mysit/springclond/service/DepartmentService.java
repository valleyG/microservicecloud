package com.mysit.springclond.service;

import com.mysit.springclond.pojos.Department;

import java.util.List;

public interface DepartmentService {
    /**
     * 添加部门
     * @param department
     * @return
     */
    boolean addDepartment(Department department);

    /**
     * 根据departmentId查询部门信息
     * @param id
     * @return
     */
    Department findDepartmentById(Integer id);

    /**
     * 查询所有的部门信息
     * @return
     */
    List<Department> findAllDepartment();
}
