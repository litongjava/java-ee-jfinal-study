package com.ppnt.jfinal.mybatis.plus.utils;

import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;

/**
 * @author create by Ping E Lee on 2022年3月28日 下午5:59:24 
 *
 */
public class PropUtils {
  public static Prop p;

  static {
    if (p == null) {
      p = PropKit.getProp();
    }
  }
}
