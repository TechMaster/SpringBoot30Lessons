# Minh hoạ cho Dependency Injection

Tôi tạo ra một [DBMessageSource.java](src/main/java/vn/techmaster/demoupload/localization/DBMessageSource.java) thay thế cho class mặc định có sẵn, tuân thủ interface MessageSource. Đây chính là cơ chế Dependency Injection cho phép thay thế các class miễn là chúng tuân thủ một interface.

Hãy quan sát file [LanguageConfig.java](src/main/java/vn/techmaster/demoupload/config/LanguageConfig.java)

```java
@Configuration
public class LanguageConfig implements WebMvcConfigurer {
  // Dùng component mặc định
  // @Autowired private MessageSource messageSource;

  //Tạo custom component DBMessageSource
  @Bean public MessageSource messageSource() {
    return new DBMessageSource();
  }
}
```
Cách cũ sử dụng class mặc định tuân thủ `MessageSource`
```java
@Autowired private MessageSource messageSource;
```

Cách mới tạo DBMessageSource rồi trả về
```java
@Bean public MessageSource messageSource() {
  return new DBMessageSource();
}
```

Việc sử dụng một Bean component qua kiểu interface giúp ứng dụng không bị ràng buộc cố định vào một class cụ thể. Chúng ta có thể tạo ra một class tuân thủ interface MessageSource, lấy thông tin chuỗi của từng ngôn ngữ trong CSDL quan hệ thay vì lưu ở file [res.properties](src/main/resources/lang/res.properties) và [res_vn.properties](src/main/resources/lang/res_vn.properties)

Đây là nguyên lý **"Program to an interface not an implementation"**