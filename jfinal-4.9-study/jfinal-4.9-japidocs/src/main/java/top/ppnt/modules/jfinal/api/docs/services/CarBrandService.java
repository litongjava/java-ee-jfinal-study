package top.ppnt.modules.jfinal.api.docs.services;

import java.util.ArrayList;
import java.util.List;

import top.ppnt.modules.jfinal.api.docs.model.CarBrand;

/**
 * @author Ping E Lee
 *
 */
public class CarBrandService {

  public List<CarBrand> getBrandsAll() {
    List<CarBrand> list = new ArrayList<>();
    list.add(new CarBrand("1", "奔驰"));
    list.add(new CarBrand("2", "宝马"));
    return list;
  }

}
