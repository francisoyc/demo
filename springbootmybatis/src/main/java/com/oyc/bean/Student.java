package com.oyc.bean;

import javax.validation.constraints.*;
import java.io.Serializable;

public class Student implements Serializable {

    public Student() {}

    public Student(String name, Integer age, String sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    private Integer id;

    @NotNull(message = "姓名不为空")
    @Size(min = 1, message = "姓名不为空")
    private String name;

    @Max(value = 120, message = "年龄必须小于120岁")
    @Min(value = 1, message="年龄必须大于1岁")
    private Integer age;

    private String sex;

    @Digits(integer = 3, fraction = 0, message="班级最多为三位整数")
    private String cls;

    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCls() {
        return cls;
    }

    public void setCls(String cls) {
        this.cls = cls;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return "Student[id=" + id + ",name=" + name + ",age="
                + age + ",sex=" + sex + ",cls=" + cls + ",address="
                + address + "]" + "\n";
    }
}