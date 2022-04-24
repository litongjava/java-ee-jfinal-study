package com.litong.java.jfinal.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringBoot extends SpringBootServletInitializer {
  public static void main(String[] args) {
    SpringApplication.run(SpringBoot.class, args);
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
    log.info("启动spring-boot");
    return builder.sources(SpringBoot.class);
  }
}