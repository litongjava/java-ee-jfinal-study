package com.litongjava.jfinal.mybatis.plugin;

import org.apache.ibatis.session.SqlSession;

/**
 * SqlSessionManager
 * create by Ping E Lee on 2022年3月28日 下午9:50:58
 *
 */
public class SqlSessionManager {

  private static SqlSession sqlSession;

  public static SqlSession getSqlSession() {
    return sqlSession;
  }

  public static void setSqlSession(SqlSession sqlSession) {
    SqlSessionManager.sqlSession = sqlSession;
  }

  public static <T> T getMapper(Class<T> clazz) {
    return sqlSession.getMapper(clazz);
  }
}