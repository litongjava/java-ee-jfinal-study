package top.ppnt.jfinal.spring.mvc.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.template.Engine;

import top.ppnt.jfinal.spring.mvc.handler.SpringMVCHandler;

public class AppConfig extends JFinalConfig {

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
    me.add(new SpringMVCHandler());
  }
}