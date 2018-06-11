package com.mysit.springclond.controller;

import com.mysit.springclond.pojos.Department;
import com.mysit.springclond.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department/")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public boolean add(@RequestBody Department department) {
        return this.departmentService.addDepartment(department);
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public Department get(@PathVariable("id") Integer id) {
        return this.departmentService.findDepartmentById(id);
    }

    @RequestMapping(value = "list",method = RequestMethod.GET)
    public List<Department> list() {
        return this.departmentService.findAllDepartment();
    }
}
