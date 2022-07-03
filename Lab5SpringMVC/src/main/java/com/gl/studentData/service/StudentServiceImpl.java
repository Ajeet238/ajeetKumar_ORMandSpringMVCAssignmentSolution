package com.gl.studentData.service;

import org.hibernate.Transaction;
import java.io.Serializable;
import javax.transaction.Transactional;
import com.gl.studentData.entity.Student;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class StudentServiceImpl implements StudentService
{
    private SessionFactory sessionfactory;
    private Session session;
    
    public StudentServiceImpl(final SessionFactory sessionfactory) {
        this.sessionfactory = sessionfactory;
        try {
            this.session = this.sessionfactory.getCurrentSession();
        }
        catch (HibernateException e) {
            this.session = this.sessionfactory.openSession();
        }
    }
    
    @Transactional
    @Override
    public List<Student> findAllStudent() {
        final List<Student> studentList = (List<Student>)this.session.createQuery("from Student").list();
        return studentList;
    }
    
    @Transactional
    @Override
    public Student findById(final Integer id) {
        final Student student = (Student)this.session.get((Class)Student.class, (Serializable)id);
        return student;
    }
    
    @Transactional
    @Override
    public void save(final Student student) {
        final Transaction tr = this.session.beginTransaction();
        this.session.saveOrUpdate((Object)student);
        tr.commit();
    }
    
    @Transactional
    @Override
    public void remove(final Student s) {
        final Transaction tr = this.session.beginTransaction();
        this.session.delete((Object)s);
        tr.commit();
    }
    
    @Transactional
    @Override
    public List<Student> findByParam(final String firstName, final String lastName, final String email) {
        List<Student> ls = null;
        String query = "";
        if (firstName != null && lastName != null && email != null) {
            query = "from Student where firstName like '%" + firstName + "%' and lastName like '%" + lastName + "%' and email like '%" + email + "%'";
        }
        else if (firstName != null && lastName == null && email == null) {
            query = "from Student where firstName like '%" + firstName + "%'";
        }
        else if (firstName == null && lastName != null && email == null) {
            query = "from Student where lastName like '%" + lastName + "%'";
        }
        else if (firstName == null && lastName == null && email != null) {
            query = "from Student where email like '%" + email + "%'";
        }
        else {
            query = "from Student";
        }
        if (query.length() != 0) {
            ls = (List<Student>)this.session.createQuery(query).list();
        }
        return ls;
    }
}
