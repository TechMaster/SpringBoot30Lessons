package vn.techmaster.jparelation.service.onemany.bidirectional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.techmaster.jparelation.model.onemany.bidirectional.Author;
import vn.techmaster.jparelation.model.onemany.bidirectional.Book;
import vn.techmaster.jparelation.repository.onemany.bidirectional.BookRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Service
public class AuthorBookService {
    @Autowired private BookRepository bookRepository;
    @PersistenceContext
    private EntityManager em;
    @Transactional
    public void generateAuthorBook(){
        Author joan = new Author("Joana","Thriller",45);
        Author jim = new Author("Jim","Commedy",50);
        Book book1 = new Book("Adventure",UUID.randomUUID().toString());

        Book book2 = new Book("Discovery",UUID.randomUUID().toString());

        Book book3 = new Book("Smile at once",UUID.randomUUID().toString());

        Book book4 = new Book("Dancing",UUID.randomUUID().toString());
        joan.addBook(book1);joan.addBook(book2);
        jim.addBook(book3);jim.addBook(book4);
        em.persist(joan);
        em.persist(jim);

    }
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }
}
