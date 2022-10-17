package com.litongjava.handlers;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jfinal.handler.Handler;
import com.jfinal.kit.HandlerKit;
import com.jfinal.kit.LogKit;
import com.jfinal.kit.StrKit;
import com.lastb7.swagger.util.IOUtils;

public class LitongjavaSwaggerHandler extends Handler {
  /**
   * SwaggerUI 入口
   */
  private String view = "swagger-ui/doc.html";
  /**
   * SwaggerUI 资源文件
   */
  private String resPath = "/swagger-ui/";
  /**
   * 分组Api -> 获取Json
   */
  private String apiPath = "/swagger-ui/swagger/api";

  @Override
  public void handle(String target, HttpServletRequest request, HttpServletResponse response, boolean[] isHandled) {
    String path = null;

    if (target.indexOf(apiPath) != -1) {
      HandlerKit.redirect("/swagger/api", request, response, isHandled);
      return;
    }

    if (target.contains(view)) {
      path = view;
    } else if (target.startsWith(resPath)) {
      path = target.substring(1);
    }
    if (StrKit.notBlank(path)) {
      InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(path);
      OutputStream outputStream = null;
      try {
        if (inputStream != null) {
          outputStream = response.getOutputStream();
          IOUtils.copy(inputStream, response.getOutputStream());
        }
      } catch (IOException e) {
        LogKit.error("无法读取Swagger UI静态资源", e);
      } finally {
        IOUtils.closeQuietly(inputStream);
        IOUtils.closeQuietly(outputStream);
      }
      isHandled[0] = true;
    } else {
      this.next.handle(target, request, response, isHandled);
    }
  }

}
