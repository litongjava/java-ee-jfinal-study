package top.ppnt.jfinal.swagger.controller;

import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.jfinal.kit.Kv;

import top.ppnt.jfinal.swaager.api.annotation.ActionApi;
import top.ppnt.jfinal.swaager.api.annotation.Api;
import top.ppnt.jfinal.swaager.api.annotation.Param;

@Api(remark = "UserController，排序到末尾", sort = 2)
@Path("user")
public class UserController extends Controller {

  @ActionApi(remark = "DemoController首页Action")
  public void index() {
    renderJson(Kv.by("user", "Hello JFinal!"));
  }

  @ActionApi(remark = "输出文本")
  @Param(name = "text", remark = "文本内容")
  public void text() {
    renderText("输出接收文本：<br>" + get("text"));
  }
}