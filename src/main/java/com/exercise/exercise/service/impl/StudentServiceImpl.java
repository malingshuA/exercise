package com.exercise.exercise.service.impl;

import com.exercise.exercise.entity.Student;
import com.exercise.exercise.mapper.StudentMapper;
import com.exercise.exercise.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author malingshu
 * @since 2020-07-29
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

    @Override
    public Student shouye() {

        return null;
    }
}
