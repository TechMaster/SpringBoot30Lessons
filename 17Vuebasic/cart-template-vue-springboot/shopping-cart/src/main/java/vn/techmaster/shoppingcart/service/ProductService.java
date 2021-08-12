package vn.techmaster.shoppingcart.service;

import vn.techmaster.shoppingcart.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product getProduct(Long id);
    List<Product> searchProduct(String context);
    List<Product> sortProduct(String type);
}
