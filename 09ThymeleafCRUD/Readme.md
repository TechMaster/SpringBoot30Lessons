## 1. Cấu trúc chương trình
> Cường: hãy giải thích ý nghĩa từng file
```
.
├── main
│   ├── java
│   │   └── vn
│   │       └── techmaster
│   │           └── personmanagement
│   │               ├── controller
│   │               │   └── PersonalController.java
│   │               ├── model
│   │               │   └── Person.java
│   │               ├── repository
│   │               │   └── PersonRepository.java
│   │               └── PersonmanagementApplication.java
│   └── resources
│       ├── templates
│       │   ├── home.html
│       │   ├── listAll.html
│       │   └── personForm.html
│       └── application.properties
``` 
   
## 2. Chạy chương trình:
     Hompage:
    
        https://user-images.githubusercontent.com/70272965/126032773-e9ee8052-7cbb-45a6-abb5-f042bc078b76.png

   
   People List:
   
        https://user-images.githubusercontent.com/70272965/126032782-8b1b5efb-b277-4517-8915-a433807248fd.png


   Create From:
   
        https://user-images.githubusercontent.com/70272965/126032786-f531f146-897a-478e-b839-ec35f3b92d25.png

Lưu ý: Ở đây mình tạo sẵn PersonRepository lưu trữ một số giá trị ban đầu, mỗi đối tượng trong class Person đều có id duy nhất để có thể thực hiện CRUD.
Dữ liệu các bạn có thể lấy thông qua file CSV, JSON, Excel hoặc qua database: Postgre, MySQL, Oracle...

## 3. Trả lời câu hỏi

### 3.1 Tại sao lại tạo Interface hoặc Abstract class cho Repository?

Trong bài này anh Quang tạo trực tiếp `class PersonRepository` không kế thừa abstract class hay tuân thủ interface
```java
public class PersonRepository {
    private List<Person> people = new ArrayList<>();

    public PersonRepository(){
        List<Person> list = List.of(
                new Person(1,"Trinh Minh Cuong","Developer",true,"1975-11-27"),
                new Person(2,"Mary Jane","Banker",false,"1980-05-24"),
                new Person(3,"Tom Sawyer","Taxi Driver",true,"1990-08-09")
        );
        for(Person person:list){
            people.add(person);
        }

    }

    public List<Person> getAll(){
        return this.people;
    }
```

Tuy nhiên bài trước thầy Cường hướng dẫn như sau:

Tạo một `abstract class Dao<T>`
```java
public abstract class Dao<T> {
  protected  List<T> collections = new ArrayList<>();

  public abstract void readCSV(String csvFile);

  public abstract List<T> getAll();
}
```

rồi tạo `class BookDao extends Dao<Book>`
```java
public class BookDao extends Dao<Book> {

  public BookDao(String csvFile) {
    this.readCSV(csvFile);
  }
}
```

Hỏi: Khác biệt ở đây là gì?

Trả lời: Anh Quang tạo concrete class PersonRepository.java cho đơn giản, không phải mất công định nghĩa interface hay abstract class. Cách này nhanh, đạt ngay mục tiêu.

Còn thầy Cường muốn xây dựng một khuôn mẫu DAO (Data Access Object) để áp dụng cho nhiều kiểu Model khác nhau. Code sẽ dài hơn. Tuy nhiên chuẩn hoá được các phương thức thao tác dữ liệu.

## 3.2 Bản chất HTTP request response là stateless.

Trong kiến trúc Server side rendering, server căn bản là không lưu trạng thái của client. Người ta gọi là stateless.

Trình duyệt gửi yêu cầu lên, server trả về kết quả.

Giả sử bạn gõ một keyword (từ tìm kiếm) vào ô text, ấn nút submit gửi lên server tìm kiếm. Server tìm được kết quả sẽ tạo ra một trang HTML mới, nhồi kết quả tìm kiếm vào.

Bạn muốn bên cạnh kết quả tìm kiếm cần hiển thị cả keyword vừa gửi lên thì server cũng phải trả về keyword này
```java
@PostMapping("/search")
public String searchByKeyword(@ModelAttribute SearchRequest request, BindingResult bindingResult, Model model) {
if (!bindingResult.hasFieldErrors()) {
     model.addAttribute("books", bookDao.searchByKeyword(request.getKeyword()));
     model.addAttribute("query", request.getKeyword()); //trả lại cả từ tìm kiếm về client
}    
return "allbooks";
}
```

Để server có thể nhớ được trình duyệt, người ta nghĩ ra Cookie. Server sẽ đánh dấu trình duyệt bằng cách yêu cầu trình duyệt gán một mẩu dữ liệu (set cookie) ở trình duyệt với tên miền của server.

Từ đó về sau, trong bất kỳ request nào gửi lên server, trình duyệt cũng gửi kèm cookie mà server gán cho mình. Nhớ cookie, mà server nhận ra trình duyệt.

Dung lượng của cookie rất hạn chế. Do đó người ta lại nghĩ ra cách, gán một unique key vào cookie. Phía server có vùng nhớ session, ứng với mỗi unique key có thể gán một đối tượng, vùng nhớ lớn hơn.

Session có thể ở dạng in memory, hoặc lưu trong Redis server hoặc lưu trong CSDL quan hệ.

Nhờ Cookie, Session, mà server nhớ được trình duyệt. Biến quan hệ tương tương trình duyệt với server đang từ stateless trở thành stateful. Một ông chủ quán, nhớ mặt, gọi tên được 1000 khách hàng. Quá quý !


Thế rồi, người ta lại phát minh ra Client Side Rendering. Lúc này mọi trạng thái của ứng dụng web có thể lưu luôn ở trình duyệt. Việc này không ép buộc server không được lưu thông tin về trinh duyệt nữa. Bạn có thể sử dụng cả 2 cách. Nhưng quản lý state ở Client Side sẽ đỡ tốn nhưng lệnh request - response gửi qua lại giữa trình duyệt và server (reduce round trip between client and server).

Server không phải tốn vùng nhớ để lưu thông tin về client. Nó cũng sẽ scale out (mở rộng ra nhiều server giống nhau) tốt hơn, đáp ứng được nhiều request hơn, chạy ổn định hơn.

Đó chính là nguyên nhân tại sao mà bây giờ người ta cứ hay chuộng React.js và Vue.js... Mặc dù code cũng khá mất thời gian.

Còn câu hỏi gì nữa gửi vào Zalo. Tôi giải thích nốt
