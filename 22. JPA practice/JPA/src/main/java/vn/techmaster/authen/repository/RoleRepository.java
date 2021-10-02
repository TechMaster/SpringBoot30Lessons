package vn.techmaster.authen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.authen.model.Role;

public interface RoleRepository extends JpaRepository<Role,Integer> {
}
