package com.litongjava.jfinal.web.demo;

import com.jfinal.server.undertow.UndertowServer;
import com.litongjava.jfinal.web.demo.config.DemoConfig;

/**
 * @author create by Ping E Lee on Oct 17, 2022 8:13:46 AM 
 *
 */

public class WebDemoApp {

  /**
   * 启动入口，运行此 main 方法可以启动项目，此 main 方法可以放置在任意的 Class 类定义中，不一定要放于此
   */
  public static void main(String[] args) {
    UndertowServer.start(DemoConfig.class);
  }
}
