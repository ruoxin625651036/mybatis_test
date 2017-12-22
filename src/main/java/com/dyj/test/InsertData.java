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
 * @author dyj
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
            teacherMapper.insert(teacher);

            StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
            Student student = new Student();
            student.setName("xiaoming");
            // 由selectKey实现的
            student.setTeacherId(teacher.getId());
            studentMapper.insert(student);

            Student student2 = new Student();
            student2.setName("xiaozhang");
            student2.setTeacherId(teacher.getId());
            studentMapper.insert(student2);

            // 在默认情况下事务提交commit是false
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
