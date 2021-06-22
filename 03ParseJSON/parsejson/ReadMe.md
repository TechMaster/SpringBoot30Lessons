# 1. Tạo dữ liệu bằng cách vào Mockaroo

https://www.mockaroo.com/

# 2. Sử dụng thư viện Jackson để đọc JSON

Serialize : Java Object --> JSON

Deserialize: JSON --> Java Object

Sử dụng thư viện Jackson. Nhớ là Google keyword `Java parse JSON` thì tìm ra bài viết này. Các bạn nghĩ tôi là thầy giáo siêu sao không bao giờ Google à?

Sai bét. Tốc độ Google của tôi nhanh như điện giật. Hầu như tôi chả bao giờ nhớ cú pháp Java. Bởi một ngày tôi chuyển qua lại vài ngôn ngữ lập trình. Thế nên nếu nhớ hết chắc tôi quá tải.

[Bài này rất hay, có cả ví dụ đọc JSON](https://mkyong.com/java/jackson-how-to-parse-json/)


Bổ xung jackson-databind vào [pom.xml](pom.xml)
```xml
<dependency>
  <groupId>com.fasterxml.jackson.core</groupId>
  <artifactId>jackson-databind</artifactId>
  <version>2.12.3</version>
</dependency>
```

```
.
├── model
│   └── Person.java
├── repository
│   └── PersonRepository.java
└── ParsejsonApplication.java
```

Gõ lệnh `spring boot read file from resources` để tìm cách đọc file từ resources