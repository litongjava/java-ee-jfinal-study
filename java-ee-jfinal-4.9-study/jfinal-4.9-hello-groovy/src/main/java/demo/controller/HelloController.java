package demo.controller;

import com.jfinal.core.Controller;

public class HelloController extends Controller {
  public void index() {
    renderText("Hello JFinal World. fds");
  }

  public void classLoader() {
    renderText(this.getClass().getClassLoader().toString());
  }
}