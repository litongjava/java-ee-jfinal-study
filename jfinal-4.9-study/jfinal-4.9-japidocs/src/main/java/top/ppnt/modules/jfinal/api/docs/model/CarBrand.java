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
public class CarBrand {
  // 车辆品牌id
  private String id;
  // 车辆品牌名称
  private String brandName;
}
