package vn.techmaster.demothymeleaf.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Person {
  private String name;
  private String nationality;
  private String birthDate;
}
