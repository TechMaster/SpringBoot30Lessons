package vn.techmaster.jparelation.controller.onemany.bidirectional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.techmaster.jparelation.model.onemany.bidirectional.Book;
import vn.techmaster.jparelation.service.onemany.bidirectional.AuthorBookService;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private AuthorBookService authorBookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> getBooks(){
        return new ResponseEntity<>(authorBookService.getAllBooks(), HttpStatus.OK);
    }
}
