package com.litongjava.jfinal.mybatis;

import com.jfinal.server.undertow.UndertowServer;
import com.litongjava.jfinal.mybatis.config.AppConfig;

public class MybatisApp {

  public static void main(String[] args) {
    UndertowServer.start(AppConfig.class);
  }
}
