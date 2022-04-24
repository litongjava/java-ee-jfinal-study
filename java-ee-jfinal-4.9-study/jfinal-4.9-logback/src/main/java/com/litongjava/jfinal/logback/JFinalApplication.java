package com.litongjava.jfinal.logback;

import com.jfinal.server.undertow.UndertowServer;
import com.litongjava.jfinal.logback.config.AppConfig;

import lombok.extern.slf4j.Slf4j;

/**
 * @author create by ping-e-lee on 2021年6月20日 下午10:59:51 
 * @version 1.0 
 * @desc
 */
@Slf4j
public class JFinalApplication {
  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    // 创建server
    UndertowServer.create(AppConfig.class,"undertow.properties").start();
    long end = System.currentTimeMillis();
    String message = (end - start) + "ms";
    System.out.println(message);
    log.info(message);
  }
}
