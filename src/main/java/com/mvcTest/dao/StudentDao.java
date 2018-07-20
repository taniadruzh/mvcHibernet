package com.mvcTest.dao;

import com.mvcTest.entity.Student;

import java.util.List;

public interface StudentDao {

    List<Student> userList();

    List<Student> getAllUserWithNameAndPintOnly();

    Student UserByUsername(String name);

    Student getById(long id);

    void remove(Student student);

    void  add(Student student);

    void update(Student student);

    void saveOrUpdate(Student entity);
}
