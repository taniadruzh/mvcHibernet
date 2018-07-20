package com.mvcTest.config;

import com.mvcTest.dao.StudentDao;
import com.mvcTest.entity.Student;
import com.mvcTest.entity.StudentTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class InitDataToDb {

    @Autowired
    private StudentDao studentDao;


    @PostConstruct
    private void init() {

        Student student = new Student();
        List<StudentTask> studentTaskList = new ArrayList<>();
        StudentTask studentTask1 = new StudentTask("task1", student);
        StudentTask studentTask2 = new StudentTask("task2", student);
        StudentTask studentTask3 = new StudentTask("task3", student);
        StudentTask studentTask4 = new StudentTask("task4", student);
        StudentTask studentTask5 = new StudentTask("tasck5", student);

        studentTaskList.add(studentTask1);
        studentTaskList.add(studentTask2);
        studentTaskList.add(studentTask3);
        studentTaskList.add(studentTask4);
        studentTaskList.add(studentTask5);


        student.setPhone("12345");
        student.setName("ivan");
        student.setTaskList(studentTaskList);

        studentDao.saveOrUpdate(student);

    }

}
