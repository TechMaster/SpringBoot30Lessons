package vn.techmaster.parsejson.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {
  private String name;
  private String email;
  private String job;
  private String gender;
  private String city;
  private Integer salary;
  private String birthdate;
}
