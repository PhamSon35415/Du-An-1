﻿CREATE DATABASE DA1_NUOCHOA;
GO

USE DA1_NUOCHOA;
GO
drop DATABASE DA1_NUOCHOA;
go
CREATE TABLE THUONGHIEU
(
    IDTHUONGHIEU INT identity(1,1),
    TEN NVARCHAR(250),
	NGAYTAO DATETIME,
    NGAYSUA DATETIME,
    CONSTRAINT PK_THUONGHIEU PRIMARY KEY (IDTHUONGHIEU)
);
GO

CREATE TABLE XUATXU
(
    IDXUATXU INT identity(1,1),
    TENXUATXU NVARCHAR(250),
    NGAYTAO DATETIME,
    NGAYSUA DATETIME,
    TRANGTHAI BIT,
    CONSTRAINT PK_XUATXU PRIMARY KEY (IDXUATXU)
);
GO

CREATE TABLE NONGDO
(
    IDNONGDO INT identity(1,1),
    TENNONGDO NVARCHAR(250),
    NGAYTAO DATETIME,
    NGAYSUA DATETIME,
    TRANGTHAI BIT,
    CONSTRAINT PK_NONGDO PRIMARY KEY (IDNONGDO)
);
GO

CREATE TABLE NHOMHUONG
(
    IDNHOMHUONG INT identity(1,1),
    TENNHOMHUONG NVARCHAR(250),
    NGAYTAO DATETIME,
    NGAYSUA DATETIME,
    TRANGTHAI BIT,
    CONSTRAINT PK_NHOMHUONG PRIMARY KEY (IDNHOMHUONG)
);
GO

CREATE TABLE KHACHHANG
(
    IDKHACHHANG INT identity(1,1),
    TENKHACHHANG NVARCHAR(250),
    SODIENTHOAI VARCHAR(10),
    DIACHI NVARCHAR(250),
    EMAIL VARCHAR(250),
    NGAYSINH DATE,
    GIOITINH int check (GIOITINH=1 or GIOITINH=0 or GIOITINH=2),
    NGAYTAO DATETIME,
    NGAYSUA DATETIME,
    TRANGTHAI BIT,
    CONSTRAINT PK_KHACHHANG PRIMARY KEY (IDKHACHHANG)
);
GO

CREATE TABLE NHANVIEN
(
    IDNHANVIEN INT identity(1,1),
    TENNHANVIEN NVARCHAR(250),
    GIOITINH int check (GIOITINH=1 or GIOITINH=0 or GIOITINH=2),
    EMAIL VARCHAR(250),
    NGAYSINH DATE,
    DIACHI NVARCHAR(250),
    SODIENTHOAIN VARCHAR(10),
    TAIKHOAN VARCHAR(250),
    MATKHAU VARCHAR(250),
    CHUCVU BIT,
    NGAYTAO DATETIME,
    NGAYSUA DATETIME,
    TRANGTHAI BIT,
    CONSTRAINT PK_NHANVIEN PRIMARY KEY (IDNHANVIEN)
);
GO

CREATE TABLE SANPHAM
(
    IDSANPHAM INT identity(1,1),
    ID_THUONGHIEU INT,
    TENSANPHAM NVARCHAR(250),
    NGAYTAO DATETIME,
    NGAYSUA DATETIME,
	SOLUONG int,
    TRANGTHAI int,
    CONSTRAINT PK_SANPHAM PRIMARY KEY (IDSANPHAM),
    CONSTRAINT FK_SANPHAM_THUONGHIEU FOREIGN KEY (ID_THUONGHIEU) REFERENCES THUONGHIEU (IDTHUONGHIEU)
);
GO

