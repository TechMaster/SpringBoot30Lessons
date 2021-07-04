package vn.techmaster.shop;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class ShopApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}

}
