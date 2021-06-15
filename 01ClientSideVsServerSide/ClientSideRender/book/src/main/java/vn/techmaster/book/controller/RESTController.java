package vn.techmaster.book.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.techmaster.book.model.Book;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class RESTController {

  @GetMapping("/books")
  public ResponseEntity<List<Book>> listBooks() {
    List<Book> books = List.of(
      new Book("Dế Mèn Phiêu Lưu Ký", "Tô Hoài"),
      new Book("Nhật Ký Trong Tù", "Hồ Chí Minh"),
      new Book("Tắt Đèn", "Ngô Tất Tố")
    );
    return ResponseEntity.ok().body(books);
  }
}
