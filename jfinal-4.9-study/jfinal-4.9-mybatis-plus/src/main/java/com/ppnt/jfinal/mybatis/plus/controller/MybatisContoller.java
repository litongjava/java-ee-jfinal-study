package com.ppnt.jfinal.mybatis.plus.controller;

import java.util.Collection;

import org.apache.ibatis.binding.MapperRegistry;
import org.apache.ibatis.session.SqlSession;

import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.ppnt.jfinal.mybatis.plus.mapper.UserMapper;
import com.ppnt.jfinal.mybatis.plus.utils.MybatisPlusUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author create by Ping E Lee on 2022年3月29日 下午3:04:52 
 *
 */
@Path("mybatis")
@Slf4j
public class MybatisContoller extends Controller{

  public void mappers() {
    SqlSession sqlSession = MybatisPlusUtils.openSession();
    MapperRegistry mapperRegistry = sqlSession.getConfiguration().getMapperRegistry();
    Collection<Class<?>> mappers = mapperRegistry.getMappers();
    for (Class<?> c : mappers) {
      log.info("c:{}", c);
    }
    renderText("success");
  }
  
  public void getUserMapper() {
    SqlSession sqlSession = MybatisPlusUtils.openSession();
    UserMapper mapper = sqlSession.getMapper(UserMapper.class);
    log.info("mapper:{}", mapper);
    renderText("success");
    
  }
}
