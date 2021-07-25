package vn.techmaster.shopingcart.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import vn.techmaster.shopingcart.repository.ProductRepository;
import vn.techmaster.shopingcart.service.CartService;

@Controller
public class ProductController {
  @Autowired private ProductRepository productRepository;
  @Autowired private CartService cartService;

  @GetMapping("/")
  public String showHomePage(HttpSession session, Model model) {
    model.addAttribute("products", productRepository.getAll());
    model.addAttribute("cartCount", cartService.countItemInCart(session));
    return "index";
  }

  @GetMapping("/buy/{id}")
  public String buy(@PathVariable(name = "id") Long id, HttpSession session, Model model) {
    cartService.addToCart(id, session);
    return "redirect:/";
  }

  @GetMapping("/checkout")
  public String checkout(HttpSession session, Model model) {
    model.addAttribute("cart", cartService.getCart(session));
    return "checkout";
  }
}
