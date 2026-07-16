package com.librarymanagementsystem.practice.contoller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.librarymanagementsystem.practice.entities.Student;
import com.librarymanagementsystem.practice.services.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
@Validated
public class StudentController {

    @Autowired
    private StudentService studentService;

    
    @PostMapping
    public ResponseEntity<Student> addStudent(@Valid @RequestBody Student student) {

        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.CREATED);
    }

    
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {

        return ResponseEntity.ok(studentService.getAllStudents());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {

        Student student = studentService.getStudentById(id);

        if (student == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(student);
    }

   
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,
                                                 @Valid @RequestBody Student student) {

        Student updatedStudent = studentService.updateStudent(id, student);

        if (updatedStudent == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedStudent);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable Long id) {

        String message = studentService.deleteStudent(id);

        if (message.equals("Student Not Found")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }

        return ResponseEntity.ok(message);
    }
}