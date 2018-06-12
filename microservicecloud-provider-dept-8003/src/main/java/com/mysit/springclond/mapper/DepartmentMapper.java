package com.mysit.springclond.mapper;

import com.mysit.springclond.pojos.Department;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentMapper {

    boolean addDepartment(Department department);

    Department findById(Integer id);

    List<Department> findAll();
}
