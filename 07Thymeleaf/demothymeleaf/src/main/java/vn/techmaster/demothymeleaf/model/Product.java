package vn.techmaster.demothymeleaf.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
  private String name;
  private String manufacturer;
  private int price;
}
