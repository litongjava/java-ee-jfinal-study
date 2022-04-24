package demo;

import com.jfinal.core.Controller;

public class HelloController extends Controller {
  public void index() {
    renderText("Hello JFinal World.43");
  }
  public void classLoader() {

    renderText(this.getClass().getClassLoader().toString());
  }
}