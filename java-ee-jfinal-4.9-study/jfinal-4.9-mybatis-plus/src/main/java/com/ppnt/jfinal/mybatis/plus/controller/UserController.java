package com.ppnt.jfinal.mybatis.plus.controller;

import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.ppnt.jfinal.mybatis.plus.service.UserServcie;

/**
 * @author create by Ping E Lee on 2022年3月28日 下午6:13:23 
 *
 */
@Path("user")
public class UserController extends Controller {

  @Inject
  private UserServcie userServcie;

  public void selectList() {
    renderJson(userServcie.selectList());
  }
}
