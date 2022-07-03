package com.gl.studentData.controller;

import org.springframework.web.bind.annotation.RequestParam;
import com.gl.studentData.entity.Student;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import com.gl.studentData.service.StudentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping({ "/student" })
public class StudentController
{
    @Autowired
    private StudentService ss;
    
    @RequestMapping({ "/list" })
    public String findAll(final Model model) {
        final List<Student> studentList = (List<Student>)this.ss.findAllStudent();
        model.addAttribute("stud", (Object)studentList);
        return "student";
    }
    
    @RequestMapping({ "/gl" })
    public String goHome() {
        return "return";
    }
    
    @RequestMapping({ "/addStudent" })
    public String findById(@RequestParam("id") final Integer id, final Model model) {
        if (id != -1) {
            System.out.println("id is: " + id);
            final Student s = this.ss.findById(id);
            System.out.println(s);
            model.addAttribute("addNewStud", (Object)s);
        }
        else {
            final Student newStud = new Student();
            newStud.setId(Integer.valueOf(-1));
            System.out.println("id is :" + newStud.getId());
            model.addAttribute("addNewStud", (Object)newStud);
        }
        return "update";
    }
    
    @RequestMapping({ "/save" })
    public String save(@RequestParam("id") final Integer id, @RequestParam("firstName") final String firstName, @RequestParam("lastName") final String lastName, @RequestParam("email") final String email) {
        System.out.println("id is" + id);
        Student s = null;
        if (id != -1) {
            s = this.ss.findById(id);
            s.setFirstName(firstName);
            s.setLastName(lastName);
            s.setEmail(email);
        }
        else {
            s = new Student(firstName, lastName, email);
        }
        this.ss.save(s);
        return "redirect:list";
    }
    
    @RequestMapping({ "/delete" })
    public String deleteStudent(@RequestParam("id") final Integer id) {
        Student s = null;
        System.out.println(s);
        s = this.ss.findById(id);
        this.ss.remove(s);
        return "redirect: list";
    }
    
    @RequestMapping({ "/search" })
    public String searchBook(@RequestParam("firstName") final String firstName, @RequestParam("lastName") final String lastName, @RequestParam("country") final String country, final Model model) {
        final List<Student> studentList = (List<Student>)this.ss.findByParam(firstName, lastName, country);
        if (studentList.size() != 0) {
            model.addAttribute("stud", (Object)studentList);
        }
        else {
            model.addAttribute("error", (Object)"No Book Found");
        }
        return "student";
    }
}