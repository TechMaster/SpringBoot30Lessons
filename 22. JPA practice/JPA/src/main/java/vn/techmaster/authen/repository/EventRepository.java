package vn.techmaster.authen.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.techmaster.authen.model.Event;

public interface EventRepository extends JpaRepository<Event,Long> {
}
