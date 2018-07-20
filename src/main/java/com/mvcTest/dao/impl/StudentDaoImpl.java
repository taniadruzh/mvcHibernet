package com.mvcTest.dao.impl;

import com.mvcTest.dao.StudentDao;
import com.mvcTest.entity.Student;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class StudentDaoImpl implements StudentDao {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Student> userList() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Student> theQuery = currentSession.createQuery("from Student", Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> getAllUserWithNameAndPintOnly() {
        Session currentSession = sessionFactory.getCurrentSession();
        List<Student> userList = currentSession
                .createQuery("SELECT new com.mvcTest.entity.Student(student.id,student.phone)" +
                        " FROM Student student", Student.class)
                .setMaxResults(11)
                .getResultList();
        return userList;
    }


    @Override
    public Student UserByUsername(String name) {
        Session currentSession = sessionFactory.getCurrentSession();
        Student user = (Student) currentSession.createQuery("FROM Student st  WHERE st.name =:name")
                .setParameter("name", name)
                .uniqueResult();
        return user;
    }




    @Override
    public Student getById(long id) {
        Session currentSession = sessionFactory.getCurrentSession();
  currentSession.get(Student.class, id);
        return null;
    }

    @Override
    public void remove(Student student) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.remove(student);
    }

    @Override
    public void add(Student student) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.save(student);
    }

    @Override
    public void update(Student student) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(student);
    }


    @Override
    public void saveOrUpdate(Student entity) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(entity);
    }

}
