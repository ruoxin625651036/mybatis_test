/**
 * Baifubao.com,Inc.
 * Copyright (c) 2017-2018 All Rights Reserved.
 */
package com.dyj.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.dyj.mapper.StudentMapper;
import com.dyj.mapper.TeacherMapper;
import com.dyj.model.Student;
import com.dyj.model.Teacher;

/**
 * a little description
 *
 * @author duanyuejiao
 */
public class InsertData {
    public static void main(String[] args) {
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatisConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
            Teacher teacher = new Teacher();
            teacher.setName("zhangsan");
            // 当执行insert语句后，可以填充id值，这个由什么来设置？
            // 这个存在两个实现，一是在insert标签下添加子标签SelectKey或者是添加属性useGeneratedKeys
            // 如果insert标签下两个都存在，则以SelectKey为准
            teacherMapper.insert(teacher);
            sqlSession.commit();

            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            Student student = new Student();
            student.setName("xiaoming");
            student.setTeacherId(teacher.getId());
            studentMapper.insert(student);

            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
