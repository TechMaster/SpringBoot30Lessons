package vn.techmaster.shop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.techmaster.shop.model.Product;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class ProductController {
	@GetMapping("products")
	public List<Product> getProducts() {		 
		return new ArrayList<>(List.of(new Product("Nike 360", 100), new Product("Sony WXMH4", 200)));
	}
}
