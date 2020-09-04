package com.exercise.exercise.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 部门表
 */

@Data
@AllArgsConstructor  //有参
@NoArgsConstructor   //无惨
public class Department {
    private Integer id;
    private String departmentName;
}
