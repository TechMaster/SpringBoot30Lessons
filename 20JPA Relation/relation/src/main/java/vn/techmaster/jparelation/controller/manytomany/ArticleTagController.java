package vn.techmaster.jparelation.controller.manytomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.techmaster.jparelation.service.manytomany.ArticleTagService;

@RestController
public class ArticleTagController {
    @Autowired
    private ArticleTagService articleTagService;
    @GetMapping("/articles")
    public ResponseEntity<?> getArticles(){
        return ResponseEntity.ok(articleTagService.getAllArticles());
    }
}
