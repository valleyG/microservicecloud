package com.mysit.springclond.service;

import com.mysit.springclond.pojos.Department;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 相当于spring中AOP的异常通知
 */
@Component    //千万不要忘记在这个类上加上组件扫描
public class DepartmentClientServiceFallbackFactory implements FallbackFactory<DepartmentClientService> {


    @Override
    public DepartmentClientService create(Throwable throwable) {
        /**
         *
         * 在真正的开发中这里就可以去处理你的自定义异常，然后根据不同的异常去对相应的异常做出处理
         *
         */

        if (throwable instanceof RuntimeException){
            RuntimeException exc = (RuntimeException) throwable;
            return new DepartmentClientService() {
                @Override
                public Department get(Integer id) {
                    return new Department().setId(id).setDepartmentName("该ID"+id+"，没有该id对应的信息，"+exc.getMessage()+"此时provider已经暂停服务")
                            .setDatabaseSource("no this database in Mysql");
                }

                @Override
                public List<Department> list() {
                    return null;
                }

                @Override
                public boolean add(Department department) {
                    return false;
                }
            };
        }
        return new DepartmentClientService() {
            @Override
            public Department get(Integer id) {
                return new Department().setId(id).setDepartmentName("该ID"+id+"，没有该id对应的信息，consumer客户端服务降级，此时provider已经暂停服务")
                        .setDatabaseSource("no this database in Mysql");
            }

            @Override
            public List<Department> list() {
                return null;
            }

            @Override
            public boolean add(Department department) {
                return false;
            }
        };
    }

}
