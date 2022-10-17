package top.ppnt.jfinal.spring.mvc.java.initialier;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import top.ppnt.jfinal.spring.mvc.java.config.SpringConfig;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
  @Override
  protected Class<?>[] getRootConfigClasses() {
    return null;
  }

  @Override
  protected Class<?>[] getServletConfigClasses() {
    // <!-- 引入SpringConfig配置类，该类用来配置spring容器 -->
    return new Class[] { SpringConfig.class };
  }

  @Override
  protected String[] getServletMappings() {
    // <!-- 配置DispatcherServlet对应所有请求(*表示所有) -->
    return new String[] { "/*" };
  }
}