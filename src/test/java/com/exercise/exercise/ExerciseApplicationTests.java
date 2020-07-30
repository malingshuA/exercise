package com.exercise.exercise;

import com.exercise.exercise.entity.Student;
import com.exercise.exercise.mapper.StudentMapper;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ExerciseApplicationTests {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;
    @Test
    void contextLoads() {
    }

    @Test
    public void selectByStudent() {
        SqlSession sqlSession = null;
        sqlSession = sqlSessionFactory.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

        Student search = new Student();
        search.setName("明");

        System.out.println("只有名字时的查询");
        List<Student> studentsByName = studentMapper.selectByStudentSelective(search);
        for (int i = 0; i < studentsByName.size(); i++) {
            System.out.println(ToStringBuilder.reflectionToString(studentsByName.get(i), ToStringStyle.MULTI_LINE_STYLE));
        }

        search.setName(null);
        //search.setSex((byte) 1);
        System.out.println("只有性别时的查询");
        List<Student> studentsBySex = studentMapper.selectByStudentSelective(search);
        for (int i = 0; i < studentsBySex.size(); i++) {
            System.out.println(ToStringBuilder.reflectionToString(studentsBySex.get(i), ToStringStyle.MULTI_LINE_STYLE));
        }

        System.out.println("姓名和性别同时存在的查询");
        search.setName("明");
        List<Student> studentsByNameAndSex = studentMapper.selectByStudentSelective(search);
        for (int i = 0; i < studentsByNameAndSex.size(); i++) {
            System.out.println(ToStringBuilder.reflectionToString(studentsByNameAndSex.get(i), ToStringStyle.MULTI_LINE_STYLE));
        }

        sqlSession.commit();
        sqlSession.close();
    }

}
