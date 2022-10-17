package com.eblly.tomcat;

import java.io.File;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.AprLifecycleListener;
import org.apache.catalina.core.StandardServer;
import org.apache.catalina.startup.Tomcat;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.template.Engine;

public class TomcatConfig extends JFinalConfig {

  @Override
  public void configConstant(Constants constants) {

  }

  @Override
  public void configRoute(Routes routes) {
    routes.add("/hello", HelloController.class);
  }

  @Override
  public void configEngine(Engine engine) {

  }

  @Override
  public void configPlugin(Plugins plugins) {

  }

  @Override
  public void configInterceptor(Interceptors interceptors) {

  }

  @Override
  public void configHandler(Handlers handlers) {

  }

  public static void main(String[] args) throws LifecycleException {
    int port = 8888;
    String contextPath = "/"; // 项目中web目录名称，以前版本为WebRoot、webapp、webapps，现在为WebContent
    String baseDir = new File("webapp/").getAbsolutePath();
    Tomcat tomcat = new Tomcat();
    tomcat.setPort(port);
    tomcat.setBaseDir(".");

    StandardServer server = (StandardServer) tomcat.getServer();
    AprLifecycleListener listener = new AprLifecycleListener();
    server.addLifecycleListener(listener);
    tomcat.addWebapp(contextPath, baseDir);

    tomcat.start();

    tomcat.getServer().await();
  }
}