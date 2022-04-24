package com.litongjava.jfinal.swagger.controller;

import java.util.Arrays;

import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.jfinal.kit.Kv;
import com.jfinal.swagger.annotation.ActionApi;
import com.jfinal.swagger.annotation.Api;
import com.jfinal.swagger.annotation.Param;
import com.jfinal.swagger.annotation.Params;
import com.jfinal.swagger.enums.InType;

@Api(tag = "/", remark = "首页Controller", sort = 10, outerRemark = "查看更多关于首页", outerUrl = "https://www.baidu.com/s?wd=JFinal")
@Path("/")
public class IndexController extends Controller {

  @ActionApi(tag = "/", remark = "IndexController首页Action", summary = "首页", sort = 2)
  public void index() {
    renderJson(Kv.by("index", "Hello JFinal!"));
  }

  @ActionApi(tag = "/", remark = "欢迎加入JFinal俱乐部", httpMethod = "post", sort = 1, consumes = "application/json", url = "/club")
  @Params({
      @Param(name = "memberName", remark = "会员", dataType = "string", defaultValue = "James", required = true, in = InType.QUERY, format = "", schema = "http"),
      @Param(name = "memberId", remark = "会员ID", dataType = "integer", defaultValue = "88888", required = true, minimum = "1", maximum = "999999"),
      @Param(name = "level", remark = "会员等级", dataType = "integer", defaultValue = "8") })
  public void club() {
    String memberName = get("memberName");
    int memberId = getInt("memberId");
    int level = getInt("level");
    Kv cnKv = Kv.by("welcome", memberName + ":欢迎加入JFinal俱乐部!").set("memberId", memberId).set("level", level);
    Kv enKv = Kv.by("welcome", memberName + ":Welcome to JFinal club!").set("memberId", memberId).set("level", level);
    renderJson(Arrays.asList(cnKv, enKv));
  }
}