package com.litongjava.jfina.undertow.servet;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;
import com.litongjava.jfina.undertow.servet.config.WebXmlConfig;
import com.litongjava.jfina.undertow.servet.handler.ServletHandler;

/**
 * @author bill white hat robot
 * @date 2020年9月10日_下午9:17:15 
 * @version 1.0 
 * @desc
 */
public class Boot extends JFinalConfig {
  public static void main(String[] args) {
    UndertowServer server = UndertowServer.create(Boot.class, "undertow.txt");
    server.configWeb(new WebXmlConfig());
    server.start();

  }

  @Override
  public void configConstant(Constants me) {
  }

  @Override
  public void configRoute(Routes me) {
  }

  @Override
  public void configEngine(Engine me) {
  }

  @Override
  public void configPlugin(Plugins me) {
  }

  @Override
  public void configInterceptor(Interceptors me) {
  }

  @Override
  public void configHandler(Handlers me) {
    me.add(new ServletHandler());
  }
}
