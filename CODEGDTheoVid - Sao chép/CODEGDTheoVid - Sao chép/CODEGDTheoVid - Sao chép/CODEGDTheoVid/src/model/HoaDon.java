/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author duck1
 */
public class HoaDon {

//        IDHOADON INT,
//    ID_KHACHHANG INT,
//    ID_NHANVIEN INT,
//    ID_VOUCHER VARCHAR(50),
//    ID_PHUONGTHUCTHANHTOAN varchar(50),
//    TONGTIEN money,
//    THANHTIEN money,
//    GiamGia money,
//    NGAYTHANHTOAN date,
//    NGAYTAO Date,
//    NGAYSUA Date,
//    TRANGTHAI INT,
    private int IDHOADON, ID_KHACHHANG, ID_NHANVIEN;
    private String ID_VOUCHER, ID_PHUONGTHUCTHANHTOAN;
    private double TONGTIEN, THANHTIEN, GiamGia;
    private String NGAYTHANHTOAN, NGAYTAO, NGAYSUA;
    private int TRANGTHAI;

    public String trangthathd() {
        String x;
        x = switch (TRANGTHAI) {
            case 0 ->
                "Đã hủy";
            case 1 ->
                "Chưa thanh toán";
            case 2 ->
                "Đã thanh toán";
            default ->
                "Trạng thái không xác định";
        };
        return x;
    }
    public Object[] torow(){
        return new Object[]{
            IDHOADON, ID_KHACHHANG, ID_NHANVIEN,ID_VOUCHER, ID_PHUONGTHUCTHANHTOAN,TONGTIEN, THANHTIEN, GiamGia,NGAYTHANHTOAN, NGAYTAO, NGAYSUA,trangthathd()
        };
    }

    public HoaDon() {
    }





    public int getIDHOADON() {
        return IDHOADON;
    }

    public void setIDHOADON(int IDHOADON) {
        this.IDHOADON = IDHOADON;
    }

    public int getID_KHACHHANG() {
        return ID_KHACHHANG;
    }

    public void setID_KHACHHANG(int ID_KHACHHANG) {
        this.ID_KHACHHANG = ID_KHACHHANG;
    }

    public int getID_NHANVIEN() {
        return ID_NHANVIEN;
    }

    public void setID_NHANVIEN(int ID_NHANVIEN) {
        this.ID_NHANVIEN = ID_NHANVIEN;
    }

    public String getID_PHUONGTHUCTHANHTOAN() {
        return ID_PHUONGTHUCTHANHTOAN;
    }

    public void setID_PHUONGTHUCTHANHTOAN(String ID_PHUONGTHUCTHANHTOAN) {
        this.ID_PHUONGTHUCTHANHTOAN = ID_PHUONGTHUCTHANHTOAN;
    }

    public double getTONGTIEN() {
        return TONGTIEN;
    }

    public void setTONGTIEN(double TONGTIEN) {
        this.TONGTIEN = TONGTIEN;
    }

    public double getTHANHTIEN() {
        return THANHTIEN;
    }

    public void setTHANHTIEN(double THANHTIEN) {
        this.THANHTIEN = THANHTIEN;
    }

    public double getGiamGia() {
        return GiamGia;
    }

    public void setGiamGia(double GiamGia) {
        this.GiamGia = GiamGia;
    }

    public String getNGAYTHANHTOAN() {
        return NGAYTHANHTOAN;
    }

    public void setNGAYTHANHTOAN(String NGAYTHANHTOAN) {
        this.NGAYTHANHTOAN = NGAYTHANHTOAN;
    }

    public String getNGAYTAO() {
        return NGAYTAO;
    }

    public void setNGAYTAO(String NGAYTAO) {
        this.NGAYTAO = NGAYTAO;
    }

    public String getNGAYSUA() {
        return NGAYSUA;
    }

    public void setNGAYSUA(String NGAYSUA) {
        this.NGAYSUA = NGAYSUA;
    }

    public HoaDon(int ID_KHACHHANG, int ID_NHANVIEN, String ID_VOUCHER, String ID_PHUONGTHUCTHANHTOAN, double TONGTIEN, double THANHTIEN, double GiamGia, String NGAYTHANHTOAN, String NGAYTAO, int TRANGTHAI) {
        this.ID_KHACHHANG = ID_KHACHHANG;
        this.ID_NHANVIEN = ID_NHANVIEN;
        this.ID_VOUCHER = ID_VOUCHER;
        this.ID_PHUONGTHUCTHANHTOAN = ID_PHUONGTHUCTHANHTOAN;
        this.TONGTIEN = TONGTIEN;
        this.THANHTIEN = THANHTIEN;
        this.GiamGia = GiamGia;
        this.NGAYTHANHTOAN = NGAYTHANHTOAN;
        this.NGAYTAO = NGAYTAO;
        this.TRANGTHAI = TRANGTHAI;
    }

    public HoaDon(int IDHOADON, int ID_KHACHHANG, int ID_NHANVIEN, String ID_VOUCHER, String ID_PHUONGTHUCTHANHTOAN, double TONGTIEN, double THANHTIEN, double GiamGia, String NGAYTHANHTOAN, String NGAYTAO, String NGAYSUA, int TRANGTHAI) {
        this.IDHOADON = IDHOADON;
        this.ID_KHACHHANG = ID_KHACHHANG;
        this.ID_NHANVIEN = ID_NHANVIEN;
        this.ID_VOUCHER = ID_VOUCHER;
        this.ID_PHUONGTHUCTHANHTOAN = ID_PHUONGTHUCTHANHTOAN;
        this.TONGTIEN = TONGTIEN;
        this.THANHTIEN = THANHTIEN;
        this.GiamGia = GiamGia;
        this.NGAYTHANHTOAN = NGAYTHANHTOAN;
        this.NGAYTAO = NGAYTAO;
        this.NGAYSUA = NGAYSUA;
        this.TRANGTHAI = TRANGTHAI;
    }


    public int getTRANGTHAI() {
        return TRANGTHAI;
    }

    public void setTRANGTHAI(int TRANGTHAI) {
        this.TRANGTHAI = TRANGTHAI;
    }

    public String getID_VOUCHER() {
        return ID_VOUCHER;
    }

    public void setID_VOUCHER(String ID_VOUCHER) {
        this.ID_VOUCHER = ID_VOUCHER;
    }

}
