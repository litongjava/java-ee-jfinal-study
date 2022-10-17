package top.ppnt.jfinal.spring.mvc.java;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import javax.servlet.ServletContainerInitializer;

import org.springframework.web.SpringServletContainerInitializer;

import com.jfinal.server.undertow.UndertowConfig;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.server.undertow.WebBuilder;

import io.undertow.servlet.api.DeploymentInfo;
import io.undertow.servlet.api.ServletContainerInitializerInfo;
import top.ppnt.jfinal.spring.mvc.java.config.AppConfig;
import top.ppnt.jfinal.spring.mvc.java.initialier.WebInitializer;

public class App {
  public static void main(String[] args) {
    long start = System.currentTimeMillis();

    Consumer<WebBuilder> consumer = builder -> {
      // 配置 Servlet
      String servletName = "dispathcer";
      builder.addServlet(servletName, "org.springframework.web.servlet.DispatcherServlet");
      builder.addServletMapping(servletName, "*/");
      builder.addServletInitParam(servletName, "contextClass", "org.springframework.web.context.support.AnnotationConfigWebApplicationContext");
      builder.setServletLoadOnStartup(servletName, 0);
      // builder.addservet
    };

    Consumer<UndertowConfig> configConsumer = config -> {
    };

    BiConsumer<ClassLoader, DeploymentInfo> onDeployConsumer = (classLoader, deploymentInfo) -> {
      try {
        // String classStr =
        // "org.apache.shiro.web.env.EnvironmentLoaderListener";
        // Class<?> c = classLoader.loadClass(classStr);
        // deploymentInfo.addDeploymentCompleteListener((javax.servlet.ServletContextListener)
        // c.newInstance());
        Class<? extends ServletContainerInitializer> springServletContainerInitializer = SpringServletContainerInitializer.class;
        Set<Class<?>> handlesTypes = null;
        ServletContainerInitializerInfo servletContainerInitializerInfo = new ServletContainerInitializerInfo(springServletContainerInitializer,
            handlesTypes);
        deploymentInfo.addServletContainerInitializer(servletContainerInitializerInfo);
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    };

    // 设置undertow
    UndertowServer servere = UndertowServer.create(AppConfig.class);
    // servere.configWeb(consumer);
    // servere.config(configConsumer);
    servere.onDeploy(onDeployConsumer);
    servere.start();

    long end = System.currentTimeMillis();
    System.out.println((end - start) + "ms");
  }
}