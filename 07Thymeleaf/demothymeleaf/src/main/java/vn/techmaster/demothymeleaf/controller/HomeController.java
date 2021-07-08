package vn.techmaster.demothymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import vn.techmaster.demothymeleaf.model.Person;
import vn.techmaster.demothymeleaf.repository.ProductRepository;

@Controller
public class HomeController {
  @Autowired private ProductRepository productRepo;

  @GetMapping("/")
  public String getHome() {
    return "index";
  }

  @GetMapping("/about")
  public String getAbout() {
    return "about";
  }

  @GetMapping("/products")
  public String getProducts(Model model) {
    model.addAttribute("products", productRepo.getProducts());
    return "products";
  }

  @GetMapping("/listbox")
  public String showListBox(Model model) {
    model.addAttribute("countries", productRepo.getCountries());
    return "listbox";
  }

  @GetMapping("/services")
  public String getService() {
    return "services";
  }

  @GetMapping("/text")
  public String demoText(Model model) {
    Person tom = new Person("Tom", "USA", "1976-12-01");
    model.addAttribute("person", tom);
    return "text";
  }

  @GetMapping("/hello")
  public String showHello() {
    return "hello";
  }
}
