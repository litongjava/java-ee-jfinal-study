package top.ppnt.modules.jfinal.api.docs.plugins;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import io.github.yedaxia.apidocs.DocContext;
import io.github.yedaxia.apidocs.IPluginSupport;
import io.github.yedaxia.apidocs.Resources;
import io.github.yedaxia.apidocs.Utils;
import io.github.yedaxia.apidocs.parser.ControllerNode;

public class PostmanDocPlugin implements IPluginSupport {
  public PostmanDocPlugin() {
  }

  public void execute(List<ControllerNode> controllerNodeList) {
    FileWriter docFileWriter = null;

    try {
      Template ctrlTemplate = this.getDocTpl();

      String docFileName = String.format("%s-%s-api-docs.json", DocContext.getDocsConfig().getProjectName(),
          DocContext.getDocsConfig().getApiVersion());
      File docFile = new File(DocContext.getDocPath(), docFileName);
      docFileWriter = new FileWriter(docFile);
      Map<String, Object> data = new HashMap();
      data.put("controllerNodes", controllerNodeList);
      data.put("currentApiVersion", DocContext.getCurrentApiVersion());
      data.put("projectName", DocContext.getDocsConfig().getProjectName());
      data.put("i18n", DocContext.getI18n());
      ctrlTemplate.process(data, docFileWriter);

    } catch (IOException | TemplateException var10) {
      var10.printStackTrace();
    } finally {
      Utils.closeSilently(docFileWriter);
    }

  }

  private Template getDocTpl() throws IOException {
    return Resources.getFreemarkerTemplate("postman-doc.json.ftl");
  }
}