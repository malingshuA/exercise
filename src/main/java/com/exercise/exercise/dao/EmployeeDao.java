package com.exercise.exercise.dao;

import com.exercise.exercise.entity.Department;
import com.exercise.exercise.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户表
 */
@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer, Employee>();   //创建一个用户表

        employees.put(1001,new Employee(1001,"person","11111@22.com",0,new Department(101,"部门1")));
        employees.put(1002,new Employee(1002,"person","11111@22.com",1,new Department(102,"部门2")));
        employees.put(1003,new Employee(1003,"person","11111@22.com",0,new Department(103,"部门3")));
        employees.put(1004,new Employee(1004,"person","11111@22.com",1,new Department(104,"部门4")));
        employees.put(1005,new Employee(1005,"person","11111@22.com",0,new Department(105,"部门5")));
        employees.put(1006,new Employee(1006,"person","11111@22.com",1,new Department(106,"部门6")));
        employees.put(1007,new Employee(1007,"person","11111@22.com",1,new Department(107,"部门7")));

    }

    // 主键自增
    private static Integer initId = 1008;
    // 增加一个员工
    public void save(Employee employee){

        if(employee.getId()==null){
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDao.getdepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(),employee);
    }

    // 查询全部员工
    public Collection<Employee> getAll(){
        return employees.values();
    }

    // 通过ID查询员工
    public Employee employeeById(Integer id){
        return employees.get(id);
    }

    // 通过Id删除员工
    public void delete(Integer id){
        employees.remove(id);
    }




}
