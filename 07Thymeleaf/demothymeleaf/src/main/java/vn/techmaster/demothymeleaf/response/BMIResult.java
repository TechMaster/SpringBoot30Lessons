package vn.techmaster.demothymeleaf.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BMIResult {
  private float bmiIndex;
  private String category;
  private String recommentation;
}
