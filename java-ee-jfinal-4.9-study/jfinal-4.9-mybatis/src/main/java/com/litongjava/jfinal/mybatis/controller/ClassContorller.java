package com.litongjava.jfinal.mybatis.controller;

import com.jfinal.core.Controller;
import com.litongjava.jfinal.mybatis.mapper.SystemAdminMapper;

/**
 * @author create by Ping E Lee on 2022年3月28日 下午10:13:50 
 *
 */
public class ClassContorller extends Controller {
  public void index() {
    renderText(SystemAdminMapper.class.toString());
  }
}
