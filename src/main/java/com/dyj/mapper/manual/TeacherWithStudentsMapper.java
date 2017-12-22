package com.dyj.mapper.manual;

import com.dyj.dto.TeacherWithStudents;

/**
 * a little description
 *
 * @author dyj
 */
public interface TeacherWithStudentsMapper {

    /**
     *   add by manual, 怎样与已经存在的xml文件关联起来？
     * @param i
     * @return
     */
    TeacherWithStudents getStudents(int i);
}
