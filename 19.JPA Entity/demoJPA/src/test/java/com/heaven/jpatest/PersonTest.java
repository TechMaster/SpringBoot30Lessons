package com.heaven.jpatest;

import com.heaven.jpatest.repository.JobCount;
import com.heaven.jpatest.repository.PersonRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
@Sql({"/person.sql"})
@Slf4j
public class PersonTest {
    @Autowired
    private PersonRepository personRepo;

    @Test
    public void countingByJob(){
        List<JobCount> jobCounts = personRepo.countByJob();
        jobCounts.forEach(System.out::println);
        assertThat(jobCounts.size()).isGreaterThan(5);
    }
}
