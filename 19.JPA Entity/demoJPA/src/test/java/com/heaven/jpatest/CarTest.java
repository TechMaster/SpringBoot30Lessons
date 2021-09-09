package com.heaven.jpatest;

import com.heaven.jpatest.model.Car;
import com.heaven.jpatest.repository.CarRepository;
import com.heaven.jpatest.repository.MakerCount;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.jdbc.Sql;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@DataJpaTest
@Sql({"/car.sql"})
@Slf4j
public class CarTest {
    @Autowired
    private CarRepository carRepository;

    @Test
    public void testCarName(){
        List<Car> carList = carRepository.findCarsByName("Ranger");
        log.info("List of car by name");
        carList.forEach(System.out::println);
        assertThat(carList.size()).isGreaterThan(2);
    }

    @Test
    public void testCarYearGreater(){
        List<Car> carList = carRepository.findCarsByYearGreaterThan(2000);
        carList.forEach(System.out::println);
        assertThat(carList.size()).isGreaterThan(2);
    }

    @Test
    public void testCarByMakerSortingByYear(){
        List<Car> carList = carRepository.findCarsByMakerOrderByYear("Ford");
        carList.forEach(System.out::println);
        assertThat(carList.size()).isGreaterThan(2);
    }

    @Test
    public void countByMakerTest() {
        List<MakerCount> makerCounts= carRepository.getListOfCarMaker();
        makerCounts.forEach(System.out::println);
        assertThat(makerCounts.size()).isGreaterThan(5);
    }
}
