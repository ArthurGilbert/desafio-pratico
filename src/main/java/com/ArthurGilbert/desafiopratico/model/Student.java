package com.ArthurGilbert.desafiopratico.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name = "tb_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer age;
    private Float firstSemesterGrade;
    private Float secondSemesterGrade;
    private String teachersName;
    private Integer roomNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getfirstSemesterGrade() {
        return firstSemesterGrade;
    }

    public void setfirstSemesterGrade(Float firstSemesterGrade) {
        this.firstSemesterGrade = firstSemesterGrade;
    }

    public Float getsecondSemesterGrade() {
        return secondSemesterGrade;
    }

    public void setsecondSemesterGrade(Float secondSemesterGrade) {
        this.secondSemesterGrade = secondSemesterGrade;
    }

    public String getTeachersName() {
        return teachersName;
    }

    public void setTeachersName(String teachersName) {
        this.teachersName = teachersName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getroomNumber() {
        return roomNumber;
    }

    public void setroomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }
}
