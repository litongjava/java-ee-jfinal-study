package top.ppnt.jfinal.spring.mvc.java;

import java.util.function.Consumer;

import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.server.undertow.WebBuilder;

import top.ppnt.jfinal.spring.mvc.config.AppConfig;

public class App {
  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    // 配置web
    Consumer<WebBuilder> consumer = builder -> {
      // 配置 Servlet
      String servletName = "dispathcer";
      builder.addServlet(servletName, "org.springframework.web.servlet.DispatcherServlet");
      builder.addServletMapping(servletName, "/");
      builder.addServletInitParam(servletName, "contextConfigLocation", "classpath:spring-mvc.xml");
      builder.setServletLoadOnStartup(servletName, 0);
    };

    // 设置web
    UndertowServer.create(AppConfig.class).configWeb(consumer).start();
    long end = System.currentTimeMillis();
    System.out.println((end - start) + "ms");
  }
}