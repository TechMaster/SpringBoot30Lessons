package vn.techmaster.jparelation.model.onemany.undirectional;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "category")
@Table(name = "category")
@Data
@NoArgsConstructor
public class Category {
  @Id @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  private String name;

  public Category(String name) {
    this.name = name;
  }
}
