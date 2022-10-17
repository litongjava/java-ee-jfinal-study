package com.litongjava.jfina.undertow.servet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CharsetFilter implements Filter {
  public void destroy() {
    /* 销毁时调用 */
  }

  public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
    log.info("after filter");
    /* 过滤方法 主要是对request和response进行一些处理，然后交给下一个过滤器或Servlet处理 */
    chain.doFilter(req, resp);// 交给下一个过滤器或servlet处理
    log.info("after filter");
  }

  public void init(FilterConfig config) throws ServletException {
    /* 初始化方法 接收一个FilterConfig类型的参数 该参数是对Filter的一些配置 */
  }
}
