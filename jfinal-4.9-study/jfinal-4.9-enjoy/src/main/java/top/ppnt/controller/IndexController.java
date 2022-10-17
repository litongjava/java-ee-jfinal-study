package top.ppnt.controller;

import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.jfinal.template.Engine;
import com.jfinal.template.Template;

import top.ppnt.utils.EngineUtils;

/**
 * Swagger UI Controller
 */
@Path("/")
public class IndexController extends Controller {

  /**
   * 首页
   */
  public void index() {
    Engine engine = EngineUtils.getEngine();
    Template template = engine.getTemplate("/index.html");
    String string = template.renderToString();
    renderHtml(string);
  }
}