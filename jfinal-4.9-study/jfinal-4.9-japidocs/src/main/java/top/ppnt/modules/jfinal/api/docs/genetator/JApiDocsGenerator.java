package top.ppnt.modules.jfinal.api.docs.genetator;

import io.github.yedaxia.apidocs.Docs;
import io.github.yedaxia.apidocs.DocsConfig;
import lombok.extern.slf4j.Slf4j;
import top.ppnt.modules.jfinal.api.docs.plugins.PostmanDocPlugin;

/**
 * JApiDocs 无需额外注解的 API 文档生成工具
 * <p>
 * 源码 https://github.com/YeDaxia/JApiDocs
 * 文档 https://japidocs.agilestudio.cn/#/zh-cn/
 */
/**
 * JApiDocs 无需额外注解的 API 文档生成工具
 * <p>
 * 源码 https://github.com/YeDaxia/JApiDocs
 * 文档 https://japidocs.agilestudio.cn/#/zh-cn/
 */
@Slf4j
public class JApiDocsGenerator {

  /**
   * JApiDocs 生成器
   * 如果报错，做如下检查：
   * 1 javadoc @param 后是否有注释
   * 2 src.main.java 目录中非 .java 扩展名文件的内容要 // 注释起来
   * 3 删除 config.setDocsPath 目录中的文件，再生成试试
   * <p>
   * 如果生成的 api 文档不是预期的，作如下检查：
   * 1 必须在 configRoute(Routes me) 中已该方式 me.add("/xx/yy", xx.class, "/"); 定义 Controller
   * 2 在需要生成 api 的 Controller 中添加 @ApiDoc 注解
   * 3 如果要忽略某 action，在 action 上添加 @Ignore
   * </p> 
   */
  public static void main(String[] args) {
    String projectRootPath = "D:\\code\\java\\java-study\\java-ee-jfinal-study\\java-ee-jfinal-4.9-study\\jfinal-4.9-japidocs";
    String projectSrcPath = projectRootPath + "/src";
    String projectWebappPath = projectSrcPath + "/main/webapp";
    String apiDocsPath = projectWebappPath + "/apidocs";

    log.info("projectRootPath:{}", projectRootPath);
    log.info("apiDocsPath:{}", apiDocsPath);

    DocsConfig config = new DocsConfig();
    // root project path
    config.setProjectPath(projectRootPath);
    // project name
    config.setProjectName("used_car");
    config.setApiVersion("v1.0"); // api version
    // 保存路径
    config.setDocsPath(apiDocsPath);
    // 添加插件
    config.addPlugin(new PostmanDocPlugin());
    // auto generate
    config.setAutoGenerate(Boolean.FALSE);
    config.setMvcFramework("JFinal");
    Docs.buildHtmlDocs(config); // execute to generate
  }

}