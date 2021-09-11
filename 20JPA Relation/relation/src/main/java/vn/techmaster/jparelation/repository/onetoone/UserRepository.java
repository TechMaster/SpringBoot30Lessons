package vn.techmaster.jparelation.repository.onetoone;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.jparelation.model.onetoone.User;

public interface UserRepository extends JpaRepository<User, Long>{
  
}
