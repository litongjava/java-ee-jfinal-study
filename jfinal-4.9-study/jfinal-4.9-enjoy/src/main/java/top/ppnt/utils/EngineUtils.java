package top.ppnt.utils;

import com.jfinal.template.Engine;

/**
 * @author Ping E Lee
 */
public class EngineUtils {
  private static final String RESOURCE_BASE_PATH = "/META-INF/resources/";
  private static Engine engine = null;

  private EngineUtils() {
  }

  public static Engine getEngine() {
    if (engine == null) {
      Engine engine = Engine.use();
      configEngine(engine);
    }
    return engine;
  }

  private static void configEngine(Engine engine) {
    engine.setBaseTemplatePath(RESOURCE_BASE_PATH);
    engine.setToClassPathSourceFactory();
    // 支持模板热加载，绝大多数生产环境下也建议配置成 true，除非是极端高性能的场景
    engine.setDevMode(true);
// 添加共享模板函数
    engine.addSharedFunction("_layout.html");
// 配置极速模式，性能提升 13%
    Engine.setFastMode(true);
// jfinal 4.9.02 新增配置：支持中文表达式、中文变量名、中文方法名、中文模板函数名
    Engine.setChineseExpression(true);
  }
}
