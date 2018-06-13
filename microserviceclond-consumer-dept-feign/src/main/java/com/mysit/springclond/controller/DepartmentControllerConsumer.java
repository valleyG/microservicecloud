package com.mysit.springclond.controller;

import com.mysit.springclond.pojos.Department;
import com.mysit.springclond.service.DepartmentClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/consumer/department/")
public class DepartmentControllerConsumer {

    @Autowired
    private DepartmentClientService service;          //注入我们的Feign定义的服务接口

    /**
     * 根据id查询部门
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public Department get(@PathVariable("id") Integer id) {
        return this.service.get(id);
    }

    /**
     * 添加部门信息
     *
     * @param department
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public boolean add(Department department) {

        return this.service.add(department);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<Department> list() {
        return this.service.list();
    }

}
