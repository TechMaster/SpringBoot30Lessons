package vn.techmaster.shoppingcart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.shoppingcart.model.Cart;
import vn.techmaster.shoppingcart.model.Order;
import vn.techmaster.shoppingcart.model.Product;
import java.util.List;

@Service
public class CartService {
    @Autowired
    private ProductService productService;
    private Cart cart = new Cart();
    //Them product vao cart
    public void addToCart(Long id){
        Product product = productService.getProduct(id);
        if(product!=null){
            List<Order> orderList = cart.getOrderList();
            if(orderList.size()==0){

                orderList.add(new Order(product,1));
                cart.setCart(orderList,0,true);
                return;
            }
            else{
                for(int i=0;i<orderList.size();i++){
                    if(orderList.get(i).getProduct().getId()==product.getId()){
                        Order order = orderList.get(i);
                        order.setCount(order.getCount()+1);
                        orderList.set(i,order);
                        cart.setCart(orderList,0,true);
                        return;
                    }

                }
                orderList.add(new Order(product,1));
                cart.setCart(orderList,0,true);
                return;

            }
        }
    }

    //Giam so luong product trong cart
    public void removeFromCart(Long id){
        Product product = productService.getProduct(id);
        List<Order> orderList = cart.getOrderList();
        for(int i=0;i<orderList.size();i++){
            if(orderList.get(i).getProduct().getId()==product.getId()){
                Order order = orderList.get(i);
                if(order.getCount()>1)
                    order.setCount(order.getCount()-1);
                orderList.set(i,order);
                cart.setCart(orderList,0,true);
            }
        }
    }

    //Xoa order chua product trong cart
    public void removeOrder(Long id){
        List<Order> orderList = cart.getOrderList();
        orderList.removeIf(order -> order.getProduct().getId()==id);
        cart.setCart(orderList,0,true);
    }

    public Cart getCart(){
        return this.cart;
    }

    //Tong so product trong cart
    public int getCount(){
        int count = 0;
        for (Order order:cart.getOrderList()) {
            count +=order.getCount();
        }
        return count;
    }

    //Giam gia trong cart
    public void discount(double percent){
        cart.setCart(cart.getOrderList(),percent,true);
    }
}
