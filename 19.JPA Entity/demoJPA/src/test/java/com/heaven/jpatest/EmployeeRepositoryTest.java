package com.heaven.jpatest;

import com.heaven.jpatest.model.Employee;
import com.heaven.jpatest.repository.EmployeeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeRepositoryTest {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private DataSource dataSource;
    //Junit test for saveEmployee
    @Test
    @Order(1)
    @Rollback(value = false)
    @DisplayName("Testing save entity")
    public void saveEmployee(){
        Employee employee = Employee.builder()
                .firstName("Quang").lastName("Minh").email("quang@yahoo.com")
                .build();
        employeeRepository.save(employee);
        Employee saveEmployee = employeeRepository.findById(1L).get();
        System.out.println(employeeRepository.findById(1L).get());
        Assertions.assertThat(saveEmployee.getFirstName()).isEqualTo("Quang");
    }
    @Test
    @Order(2)
    @DisplayName("Testing get by Id")
    public void getEmployeeTest(){
        Employee employee = employeeRepository.findById(1L).get();
        Assertions.assertThat(employee.getId()).isEqualTo(1L);
    }

    @Test
    @Order(3)
    @DisplayName("Testing employee list")
    public void showListOfEmployees(){
        List<Employee> employees = employeeRepository.findAll();
        Assertions.assertThat(employees.size()).isEqualTo(1);
    }

    @Test
    @Order(4)
    @Rollback(value = false)
    @DisplayName("update employee")
    public void updateEmployee(){
        Employee employee = employeeRepository.findById(1L).get();
        employee.setEmail("rambo@gmail.com");
        employeeRepository.save(employee);
        Assertions.assertThat(employee.getEmail()).isNotEqualTo("quang@yahoo.com");

    }

    @Test
    @Order(5)
    @Rollback(value = false)
    @DisplayName("testing delete")
    public void deleteEmployee(){
        Employee employee = employeeRepository.findById(1L).get();
        employeeRepository.delete(employee);
        Employee employee1 = null;
        Optional<Employee> noEmp = employeeRepository.findByEmail("rambo@gmail.com");
        if(noEmp.isPresent()){
            employee1 = noEmp.get();
        }
        Assertions.assertThat(employee1).isNull();
    }
}
