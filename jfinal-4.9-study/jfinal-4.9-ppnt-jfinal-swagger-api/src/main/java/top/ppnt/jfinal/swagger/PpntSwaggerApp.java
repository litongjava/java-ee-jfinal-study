package top.ppnt.jfinal.swagger;

import com.jfinal.server.undertow.UndertowServer;

import top.ppnt.jfinal.swaager.api.constants.PpntSwaggerConstants;
import top.ppnt.jfinal.swagger.config.AppConfig;

public class PpntSwaggerApp {
  public static void main(String[] args) {
    UndertowServer undertowServer = UndertowServer.create(AppConfig.class);
    undertowServer.addHotSwapClassPrefix(PpntSwaggerConstants.PACKAGE_NAME);
    undertowServer.start();
  }
}