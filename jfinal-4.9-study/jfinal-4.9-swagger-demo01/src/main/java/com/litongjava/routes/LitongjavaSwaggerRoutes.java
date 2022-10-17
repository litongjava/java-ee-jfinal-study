package com.litongjava.routes;

import com.jfinal.config.Routes;
import com.jfinal.kit.PropKit;

public class LitongjavaSwaggerRoutes extends Routes {

  @Override
  public void config() {
    boolean enable = PropKit.use("swagger.properties").getBoolean("enable", false);
    if (enable) {
      ///add("/swagger", LitongjavaSwaggerController.class);
    }
  }
}
