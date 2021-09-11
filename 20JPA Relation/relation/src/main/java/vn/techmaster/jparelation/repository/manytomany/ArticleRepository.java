package vn.techmaster.jparelation.repository.manytomany;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.jparelation.model.manytomany.Article;


public interface ArticleRepository extends JpaRepository<Article, Long> {
  
}
