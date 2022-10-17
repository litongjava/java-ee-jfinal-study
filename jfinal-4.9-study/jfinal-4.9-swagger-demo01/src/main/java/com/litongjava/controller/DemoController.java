package com.litongjava.controller;

import com.jfinal.core.Controller;
import com.lastb7.swagger.annotation.ApiRes;
import com.lastb7.swagger.annotation.ApiResProperty;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

/**
 * @author: lbq
 * @email: 526509994@qq.com
 * @date: 2020/12/21
 */
@Api(description = "app管理", tags = "示例")
public class DemoController extends Controller {

  @ApiOperation(value = "简单返回值", notes = "SwaggerConst.COMMON_RES.data中返回值")
  @ApiImplicitParams({ @ApiImplicitParam(name = "paramA", value = "参数a", defaultValue = "1111"),
      @ApiImplicitParam(name = "paramB", value = "参数b", defaultValue = "222"), })
  @ApiRes({ @ApiResProperty(name = "resA", value = "返回值A", example = "hello word1"),
      @ApiResProperty(name = "resB", value = "返回值b", example = "hello word2"), })
  public void test2() {
    this.renderJson();
  }
}