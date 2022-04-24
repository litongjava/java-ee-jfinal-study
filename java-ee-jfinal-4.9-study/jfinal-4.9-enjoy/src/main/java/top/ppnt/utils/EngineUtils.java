package top.ppnt.utils;

import com.jfinal.template.Engine;

/**
 * @author Ping E Lee
 *
 */
public class EngineUtils {
  private static final String RESOURCE_BASE_PATH = "/META-INF/resources/";
  private static Engine engine = null;

  private EngineUtils() {
  }

  public static Engine getEngine() {
    if (engine == null) {
      engine = Engine.use().setBaseTemplatePath(RESOURCE_BASE_PATH);
      engine.setToClassPathSourceFactory();
    }
    return engine;
  }
}
