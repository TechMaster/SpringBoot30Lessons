package vn.techmaster.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import vn.techmaster.web.feign.ShopClient;
import vn.techmaster.web.model.Product;

import java.util.List;

@Controller
public class WebController {
	@Autowired	private ShopClient shopClient;

	@GetMapping("/")
	public String showProducts(Model model) {
		List<Product> products = shopClient.getProducts();
		model.addAttribute("products", products);
		return "products.html";
	}
}
