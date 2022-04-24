package com.ppnt.jfinal.mybatis.plus.utils;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.baomidou.mybatisplus.core.MybatisSqlSessionFactoryBuilder;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MybatisPlusUtils {
  public static final String resource = "mybatis.xml";
  private static SqlSessionFactory factory;
  static {
    InputStream inputStream = null;
    try {
      inputStream = Resources.getResourceAsStream(resource);
      // factory= new SqlSessionFactoryBuilder().build(inputStream);
      MybatisSqlSessionFactoryBuilder builder=new MybatisSqlSessionFactoryBuilder();
      log.info("builder:{}", builder);
      factory=builder.build(inputStream);
      log.info("factory:{}", factory);
    } catch (IOException ioException) {
      ioException.printStackTrace();
    }
  }

  /**
   * 返回factory
   * @return
   */
  public static SqlSessionFactory getFactory() {
    return factory;
  }

  /**
   * 打开会话
   * @return
   */
  public static SqlSession openSession(boolean autoCommit) {
    return factory.openSession(autoCommit);
  }

  public static SqlSession openSession() {
    return factory.openSession(true);
  }

}
