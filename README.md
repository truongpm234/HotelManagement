# Hotel Management Console Application

## 📌 Giới thiệu

Đây là một ứng dụng Java chạy trên console giúp quản lý thông tin khách sạn. Ứng dụng hỗ trợ thêm, cập nhật, xoá, tìm kiếm và lưu trữ thông tin khách sạn vào file. Dữ liệu được lưu trong tệp `Hotel.txt` theo định dạng văn bản.

## ✅ Tính năng chính

- ✅ Thêm khách sạn mới
- ✅ Cập nhật thông tin khách sạn
- ✅ Xoá khách sạn theo ID
- ✅ Tìm kiếm khách sạn theo ID
- ✅ Ghi dữ liệu khách sạn vào file
- ✅ Đọc và tải dữ liệu từ file
- ✅ Kiểm tra sự tồn tại của khách sạn
- ✅ Kiểm tra và xác thực thông tin đầu vào

## 🏗️ Cấu trúc lớp

### `Hotel.java`
- Lưu trữ thông tin chi tiết về một khách sạn:  
  - ID
  - Tên khách sạn
  - Số phòng còn trống
  - Địa chỉ
  - Số điện thoại
  - Xếp hạng (1–6 sao)
- Override `toString()` để xuất định dạng tab dễ ghi file.

### `Function.java`
Chứa các chức năng thao tác chính với danh sách khách sạn:
- `enterHotel(int choice)`: Nhập thông tin khách sạn từ người dùng.
- `addHotel()`: Thêm khách sạn mới và ghi vào file.
- `updateHotel()`: Cập nhật thông tin khách sạn.
- `deleteHotel()`: Xoá khách sạn theo ID.
- `loadAllData()`: Đọc dữ liệu từ file `Hotel.txt`.
- `fileWriterNew(ArrayList<Hotel>)`: Ghi toàn bộ dữ liệu vào file.
- `fileSearch(Object searchWord)`: Tìm kiếm thông tin khách sạn trong file.
- `checkExistHotel()`: Kiểm tra sự tồn tại của khách sạn theo ID.
- `searchHotel()`: Cho phép tìm khách sạn theo ID.
- `continueTask(Scanner)`: Hỏi người dùng có muốn tiếp tục thao tác không.

### `Validator.java` (giả định)
- Kiểm tra ID trùng lặp trong danh sách
- Kiểm tra số điện thoại hợp lệ
- Kiểm tra xếp hạng trong khoảng 1–6
- Kiểm tra xem có trường nào bị bỏ trống hay không

## 🗂️ File dữ liệu

- Dữ liệu được lưu trong file

## ⚙️ Cách chạy chương trình

1. Clone hoặc tải mã nguồn về máy.
2. Đảm bảo cấu trúc thư mục và đường dẫn file hợp lệ (có thể sửa `Hotel.txt` path nếu cần).
3. Chạy `Function.java` từ IDE hoặc command line.
4. Nhập lệnh từ bàn phím theo hướng dẫn của chương trình.

## 💡 Ghi chú

- Chương trình hiện chạy trong console, chưa có giao diện người dùng.
- Mọi dữ liệu sẽ được lưu đè trong file `Hotel.txt` mỗi khi thêm/xoá/sửa.
- Đảm bảo file `Hotel.txt` tồn tại hoặc chương trình có quyền ghi file tại vị trí tương ứng.

## 📁 Thư mục

project-root/
├── src/
│ └── main/
│ └── java/
│ └── data/
│ ├── Hotel.java
│ ├── Function.java
│ ├── Validator.java
│ └── Hotel.txt
├── README.md

## 📞 Liên hệ

Tác giả: **truongpm234**  
Email: [Email](phamminhtruong2032004@gmail.com)  
GitHub: [GitHub](githttps://github.com/truongpm234)

---

