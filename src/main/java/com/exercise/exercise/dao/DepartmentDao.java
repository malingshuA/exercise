package com.exercise.exercise.dao;

import com.exercise.exercise.entity.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//部门dao
@Repository
public class DepartmentDao {
    //模拟数据库的数据

    private static Map<Integer, Department> departments = null;

    static {
        departments = new HashMap<Integer, Department>();   //创建一个部门表

        departments.put(101,new Department(101,"部门1"));
        departments.put(101,new Department(102,"部门2"));
        departments.put(101,new Department(103,"部门3"));
        departments.put(101,new Department(104,"部门4"));
        departments.put(101,new Department(105,"部门5"));
        departments.put(101,new Department(106,"部门6"));
        departments.put(101,new Department(107,"部门7"));
        departments.put(101,new Department(108,"部门8"));
    }

    //获得所有部门信息：
    public Collection<Department> getDepartments(){
        return departments.values();
    }
    //通过id得到部门：
    public Department getdepartmentById(Integer id){
        return departments.get(id);
    }
}
