/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class HoaDonChiTiet {
    //ID_HOADON, ID_SANPHAMCHITIET, TENSANPHAM, GIABAN, SOLUONG, TONGTIEN, NGAYTAO, NGAYSUA, TRANGTHAI
    private int IDHdCt,IDHD,IDSpCt;
    private String TenSanPham;
    private int SoLg;
    
    private double GiaBan,TongTien;
    private String NgayTao, NgaySua;
    private int TrangThai;

    public Object[] torow(){
        return new Object[]{
            IDHdCt,IDHD,IDSpCt,TenSanPham,SoLg,GiaBan,TongTien,NgayTao, NgaySua,TrangThai
        };
    }

    public HoaDonChiTiet(int IDHdCt, int IDHD, int IDSpCt, String TenSanPham, int SoLg, double GiaBan, double TongTien, String NgayTao, String NgaySua, int TrangThai) {
        this.IDHdCt = IDHdCt;
        this.IDHD = IDHD;
        this.IDSpCt = IDSpCt;
        this.TenSanPham = TenSanPham;
        this.SoLg = SoLg;
        this.GiaBan = GiaBan;
        this.TongTien = TongTien;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.TrangThai = TrangThai;
    }

    public HoaDonChiTiet(int IDHD, int IDSpCt, String TenSanPham, int SoLg, double GiaBan, double TongTien, String NgayTao, String NgaySua, int TrangThai) {
        this.IDHD = IDHD;
        this.IDSpCt = IDSpCt;
        this.TenSanPham = TenSanPham;
        this.SoLg = SoLg;
        this.GiaBan = GiaBan;
        this.TongTien = TongTien;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.TrangThai = TrangThai;
    }

    public int getIDHdCt() {
        return IDHdCt;
    }

    public void setIDHdCt(int IDHdCt) {
        this.IDHdCt = IDHdCt;
    }
    
    

    public HoaDonChiTiet() {
    }

    public int getIDHD() {
        return IDHD;
    }

    public void setIDHD(int IDHD) {
        this.IDHD = IDHD;
    }

    public int getIDSpCt() {
        return IDSpCt;
    }

    public void setIDSpCt(int IDSpCt) {
        this.IDSpCt = IDSpCt;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
    }

    public int getSoLg() {
        return SoLg;
    }

    public void setSoLg(int SoLg) {
        this.SoLg = SoLg;
    }

    public double getGiaBan() {
        return GiaBan;
    }

    public void setGiaBan(double GiaBan) {
        this.GiaBan = GiaBan;
    }

    public double getTongTien() {
        return TongTien;
    }

    public void setTongTien(double TongTien) {
        this.TongTien = TongTien;
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
