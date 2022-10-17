package com.litongjava.jfinal.mybatis.controller;

import org.apache.ibatis.session.SqlSession;

import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.litongjava.jfinal.mybatis.mapper.SystemAdminMapper;
import com.litongjava.jfinal.mybatis.model.SystemAdmin;
import com.litongjava.jfinal.mybatis.plugin.SqlSessionManager;
import com.litongjava.jfinal.mybatis.utils.MybatisUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IndexController extends Controller {

  @Inject
  private SystemAdminMapper mapper;
  
  public void index() {
    SystemAdminMapper mapper = MybatisUtils.openSession().getMapper(SystemAdminMapper.class);
    log.info("systemAdminMapper:{}",mapper);
    SystemAdmin systemAdmin = new SystemAdmin();
    systemAdmin.setLoginName("litong");
    renderJson(mapper.getSystemAdmin(systemAdmin));
  }
  
  public void v2() {
    SqlSession sqlSession = SqlSessionManager.getSqlSession();
    SystemAdminMapper mapper = sqlSession.getMapper(SystemAdminMapper.class);
    log.info("systemAdminMapper:{}",mapper);
    SystemAdmin systemAdmin = new SystemAdmin();
    systemAdmin.setLoginName("litong");
    renderJson(mapper.getSystemAdmin(systemAdmin));
  }
  
  public void v3() {
    log.info("systemAdminMapper:{}",mapper);
    renderText("v3");
  }
}