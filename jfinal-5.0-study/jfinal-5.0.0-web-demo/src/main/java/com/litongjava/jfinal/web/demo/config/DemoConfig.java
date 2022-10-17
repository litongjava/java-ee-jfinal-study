package com.litongjava.jfinal.web.demo.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.template.Engine;

/**
 * 本 demo 仅表达最为粗浅的 jfinal 用法，更为有价值的实用的企业级用法
 * 详见 JFinal 俱乐部: https://jfinal.com/club
 * 
 * API 引导式配置
 */
public class DemoConfig extends JFinalConfig {

  static Prop p;

  /**
   * PropKit.useFirstFound(...) 使用参数中从左到右最先被找到的配置文件
   * 从左到右依次去找配置，找到则立即加载并立即返回，后续配置将被忽略
   */
  static void loadConfig() {
    if (p == null) {
      p = PropKit.useFirstFound("demo-config-pro.txt", "demo-config-dev.txt");
    }
  }

  /**
   * 配置常量
   */
  public void configConstant(Constants me) {
    loadConfig();

    me.setDevMode(p.getBoolean("devMode", false));

    /**
     * 支持 Controller、Interceptor、Validator 之中使用 @Inject 注入业务层，并且自动实现 AOP
     * 注入动作支持任意深度并自动处理循环注入
     */
    me.setInjectDependency(true);

    // 配置对超类中的属性进行注入
    me.setInjectSuperClass(true);
    
    // 开启解析 json 请求，5.0.0 版本新增功能
    me.setResolveJsonRequest(true);
  }

  /**
   * 配置路由
   */
  public void configRoute(Routes me) {
    // 使用 jfinal 4.9.03 新增的路由扫描功能
    me.scan("com.litongjava.jfinal.web.demo.controller.");
  }

  public void configEngine(Engine me) {
  }

  /**
   * 配置插件
   */
  public void configPlugin(Plugins me) {

  }

  /**
   * 配置全局拦截器
   */
  public void configInterceptor(Interceptors me) {

  }

  /**
   * 配置处理器
   */
  public void configHandler(Handlers me) {

  }
}
