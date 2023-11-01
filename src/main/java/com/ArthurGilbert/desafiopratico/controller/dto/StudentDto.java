package com.ArthurGilbert.desafiopratico.controller.dto;

import com.ArthurGilbert.desafiopratico.model.Student;

public record StudentDto(Long id, String name, Integer age, Float firstSemesterGrade, Float secondSemesterGrade, String teachersName, Integer roomNumber) {

    public StudentDto(Student model) {
        this(model.getId(), model.getName(), model.getAge(), model.getFirstSemesterGrade(), model.getSecondSemesterGrade(), model.getTeachersName(), model.getRoomNumber());
    }

    public Student toModel() {
        Student model = new Student();
        model.setId(this.id);
        model.setName(this.name);
        model.setAge(this.age);
        model.setFirstSemesterGrade(this.firstSemesterGrade);
        model.setSecondSemesterGrade(this.secondSemesterGrade);
        model.setTeachersName(this.teachersName);
        model.setRoomNumber(this.roomNumber);
        return model;
    }

}
