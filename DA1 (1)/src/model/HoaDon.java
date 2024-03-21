/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import service.HoaDonDao;

/**
 *
 * @author Admin
 */
public class HoaDon {

    private int IDHD, IDKhacHang, IDNhanVien, IDPhuongThucThanhToan, IDVoucher;
    private double TongTien;
    private String NgayTao, NgaySua;
    private int TrangThai;//0:Da huy,1 Chua thanh toan, 2:da thanhtoan ,3:Dang giao,4:Da giao
    HoaDonDao hd = new HoaDonDao();

    public String trangthathd() {
        String x;
        x = switch (TrangThai) {
            case 0 -> "Đã hủy";
            case 1 -> "Chưa thanh toán";
            case 2 -> "Đã thanh toán";
            case 3 -> "Đang giao";
            case 4 -> "Đã giao";
            default -> "Trạng thái không xác định";
        };
        return x;
    }

    public Object[] torow() {
        return new Object[]{
            IDHD, hd.getTenKH(IDKhacHang), hd.getTenNV(IDNhanVien), hd.getTenPT(IDPhuongThucThanhToan), 
            hd.getTenVC(IDVoucher), TongTien, NgayTao, NgaySua, trangthathd()
        };
    }
    public HoaDon(int IDHD, int IDKhacHang, int IDNhanVien, int IDPhuongThucThanhToan, int IDVoucher, double TongTien, int TrangThai) {
        this.IDHD = IDHD;
        this.IDKhacHang = IDKhacHang;
        this.IDNhanVien = IDNhanVien;
        this.IDPhuongThucThanhToan = IDPhuongThucThanhToan;
        this.IDVoucher = IDVoucher;
        this.TongTien = TongTien;
        this.TrangThai = TrangThai;
    }

    public HoaDon(int IDHD, int IDKhacHang, int IDNhanVien, int IDPhuongThucThanhToan, int IDVoucher, double TongTien, String NgayTao, String NgaySua, int TrangThai) {
        this.IDHD = IDHD;
        this.IDKhacHang = IDKhacHang;
        this.IDNhanVien = IDNhanVien;
        this.IDPhuongThucThanhToan = IDPhuongThucThanhToan;
        this.IDVoucher = IDVoucher;
        this.TongTien = TongTien;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.TrangThai = TrangThai;
    }

    public HoaDon(int IDKhacHang, int IDNhanVien, int IDPhuongThucThanhToan, int IDVoucher, double TongTien, String NgayTao, String NgaySua, int TrangThai) {
        this.IDKhacHang = IDKhacHang;
        this.IDNhanVien = IDNhanVien;
        this.IDPhuongThucThanhToan = IDPhuongThucThanhToan;
        this.IDVoucher = IDVoucher;
        this.TongTien = TongTien;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.TrangThai = TrangThai;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
    }

    public HoaDon() {
    }

    public int getIDHD() {
        return IDHD;
    }

    public void setIDHD(int IDHD) {
        this.IDHD = IDHD;
    }

    public int getIDKhacHang() {
        return IDKhacHang;
    }

    public void setIDKhacHang(int IDKhacHang) {
        this.IDKhacHang = IDKhacHang;
    }

    public int getIDNhanVien() {
        return IDNhanVien;
    }

    public void setIDNhanVien(int IDNhanVien) {
        this.IDNhanVien = IDNhanVien;
    }

    public int getIDPhuongThucThanhToan() {
        return IDPhuongThucThanhToan;
    }

    public void setIDPhuongThucThanhToan(int IDPhuongThucThanhToan) {
        this.IDPhuongThucThanhToan = IDPhuongThucThanhToan;
    }

    public int getIDVoucher() {
        return IDVoucher;
    }

    public void setIDVoucher(int IDVoucher) {
        this.IDVoucher = IDVoucher;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }

    public String getNgaySua() {
        return NgaySua;
    }

    public void setNgaySua(String NgaySua) {
        this.NgaySua = NgaySua;
    }

    public int getTrangThai() {
        return TrangThai;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public HoaDon(int IDKhacHang, int IDNhanVien, int IDPhuongThucThanhToan, int IDVoucher, double TongTien, String NgaySua, int TrangThai) {
        this.IDKhacHang = IDKhacHang;
        this.IDNhanVien = IDNhanVien;
        this.IDPhuongThucThanhToan = IDPhuongThucThanhToan;
        this.IDVoucher = IDVoucher;
        this.TongTien = TongTien;
        this.NgaySua = NgaySua;
        this.TrangThai = TrangThai;
    }

}
