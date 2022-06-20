package com.lisa.demo.controllers;


import com.lisa.demo.entities.Student;
import com.lisa.demo.repositories.StudentRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
    //Inserts a student into the database
    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentRepository.save(student), HttpStatus.CREATED);
    }
    //Retrives all students from the database
    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
    }
    //Retrives a single student with the specified email from the database
    @GetMapping("/{email}")
    public ResponseEntity<Student> getStudentByEmail(@PathVariable("email") String email) {
        return new ResponseEntity<>(studentRepository.findStudentByEmail(email).orElseThrow(IllegalStateException::new), HttpStatus.OK);
    }
    //Updates the student with the email passed as path variable
    @PutMapping("/{email}")
    public ResponseEntity<Student> updateStudent(@PathVariable("email") String email, @RequestBody Student student) {
        Student dbStudent = studentRepository.findStudentByEmail(email).orElseThrow(IllegalAccessError::new);
        dbStudent.setCourse(student.getCourse());
        dbStudent.setFirstName(student.getFirstName());
        dbStudent.setLastName(student.getLastName());
        return new ResponseEntity<>(studentRepository.save(dbStudent), HttpStatus.OK);
    }
    //Deletes a student with the email passed as the path variable
    @DeleteMapping("/{email}")
    public ResponseEntity<String> deleteStudent(@PathVariable("email") String email) {
        studentRepository.deleteStudentByEmail(email);
        return new ResponseEntity<>("Student deleted successfully", HttpStatus.NO_CONTENT);
    }
}
