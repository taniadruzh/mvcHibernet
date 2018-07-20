package com.mvcTest.controller;

import com.mvcTest.entity.Student;
import com.mvcTest.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/")
public class StartController {

    @Autowired
    private StudentService studentService;


    List<Student> studentListModify = null;

    @RequestMapping(method = RequestMethod.GET)
    public String getStudentList(Model model) {
        model.addAttribute("userList", studentService.userList());
       // model.addAttribute("userListModify", userListModify);
        return "start";
    }

    @RequestMapping(value = "/modify", method = RequestMethod.GET)
    public String getModifyStudentList(Model model) {
        studentListModify = studentService.userListWithModific();
        return "redirect:/";
    }

    @RequestMapping(value = "/salary", method = RequestMethod.GET)
    public String getStudentSalary(Model model) {
        System.out.println(" in salary contr");
        studentService.userListWithCel().forEach((k, v) -> System.out.println(k.getName() + " -- " + v));
        return "redirect:/";
    }
}
