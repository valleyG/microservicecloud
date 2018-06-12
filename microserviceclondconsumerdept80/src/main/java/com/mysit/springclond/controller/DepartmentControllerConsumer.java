package com.mysit.springclond.controller;

import com.mysit.springclond.pojos.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * 部门微服务的消费controller
 * 这个类只是消费者 在这个微服务里面不应该有service层这些东西
 */
@RestController
@RequestMapping("/consumer/department/")
public class DepartmentControllerConsumer {

//    private static final String REST_URI_PREFIX = "http://localhost:8001/";
    private static final String REST_URI_PREFIX = "http://MICROSERVICECLOUD-DEPT";//因为Ribbon和Eureka整合后就可以直接通过服务名称去调用服务而不用去关心地址和端口号

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 根据id查询部门
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "get/{id}", method = RequestMethod.GET)
    public Department get(@PathVariable("id") Integer id) {
        return this.restTemplate.getForObject(REST_URI_PREFIX + "/department/get/" + id, Department.class);
    }

    /**
     * 添加部门信息
     *
     * @param department
     * @return
     */
    @RequestMapping(value = "add", method = RequestMethod.GET)
    public boolean add(Department department) {
        /**
         * RestTemplate的调用是简单粗暴的
         * RestTemplate的postForObject的方法参数
         * url是请求的服务提供者的地址，request是请求的参数，responseType是服务请求的响应类型（class）
         */
        return this.restTemplate.postForObject(REST_URI_PREFIX + "/department/add", department, Boolean.class);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public List<Department> list() {
        return restTemplate.getForObject(REST_URI_PREFIX + "/department/list", List.class);
    }


    @RequestMapping(value = "discovery", method = RequestMethod.GET)
    public Object discovery() {
        return restTemplate.getForObject(REST_URI_PREFIX + "/department/discovery", Object.class);
    }
}
