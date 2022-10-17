package top.ppnt.modules.jfinal.api.docs.services;

import java.util.ArrayList;
import java.util.List;

import top.ppnt.modules.jfinal.api.docs.model.CarSeries;

/**
 * @author Ping E Lee
 *
 */
public class CarSeriesServices {

  public List<CarSeries> getSeries(String brand) {
    List<CarSeries> list = new ArrayList<CarSeries>();
    list.add(new CarSeries("1", "奔驰", "奔驰X5"));
    list.add(new CarSeries("1", "奔驰", "奔驰X6"));
    return list;
  }

}
