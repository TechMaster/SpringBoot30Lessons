# Data Structure


Hỏi: Array khác gì với ArrayList trong Java?

Đáp: ArrayList khai báo động.
ArrayList implements interface List, AbstractList
Array là mảng có kích thước xác định ngay từ đầu, không thể thêm xoá phần tử.

`List.of` trả immutable collection không thể thay đổi phần tử. Nếu cố tình thêm, xoá phần tử Exception sẽ quăng ra
```
Exception in thread "main" java.lang.UnsupportedOperationException
```
Arrays.asList trả về ArrayList

Để thêm, xoá phần tử thì bắt buộc phải dùng ArrayList<T> chứ không dùng List<T>

Đặc điểm của TreeSet là cứ thêm 1 hoặc nhiều phần tử vào thì sẽ sắp xếp theo thứ tự A-Z.

Muốn sắp xếp ngược lại thì
```java
NavigableSet<String> manZANames = manNames.descendingSet();
```

