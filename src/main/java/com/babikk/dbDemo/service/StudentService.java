package com.babikk.dbDemo.service;

import com.babikk.dbDemo.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student findStudentById(int id);
    Student saveStudent(Student student);

    void deleteStudent(int id);

    Student updateStudent(Student student);


}
