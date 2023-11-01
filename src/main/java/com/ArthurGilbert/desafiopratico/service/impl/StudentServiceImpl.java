package com.ArthurGilbert.desafiopratico.service.impl;

import com.ArthurGilbert.desafiopratico.model.Student;
import com.ArthurGilbert.desafiopratico.repository.StudentRepository;
import com.ArthurGilbert.desafiopratico.service.StudentService;
import com.ArthurGilbert.desafiopratico.service.exception.BusinessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class StudentServiceImpl implements StudentService {

    private static final Long UNCHANGEABLE_STUDENT_ID = 1L;

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public Student create(Student studentToCreate) {
        return studentRepository.save(studentToCreate);
    }

    @Override
    public List<Student> findAll() {
        return this.studentRepository.findAll();

    }

    public Student update(Long id, Student studentToUpdate) {
        this.validateChangeableId(id, "updated");
        Student dbStudent = this.findById(id);
        if (!dbStudent.getId().equals(studentToUpdate.getId())) {
            throw new BusinessException("Update IDs must be the same.");
        }

        dbStudent.setName(studentToUpdate.getName());
        dbStudent.setTeachersName(studentToUpdate.getTeachersName());
        dbStudent.setAge(studentToUpdate.getAge());
        //dbStudent.setfirstSemesterGrade(studentToUpdate.getfirstSemesterGrade());
        //dbStudent.setsecondSemesterGrade(studentToUpdate.getsecondSemesterGrade());
       // dbStudent.setroomNumber(studentToUpdate.getroomNumber());

        return this.studentRepository.save(dbStudent);
    }
    @Override
    public void delete(Long id) {

    }

    private void validateChangeableId(Long id, String operation) {
        if (UNCHANGEABLE_STUDENT_ID.equals(id)) {
            throw new BusinessException("Student with ID %d can not be %s.".formatted(UNCHANGEABLE_STUDENT_ID, operation));
        }
    }


}
