package com.litongjava.jfinal.mybatis.plugin;

import java.io.IOException;
import java.io.Reader;
import java.util.Collection;

import org.apache.ibatis.binding.MapperRegistry;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.jfinal.aop.Aop;
import com.jfinal.aop.AopManager;
import com.jfinal.plugin.IPlugin;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyBatisPlugin implements IPlugin {

  // 配置文件名称
  private String mybatisConfigXml;

  public MyBatisPlugin(String mybatisConfigXml) {
    this.mybatisConfigXml = mybatisConfigXml;
  }

  @Override
  public boolean start() {
    log.info("插件启动");
    SqlSession sqlSession = getSqlSession();
    log.info("获取sqlSession:{}",sqlSession);
    SqlSessionManager.setSqlSession(sqlSession);
    //将Mapper添加到Aop容器中
//    addMapperToAopContainer(sqlSession);
    return true;
  }

  /**
   * 获取SqlSession
   * 
   * @return
   */
  private SqlSession getSqlSession() {
    Reader reader = null;
    try {
      reader = Resources.getResourceAsReader(mybatisConfigXml);
      SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
      // 通过sqlSessionFactory打开一个数据库会话
      SqlSession sqlSession = sqlSessionFactory.openSession();
      return sqlSession;
    } catch (IOException e) {
      log.error("can not get sqlSession", e);
    }
    return null;
  }
  
  /**
   * 将Mapper添加到Aop容器中
   * @param sqlSession
   */
//  private void addMapperToAopContainer(SqlSession sqlSession) {
//    MapperRegistry mapperRegistry = sqlSession.getConfiguration().getMapperRegistry();
//    Collection<Class<?>> mappers = mapperRegistry.getMappers();
//    for (Class c : mappers) {
//      //c仅仅是一个接口,需要从sqlSession总获取代理类
//      log.info("接口类c:{}", c);
//      Object mapper = sqlSession.getMapper(c);
//      log.info("代理类 mapper:{}", mapper);
//      //Aop.inject(mapper);
//      //AopManager.me().addMapping(c, mapper);
//      AopManager.me().getAopFactory().inject(c,mapper);
//      
//      Object object = Aop.get(c);
//      log.info("获取到的Object:{}",object);
//    }
//  
//  }

  @Override
  public boolean stop() {
    log.info("插件启停止");
    SqlSessionManager.getSqlSession().close();
    return true;
  }
}