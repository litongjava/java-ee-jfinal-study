package top.ppnt.jfinal.swagger;

import com.jfinal.server.undertow.UndertowServer;
import top.ppnt.jfinal.swagger.config.AppConfig;

public class PpntSwaggerApp {
  public static void main(String[] args) {
    UndertowServer.start(AppConfig.class);
  }
}