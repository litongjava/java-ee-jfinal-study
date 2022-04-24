package com.litongjava.jfinal.logback.controller;

import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.litongjava.jfinal.logback.utils.LogUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author create by ping-e-lee on 2021年7月12日 下午7:38:31 
 * @version 1.0 
 * @desc
 */
@Path("logback")
@Slf4j
public class LogbackController extends Controller {
  public void exception() throws Exception {
    try {
      throw new IllegalArgumentException("This is a test");
    } catch (Exception e) {
      //e.printStackTrace();
      log.error(LogUtils.getStackTraceInfo(e));
    }
    renderText("ok");
  }
  public void logClassName() {
    renderText(log.getClass().getName());
  }
}
