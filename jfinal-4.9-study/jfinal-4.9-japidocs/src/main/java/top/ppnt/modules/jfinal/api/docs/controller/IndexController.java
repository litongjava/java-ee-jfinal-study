package top.ppnt.modules.jfinal.api.docs.controller;

import com.jfinal.core.Controller;
import com.jfinal.core.Path;

/**
 * @author Ping E Lee
 *
 */
@Path("/")
public class IndexController extends Controller {

  public void index() {
    renderText("index");
  }
}
