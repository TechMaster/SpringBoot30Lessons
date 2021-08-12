package vn.techmaster.shoppingcart.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Order {
    private Product product;
    private int count;
    public void increaseByOne() {
        count += 1;
    }
    public void decreaseByOne() {
        if(count>0)
            count -=1;
    }
}
