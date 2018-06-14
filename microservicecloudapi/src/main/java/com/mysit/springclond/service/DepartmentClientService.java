package com.mysit.springclond.service;

import com.mysit.springclond.pojos.Department;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
//指定我们自定义接口对应的服务,并且指定我们fallback处理
@FeignClient(value = "MICROSERVICECLOUD-DEPT",fallbackFactory = DepartmentClientServiceFallbackFactory.class)
public interface DepartmentClientService {


    @RequestMapping(value = "/department/get/{id}", method = RequestMethod.GET)
    Department get(@PathVariable(value = "id") Integer id);

    @RequestMapping(value = "/department/list", method = RequestMethod.GET)
    List<Department> list();

    @RequestMapping(value = "department/add", method = RequestMethod.POST)
    boolean add(Department department);
}
