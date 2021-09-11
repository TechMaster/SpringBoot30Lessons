package vn.techmaster.jparelation.service.manytomany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.jparelation.model.manytomany.Article;
import vn.techmaster.jparelation.model.manytomany.Tag;
import vn.techmaster.jparelation.repository.manytomany.ArticleRepository;
import vn.techmaster.jparelation.repository.manytomany.TagRepository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ArticleTagService {
  @PersistenceContext
  private EntityManager em;

  @Autowired private ArticleRepository articleRepository;
  @Autowired private TagRepository tagRepository;
  @Transactional
  public void generateArticleTag() {
    Tag sport = new Tag("Sport");
    Tag fashion = new Tag("Fashion");
    Tag technology = new Tag("Technology");

    Article at1 = new Article("Ronaldo sang Việt nam thi đấu");
    Article at2 = new Article("Luis Vuiton sẽ sản xuất ở Việt nam");
    Article at3 = new Article("HTML6 chuẩn bị ra mắt");
    Article at4 = new Article("Pep Guardiola học lập trình Java");
    Article at5 = new Article("Zlatan Ibrahimovic quảng cáo cho Bitis Hunter");

    at1.addTag(sport);
    at2.addTag(fashion);
    at3.addTag(technology);
    at4.addTag(sport);
    at4.addTag(technology);
    at5.addTag(sport);
    at5.addTag(fashion);

    em.persist(sport);
    em.persist(fashion);
    em.persist(technology);

    em.persist(at1); em.persist(at2); em.persist(at3);
    em.persist(at4); em.persist(at5);
  }

  public List<Article> getAllArticles() {
    return articleRepository.findAll();
  }
  public List<Tag> getAllTags(){return  tagRepository.findAll();}
}
