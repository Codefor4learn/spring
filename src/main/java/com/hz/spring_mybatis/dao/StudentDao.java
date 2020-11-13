package com.hz.spring_mybatis.dao;

import com.hz.spring_mybatis.domain.Student;

import java.util.List;

public interface StudentDao {

    int insertStudent(Student student);

    List<Student> selectStudents();
}
