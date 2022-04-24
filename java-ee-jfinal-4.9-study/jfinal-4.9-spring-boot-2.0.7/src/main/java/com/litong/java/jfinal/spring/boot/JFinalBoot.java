package com.litong.java.jfinal.spring.boot;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;
import com.litong.java.jfinal.spring.boot.handler.SpringMVCHandler;

/**
 * @author bill white hat robot
 * @date 2020年9月10日_下午9:17:15 
 * @version 1.0 
 * @desc
 */
@SpringBootApplication
public class JFinalBoot extends JFinalConfig {
  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    UndertowServer server = UndertowServer.create(JFinalBoot.class, "undertow.txt");
    server.start();
    long end = System.currentTimeMillis();
    System.out.println((end - start) + "ms");

  }

  @Override
  public void configConstant(Constants me) {
  }

  @Override
  public void configRoute(Routes me) {
  }

  @Override
  public void configEngine(Engine me) {
  }

  @Override
  public void configPlugin(Plugins me) {
  }

  @Override
  public void configInterceptor(Interceptors me) {
  }

  @Override
  public void configHandler(Handlers me) {
    me.add(new SpringMVCHandler());
  }
}
