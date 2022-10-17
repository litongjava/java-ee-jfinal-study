package top.ppnt.jfinal.spring.mvc.java.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("hello")
public class HelloController {
  @RequestMapping()
  @ResponseBody
  public String index() {
    return "Hello,World";
  }
}