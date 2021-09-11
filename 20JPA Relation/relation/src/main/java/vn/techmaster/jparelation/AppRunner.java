package vn.techmaster.jparelation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import vn.techmaster.jparelation.service.manytomany.ArticleTagService;
import vn.techmaster.jparelation.service.onemany.bidirectional.AuthorBookService;
import vn.techmaster.jparelation.service.onemany.undirectional.ProductCategoryService;
import vn.techmaster.jparelation.service.onetoone.UserService;

@Component
public class AppRunner implements CommandLineRunner {
    @Autowired private UserService userService;
    @Autowired private ProductCategoryService productCategoryService;
    @Autowired private AuthorBookService authorBookService;
    @Autowired private ArticleTagService articleTagService;
    @Override
    public void run(String... args) throws Exception {
        userService.generateUsers();
        productCategoryService.generateCategoryProduct();
        authorBookService.generateAuthorBook();
        articleTagService.generateArticleTag();
    }
}
