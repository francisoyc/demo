package com.oyc.service;

import com.github.pagehelper.PageInfo;
import com.oyc.bean.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getListByName(String name);

    public void addStudent(Student student);

    public void deleteById(int id);

    public int updateStudent(Student student);

    public Student getStudentById(int id);

    public List<Student> getStudentList();

}