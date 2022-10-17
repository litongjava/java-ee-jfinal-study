package com.litongjava.jfinal;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;
import com.litongjava.jfinal.config.DbConfig;
import com.litongjava.jfinal.utils.PropKitUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Application extends JFinalConfig {
  private static String configFileName = PropKitUtils.configFileName;

  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    UndertowServer.create(Application.class, configFileName).start();
    long end = System.currentTimeMillis();
    System.out.println("启动完成,共使用了" + (end - start) + "ms");
  }

  public void configConstant(Constants me) {
    me.setInjectDependency(true);
    me.setInjectSuperClass(true);
    //
  }

  public void configRoute(Routes me) {
    me.setMappingSuperClass(true);
    me.scan("com.litongjava.jfinal.demo.controller.");
  }

  @Override
  public void configEngine(Engine me) {
  }

  @Override
  public void configPlugin(Plugins me) {
    log.info("开始配置插件");
    DbConfig.config(me);
  }

  @Override
  public void configInterceptor(Interceptors me) {
  }

  @Override
  public void configHandler(Handlers me) {
  }

}