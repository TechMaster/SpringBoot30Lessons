package com.heaven.jpatest.repository;



import com.heaven.jpatest.model.Person;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {

  @Query("SELECT new com.heaven.jpatest.repository.JobCount(p.job, COUNT(*)) " +
  "FROM person AS p GROUP BY p.job ORDER BY 2 DESC")
  List<JobCount> countByJob();

  @Query("SELECT new com.heaven.jpatest.repository.JobCount(p.job, COUNT(*)) " +
  "FROM person AS p GROUP BY p.job ORDER BY 2 DESC")
  List<JobCount> findTopJobs(Pageable pageable);

  @Query("SELECT new com.heaven.jpatest.repository.CityJobCount(p.city, p.job, COUNT(*)) " +
  "FROM person AS p GROUP BY p.city, p.job")
  List<CityJobCount> countJobsInCity();

  @Query("SELECT new com.heaven.jpatest.repository.JobSalary(p.job, AVG(p.salary)) " +
  "FROM person AS p GROUP BY p.job ORDER BY 2 DESC")
  List<JobSalary> jobAverageSalary();

  @Query("SELECT new com.heaven.jpatest.repository.CityAvgSalary(city, AVG(salary)) " +
  "FROM person GROUP BY city ORDER BY 2 DESC")
  List<CityAvgSalary> cityAverageSalary(Pageable pageable);

  @Query("SELECT new com.heaven.jpatest.repository.CityJobCount(city, job, COUNT(job)) " +
  "FROM person GROUP BY city, job HAVING job = ?1 ORDER BY 3 DESC")
  List<CityJobCount> findCitiesHaveMostSpecificJob(String job, Pageable pageable);
}
