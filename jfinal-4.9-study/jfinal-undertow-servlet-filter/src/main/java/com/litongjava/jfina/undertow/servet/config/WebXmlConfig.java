package com.litongjava.jfina.undertow.servet.config;

import java.util.function.Consumer;

import com.jfinal.server.undertow.WebBuilder;
import com.litongjava.jfina.undertow.servet.filter.CharsetFilter;
import com.litongjava.jfina.undertow.servet.servlet.UserServlet;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class WebXmlConfig implements Consumer<WebBuilder> {
  @Override
  public void accept(WebBuilder builder) {
    addUserServlet(builder, "/user");
    
    addFilter(builder);
  }
  
  private void addUserServlet(WebBuilder builder, String urlPattern) {
    String name = UserServlet.class.getName();
    String simpleName = UserServlet.class.getSimpleName();
    log.info("add servlet:{}", simpleName);
    builder.addServlet(simpleName, name);
    builder.addServletMapping(simpleName, urlPattern);
  }

  

  /**
   * add filter
   * @param builder
   */
  private void addFilter(WebBuilder builder) {
    addCharsetFilter(builder);
  }

  private void addCharsetFilter(WebBuilder builder) {
    String filterClass = CharsetFilter.class.getName();
    String filterName = CharsetFilter.class.getSimpleName();
    log.info("add filter:{}",filterName);
    builder.addFilter(filterName, filterClass);
    builder.addFilterUrlMapping(filterName, "/*");
  }
}