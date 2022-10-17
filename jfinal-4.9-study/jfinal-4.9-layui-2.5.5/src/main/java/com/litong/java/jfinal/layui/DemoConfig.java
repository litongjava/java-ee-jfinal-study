package com.litong.java.jfinal.layui;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;

public class DemoConfig extends JFinalConfig {
  public static void main(String[] args) {
    UndertowServer.start(DemoConfig.class, 10060, true);
  }

  public void configConstant(Constants me) {
    me.setDevMode(true);
  }

  public void configRoute(Routes me) {
    me.add("/hello", HelloController.class);
    me.add("/upload",UploadController.class);
  }

  public void configEngine(Engine me) {
    
  }

  public void configPlugin(Plugins me) {
  }

  public void configInterceptor(Interceptors me) {
  }

  public void configHandler(Handlers me) {
  }
}