package vn.techmaster.bookstore.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import vn.techmaster.bookstore.model.Book;

@Controller
@RequestMapping("/")
public class HomeController {
  @GetMapping()
  public String showHomePage(Model model) {
    model.addAttribute("name", "Bill Gates");
    return "index";
  }

  @GetMapping("about")
  public String showAboutPage(Model model) {
    model.addAttribute("name", "Bill Gates");
    return "about";
  }

  @GetMapping("books")
  public String listBook(Model model) {
    List<Book> books = List.of(
      new Book("Dế Mèn Phiêu Lưu Ký", "Tô Hoài"),
      new Book("Nhật Ký Trong Tù", "Hồ Chí Minh"),
      new Book("Tắt Đèn", "Ngô Tất Tố"),
      new Book("Cọp Trắng", "Khan")
    );
    model.addAttribute("books", books);
    return "book";
  }
}
