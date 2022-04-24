package com.litong.java.jfinal.spring.boot.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bill white hat robot
 * @date 2020年9月10日_下午9:56:53 
 * @version 1.0 
 * @desc
 */
@RestController
public class HelloServlet {
  @RequestMapping("hello")
  public String hello() {
    return "helloxxx";
  }
}
