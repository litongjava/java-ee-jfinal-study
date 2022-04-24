package demo;

import com.jfinal.core.Controller;

/**
 * Created by litonglinux@qq.com on 8/22/2021_5:37 PM
 */
public class IndexController extends Controller {
  public void index(){
    renderText("this is index controller1");
  }
}
