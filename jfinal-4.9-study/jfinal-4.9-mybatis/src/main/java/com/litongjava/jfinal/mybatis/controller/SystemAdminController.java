package com.litongjava.jfinal.mybatis.controller;

import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.litongjava.jfinal.mybatis.mapper.SystemAdminMapper;
import com.litongjava.jfinal.mybatis.model.SystemAdmin;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SystemAdminController extends Controller {

  @Inject
  SystemAdminMapper mapper;

  public void getMapperWithPlugin() {
    log.info("mapper:{}", mapper);
    SystemAdmin systemAdmin = new SystemAdmin();
    systemAdmin.setLoginName("litong");
    renderJson(mapper.getSystemAdmin(systemAdmin));
  }
}
