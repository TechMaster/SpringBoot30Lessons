# Server Side Rendering

Server side rendering web application là ứng dụng web ở đó web application sẽ sinh mã HTML ngay tại server và trả về cho trình duyệt.

Ưu điểm của Server side rendering là:

1. Tối ưu về SEO (Search Engine Optimization)
2. Có thể sử dụng caching phía server
3. Lập trình kiểu truyền thống, dễ dàng debug gỡ rối

Sau đây là các bước thực hành
## 1. Tạo project sử dụng maven làm thư viện quản lý dependencies

Dependency có nghĩa là thư viện mà ứng dụng Spring Boot sẽ phải phụ thuộc. Maven là công cụ quản lý phiên bản thư viện, các plugin
phục vụ quá trình biên dịch. Maven sử dụng file cấu hình XML pom.xml. Song song với Maven có Gradle có chức năng tương tự. 
Gradel hiện đại hơn, biên dịch nhanh hơn, nhưng lại ít phổ biến hơn. Trong lớp học này 80% ví dụ sẽ dùng Maven, còn lại chuyển qua dùng Gradle.

File [pom.xml](pom.xml) cần chứa 3 dependencies : ```spring-boot-starter-thymeleaf, spring-boot-starter-web, spring-boot-devtools```
```xml
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-web</artifactId>
</dependency>
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-devtools</artifactId>
  <scope>runtime</scope>
  <optional>true</optional>
</dependency>
<dependency>
  <groupId>org.springframework.boot</groupId>
  <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>
```

Ý nghĩa và tác dụng của từng dependency như sau:
1. ```spring-boot-starter-web```: thư viện web căn bản quan trọng trong Spring Boot
2. ```spring-boot-devtools```: nice to have (nên có) để tự động biên dịch, khởi động lại Spring Boot khi lập trình viên thay đổi mã
3. ```spring-boot-starter-thymeleaf```: view template engine để kết hợp với dữ liệu sinh ra mã HTML tại server

