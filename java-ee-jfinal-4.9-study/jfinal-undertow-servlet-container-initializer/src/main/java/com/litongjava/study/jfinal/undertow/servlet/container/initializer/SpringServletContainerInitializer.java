package com.litongjava.study.jfinal.undertow.servlet.container.initializer;

import java.util.Set;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpringServletContainerInitializer implements ServletContainerInitializer {

  public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
    log.info("回调成功");
  }
}
