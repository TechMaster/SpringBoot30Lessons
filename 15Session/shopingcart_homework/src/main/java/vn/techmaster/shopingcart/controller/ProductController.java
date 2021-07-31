package vn.techmaster.shopingcart.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import vn.techmaster.shopingcart.model.Cart;
import vn.techmaster.shopingcart.model.OrderLine;
import vn.techmaster.shopingcart.model.User;
import vn.techmaster.shopingcart.repository.ProductRepository;
import vn.techmaster.shopingcart.service.CartService;
import vn.techmaster.shopingcart.util.MailConstructor;

import java.util.Locale;

@Controller
public class ProductController {
  @Autowired private ProductRepository productRepository;
  @Autowired private CartService cartService;
  @Autowired private JavaMailSender mailSender;
  @Autowired
  private MailConstructor mailConstructor;

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

  @GetMapping("/add/{id}")
  public String add(@PathVariable(name = "id") Long id, HttpSession session, Model model) {
    cartService.addToCart(id, session);
    model.addAttribute("cartCount", cartService.countItemInCart(session));
    return "redirect:/checkout";
  }

  @GetMapping("/remove/{id}")
  public String remove(@PathVariable(name = "id") Long id, HttpSession session, Model model) {
    cartService.removeFromCart(id,session);
    model.addAttribute("cartCount", cartService.countItemInCart(session));
    return "redirect:/checkout";
  }

  @GetMapping("/delete/{id}")
  public String delete(@PathVariable(name = "id") Long id, HttpSession session, Model model) {
    cartService.deleteOrder(id,session);
    System.out.println(cartService.countItemInCart(session));
    model.addAttribute("cartCount", cartService.countItemInCart(session));
    return "redirect:/checkout";
  }

  @GetMapping("/checkout")
  public String checkout(HttpSession session, Model model) {
    model.addAttribute("cart", cartService.getCart(session));
    model.addAttribute("cartCount", cartService.countItemInCart(session));
    return "checkout";
  }

  @GetMapping("/userForm")
  public String getForm(Model model, HttpSession session){
    model.addAttribute("cartCount",cartService.countItemInCart(session));
    model.addAttribute("user",new User());
    return "userform";
  }

  @PostMapping("/confirm")
  public String confirm(@Valid @ModelAttribute("user") User user, BindingResult result,
                        Model model, HttpSession session, HttpServletRequest request){
    if(!result.hasErrors()){
      mailSender.send(mailConstructor.constructOrderConfirmationEmail(user, cartService.getCart(session), Locale.ENGLISH));
      model.addAttribute("products", productRepository.getAll());
      model.addAttribute("cartCount",0);
      request.getSession().invalidate();
      return "index";
    }
    return "userform";
  }

}
