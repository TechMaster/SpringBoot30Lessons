package vn.techmaster.web.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import vn.techmaster.web.model.Product;

import java.util.List;

@FeignClient("shop")
public interface ShopClient {
	@GetMapping("/products")
	public List<Product> getProducts();
}
