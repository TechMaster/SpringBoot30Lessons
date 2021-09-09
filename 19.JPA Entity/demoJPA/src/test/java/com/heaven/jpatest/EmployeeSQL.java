package com.heaven.jpatest;

import com.heaven.jpatest.model.Employee;
import com.heaven.jpatest.repository.EmployeeRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Sql({"/employees.sql"})
@Slf4j
public class EmployeeSQL {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    @DisplayName("Testing employees number")
    public void employeeNumber(){
        assertThat(employeeRepository.count()).isEqualTo(100);
    }

    @Test
    @DisplayName("Testing employees email")
    public void employeeEmail(){
        List<Employee> employees = employeeRepository.findEmployeesByEmailEndsWith(".com");
        log.info("There are " + employees.size() + " employees have email .com");
//        System.out.println("There are " + employees.size() + " employees have email .com");
        assertThat(employeeRepository.findEmployeesByEmailEndsWith(".com").size()).isEqualTo(55);
    }
}
