package com.babikk.dbDemo.rest;

import com.babikk.dbDemo.dao.StudentDAO;
import com.babikk.dbDemo.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    @Autowired
    StudentDAO dao;
@GetMapping("/students")
    public List<Student> getStudents(){
    List<Student> result  = dao.findAll();
    return result;
}

}

