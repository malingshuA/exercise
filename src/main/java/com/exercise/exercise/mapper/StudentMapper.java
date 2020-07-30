package com.exercise.exercise.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.exercise.exercise.entity.Student;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author malingshu
 * @since 2020-07-29
 */
public interface StudentMapper extends BaseMapper<Student> {

    /**
     * 根据输入的学生信息进行条件检索
     * 1. 当只输入用户名时， 使用用户名进行模糊检索；
     * 2. 当只输入邮箱时， 使用性别进行完全匹配
     * 3. 当用户名和性别都存在时， 用这两个条件进行查询匹配的用
     * @param student
     * @return
     */

    List<Student> selectByStudentSelective(Student student);

}