CREATE TABLE SANPHAMCHITIET
(
    IDSANPHAMCHITIET INT identity(1,1),
    DOTOHUONG NVARCHAR(250),
    THOIGIANNENDUNG NVARCHAR(250),
    NAMPHATHANH DATE,
    DUNGTICH INT,
    GIOITINH BIT,
    LUUHUONG INT,
    ID_SP INT,
    ID_XUATXU INT,
    ID_NONGDO INT,
    ID_NHOMHUONG INT,
	NGAYTAO DATETIME,
    NGAYSUA DATETIME,
	TRANGTHAI INT,
    CONSTRAINT FK_SPCT_SANPHAMCHITIET_SANPHAM FOREIGN KEY (ID_SP) REFERENCES SANPHAM (IDSANPHAM),
    CONSTRAINT FK_SPCT_SANPHAMCHITIET_XUATXU FOREIGN KEY (ID_XUATXU) REFERENCES XUATXU (IDXUATXU),
    CONSTRAINT FK_SPCT_SANPHAMCHITIET_NONGDO FOREIGN KEY (ID_NONGDO) REFERENCES NONGDO (IDNONGDO),
    CONSTRAINT FK_SPCT_SANPHAMCHITIET_NHOMHUONG FOREIGN KEY (ID_NHOMHUONG) REFERENCES NHOMHUONG (IDNHOMHUONG),
    CONSTRAINT PK_SPCT_SANPHAMCHITIET PRIMARY KEY (IDSANPHAMCHITIET)
);
GO

CREATE TABLE VOUCHER
(
    IDVOUCHER INT identity(1,1),
    MAVOUCHER VARCHAR(100),
    PHANCHAMGIAMGIA FLOAT,
    NGAYBATDAU DATE,
    NGAYKETTHUC DATE,
    NGAYTAO DATETIME ,
    NGAYSUA DATETIME,
    TRANGTHAI INT,
    CONSTRAINT PK_VC_VOUCHER PRIMARY KEY (IDVOUCHER)
);
GO

CREATE TABLE PHUONGTHUCTHANHTOAN
(
    IDPHUONGTHUCTHANHTOAN INT identity(1,1),
    TENPHUONGTHUCTHANHTOAN NVARCHAR(250),
    NGAYTAO DATETIME,
    NGAYSUA DATETIME,
    TRANGTHAI int,
    CONSTRAINT PK_PTTT_PHUONGTHUCTHANHTOAN PRIMARY KEY (IDPHUONGTHUCTHANHTOAN)
);
GO

CREATE TABLE HOADON
(
    IDHOADON INT identity(1,1),
    ID_KHACHHANG INT,
    ID_NHANVIEN INT,
    ID_VOUCHER INT,
    ID_PHUONGTHUCTHANHTOAN INT,
    TONGTIEN FLOAT,
    NGAYTAO DATETIME,
    NGAYSUA DATETIME,
    TRANGTHAI int,
    CONSTRAINT PK_HOADON PRIMARY KEY (IDHOADON),
    CONSTRAINT FK_HOADON_KHACHHANG FOREIGN KEY (ID_KHACHHANG) REFERENCES KHACHHANG (IDKHACHHANG),
    CONSTRAINT FK_HOADON_NHANVIEN FOREIGN KEY (ID_NHANVIEN) REFERENCES NHANVIEN (IDNHANVIEN),
    CONSTRAINT FK_HOADON_VOUCHER FOREIGN KEY (ID_VOUCHER) REFERENCES VOUCHER (IDVOUCHER),
    CONSTRAINT FK_HOADON_PHUONGTHUCTHANHTOAN FOREIGN KEY (ID_PHUONGTHUCTHANHTOAN) REFERENCES PHUONGTHUCTHANHTOAN (IDPHUONGTHUCTHANHTOAN)
);
GO

CREATE TABLE HOADONCHITIET
(
    IDHOADONCHITIET INT identity(1,1),
    ID_HOADON INT,
    ID_SANPHAMCHITIET INT,
    TENSANPHAM NVARCHAR(250),
    GIABAN FLOAT,
    SOLUONG INT,
    TONGTIEN FLOAT,
    NGAYTAO DATETIME,
    NGAYSUA DATETIME,
    TRANGTHAI int,
    CONSTRAINT PK_HOADONCHITIET PRIMARY KEY (IDHOADONCHITIET),
    CONSTRAINT FK_HOADONCHITIET_HOADON FOREIGN KEY (ID_HOADON) REFERENCES HOADON (IDHOADON),
    CONSTRAINT FK_HOADONCHITIET_SANPHAMCHITIET FOREIGN KEY (ID_SANPHAMCHITIET) REFERENCES SANPHAMCHITIET (IDSANPHAMCHITIET)
);
GO
-- THEM DU LIEU 
USE DAN1_NUOCHOA

