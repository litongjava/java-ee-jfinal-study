package top.ppnt.modules.jfinal.api.docs;

import com.jfinal.server.undertow.UndertowServer;

import top.ppnt.modules.jfinal.api.docs.config.ApiDocsConfig;

/**
 * @author Ping E Lee
 *
 */
public class ApiDocsApplication {
  public static void main(String[] args) {
    UndertowServer.start(ApiDocsConfig.class);
  }
}
