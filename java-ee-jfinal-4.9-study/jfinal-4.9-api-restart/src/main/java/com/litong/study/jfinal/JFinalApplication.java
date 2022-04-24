package com.litong.study.jfinal;

import com.jfinal.server.undertow.UndertowServer;
import com.litong.study.jfinal.config.AppConfig;
import com.litong.study.jfinal.utils.UndertowUtils;

/**
 * @author create by ping-e-lee on 2021年6月20日 下午10:59:51 
 * @version 1.0 
 * @desc
 */
public class JFinalApplication {
  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    // 创建server
    UndertowUtils.server = UndertowServer.create(AppConfig.class);
    // 启动Server全局共享
    UndertowUtils.server.addSystemClassPrefix("com.litong.study.jfinal.utils.UndertowUtils");
    UndertowUtils.server.start();
    long end = System.currentTimeMillis();
    System.out.println((end-start)+"ms");
  }
}
