package com.ppnt.jfinal.mybatis.plus;

import com.jfinal.server.undertow.UndertowServer;
import com.ppnt.jfinal.mybatis.plus.config.DemoConfig;

/**
 * @author create by Ping E Lee on 2022年3月28日 下午5:56:19 
 *
 */
public class MybatisPlusApp {

  /**
   * 启动入口，运行此 main 方法可以启动项目，此 main 方法可以放置在任意的 Class 类定义中，不一定要放于此
   */
  public static void main(String[] args) {
    UndertowServer.start(DemoConfig.class);
  }

}
