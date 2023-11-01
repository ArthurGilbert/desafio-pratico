package com.ArthurGilbert.desafiopratico.controller;

import com.ArthurGilbert.desafiopratico.controller.dto.StudentDto;
import com.ArthurGilbert.desafiopratico.model.Student;
import com.ArthurGilbert.desafiopratico.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/students")
@Tag(name = "Students Controller", description = "API Rest for managing students.")
public record StudentController(StudentService studentService) {

    //@GetMapping
    //@Operation(summary = "Get all students", description = "Retrieve a list of all registered students")
    //@ApiResponses(value = {
     //       @ApiResponse(responseCode = "200", description = "Operation successful")
    //})
    //public ResponseEntity<List<Student>> findAll() {
     //   var students = studentService.findAll();
       // var studentsAll = students.stream().map(studentsAll::new).collect(Collectors.toList());
       // return ResponseEntity.ok(studentsAll);
    //}
    @GetMapping("/{id}")
    @Operation(summary = "Get a student by ID", description = "Retrieve a specific student based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation successful"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    public ResponseEntity<Student> findById(@PathVariable Long id) {
        var student = studentService.findById(id);
        return ResponseEntity.ok(student);
    }

    @PostMapping
    @Operation(summary = "Create a new student", description = "Create a new student and return the created student's data")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Student created successfully"),
            @ApiResponse(responseCode = "422", description = "Invalid Student data provided")
    })
    public ResponseEntity<Student> create(@RequestBody Student studentToCreate) {
        var studentCreate = studentService.create(studentToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(studentCreate.getId())
                .toUri();
        return ResponseEntity.created(location).body(studentCreate);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a student", description = "Update the data of an existing user based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Student updated successfully"),
            @ApiResponse(responseCode = "404", description = "Student not found"),
            @ApiResponse(responseCode = "422", description = "Invalid student data provided")
    })
    public ResponseEntity<StudentDto> update(@PathVariable Long id, @RequestBody StudentDto studentDto) {
        var student = studentService.update(id, studentDto.toModel());
        return ResponseEntity.ok(new StudentDto(student));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a student", description = "Delete an existing user based on its ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Student deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Student not found")
    })
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
