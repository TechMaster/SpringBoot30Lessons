package vn.techmaster.bookstore.model;

public class Book {
  public String getTitle() {
    return title;
  }
  public void setTitle(String title) {
    this.title = title;
  }
  public String getAuthor() {
    return author;
  }
  public void setAuthor(String author) {
    this.author = author;
  }
  public Book(String title, String author) {
    this.title = title;
    this.author = author;
  }
  private String title;
  private String author;
}
