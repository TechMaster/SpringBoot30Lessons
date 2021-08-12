package vn.techmaster.shoppingcart.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data

public class Cart {
    List<Order> orderList;
    private long rawTotal;
    private long discount;
    private long vatTax;
    private long total;

    public Cart() {
        orderList = new ArrayList<>();
        rawTotal = 0;
        discount = 0;
        vatTax = 0;
        total = 0;
    }

    public void setCart(List<Order> orderList, double discountPercentage, boolean isVATIncluded){
        this.orderList = orderList;
        rawTotal = 0;

        orderList.stream().forEach(order ->
                rawTotal += order.getCount() * order.getProduct().getPrice()
        );

        discount = (long) Math.round(rawTotal * discountPercentage);

        if (isVATIncluded) {
            vatTax = (long) Math.round((rawTotal - discount) * 0.01f);
        } else {
            vatTax = 0;
        }

        total = rawTotal - discount + vatTax;
    }
}
