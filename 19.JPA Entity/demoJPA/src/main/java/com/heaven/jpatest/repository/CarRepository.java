package com.heaven.jpatest.repository;

import com.heaven.jpatest.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CarRepository extends JpaRepository<Car,Long> {
    //Native query

    List<Car> findCarsByName(String name);
    List<Car> findCarsByYearGreaterThan(int year);
    List<Car> findCarsByMakerOrderByYear(String maker);


    //Custom query
    @Query("SELECT new com.heaven.jpatest.repository.MakerCount(c.maker,COUNT(*))" +
    "FROM Car as c GROUP BY c.maker order by COUNT(*) DESC ")
    List<MakerCount> getListOfCarMaker();
}
