package vn.techmaster.jparelation.model.manytomany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "tag")
@Table(name = "tag")
@Data
@NoArgsConstructor
public class Tag {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String name;

  public Tag(String name) {
    this.name = name;
  }
  @JsonBackReference
  @ManyToMany(mappedBy = "tags", fetch = FetchType.LAZY)
  List<Article> articles = new ArrayList<>();
}
