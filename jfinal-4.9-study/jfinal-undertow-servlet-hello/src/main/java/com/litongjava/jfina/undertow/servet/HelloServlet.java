package com.litongjava.jfina.undertow.servet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author bill white hat robot
 * @date 2020年9月10日_下午9:36:59 
 * @version 1.0 
 * @desc
 */
@SuppressWarnings("serial")
public class HelloServlet extends HttpServlet{
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    resp.getWriter().print("hello servet 1");
  }
}
