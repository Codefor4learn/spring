package com.hz.spring_mybatis.service.Impl;

import com.hz.spring_mybatis.dao.StudentDao;
import com.hz.spring_mybatis.domain.Student;
import com.hz.spring_mybatis.service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao;

    public void setStudentDao(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @Override
    public int addStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    @Override
    public List<Student> queryStudent() {
        return studentDao.selectStudents();
    }
}
