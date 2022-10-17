package top.ppnt;

import com.jfinal.server.undertow.UndertowServer;

import top.ppnt.config.AppConfig;

public class App {
  public static void main(String[] args) {
    UndertowServer.start(AppConfig.class);
  }
}