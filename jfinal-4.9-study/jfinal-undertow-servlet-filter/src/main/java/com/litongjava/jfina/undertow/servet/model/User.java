package com.litongjava.jfina.undertow.servet.model;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements HttpSessionBindingListener {
  private String username,password;
  
  
  public void valueBound(HttpSessionBindingEvent event) {
    Object value = event.getValue();
    log.info("valueBound:{}", value);
  }

  public void valueUnbound(HttpSessionBindingEvent event) {
    Object value = event.getValue();
    log.info("valueUnbound:{}", value);
  }
}