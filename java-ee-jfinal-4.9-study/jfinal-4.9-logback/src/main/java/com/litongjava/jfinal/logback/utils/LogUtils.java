package com.litongjava.jfinal.logback.utils;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

/**
 * @author create by ping-e-lee on 2021年7月12日 下午8:36:28 
 * @version 1.0 
 * @desc
 */

public class LogUtils {
  /**
   * 获取e.printStackTrace() 的具体信息，赋值给String 变量，并返回
   * @param e Exception
   * @return e.printStackTrace() 中 的信息
   */
  public static String getStackTraceInfo(Exception e) {
    /*
     * 将出错的栈信息输出到printWriter中
     */
    StringWriter sw = null;
    PrintWriter pw = null;
    try {
      sw = new StringWriter();
      pw = new PrintWriter(sw);
      e.printStackTrace(pw);
      pw.flush();
      sw.flush();
      return sw.toString();
    } catch (Exception ex) {
      return "printStackTrace()转换错误";
    } finally {
      if (sw != null) {
        try {
          sw.close();
        } catch (IOException e1) {
          e1.printStackTrace();
        }
      }
      if (pw != null) {
        pw.close();
      }
    }
  }
}
