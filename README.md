# Báo cáo kiểm tra Docker (45 phút)

- **Họ tên:** Vũ Việt Tiến
- **Lớp:** K24CNTT4
- **Mã sinh viên:** B24DTCN276
- **Repository:** https://github.com/tienvuiet/devops-fundamentals_test-deploy2

## Nội dung thực hiện

Project hiện tại là API quản lý sản phẩm (`product_ss5`), sử dụng Java 21, Spring Boot, Gradle và MySQL; khác với Campus Hub Base được nêu trong đề.

Dockerfile gồm hai stage: build JAR bằng JDK 21 và chạy bằng JRE 21 với user riêng. Docker Compose cấu hình backend và MySQL 8.4, công khai cổng backend 8080 và lưu dữ liệu MySQL bằng volume. Backend nhận cấu hình database qua biến môi trường, kết nối bằng tên service `department-employee-db`.

## Lệnh chạy và kiểm tra

Chạy tại thư mục gốc project, cần Docker đang hoạt động; lệnh Gradle trên Windows cần JDK 21:

```powershell
.\gradlew.bat test
docker build -t tienvuviet/devops-fundamentals_test-deploy2:latest .
docker images
docker compose config
docker compose up -d
docker compose ps
curl.exe http://localhost:8080/api/v1/products
curl.exe http://localhost:8080/actuator/health
```

Build với đúng tag trên để Compose sử dụng image vừa tạo. API sản phẩm: http://localhost:8080/api/v1/products. URL kiểm tra theo đề: http://localhost:8080/actuator/health.

## Đối chiếu yêu cầu

Đã có cấu hình Dockerfile, hai service Compose, biến môi trường database, tên service MySQL trong JDBC URL và volume lưu dữ liệu. Chưa xác minh thực tế kết quả test, build image, khởi động service hoặc kết nối database trong lần rà soát này.

Cần bổ sung trước khi nộp:

- `.dockerignore` để loại bỏ `.git`, `.gradle`, `.idea`, `bin`, `build` và các tệp không cần thiết khỏi build context.
- Dependency `spring-boot-starter-actuator`, sau đó kiểm tra `/actuator/health` trả HTTP 200 và trạng thái `UP`.
- Kiểm thử thực sự: file test hiện đang bị comment toàn bộ; chạy Gradle thành công chưa chứng minh có test được thực thi.
- Bổ sung 2–3 ảnh minh chứng bên dưới; xác nhận source đúng Campus Hub Base theo đề.

## Minh chứng

[Chèn 2–3 ảnh thực tế: build thành công và danh sách image; trạng thái hai service từ `docker compose ps`; kết quả `/actuator/health` trả HTTP 200 và `UP`.]

