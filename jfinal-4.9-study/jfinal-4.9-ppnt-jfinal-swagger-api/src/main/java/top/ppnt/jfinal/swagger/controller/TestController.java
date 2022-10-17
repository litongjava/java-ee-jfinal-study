package top.ppnt.jfinal.swagger.controller;

import com.jfinal.core.Controller;
import com.jfinal.core.Path;

/**
 * @author Ping E Lee
 *
 */
@Path("test")
public class TestController extends Controller {

  public void getParaTest() {
    renderText(getPara());
  }
}
