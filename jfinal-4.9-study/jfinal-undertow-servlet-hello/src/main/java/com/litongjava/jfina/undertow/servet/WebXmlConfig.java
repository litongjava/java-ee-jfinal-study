package com.litongjava.jfina.undertow.servet;

import java.util.function.Consumer;

import com.jfinal.server.undertow.WebBuilder;

/**
 * @author bill white hat robot
 * @date 2020年9月10日_下午9:35:36 
 * @version 1.0 
 * @desc
 */
public class WebXmlConfig implements Consumer<WebBuilder> {

  public void accept(WebBuilder builder) {
    // 方式2
    builder.addServlet("HelloServlet", "com.litongjava.jfina.undertow.servet.HelloServlet");
    builder.addServletMapping("HelloServlet", "/hello");
    
    //方式2
    //String name = UserServlet.class.getName();
    //String simpleName = UserServlet.class.getSimpleName();
    //builder.addServlet(simpleName, name);
    //builder.addServletMapping(simpleName, urlPattern);
  }
}
