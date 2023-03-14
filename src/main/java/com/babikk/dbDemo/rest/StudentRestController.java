package com.babikk.dbDemo.rest;

import com.babikk.dbDemo.dao.StudentDAO;
import com.babikk.dbDemo.entity.Student;
import com.babikk.dbDemo.service.StudentService;
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
    StudentService studentService;

    @PostConstruct
    void loadData(){
       this.students  = studentService.findAll();
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

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student ){

        student.setId(0L);
        studentService.saveStudent(student);
        return student;
    }
    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student ){


        Student studentDb=studentService.updateStudent(student);
        return studentDb;
    }

    @DeleteMapping("/students/{studentId}")
    public void deleteStudent(@PathVariable int studentId){

            studentService.deleteStudent(studentId);

    }


}

