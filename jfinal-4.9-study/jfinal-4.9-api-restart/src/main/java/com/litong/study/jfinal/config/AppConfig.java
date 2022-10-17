package com.litong.study.jfinal.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.template.Engine;

/**
 * @author create by ping-e-lee on 2021年6月20日 下午11:00:36 
 * @version 1.0 
 * @desc
 */
public class AppConfig extends JFinalConfig {

  @Override
  public void configConstant(Constants me) {
  }

  @Override
  public void configRoute(Routes me) {
    me.scan("com.litong.study.jfinal.controller.");
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
