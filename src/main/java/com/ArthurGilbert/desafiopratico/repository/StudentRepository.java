package com.ArthurGilbert.desafiopratico.repository;


import com.ArthurGilbert.desafiopratico.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
