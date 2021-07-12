package vn.techmaster.demothymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import vn.techmaster.demothymeleaf.model.Person;
import vn.techmaster.demothymeleaf.model.TravelType;
import vn.techmaster.demothymeleaf.repository.InMemoryRepository;

@Controller
public class HomeController {
  @Autowired private InMemoryRepository repo;

  @GetMapping("/")
  public String getHome() {
    return "index";
  }

  @GetMapping("/text")
  public String demoText(Model model) {
    Person tom = new Person("Tom", "USA", "1976-12-01", "male");
    model.addAttribute("person", tom);
    model.addAttribute("message", "<h2>Display <span style='color:red'>HTML</span> inside</h2>");
    return "text";
  }

  @GetMapping("/link")
  public String linkExpression(Model model) {
    model.addAttribute("dynamiclink", "products");
    return "link";
  }

  @GetMapping("/hello")
  public String showHello() {
    return "hello";
  }

  @GetMapping("/about")
  public String getAbout() {
    return "about";
  }

  @GetMapping("/products")
  public String getProducts(Model model) {
    model.addAttribute("products", repo.getProducts());
    return "products";
  }

  @GetMapping("/services")
  public String getService() {
    return "services";
  }

  @GetMapping("/condition")
  public String demoCondition(Model model) {
    model.addAttribute("people", repo.getPeople());
    return "condition";
  }

  @GetMapping("/switch")
  public String demoSwitch(Model model) {
    model.addAttribute("users", repo.getUsers());
    return "switch";
  }

  @GetMapping("/thblock")
  public String demoThBlock(Model model) {
    model.addAttribute("travelTypes", TravelType.values());
    return "thblock";
  }



  
}
