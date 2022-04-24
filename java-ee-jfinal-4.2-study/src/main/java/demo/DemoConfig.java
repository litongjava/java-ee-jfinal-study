package demo;

import java.util.List;

import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.server.undertow.UndertowServer;
import com.jfinal.template.Engine;

public class DemoConfig extends JFinalConfig {

  public static void main(String[] args) {
    long start = System.currentTimeMillis();
    // 最简单的方式启动
    UndertowServer.start(DemoConfig.class);
    // UndertowServer.create(DemoConfig.class).configWeb(builder -> {
    // builder.addServlet("HelloServlet", "demo.servlet.HelloServlet");
    // builder.addServletMapping("HelloServlet", "HelloServlet.do");
    // }).start();
    long end = System.currentTimeMillis();
    System.out.println("启动完成,共使用了:" + (end - start) + "ms");
    List<UrlManager> list = UrlManager.dao.find("select * from url_manager");
    System.out.println(list);
  }

  public void configConstant(Constants me) {
    me.setDevMode(true);
    me.setUrlParaSeparator("&");
  }

  public void configRoute(Routes me) {
    me.add("/hello", HelloController.class);
  }

  public void configEngine(Engine me) {
  }

  public void configPlugin(Plugins me) {
    PropKit.use("undertow.txt");
    String jdbcUrl = PropKit.get("jdbc.url");
    String jdbcUser = PropKit.get("jdbc.user");
    String jdbcPswd = PropKit.get("jdbc.pswd");
    System.out.println(jdbcUrl + "," + jdbcUrl + "," + jdbcPswd);
    DruidPlugin dp = new DruidPlugin(jdbcUrl, jdbcUser, jdbcPswd);
    me.add(dp);
    ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
    me.add(arp);
    arp.addMapping("url_manager", UrlManager.class);
  }

  public void configInterceptor(Interceptors me) {
  }

  public void configHandler(Handlers me) {
  }
}