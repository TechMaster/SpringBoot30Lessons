package vn.techmaster.demothymeleaf.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
  private String name;
  private String role;
}
