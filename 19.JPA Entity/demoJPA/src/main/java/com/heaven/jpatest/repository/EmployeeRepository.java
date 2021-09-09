package com.heaven.jpatest.repository;

import com.heaven.jpatest.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    Optional<Employee> findByEmail(String email);
    List<Employee> findEmployeesByEmailEndsWith(String suffix);

}
