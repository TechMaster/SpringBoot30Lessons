1. Cấu trúc chương trình
 ![img.png](img.png)
   
![img_4.png](img_4.png)
2. Chạy chương trình:
    Hompage:
        ![img_1.png](img_1.png)
    People List:
        ![img_2.png](img_2.png)
    People detail:
        ![img_3.png](img_3.png)
    Create Job:
        ![img_5.png](img_5.png)
        
   
Lưu ý: Khi upload ảnh lên server ta upload vào thư mục photos trong Project sau đó ghép nối thư mục static/photos vào thư mục photos
1. Có lưu được file Binary vào CSDL: Có thể lưu nhưng không nên
2. Khi xóa một Person record: xóa theo id, đồng thời xóa ảnh tương ứng lưu trong thư mục
3. Khi lưu file nên đổi tên file theo id của mỗi Person record để có thể quản lý việc trùng file, dễ thao tác edit, delete và lưu trữ trong CSDL
4. Lúc upload file vào thư mục trong project nên lưu ra thư mục ngoài resource  sau đó cấu hình để nối các file trong thư mục này với thư mục resource/static