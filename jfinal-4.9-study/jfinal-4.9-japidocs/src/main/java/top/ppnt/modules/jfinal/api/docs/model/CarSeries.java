package top.ppnt.modules.jfinal.api.docs.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Ping E Lee
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarSeries {
  // 车辆系列id
  private String id;
  // 车辆系列品牌id
  private String carBrandId;
  // 车辆系列名称
  private String carSeriesName;
}
