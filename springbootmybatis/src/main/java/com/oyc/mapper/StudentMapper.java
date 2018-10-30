package com.oyc.mapper;

import com.oyc.bean.Student;
import com.oyc.sqlprovider.StudentSqlProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {

    @SelectProvider(type = StudentSqlProvider.class, method = "getListByName")
    List<Student> getListByName(String name);

    @Select("select * from student")
    List<Student> getStudentList();

    @Insert("insert into student(name, age, sex, cls, address) values(#{name}, #{age}, #{sex}, #{cls}, #{address})")
    public void addStudent(Student student);

    @Delete("delete from student where id=#{id}")
    public void deleteById(int id);

    @Update("update student set name=#{name}, age=#{age}, sex=#{sex}, cls=#{cls}, address=#{address} where id=#{id}")
    public int updateStudent(Student student);

    @Select("select * from student where id=#{id}")
    public Student getStudentById(int id);
}