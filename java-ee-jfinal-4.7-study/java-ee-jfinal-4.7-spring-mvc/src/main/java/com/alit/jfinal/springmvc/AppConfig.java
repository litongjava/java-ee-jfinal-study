package com.alit.jfinal.springmvc;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;

public class AppConfig extends JFinalConfig {
  public static void main(String[] args) {
    long startTime = System.currentTimeMillis();
    UndertowServer.create(AppConfig.class).configWeb(builder -> {
      // 配置 Servlet
      String servletName = "dispathcer";
      builder.addServlet(servletName, "org.springframework.web.servlet.DispatcherServlet");
      // builder.addServletMapping(servletName, "*.do");
      builder.addServletMapping(servletName, "/");
      builder.addServletInitParam(servletName, "contextConfigLocation", "classpath:spring-mvc.xml");
      builder.setServletLoadOnStartup(servletName, 0);
    }).start();
    long endTime = System.currentTimeMillis();
    System.out.println("启动完成,共使用了" + (endTime - startTime) + "ms");
  }

  public void configConstant(Constants me) {
    me.setDevMode(true);
  }

  public void configRoute(Routes me) {
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