package top.ppnt.modules.jfinal.api.docs.controller;

import com.jfinal.aop.Inject;
import com.jfinal.core.Controller;
import com.jfinal.core.Path;
import com.jfinal.core.paragetter.Para;
import com.litongjava.utils.vo.JsonBean;

import io.github.yedaxia.apidocs.ApiDoc;
import top.ppnt.modules.jfinal.api.docs.model.CarBrand;
import top.ppnt.modules.jfinal.api.docs.services.CarBrandService;
import top.ppnt.modules.jfinal.api.docs.services.CarSeriesServices;

@ApiDoc
@Path("api/car")
public class CarApiController extends Controller {

  @Inject
  private CarBrandService carBrandService;

  @Inject
  private CarSeriesServices carSeriesServices;

  /**
   * 获取所有车辆品牌列表
   */
  @ApiDoc(result = JsonBean.class)
  public void getBrandsAll() {
    renderJson(new JsonBean<>(carBrandService.getBrandsAll()));
  }

  /**
   * 获取车系列表
   */
  @ApiDoc(result = JsonBean.class)
  public void getSeries(@Para("") CarBrand carBrand) {
    renderJson(new JsonBean<>(carSeriesServices.getSeries(carBrand.getBrandName())));
  }
}