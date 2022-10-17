package com.litongjava.jfinal.web.demo.controller;

import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.litongjava.jfinal.web.model.User;

import lombok.extern.slf4j.Slf4j;

@Path("/")
@Slf4j
public class IndexController extends Controller {

  public void index() {
    log.info("ok");
    renderText("ok");
  }

  public void receiveUser(User user) {
    log.info("usre:{}", user);
    renderJson(user);
  }

  public void responseUser() {
    User user = User.builder().username("Ping").password("password").build();
    renderJson(user);
  }

}
