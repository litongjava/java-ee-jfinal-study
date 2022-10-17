package com.litongjava.jfina.undertow.servet.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.litongjava.jfina.undertow.servet.model.User;

@SuppressWarnings("serial")
public class UserServlet extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    HttpSession session = req.getSession();
    String type = req.getParameter("type");
    if ("login".equals(type)) {
      session.setAttribute("user", new User("litong", "00000000"));
      session.setMaxInactiveInterval(30*60);
    } else if("invalidate".equals(type)){
      session.invalidate();
    }else {
      session.removeAttribute("user");
    }
    super.doGet(req, resp);
  }
}
