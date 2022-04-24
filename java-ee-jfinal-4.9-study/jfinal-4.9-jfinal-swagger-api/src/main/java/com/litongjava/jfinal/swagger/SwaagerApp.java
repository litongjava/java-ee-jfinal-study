package com.litongjava.jfinal.swagger;

import com.jfinal.server.undertow.UndertowServer;

public class SwaagerApp {
  public static void main(String[] args) {
    UndertowServer.start(AppConfig.class);
  }
}