--Thêm dữ liệu cho bảng THUONGHIEU
INSERT INTO THUONGHIEU (TEN, NGAYTAO, NGAYSUA)
VALUES 
    (N'Nước hoa Chanel', GETDATE(), GETDATE()),
    (N'Nước hoa Dior', GETDATE(), GETDATE()),
    (N'Nước hoa Gucci', GETDATE(), GETDATE());

--Thêm dữ liệu cho bảng XUATXU
INSERT INTO XUATXU (TENXUATXU, NGAYTAO, NGAYSUA, TRANGTHAI)
VALUES 
    (N'Pháp', GETDATE(), GETDATE(), 1),
    (N'Ý', GETDATE(), GETDATE(), 1),
    (N'Mỹ', GETDATE(), GETDATE(), 1);

--Thêm dữ liệu cho bảng NONGDO
INSERT INTO NONGDO (TENNONGDO, NGAYTAO, NGAYSUA, TRANGTHAI)
VALUES 
    (N'Light', GETDATE(), GETDATE(), 1),
    (N'Medium', GETDATE(), GETDATE(), 1),
    (N'Strong', GETDATE(), GETDATE(), 1);

--Thêm dữ liệu cho bảng NHOMHUONG
INSERT INTO NHOMHUONG (TENNHOMHUONG, NGAYTAO, NGAYSUA, TRANGTHAI)
VALUES 
    (N'Floral', GETDATE(), GETDATE(), 1),
    (N'Woody', GETDATE(), GETDATE(), 1),
    (N'Spicy', GETDATE(), GETDATE(), 1);

--Thêm dữ liệu cho bảng KHACHHANG
INSERT INTO KHACHHANG (TENKHACHHANG, SODIENTHOAI, DIACHI, EMAIL, NGAYSINH, GIOITINH, NGAYTAO, NGAYSUA, TRANGTHAI)
VALUES 
    (N'Nguyễn Văn A', '0123456789', N'Hà Nội', 'nguyenvana@example.com', '1990-01-01', 1, GETDATE(), GETDATE(), 1),
    (N'Trần Thị B', '0987654321', N'Hồ Chí Minh', 'tranthib@example.com', '1995-05-05', 0, GETDATE(), GETDATE(), 1),
    (N'Phạm Văn C', '0369852147', N'Đà Nẵng', 'phamvanc@example.com', '1988-12-10', 1, GETDATE(), GETDATE(), 1);

--Thêm dữ liệu cho bảng NHANVIEN
INSERT INTO NHANVIEN (TENNHANVIEN, GIOITINH, EMAIL, NGAYSINH, DIACHI, SODIENTHOAIN, TAIKHOAN, MATKHAU, CHUCVU, NGAYTAO, NGAYSUA, TRANGTHAI)
VALUES 
    (N'Nguyễn Thị D', 0, 'nguyenthid@example.com', '1992-03-15', N'Hà Nội', '0987456321', 'nguyenthid', 'password', 1, GETDATE(), GETDATE(), 1),
    (N'Trần Văn E', 1, 'tranve@example.com', '1985-08-20', N'Hồ Chí Minh', '0912345678', 'tranve', 'password', 0, GETDATE(), GETDATE(), 1),
    (N'Lê Thị F', 0, 'lethif@example.com', '1993-12-25', N'Đà Nẵng', '0978965412', 'lethif', 'password', 0, GETDATE(), GETDATE(), 1);

--Thêm dữ liệu cho bảng SANPHAM
INSERT INTO SANPHAM (ID_THUONGHIEU, TENSANPHAM, NGAYTAO, NGAYSUA,SOLUONG, TRANGTHAI)
VALUES 
    (1, N'Nước hoa Chanel No. 5', GETDATE(), GETDATE(),3, 1),
    (2, N'Nước hoa Dior Sauvage', GETDATE(), GETDATE(),16, 1),
    (3, N'Nước hoa Gucci Bloom', GETDATE(), GETDATE(),7, 1);

