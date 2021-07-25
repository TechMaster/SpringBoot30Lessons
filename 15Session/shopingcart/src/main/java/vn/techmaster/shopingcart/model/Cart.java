package vn.techmaster.shopingcart.model;

import java.util.Collections;
import java.util.List;

import lombok.Data;
@Data
public class Cart {
  private List<OrderLine> orderLines;
  private long rawTotal;
  private long discount;
  private long vatTax;
  private long total;

  public Cart() {
    orderLines = Collections.emptyList();
    rawTotal = 0;
    discount = 0;
    vatTax = 0;
    total = 0;
  }

  public Cart(List<OrderLine> orderLines, double discountPercentage, boolean isVATIncluded){
    this.orderLines = orderLines;
    rawTotal = 0;

    orderLines.stream().forEach(orderLine -> {
      rawTotal += orderLine.getCount() * orderLine.getProduct().getPrice();
    });

    discount = (long) Math.round(rawTotal * discountPercentage);
    
    if (isVATIncluded) {
      vatTax = (long) Math.round((rawTotal - discount) * 0.01f);
    } else {
      vatTax = 0;
    }

    total = rawTotal - discount + vatTax;
  }
}