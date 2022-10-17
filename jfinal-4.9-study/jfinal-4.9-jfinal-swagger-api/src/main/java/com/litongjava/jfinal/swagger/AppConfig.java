package com.litongjava.jfinal.swagger;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.template.Engine;

import top.ppnt.jfinal.swagger.config.SwaggerConfig;
import top.ppnt.jfinal.swagger.config.SwaggerRoute;
import top.ppnt.jfinal.swagger.enums.InType;

public class AppConfig extends JFinalConfig {
  /**
   * 配置访问路由
   * 
   * @param me
   */
  @Override
  public void configRoute(Routes me) {
    String basePackage="com.litongjava.jfinal.swagger";
    me.scan(basePackage+".controller.");
    // 配置Swagger UI访问路由
    me.add(new SwaggerRoute());
  }

  /**
   * JFinal启动完成后的操作
   */
  @Override
  public void onStart() {
    // 添加全局参数(如token,非必需)
    SwaggerConfig.addGlobalParam("x-access-token", "token令牌", "string", "jfinal-awesome-token", true, "",
        InType.HEADER);
  }

  public void configConstant(Constants me) {
    //me.setDevMode(true);
    // 开启对 jfinal web 项目组件 Controller、Interceptor、Validator 的注入
    me.setInjectDependency(true);
    
    // 开启对超类的注入。不开启时可以在超类中通过 Aop.get(...) 进行注入
    me.setInjectSuperClass(true);
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
    
  }
}