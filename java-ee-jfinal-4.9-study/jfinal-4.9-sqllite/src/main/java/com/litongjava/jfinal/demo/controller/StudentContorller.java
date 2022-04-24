package com.litongjava.jfinal.demo.controller;

import java.util.List;

import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.litongjava.jfinal.demo.model.Student;
@Path("student")
public class StudentContorller extends Controller{
  public void list() {
    List<Student> studentList = Student.dao.findAll();
    renderJson(studentList);
  }
}
