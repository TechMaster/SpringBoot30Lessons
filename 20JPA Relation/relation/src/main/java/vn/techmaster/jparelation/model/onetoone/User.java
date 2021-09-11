package vn.techmaster.jparelation.model.onetoone;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Table(name="user")
@Entity(name="user")
@Data
@NoArgsConstructor
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false, length = 200)
  private String fullname;

  @NaturalId
  private String email;

  public User(String fullname, String email) {
    this.fullname = fullname;
    this.email = email;
  }

  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  @PrimaryKeyJoinColumn
  private UserDetail userDetail;

  public void setUserDetail(UserDetail userDetail) {
    userDetail.setUser(this);
    this.userDetail = userDetail;
  }

  
}