package com.hz.spring_ioc.service.DAO;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("student")
public class Student {

    @Value("张三")
    private String name;
    @Value("20")
    private int age;

    @Resource(name = "myschool")
    private School school;


    public Student(){

    }

    public Student(String name,int age, School school){
        this.name = name;
        this.age = age;
        this.school=school;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
