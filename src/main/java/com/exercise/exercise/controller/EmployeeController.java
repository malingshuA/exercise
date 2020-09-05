package com.exercise.exercise.controller;

import com.exercise.exercise.dao.EmployeeDao;
import com.exercise.exercise.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    //查询
    @RequestMapping("/emps")
    public Collection<Employee> list(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        //model.addAttribute("emps",employees);
        System.out.println(employees);
        return employees;
    }

    @RequestMapping("/add")
    public List<Employee> add(@RequestParam("") Employee employee){

    }
}
