package vn.techmaster.jparelation.service.onemany.undirectional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.jparelation.model.onemany.undirectional.Category;
import vn.techmaster.jparelation.model.onemany.undirectional.Product;
import vn.techmaster.jparelation.repository.onemany.undirectional.ProductRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductCategoryService {
  @Autowired
  private ProductRepository productRepo;
  @PersistenceContext
  private EntityManager em;

  @Transactional
  public void generateCategoryProduct() {
    Category catElectronics = new Category("Electronics");

    Category catFoodBeverages = new Category("Food Beverages");

    Category catFashion = new Category("Fashion");

    Product laptopDell = new Product("Dell Laptop", catElectronics);
    Product mobileVinSmart = new Product("Vinsmart", catElectronics);

    Product beerHanoi = new Product("Beer Hanoi", catFoodBeverages);
    Product kimChi = new Product("Kim Chi", catFoodBeverages);

    Product bitisHunter = new Product("Bitis Hunter", catFashion);
    Product shirt511 = new Product("511 Shirt", catFashion);
    Product jeanVietthang = new Product("Jean Viet Thang", catFashion);

    em.persist(catElectronics);
    em.persist(catFoodBeverages);
    em.persist(catFashion);

    em.persist(laptopDell);
    em.persist(mobileVinSmart);

    em.persist(beerHanoi);
    em.persist(kimChi);
    
    em.persist(bitisHunter);
    em.persist(shirt511);
    em.persist(jeanVietthang);

    /*
    //thử xoá category Fashion sẽ báo lỗi  Referential integrity constraint violation: 
    "FK1MTSBUR82FRN64DE7BALYMQ9S: PUBLIC.PRODUCT FOREIGN KEY(CATEGORY_ID) REFERENCES PUBLIC.CATEGORY(ID) (8)"; SQL statement:
    */
    //em.remove(catFashion); 
  }

  public List<Product> getAll(){
    return productRepo.findAll();
  }
}