--Thêm dữ liệu cho bảng SANPHAMCHITIET
INSERT INTO SANPHAMCHITIET (DOTOHUONG, THOIGIANNENDUNG, NAMPHATHANH, DUNGTICH, GIOITINH, LUUHUONG, ID_SP, ID_XUATXU, ID_NONGDO, ID_NHOMHUONG, NGAYTAO, NGAYSUA, TRANGTHAI)
VALUES 
    (N'Fresh', N'24 giờ', '2022-01-01', 50, 1, 1, 1, 1, 1, 1, GETDATE(), GETDATE(), 1),
    (N'Woody', N'36 giờ', '2021-12-01', 100, 0, 2, 2, 2, 2, 2, GETDATE(), GETDATE(), 1),
    (N'Sweet', N'48 giờ', '2023-03-01', 75, 1, 3, 3, 3, 3, 3, GETDATE(), GETDATE(), 1);

--Thêm dữ liệu cho bảng VOUCHER
INSERT INTO VOUCHER (MAVOUCHER, PHANCHAMGIAMGIA, NGAYBATDAU, NGAYKETTHUC, NGAYTAO, NGAYSUA, TRANGTHAI)
VALUES 
    ('VOUCHER01', 10, '2024-01-01', '2024-12-31', GETDATE(), GETDATE(), 1),
    ('VOUCHER02', 15, '2024-03-01', '2024-06-30', GETDATE(), GETDATE(), 1),
    ('VOUCHER03', 20, '2024-04-01', '2024-05-31', GETDATE(), GETDATE(), 1);

--Thêm dữ liệu cho bảng PHUONGTHUCTHANHTOAN
INSERT INTO PHUONGTHUCTHANHTOAN (TENPHUONGTHUCTHANHTOAN, NGAYTAO, NGAYSUA, TRANGTHAI)
VALUES 
    (N'Thanh toán khi nhận hàng', GETDATE(), GETDATE(), 1),
    (N'Chuyển khoản ngân hàng', GETDATE(), GETDATE(), 1),
    (N'Thanh toán qua thẻ tín dụng', GETDATE(), GETDATE(), 1);

--Thêm dữ liệu cho bảng HOADON
INSERT INTO HOADON (ID_KHACHHANG, ID_NHANVIEN, ID_VOUCHER, ID_PHUONGTHUCTHANHTOAN, TONGTIEN, NGAYTAO, NGAYSUA, TRANGTHAI)
VALUES 
    (1, 1, 1, 1, 1000000, GETDATE(), GETDATE(), 1),
    (2, 2, 2, 2, 2000000, GETDATE(), GETDATE(), 1),
    (3, 3, 3, 3, 1500000, GETDATE(), GETDATE(), 1);

--Thêm dữ liệu cho bảng HOADONCHITIET
INSERT INTO HOADONCHITIET (ID_HOADON, ID_SANPHAMCHITIET, TENSANPHAM, GIABAN, SOLUONG, TONGTIEN, NGAYTAO, NGAYSUA, TRANGTHAI)
VALUES 
    (1, 1, N'Nước hoa Chanel No. 5', 1500000, 1, 1500000, GETDATE(), GETDATE(), 1),
    (2, 2, N'Nước hoa Dior Sauvage', 2000000, 1, 2000000, GETDATE(), GETDATE(), 1),
    (3, 3, N'Nước hoa Gucci Bloom', 1200000, 1, 1200000, GETDATE(), GETDATE(), 1);



SELECT * FROM KHACHHANG;
SELECT * FROM NHANVIEN;
SELECT * FROM SANPHAM;
SELECT * FROM THUONGHIEU;
SELECT * FROM SANPHAMCHITIET;
SELECT * FROM XUATXU;
SELECT * FROM NONGDO;
SELECT * FROM NHOMHUONG;
SELECT * FROM VOUCHER;
SELECT * FROM PHUONGTHUCTHANHTOAN;
SELECT * FROM HOADON;
SELECT * FROM HOADONCHITIET;