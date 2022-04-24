package com.litongjava.jfinal.mybatis.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.template.Engine;
import com.litongjava.jfinal.mybatis.controller.ClassContorller;
import com.litongjava.jfinal.mybatis.controller.IndexController;
import com.litongjava.jfinal.mybatis.controller.MybatisController;
import com.litongjava.jfinal.mybatis.controller.SystemAdminController;
import com.litongjava.jfinal.mybatis.interceptor.MapperBeanInterceptor;
import com.litongjava.jfinal.mybatis.plugin.MyBatisPlugin;

public class AppConfig extends JFinalConfig {

  @Override
  public void configConstant(Constants me) {
  }

  @Override
  public void configRoute(Routes me) {
    me.add("/", IndexController.class);
    me.add("/mybatis", MybatisController.class);
    me.add("class",ClassContorller.class);
    me.add("system-admin",SystemAdminController.class);
  }

  @Override
  public void configEngine(Engine me) {
  }

  @Override
  public void configPlugin(Plugins me) {
    MyBatisPlugin myBatisPlugin = new MyBatisPlugin("mybatis.xml");
    me.add(myBatisPlugin);
  }

  @Override
  public void configInterceptor(Interceptors me) {
//    me.add(new MapperBeanInterceptor());
  }

  @Override
  public void configHandler(Handlers me) {
  }
}