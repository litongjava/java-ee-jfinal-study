package com.alit.jfinal.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("Hello")
public class HelloController {
  @RequestMapping()
  @ResponseBody
  public String index() {
    return "Hello,World";
  }
}
