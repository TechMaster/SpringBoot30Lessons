# Ôn tập lại những gì đã học 4 buổi trước

## Buổi 1 chúng ta đã học
- Cách tạo một ứng dụng Spring Boot sử dụng [https://start.spring.io/](https://start.spring.io/)
- Ứng dụng Spring Boot Server Side Rendering sử Thymeleaf. File pom.xml sẽ phải có các dependencies như sau:
  ```xml
  <dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-thymeleaf</artifactId>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
	</dependencies>
  ```
- Tạo Controller để hứng request và trả về response. Chú ý annotation `@Controller`
- `@GetMapping("/path")` để hứng đường dẫn của request gửi lên
  ```java
  @GetMapping("/books")
  public String listBooks(Model model) {
    List<Book> books = List.of(
      new Book("Dế Mèn Phiêu Lưu Ký", "Tô Hoài"),
      new Book("Nhật Ký Trong Tù", "Hồ Chí Minh"),
      new Book("Tắt Đèn", "Ngô Tất Tố"),
      new Book("Ma Thổi Đèn", "Phạm Hữu Tín"),
      new Book("Đắc Nhân Tâm", "Dale Carnege")
    );
    model.addAttribute("books", books);
    return "book";
  }
  ```
- `model.addAttribute("key", value);` dùng để truyền dữ liệu kiểu key - value về cho Thymeleaf View Engine
- Thymeleaf View Engine luôn có những thuộc tính `th:` bổ xung vào các thẻ HTML, không gây vỡ cấu trúc HTML
  ```html
  <ul th:each="book : ${books}">
    <li th:text="|&quot;${book.title}&quot; : &quot;${book.author}&quot;|"></li>
  </ul>
  ```

## Buổi 2 học
- Tạo ra REST API trả về JSON
- Sử dụng annotation `@RestController` thay cho `@Controller`
  ```java
  @RestController
  @CrossOrigin
  @RequestMapping("/api")
  public class RESTController {

    @GetMapping("/books")
    public ResponseEntity<List<Book>> listBooks() {
      List<Book> books = List.of(
        new Book("Dế Mèn Phiêu Lưu Ký", "Tô Hoài"),
        new Book("Nhật Ký Trong Tù", "Hồ Chí Minh"),
        new Book("Tắt Đèn", "Ngô Tất Tố")
      );
      return ResponseEntity.ok().body(books);
    }
  }
  ```
- `@CrossOrigin` cho phép JavaScript code ở một host khác, domain khác gọi được
- `ResponseEntity` cho phép lập trình customize response trả về
- Làm quen với Vue.js, lập trình JavaScript.
- Thư viện axios để gọi vào REST API

## Buổi 3 học
- Làm quen với khái niệm Repository, nơi chuyên truy vấn, xử lý dữ liệu
- `@Repository` là annotation để đánh dấu component làm nhiệm vụ truy vấn, xử lý dữ liệu
- Parse file JSON
  ```java
  try {
    File file = ResourceUtils.getFile("classpath:static/personsmall.json");
    ObjectMapper mapper = new ObjectMapper();
    people.addAll(mapper.readValue(file, new TypeReference<List<Person>>(){}));
    people.forEach(System.out::println);
  } catch (IOException e) {
    System.out.println(e.getMessage());
  }
  ```
  `ResourceUtils.getFile` để đọc file trong thư mục resources
- Sử dụng dependency Jackson để deserialize JSON về Java Object
  ```xml
  <dependency>
    <groupId>com.fasterxml.jackson.core</groupId>
    <artifactId>jackson-databind</artifactId>
    <version>2.12.3</version>
  </dependency>
  ```
- Sử dụng Lombok để rút gắn những đoạn code sinh Getter, Setter, constructor
  ```java
  @Data
  public class Person {
    private String name;
    private String email;
    private String job;
    private String gender;
    private String city;
    private Integer salary;
    private String birthdate;
  }
  ```

## Buổi 4

- Ôn tập các cấu trúc dữ liệu phổ biến học từ lớp Java Core
- Interface: `List`, `Map`, `Set`
- Concrete Class: `ArrayList`, `LinkedList`, `Vector`, ...

![](https://www.codejava.net/images/articles/javacore/collections/collections%20framework%20overview.png)

## Buổi 5: chúng ta sẽ làm quen với Stream

