package vn.techmaster.shopingcart.model;

import java.io.Serializable;

import lombok.Data;

@Data
public class Product implements Serializable{
  private long id;
  private String name;
  private String manufacturer;
  private long price;
  private String photo;

  public Product(String name, String manufacturer, long price, String photo) {
    this.name = name;
    this.manufacturer = manufacturer;
    this.price = price;
    this.photo = photo;
  }
}
