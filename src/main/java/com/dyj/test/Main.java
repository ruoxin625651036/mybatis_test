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

import com.dyj.dto.TeacherWithStudents;
import com.dyj.mapper.TeacherMapper;
import com.dyj.model.Student;

/**
 * a little description
 *
 * @author duanyuejiao
 */
public class Main {
    public static void main(String[] args) {
        InputStream is = null;
        try {
            is = Resources.getResourceAsStream("mybatisConfig.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
            SqlSession sqlSession = sqlSessionFactory.openSession();

            TeacherMapper teacherMapper  = sqlSession.getMapper(TeacherMapper.class);
            TeacherWithStudents teacherWithStudents = teacherMapper.getStudents(6);
            System.out.println(teacherWithStudents.getId());
            System.out.println(teacherWithStudents.getName());
            System.out.println("Students:");
            int i = 1;
            for (Student student : teacherWithStudents.getStudents()) {
                System.out.println( i + ": " + student.getName());
                i++;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
