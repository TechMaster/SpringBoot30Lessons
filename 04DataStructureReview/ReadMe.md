# Java Collections

Trong buổi hôm nay chúng ta ôn lại Java Data Structure List, Set, Map. Hãy xem thư mục [Basic](Basic). Đây là một ứng dụng Java Console gồm nhiều ví dụ nhỏ.

Sau đó chúng ta sang đến ứng dụng [datanalysis](dataanalysis) viết trên SpringBoot, chúng ta sẽ thử lập trình xử lý dữ liệu bằng 2 cách:

1. Cách cổ điển dùng vòng lặp for loop
2. Cách sử dụng Java Collection Stream API

## 1. Basic
Hãy vào file [App.java](Basic/App.java) uncomment từng dòng để chạy thử.

Chúng ta có cấu trúc thư mục code như sau:
```
├── App.java  <-- ứng dụng chính
├── DemoList.java <-- demo code của List interface, ArrayList
├── DemoMap.java <-- demo Map, HashMap
├── DemoSet.java <-- demo Set
├── DemoVector.java <-- demo Vector
├── Person.java <-- định nghĩa một class Person
└── ReadMe.md
```

Trong mỗi file class có rất nhiều phương thức, các bạn hãy vào xem từng phương thức để hình dung ra cách chạy.

## 2. DataAnalysis
Đây là ứng dụng Spring Boot lắng nghe ở cổng 8080:
- http://localhost:8080/api/people lấy về tất cả danh sách people
- http://localhost:8080/api/countnationality đếm số người trong nhóm cùng quốc tịch
- http://localhost:8080/api/countnationality2 , 3, 4, 5 các cách khác để đếm số người trong nhóm cùng quốc tịch


## Tham khảo
- [The Java 8 Stream API Tutorial](https://www.baeldung.com/java-8-streams)
- [Java Collections and Streams](http://tutorials.jenkov.com/java-collections/streams.html#reduce)