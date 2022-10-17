package com.litongjava.plugins;

import java.util.Map;

import com.jfinal.kit.PropKit;
import com.jfinal.plugin.IPlugin;
import com.jfinal.template.Engine;
import com.lastb7.swagger.common.SwaggerConst;
import com.lastb7.swagger.common.SwaggerHttpCode;
import com.lastb7.swagger.common.SwaggerRes;

public class LitongjavaSwaggerPlugin implements IPlugin {
  /**
   * swagger配置文件
   */
  private String propPath;

  /**
   * http返回状态
   */
  private Map httpCode;

  /**
   * http返回状态200时的通用返回格式
   */
  private Class<?> commonRet;

  public LitongjavaSwaggerPlugin setPropPath(String propPath) {
    this.propPath = propPath;
    return this;
  }

  public LitongjavaSwaggerPlugin setHttpCode(Map httpCode) {
    this.httpCode = httpCode;
    return this;
  }

  public LitongjavaSwaggerPlugin setCommonRet(Class<?> commonRet) {
    this.commonRet = commonRet;
    return this;
  }

  public LitongjavaSwaggerPlugin() {
    this.propPath = "swagger.properties";
    this.httpCode = new SwaggerHttpCode().getHttpCodeKv();
    this.commonRet = SwaggerRes.class;
  }

  @Override
  public boolean start() {
    SwaggerConst.CONFIG = PropKit.use(this.propPath);
    SwaggerConst.HTTP_CODE = this.httpCode;
    SwaggerConst.COMMON_RES = this.commonRet;
    SwaggerConst.RESPONSE_IN_DATA = PropKit.use(this.propPath).getBoolean("responseInData", true);

    Engine engine = Engine.create("swagger");
    engine.setDevMode(false);
    engine.setBaseTemplatePath("/swagger-template");
    engine.setToClassPathSourceFactory();

    return true;
  }

  @Override
  public boolean stop() {
    return true;
  }
}
