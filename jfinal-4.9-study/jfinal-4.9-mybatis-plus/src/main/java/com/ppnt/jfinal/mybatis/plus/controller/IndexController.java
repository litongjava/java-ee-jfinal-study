package com.ppnt.jfinal.mybatis.plus.controller;

import com.jfinal.core.Controller;
import com.jfinal.core.Path;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Path("/")
public class IndexController extends Controller {
  public void index() {
    log.info("success");
    renderText("success");
  }
}