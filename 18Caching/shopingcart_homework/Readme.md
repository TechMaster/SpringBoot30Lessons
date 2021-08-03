# Caching


## Hướng dẫn chạy thử ứng dụng

- Khởi động server Redis theo cách bạn thấy thuận tiện:
  - Cài Redis Server trên máy
  - Hoặc khởi động Docker container
  ```
  docker run --name redis -p 6379:6379 -d redis:alpine
  ```

## Kết quả load test dùng Rakyll/Hey

### 1. Trường hợp không có trễ
Requests/sec:	668.8614

Thêm trễ 200 milliseconds
Requests/sec:	220.9488

Thêm trễ 400 milliseconds
157.5359

## Chú ý về caching:

1. Cần đo đạc đúng thì mới thực hiện tối ưu
2. Tối ưu theo trọng số hay tối ưu theo thời gian ngắn,chi phí thấp
3. Người ta thường dùng Key-Value In Memory để làm nơi lưu cache
4. Ngoài ra có thể dụng Cluster Redis server để làm cache
5. Lưu thông tin vào cache, lấy thông tin từ cache rất dễ nhưng invalidate cache thì rất khó.
6. Web site bán hàng hiện nay response > 0.2 giây, khách hàng đã muốn bỏ shop !
7. Google ưu tiên indexing web site có tốc độ phản hồi tốt
8. Vừa lập trình vừa phải chú ý tối ưu tốc độ, chứ không tối ưu tốc độ sau khi ứng dụng triển khai, chi phí đội lên rất cao thậm chí đập đi xây lại từ đầu.

## Các keyword cần nhớ
```java
@EnableCaching
@Cacheable
@PutCache
@EvictCache
```


## Bài viết tham khảo
https://dzone.com/articles/spring-cache-annotation-tips-and-tricks

[@CachePut](https://www.concretepage.com/spring/spring-cacheput-annotation-example-using-javaconfig)