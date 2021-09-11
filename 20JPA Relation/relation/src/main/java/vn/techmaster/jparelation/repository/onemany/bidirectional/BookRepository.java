package vn.techmaster.jparelation.repository.onemany.bidirectional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import vn.techmaster.jparelation.model.onemany.bidirectional.Book;
@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
