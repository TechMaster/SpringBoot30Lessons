package vn.techmaster.jparelation.controller.onemany.undirectional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.techmaster.jparelation.model.onemany.undirectional.Product;
import vn.techmaster.jparelation.service.onemany.undirectional.ProductCategoryService;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductCategoryService productCategoryService;
    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts(){
        return new ResponseEntity<>(productCategoryService.getAll(), HttpStatus.OK);
    }
}
