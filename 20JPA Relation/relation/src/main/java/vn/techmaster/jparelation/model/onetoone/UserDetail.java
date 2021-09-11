package vn.techmaster.jparelation.model.onetoone;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table
@Entity
@Data
@NoArgsConstructor
public class UserDetail {
  @Id
  private Long id;

  @OneToOne(fetch = FetchType.LAZY)
  @MapsId
  @JsonIgnore
  private User user;

  private String job;
  private String address;
  
  public UserDetail(String job, String address) {
    this.job = job;
    this.address = address;
  }
}
