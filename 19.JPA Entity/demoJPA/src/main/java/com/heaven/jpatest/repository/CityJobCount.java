package com.heaven.jpatest.repository;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CityJobCount {
  private String city;
  private String job;
  private long count;
}
