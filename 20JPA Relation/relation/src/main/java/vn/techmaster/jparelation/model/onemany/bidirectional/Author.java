package vn.techmaster.jparelation.model.onemany.bidirectional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity(name = "author")
@Table(name="author")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String genre;
    private int age;

    public Author(String name, String genre, int age) {
        this.name = name;
        this.genre = genre;
        this.age = age;
    }

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "author",orphanRemoval = true)
    private List<Book> books = new ArrayList<>();
    public void addBook(Book book){
        this.books.add(book);
        book.setAuthor(this);
    }
    public void removeBook(Book book){
        book.setAuthor(null);
        this.books.remove(book);
    }
    public void removeBooks(){
        Iterator<Book> iterator = this.books.iterator();
        while(iterator.hasNext()){
            Book book = iterator.next();
            book.setAuthor(null);
            iterator.remove();
        }
    }
}
