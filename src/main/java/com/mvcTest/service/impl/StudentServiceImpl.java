package com.mvcTest.service.impl;

import com.mvcTest.dao.StudentDao;
import com.mvcTest.entity.Student;
import com.mvcTest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> userList() {
        return studentDao.userList();
    }

    @Override
    public List<Student> userListWithModific() {
        List<Student> studentList = studentDao.userList();
        for (Student student : studentList) {
            student.setName(student.getName() + " -word");
        }
        return studentList;
    }

    @Override
    public Map<Student, String> userListWithCel() {
        List<Student> studentList = studentDao.userList();
        Map<Student, String> userSelary = new HashMap<>();
        for (int i = 0; i < studentList.size(); i++) {
            userSelary.put(studentList.get(i), String.valueOf(i + 100));
        }
        return userSelary;
    }

    @Override
    public Student getById() {
        return null;
    }
}
