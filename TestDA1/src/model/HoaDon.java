/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class HoaDon {
    private int IDHD,IDKhacHang, IDNhanVien, IDPhuongThucThanhToan, IDVoucher;
    private String NgayTao, NgaySua;
    private int TrangThai;

    public HoaDon(int IDHD, int IDKhacHang, int IDNhanVien, int IDPhuongThucThanhToan, int IDVoucher, String NgayTao, String NgaySua, int TrangThai) {
        this.IDHD = IDHD;
        this.IDKhacHang = IDKhacHang;
        this.IDNhanVien = IDNhanVien;
        this.IDPhuongThucThanhToan = IDPhuongThucThanhToan;
        this.IDVoucher = IDVoucher;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.TrangThai = TrangThai;
    }

    public HoaDon(int IDKhacHang, int IDNhanVien, int IDPhuongThucThanhToan, int IDVoucher, String NgayTao, String NgaySua, int TrangThai) {
        this.IDKhacHang = IDKhacHang;
        this.IDNhanVien = IDNhanVien;
        this.IDPhuongThucThanhToan = IDPhuongThucThanhToan;
        this.IDVoucher = IDVoucher;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.TrangThai = TrangThai;
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
    
}
