package com.babikk.dbDemo.rest;

import com.babikk.dbDemo.dao.StudentDAO;
import com.babikk.dbDemo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        if(studentId>=students.size() || studentId<0){
            throw new StudentNotFoundException("Student id not found" + studentId);
        }
       return students.get(studentId);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleExc(StudentNotFoundException exc){
         StudentErrorResponse error =new StudentErrorResponse();

         error.setStatus(HttpStatus.NOT_FOUND.value());
         error.setMessage(exc.getMessage());
         error.setTimeStamp(System.currentTimeMillis());

         return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }



}

