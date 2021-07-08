package vn.techmaster.demothymeleaf.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

import vn.techmaster.demothymeleaf.model.Country;
import vn.techmaster.demothymeleaf.model.Product;

@Repository
public class ProductRepository {
  private ArrayList<Product> products;
  private ArrayList<Country> countries;
  
  public ProductRepository() {
    products = new ArrayList<>(List.of
    (new Product("Sony WX-MH1004", "Sony", 55000000),
    new Product("Nike Air", "Nike", 25000000),
    new Product("Dell M6800", "Dell", 105000000),
    new Product("Aris Pro", "VinSmart", 65000000),
    new Product("Logitech MX Master 2X", "Logitech", 32000000)
    )
    );

    countries = new ArrayList<>(List.of(
      new Country("Vietnam", "VN"),
      new Country("China", "CN"),
      new Country("USA", "US"),
      new Country("France", "FR"),
      new Country("Singapore", "SG"),
      new Country("Japan", "JP")
      ));
  }

  public List<Product> getProducts() {
    return products;
  }

  public List<Country> getCountries() {
    return countries;
  }
}
