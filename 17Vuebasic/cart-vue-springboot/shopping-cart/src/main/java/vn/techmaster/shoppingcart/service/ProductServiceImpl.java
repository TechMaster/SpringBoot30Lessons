package vn.techmaster.shoppingcart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.shoppingcart.model.Product;
import vn.techmaster.shoppingcart.repository.ProductRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public Product getProduct(Long id) {
        return productRepository.getAll().stream()
                .filter(product -> product.getId()==id).findAny().orElse(null);
    }

    @Override
    public List<Product> searchProduct(String context) {
        return productRepository.getAll().stream()
                .filter(product->product.getName().toLowerCase().contains(context.toLowerCase()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> sortProduct(String type) {
        switch(type){
            case "price":
                return productRepository.getAll().stream()
                        .sorted(Comparator.comparingDouble(Product::getPrice))
                        .collect(Collectors.toList());
            case "asc":
                return productRepository.getAll().stream()
                        .sorted(Comparator.comparing(Product::getName))
                        .collect(Collectors.toList());
            case "desc":
                return productRepository.getAll().stream()
                        .sorted(Comparator.comparing(Product::getName).reversed())
                        .collect(Collectors.toList());
            default:
                return productRepository.getAll();
        }

    }
}
