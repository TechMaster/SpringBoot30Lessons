package vn.techmaster.jparelation.repository.onemany.undirectional;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.jparelation.model.onemany.undirectional.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
