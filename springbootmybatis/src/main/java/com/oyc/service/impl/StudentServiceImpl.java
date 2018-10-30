package com.oyc.service.impl;

import com.oyc.bean.Student;
import com.oyc.mapper.StudentMapper;
import com.oyc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("studentService")
//@Transactional
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Student> getListByName(String name) {
        return studentMapper.getListByName(name);
    }

    @Override
    public void addStudent(Student student) {
        studentMapper.addStudent(student);
    }

    @Override
    public void deleteById(int id) {
        studentMapper.deleteById(id);
    }

    @Override
    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    @Override
    public Student getStudentById(int id) {
        return studentMapper.getStudentById(id);
    }

    @Override
    public List<Student> getStudentList() {
        return studentMapper.getStudentList();
    }
}