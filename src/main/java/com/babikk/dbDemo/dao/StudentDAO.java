package com.babikk.dbDemo.dao;

import com.babikk.dbDemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void deleteById(int id);
    Student save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String data);

}
