package com.mysit.springclond.controller;

import com.mysit.springclond.pojos.Department;
import com.mysit.springclond.service.DepartmentService;
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

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "add", method = RequestMethod.POST)
    public boolean add(@RequestBody Department department) {
        return this.departmentService.addDepartment(department);
    }

    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public Department get(@PathVariable("id") Integer id) {
        return this.departmentService.findDepartmentById(id);
    }

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<Department> list() {
        return this.departmentService.findAllDepartment();
    }

    @RequestMapping(value = "discovery", method = RequestMethod.GET)
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        System.out.println("*********" + services);

        List<ServiceInstance> instances = discoveryClient.getInstances("MICROSERVICECLOUD-DEPT");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getHost() + instance.getPort() + instance.getUri() + instance.getServiceId());

        }

        return this.discoveryClient;
    }
}
