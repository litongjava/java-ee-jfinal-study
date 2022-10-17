package com.litongjava;


import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;
import com.lastb7.swagger.handler.SwaggerHandler;
import com.lastb7.swagger.plugin.SwaggerPlugin;
import com.lastb7.swagger.routes.SwaggerRoutes;
import com.litongjava.controller.DemoController;

/**
 * @author lbq
 * @date 2020/06/16
 */
public class MainConfig extends JFinalConfig {

  public static void main(String[] args) {
    UndertowServer.create(MainConfig.class).addHotSwapClassPrefix("com.lastb7.swagger.").start();
  }

  @Override
  public void configConstant(Constants me) {
    me.setDevMode(true);
  }

  @Override
  public void configRoute(Routes me) {
    // jfinal 路由扫描
    me.add("/demo",DemoController.class);

    // 不同分组对应不同的basePath.修改swagger_resources
    // 服务端路由
//        me.add(new PrefixRoutes("/api/admin", "com.swagger.demo.admin."));
    // app端路由
//        me.add(new PrefixRoutes("/api/app", "com.swagger.demo.app."));

    // swagger路由
    me.add(new SwaggerRoutes());
  }

  @Override
  public void configEngine(Engine me) {
  }

  @Override
  public void configPlugin(Plugins me) {
    me.add(new SwaggerPlugin());
    // 自定义返回值
//        me.add(new SwaggerPlugin()
//                .setHttpCode(new CommonHttpCode().getHttpCodeKv())
//                .setCommonRet(CommonRes.class));
  }

  @Override
  public void configInterceptor(Interceptors me) {
  }

  @Override
  public void configHandler(Handlers me) {
    me.add(new SwaggerHandler());
  }
}