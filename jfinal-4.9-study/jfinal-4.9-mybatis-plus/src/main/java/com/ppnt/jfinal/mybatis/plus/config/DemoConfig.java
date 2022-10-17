package com.ppnt.jfinal.mybatis.plus.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.template.Engine;

/**
 * 本 demo 仅表达最为粗浅的 jfinal 用法，更为有价值的实用的企业级用法
 * 详见 JFinal 俱乐部: https://jfinal.com/club
 * 
 * API 引导式配置
 */
public class DemoConfig extends JFinalConfig {

  /**
   * 配置常量
   */
  public void configConstant(Constants me) {

    me.setDevMode(true);

    /**
     * 支持 Controller、Interceptor、Validator 之中使用 @Inject 注入业务层，并且自动实现 AOP
     * 注入动作支持任意深度并自动处理循环注入
     */
    me.setInjectDependency(true);

    // 配置对超类中的属性进行注入
    me.setInjectSuperClass(true);
  }

  /**
   * 配置路由
   */
  public void configRoute(Routes me) {
    // 使用 jfinal 4.9.03 新增的路由扫描功能
    me.scan("com.ppnt.jfinal.mybatis.plus.");
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
