package com.litongjava;

import com.jfinal.core.Controller;

public class HelloController extends Controller {
  public void index() {
    renderText("Hello JFinal World.");
  }
}