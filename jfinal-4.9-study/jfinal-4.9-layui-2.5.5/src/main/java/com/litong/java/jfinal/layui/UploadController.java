package com.litong.java.jfinal.layui;

import com.alibaba.fastjson.JSONObject;
import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;
import com.litongjava.utils.vo.JsonBean;

/**
 * @author litong
 * @date 2020年9月28日_下午8:29:40 
 * @version 1.0 
 * @desc
 */
public class UploadController extends Controller {

  public void index() {
    UploadFile file = getFile();
    System.out.println(file.getUploadPath());
    JsonBean<JSONObject> jsonBean = new JsonBean<JSONObject>();
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("src", "1");
    jsonBean.setData(jsonObject);
    renderJson(jsonBean);
  }

}
