package com.librarymanagementsystem.practice.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.librarymanagementsystem.practice.entities.Student;
import com.librarymanagementsystem.practice.repository.StudentRepository;


@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

   
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    
    public Student updateStudent(Long id, Student newStudent) {

        Student student = studentRepository.findById(id).orElse(null);

        if (student != null) {
            student.setName(newStudent.getName());
            student.setEmail(newStudent.getEmail());
            student.setMobile(newStudent.getMobile());

            return studentRepository.save(student);
        }

        return null;
    }

 
    public String deleteStudent(Long id) {

        Student student = studentRepository.findById(id).orElse(null);

        if (student != null) {
            studentRepository.delete(student);
            return "Student Deleted Successfully";
        }

        return "Student Not Found";
    }

}