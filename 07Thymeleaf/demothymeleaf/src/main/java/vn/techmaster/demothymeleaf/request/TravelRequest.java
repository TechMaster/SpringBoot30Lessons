package vn.techmaster.demothymeleaf.request;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import vn.techmaster.demothymeleaf.model.TravelType;

@Data
@AllArgsConstructor
public class TravelRequest {
  private String nationality;
  private List<String> visitedCountries;
  private TravelType travelType;
  public TravelRequest() {
    visitedCountries = new ArrayList<>();
    travelType = TravelType.BASIC;
  }
}
