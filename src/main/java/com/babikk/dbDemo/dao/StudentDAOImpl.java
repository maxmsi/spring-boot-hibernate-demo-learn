package com.babikk.dbDemo.dao;

import com.babikk.dbDemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    @Autowired
    private EntityManager entityManager;

    @Override
    public void deleteById(int id) {
       Student student= entityManager.find(Student.class,id);
       entityManager.remove(student);
    }

    @Override
    public Student save(Student student) {
        entityManager.merge(student);
        return student;
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> query= entityManager.createQuery("FROM Student",Student.class);
        return query.getResultList();
    }

    @Override
    public List<Student> findByLastName(String data) {
        TypedQuery<Student> query= entityManager.createQuery("FROM Student WHERE last_name=:data",Student.class);
        query.setParameter("data",data);
        return query.getResultList();
    }
}
