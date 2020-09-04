package com.exercise.exercise.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 员工表
 */
@Data
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String listName;
    private String email;
    private Integer sex;  // 0:女，1：男
    private Department department;
    private Date birth;

    public Employee(Integer id, String listName, String email, Integer sex, Department department) {
        this.id = id;
        this.listName = listName;
        this.email = email;
        this.sex = sex;
        this.department = department;
        //默认创建日期
        this.birth = new Date();
    }
}
