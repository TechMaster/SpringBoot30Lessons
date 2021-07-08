package vn.techmaster.demothymeleaf.request;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BMIRequest {
  private String name;
  private String email;
  private float height;
  private float weight;
  
}