package demo;

import com.jfinal.core.Controller;
import com.jfinal.core.Path;

import java.util.HashMap;
import java.util.Map;

@Path("/hello")
public class HelloController extends Controller {
  public void index() {
    renderText("Hello JFinal World 111s");
  }

  public void name(String first, String last) {
    renderText(first + ":" + last);
  }


  // http://localhost/hello/var/1111
  @Path(value = "/var/{id}")
  public void getById(String id) {
    System.out.println(id);
    renderText(id);
  }

  // http://localhost/hello/var/tableName/list
  @Path(value = "/var/{name}/list")
  public void list(String name) {
    System.out.println(name);
    renderText(name);
  }

  //http://localhost/hello/var/name/a?id=111
  @Path(value = "/var/{name}/a")
  public void a(String name, String id) {
    System.out.println(name);
    System.out.println(id);
    renderText(name + ":" + id);
  }

  //http://localhost/hello/var/d/name/111
  @Path(value = "/var/d/{name}/{id}")
  public void var(String name, String id) {
    System.out.println(name);
    System.out.println(id);
    renderText(name + ":" + id);
  }

  //http://localhost/hello/var/four/name/111?a=a&b=b;
  @Path(value = "/var/four/{name}/{id}")
  public void four(String name, String id, String a, String b) {
    renderText(name + ":" + id + ":" + a + ":" + b);
  }

  //http://localhost/hello/jsonMap
  public Map<String, String> jsonMap() {
    Map<String, String> map = new HashMap<>();
    map.put("name", "liotng");
    return map;
  }
}