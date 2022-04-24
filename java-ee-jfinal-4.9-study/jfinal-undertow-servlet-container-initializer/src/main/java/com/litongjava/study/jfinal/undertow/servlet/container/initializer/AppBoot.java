package com.litongjava.study.jfinal.undertow.servlet.container.initializer;

import com.jfinal.server.undertow.UndertowServer;

/**
 * @author bill white hat robot
 * @date 2020年9月10日_下午10:49:56 
 * @version 1.0 
 * @desc
 */
public class AppBoot {
  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    UndertowServer.create(AppConfig.class, "undertow.txt").start();
    long end = System.currentTimeMillis();
    System.out.println((end - start) + "ms");
  }
}
