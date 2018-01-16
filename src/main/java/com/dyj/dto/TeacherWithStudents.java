package com.dyj.dto;

import java.util.List;

import com.dyj.model.Student;

/**
 * a little description
 *
 * @author dyj
 */
public class TeacherWithStudents {

    private int id;
    private String name;
    List<Student> students;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
