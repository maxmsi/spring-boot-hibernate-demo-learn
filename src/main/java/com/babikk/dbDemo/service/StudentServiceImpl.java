package com.babikk.dbDemo.service;

import com.babikk.dbDemo.dao.StudentDAO;
import com.babikk.dbDemo.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentDAO dao;

    public StudentServiceImpl() {
    }

    @Override
    public List<Student> findAll() {
        return dao.findAll();
    }

    @Override
    public Student findStudentById(int id) {
        return dao.findById(id);
    }

    @Override
    @Transactional
    public Student saveStudent(Student student) {
        dao.save(student);
        return student;
    }

    @Transactional
    @Override
    public void deleteStudent(int id) {
        dao.deleteById(id);
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) {
        dao.save(student);
        return student;
    }
}
