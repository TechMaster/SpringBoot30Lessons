package vn.techmaster.jparelation.repository.manytomany;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.jparelation.model.manytomany.Tag;

public interface TagRepository extends JpaRepository<Tag,Long> {
}
