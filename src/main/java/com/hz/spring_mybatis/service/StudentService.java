package com.hz.spring_mybatis.service;

import com.hz.spring_mybatis.domain.Student;

import java.util.List;

public interface StudentService {

    int addStudent(Student student);

    List<Student> queryStudent();
}
