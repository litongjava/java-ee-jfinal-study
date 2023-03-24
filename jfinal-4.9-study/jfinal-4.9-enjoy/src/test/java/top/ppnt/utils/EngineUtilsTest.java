package top.ppnt.utils;

import com.jfinal.template.Engine;
import com.jfinal.template.Template;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author litongjava@qq.com on 2023/3/24 17:36
 */
public class EngineUtilsTest {

  @Test
  public void getEngine() {
    Engine engine = EngineUtils.getEngine();
    Template template = engine.getTemplate("/index.html");
    String string = template.renderToString();
    System.out.println(string);
  }
}