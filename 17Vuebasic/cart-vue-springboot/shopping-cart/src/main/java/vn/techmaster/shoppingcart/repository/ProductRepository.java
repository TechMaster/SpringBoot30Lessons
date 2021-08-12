package vn.techmaster.shoppingcart.repository;

import org.springframework.stereotype.Repository;
import vn.techmaster.shoppingcart.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Repository
public class ProductRepository {
    private List<Product> products = new ArrayList<>();
    public ProductRepository(){
        products = Arrays.asList(
                new Product(1L,"Acer Aspire","A new sence",86,"watch1"),
                new Product(2L,"Booror Moon","A new sence",90,"watch2"),
                new Product(3L,"Rocker Stone","A new sence",96,"watch3"),
                new Product(4L,"Dark Knight","A new sence",105,"watch4"),
                new Product(5L,"Glow Dim","A new sence",80,"watch5"),
                new Product(6L,"Flash Tider","A new sence",100,"watch6")
        );
    }
    public List<Product> getAll(){
        return this.products;
    }
}
