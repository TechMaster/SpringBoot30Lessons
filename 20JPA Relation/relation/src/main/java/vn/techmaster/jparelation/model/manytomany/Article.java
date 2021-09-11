package vn.techmaster.jparelation.model.manytomany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "article")
@Table(name = "article")
@Data
@NoArgsConstructor
public class Article {
  @Id @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String title;

  public Article(String title) {
    this.title = title;
  }

  @ManyToMany
  @JoinTable(
      name = "article_tag",
      joinColumns = @JoinColumn(name = "article_id"),
      inverseJoinColumns = @JoinColumn(name = "tag_id")
  )

  @JsonManagedReference
  private List<Tag> tags = new ArrayList<>();
  
  public void addTag(Tag tag) {
      tags.add(tag);
      tag.getArticles().add(this);        
  }

  public void removeTag(Tag tag) {
      tags.remove(tag);
      tag.getArticles().remove(this);
  }
}