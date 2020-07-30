package com.exercise.exercise.controller;


import com.exercise.exercise.entity.Student;
import com.exercise.exercise.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author malingshu
 * @since 2020-07-29
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentMapper studentMapper;

    public Object selectByStudentSelective(Student student){
        Student student1 = new Student();
        student1.setName("11");
        List<Student> aa = studentMapper.selectByStudentSelective(student1);
        for(int i = 0; i<aa.size();i++){
            System.out.println(aa);
        }
        return null;
    }

}

