package vn.techmaster.shoppingcart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import vn.techmaster.shoppingcart.model.Product;
import vn.techmaster.shoppingcart.service.CartService;
import vn.techmaster.shoppingcart.service.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin//
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CartService cartService;
    @GetMapping("/products")
    public ResponseEntity<?> getAll(@RequestParam(value = "search",required = false) String search,
                                    @RequestParam(value="sort",required = false) String sort){
        if(search==null && sort==null){
            return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
        }
        else{
            if(search==null)
                return new ResponseEntity<>(productService.sortProduct(sort),HttpStatus.OK);
            else if(sort==null)
                return new ResponseEntity<>(productService.searchProduct(search),HttpStatus.OK);
            else{
                List<Product> products = productService.sortProduct(sort);
                products.stream()
                        .filter(product->product.getName().toLowerCase().contains(search.toLowerCase()))
                        .collect(Collectors.toList());
                return new ResponseEntity<>(products,HttpStatus.OK);
            }
        }
    }


}
