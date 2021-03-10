package com.example.demo.service;

import com.example.demo.model.Student;
import com.example.demo.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Function select all the Students from the DB
    public List<Student> getAll(){
        return studentRepository.findAll();
    }

    // Function get a Student by the StudentId
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }


    // Function insert a new Student in the DB
    public void insertStudent(Student student){
        studentRepository.save(student);
    }

    // Function delete a Student from the DB by a StudentId
    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }

    // Function update a Student from the DB by a StudentId;
    public void updateStudent(Long id,Student student){
        Optional<Student> s = studentRepository.findById(id);
        if (s.isPresent()){
            student.setId(id);
            studentRepository.save(student);
        }
        else{
            throw  new IllegalStateException("there is no student with this id "+ id);
        }
    }



}

