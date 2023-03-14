package com.babikk.dbDemo.rest;

import com.babikk.dbDemo.dao.StudentDAO;
import com.babikk.dbDemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    List<Student> students;
    @Autowired
    StudentDAO dao;

    @PostConstruct
    void loadData(){
       this.students  = dao.findAll();
    }
@GetMapping("/students")
    public List<Student> getStudents(){
    return students;
}

    @GetMapping("/students/{studentId}")
    public Student getStudentsById(@PathVariable int studentId){
       return students.get(studentId);
    }
}

