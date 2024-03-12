﻿CREATE DATABASE DAN1_NUOCHOA;
GO

USE DAN1_NUOCHOA;
GO

CREATE TABLE THUONGHIEU
(
    IDTHUONGHIEU INT identity(1,1),
    TEN NVARCHAR(250),
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
    TRANGTHAI BIT,
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
    TRANGTHAI BIT,
    CONSTRAINT PK_VC_VOUCHER PRIMARY KEY (IDVOUCHER)
);
GO

CREATE TABLE PHUONGTHUCTHANHTOAN
(
    IDPHUONGTHUCTHANHTOAN INT identity(1,1),
    TENPHUONGTHUCTHANHTOAN NVARCHAR(250),
    NGAYTAO DATETIME,
    NGAYSUA DATETIME,
    TRANGTHAI BIT,
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
    TONGTIEN DECIMAL(10, 2),
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

-- Insert data into THUONGHIEU table
INSERT INTO THUONGHIEU (IDTHUONGHIEU, TEN) VALUES (1, 'Nước hoa X');
INSERT INTO THUONGHIEU (IDTHUONGHIEU, TEN) VALUES (2, 'Nước hoa Y');

-- Insert data into XUATXU table
INSERT INTO XUATXU (IDXUATXU, TENXUATXU, TRANGTHAI) VALUES (1, 'Việt Nam', 1);
INSERT INTO XUATXU (IDXUATXU, TENXUATXU, TRANGTHAI) VALUES (2, 'Pháp', 1);

-- Insert data into NONGDO table
INSERT INTO NONGDO (IDNONGDO, TENNONGDO, TRANGTHAI) VALUES (1, 'Cao', 1);
INSERT INTO NONGDO (IDNONGDO, TENNONGDO, TRANGTHAI) VALUES (2, 'Thấp', 1);

-- Insert data into NHOMHUONG table
INSERT INTO NHOMHUONG (IDNHOMHUONG, TENNHOMHUONG, TRANGTHAI) VALUES (1, 'Hương hoa', 1);
INSERT INTO NHOMHUONG (IDNHOMHUONG, TENNHOMHUONG, TRANGTHAI) VALUES (2, 'Hương gỗ', 1);

-- Insert data into KHACHHANG table
INSERT INTO KHACHHANG (IDKHACHHANG, TENKHACHHANG, SODIENTHOAI, DIACHI, EMAIL, NGAYSINH, GIOITINH, TRANGTHAI) 
VALUES (1, 'Khách hàng A', '1234567890', 'Địa chỉ A', 'customerA@email.com', '1990-01-01', 1, 1);

-- Insert data into NHANVIEN table
INSERT INTO NHANVIEN (IDNHANVIEN, TENNHANVIEN, GIOITINH, EMAIL, NGAYSINH, DIACHI, SODIENTHOAIN, TAIKHOAN, MATKHAU, CHUCVU, TRANGTHAI) 
VALUES (1, 'Nhân viên A', 1, 'employeeA@email.com', '1985-05-05', 'Địa chỉ B', '0987654321', 'employeeA', 'password123', 1, 1);

-- Insert data into SANPHAM table
INSERT INTO SANPHAM (IDSANPHAM, ID_THUONGHIEU, TENSANPHAM, TRANGTHAI) VALUES (1, 1, 'Nước hoa X1', 1);
INSERT INTO SANPHAM (IDSANPHAM, ID_THUONGHIEU, TENSANPHAM, TRANGTHAI) VALUES (2, 2, 'Nước hoa Y1', 1);

-- Insert data into SANPHAMCHITIET table
INSERT INTO SANPHAMCHITIET (IDSANPHAMCHITIET, DOTOHUONG, THOIGIANNENDUNG, NAMPHATHANH, DUNGTICH, GIOITINH, LUUHUONG, ID_SP, ID_XUATXU, ID_NONGDO, ID_NHOMHUONG)
VALUES (1, 'Hương hoa A', '2024-01-01', '2022-01-01', 100, 1, 1, 1, 1, 1, 1);

-- Insert data into VOUCHER table
INSERT INTO VOUCHER (IDVOUCHER, MAVOUCHER, PHANCHAMGIAMGIA, NGAYBATDAU, NGAYKETTHUC, TRANGTHAI) 
VALUES (1, 'VOUCHER01', 0.1, '2024-01-01', '2024-12-31', 1);

-- Insert data into PHUONGTHUCTHANHTOAN table
INSERT INTO PHUONGTHUCTHANHTOAN (IDPHUONGTHUCTHANHTOAN, TENPHUONGTHUCTHANHTOAN, TRANGTHAI) 
VALUES (1, 'Thanh toán khi nhận hàng', 1);

-- Insert data into HOADON table
INSERT INTO HOADON (IDHOADON, ID_KHACHHANG, ID_NHANVIEN, ID_VOUCHER, ID_PHUONGTHUCTHANHTOAN, TONGTIEN, TRANGTHAI)
VALUES (1, 1, 1, 1, 1, 100000, 1);

-- Insert data into HOADONCHITIET table
INSERT INTO HOADONCHITIET (IDHOADONCHITIET, ID_HOADON, ID_SANPHAMCHITIET, TENSANPHAM, GIABAN, SOLUONG, TONGTIEN, TRANGTHAI)
VALUES (1, 1, 1, 'Nước hoa X1', 1000, 2, 2000, 1);

-- END 

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