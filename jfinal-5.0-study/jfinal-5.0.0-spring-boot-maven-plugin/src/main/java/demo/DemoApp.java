package demo;

import com.jfinal.server.undertow.UndertowServer;

public class DemoApp {
  public static void main(String[] args) {
    UndertowServer.start(DemoConfig.class, 8000, true);
  }
}
