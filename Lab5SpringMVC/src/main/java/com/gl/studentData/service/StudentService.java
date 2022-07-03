package com.gl.studentData.service;

import com.gl.studentData.entity.Student;
import java.util.List;

public interface StudentService
{
    List<Student> findAllStudent();
    
    Student findById(final Integer p0);
    
    void save(final Student p0);
    
    void remove(final Student p0);
    
    List<Student> findByParam(final String p0, final String p1, final String p2);
}