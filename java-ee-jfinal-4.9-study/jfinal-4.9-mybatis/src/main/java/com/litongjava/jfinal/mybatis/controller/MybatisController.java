package com.litongjava.jfinal.mybatis.controller;

import java.awt.ContainerOrderFocusTraversalPolicy;
import java.sql.Connection;
import java.util.Collection;

import org.apache.ibatis.binding.MapperRegistry;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.jfinal.core.Controller;
import com.litongjava.jfinal.mybatis.mapper.SystemAdminMapper;
import com.litongjava.jfinal.mybatis.plugin.SqlSessionManager;
import com.litongjava.jfinal.mybatis.utils.MybatisUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author create by Ping E Lee on 2022年3月28日 下午9:11:54 
 *
 */
@Slf4j
public class MybatisController extends Controller {

  public void index() {
    renderText("success");
  }

  public void getMapper() {
    SqlSessionFactory factory = MybatisUtils.getFactory();
    log.info("factory:{}", factory);
    SqlSession sqlSession = MybatisUtils.openSession(true);
    log.info("sqlSession:{}", sqlSession);
    Connection connection = sqlSession.getConnection();
    log.info("connection:{}", connection);
    Configuration configuration = sqlSession.getConfiguration();
    log.info("configuration:{}", configuration);
    MapperRegistry mapperRegistry = configuration.getMapperRegistry();
    log.info("mapperRegistry:{}", mapperRegistry);
    SystemAdminMapper mapper = sqlSession.getMapper(SystemAdminMapper.class);
    log.info("mapper:{}", mapper);
    renderText(mapper.toString());
  }
  
  public void getMappers() {
    SqlSession sqlSession = SqlSessionManager.getSqlSession();
    Configuration configuration = sqlSession.getConfiguration();
    MapperRegistry mapperRegistry = configuration.getMapperRegistry();
    Collection<Class<?>> mappers = mapperRegistry.getMappers();
    for (Class<?> c : mappers) {
      log.info("c:{}", c);
    }
    renderText(mappers.toString());
  }
}
