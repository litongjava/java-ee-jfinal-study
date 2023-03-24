package demo;

import com.jfinal.core.Controller;
import com.jfinal.core.Path;

@Path("/")
public class HelloController extends Controller {
  public void index() {
    renderText("Hello JFinal World. 123434");
  }
}