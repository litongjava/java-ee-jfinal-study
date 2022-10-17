package top.ppnt.modules.jfinal.api.docs.config;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.template.Engine;

import top.ppnt.modules.jfinal.api.docs.controller.CarApiController;

/**
 * @author Ping E Lee
 *
 */
public class ApiDocsConfig extends JFinalConfig {

  @Override
  public void configConstant(Constants me) {
    me.setDevMode(true);
    // 开启对 jfinal web 项目组件 Controller、Interceptor、Validator 的注入
    me.setInjectDependency(true);

    // 开启对超类的注入。不开启时可以在超类中通过 Aop.get(...) 进行注入
    me.setInjectSuperClass(true);
  }

  @Override
  public void configRoute(Routes me) {
    me.scan("top.ppnt.modules.jfinal.api.docs.controller.");
    me.add("/wxa/car", CarApiController.class);
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
