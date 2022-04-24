package com.ppnt.jfinal.mybatis.plus.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ppnt.jfinal.mybatis.plus.mapper.UserMapper;
import com.ppnt.jfinal.mybatis.plus.model.User;
import com.ppnt.jfinal.mybatis.plus.utils.MybatisPlusUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * @author create by Ping E Lee on 2022年3月28日 下午6:12:10 
 *
 */
@Slf4j
public class UserServcie {
  public List<User> selectList() {
    SqlSession sqlSession = MybatisPlusUtils.openSession();
    log.info("sqlSession:{}", sqlSession);
    UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
    log.info("userMapper:{}", userMapper);
    return userMapper.selectList(null);
  }
}
