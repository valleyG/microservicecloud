package com.mysit.springclond.pojos;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Department implements Serializable {

    private static final long serialVersionUID = 7506911655071863408L;
    private Integer id;
    private String departmentName;
    private String databaseSource;

}
