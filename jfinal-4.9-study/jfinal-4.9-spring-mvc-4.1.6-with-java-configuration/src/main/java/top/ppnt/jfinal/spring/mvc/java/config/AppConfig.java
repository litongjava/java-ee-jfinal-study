package top.ppnt.jfinal.spring.mvc.java.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.template.Engine;

import lombok.extern.slf4j.Slf4j;
import top.ppnt.jfinal.spring.mvc.java.handler.SpringMVCHandler;

@Slf4j
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

  @Override
  public void onStart() {
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

  }
}