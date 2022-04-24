package com.litong.study.jfinal.controller;
/**
 * @author create by ping-e-lee on 2021年6月20日 下午11:02:58 
 * @version 1.0 
 * @desc
 */
import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.litong.study.jfinal.utils.UndertowUtils;

@Path("undertow")
public class UndertowController extends Controller {
  public void restart() {
    //UndertowUtil.server.restart();
    UndertowUtils.restart();
    renderText("OK");
  }

  public void stop() {
    UndertowUtils.server.stop();
    renderText("OK");
  }
  
  public void status() {
    boolean started = UndertowUtils.server.isStarted();
    renderJson(started);
  }
  
  public void undeploy() {
    UndertowUtils.server.getUndertowConfig();
  }
}
