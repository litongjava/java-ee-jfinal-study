package com.litongjava.jfinal.mybatis.interceptor;

import java.lang.reflect.Field;

import org.apache.ibatis.session.SqlSession;

import com.jfinal.aop.Inject;
import com.jfinal.aop.Interceptor;
import com.jfinal.aop.Invocation;
import com.jfinal.core.Controller;
import com.litongjava.jfinal.mybatis.plugin.SqlSessionManager;

import lombok.extern.slf4j.Slf4j;

/**
 * mappr接口代理类注入
 */
@Slf4j
public class MapperBeanInterceptor implements Interceptor {

  @Override
  public void intercept(Invocation inv) {
    Controller controller = inv.getController();
    Field[] fields = controller.getClass().getDeclaredFields();
    for (Field field : fields) {
      Object bean = null;
      if (field.isAnnotationPresent(Inject.class)) {
        try {
          if (field.getType().isInterface()) {
            Class<?> type = field.getType();
            log.info("type:{}", type);
            SqlSession sqlSession = SqlSessionManager.getSqlSession();
            log.info("sqlSession:{}", sqlSession);
            bean = sqlSession.getMapper(type);
            log.info("注入Bean:{}",bean);
          }
        } catch (Exception e) {
          throw new NullPointerException("can not get proxy bean");
        }
      }
      try {
        if (bean != null) {
          field.setAccessible(true);
          field.set(controller, bean);
        }
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }
    inv.invoke();
  }
}