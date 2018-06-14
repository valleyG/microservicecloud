package com.mysit.springclond.controller;

import com.mysit.springclond.pojos.Department;
import com.mysit.springclond.service.DepartmentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department/")
public class DepartmentController {


    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    //一旦调用服务方法失败并抛出了错误信息后，就会自动调用@HystrixCommand标注好的fallbackMethod调用类中指定的方法
    //说白了就是给这个微服务方法解决后顾之忧，就算你报错抛异常，我也可以给你服务调用者返回一个你服务调用方可以接受的结果
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Department get(@PathVariable("id") Integer id) {

        Department department = this.departmentService.findDepartmentById(id);
        if (department == null) {
            throw new RuntimeException("该部门ID" + id + "不存在对应部门信息存在");
        }
        return department;
    }

    public Department processHystrix_Get(@PathVariable("id") Integer id) {

        return new Department().setId(id).setDepartmentName("该ID" + id + "没有对应的部门信息，null--@HystrixCommand")
                .setDatabaseSource("No this database in mysql");

    }

}
