/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class SanPham {
    private int IDSP, IDThuongHieu;
    private String TenSanPham, NgayTao, NgaySua;   
    private int TrangThai;

    public int getIDSP() {
        return IDSP;
    }

    public void setIDSP(int IDSP) {
        this.IDSP = IDSP;
    }

    public int getIDThuongHieu() {
        return IDThuongHieu;
    }

    public void setIDThuongHieu(int IDThuongHieu) {
        this.IDThuongHieu = IDThuongHieu;
    }

    public String getTenSanPham() {
        return TenSanPham;
    }

    public void setTenSanPham(String TenSanPham) {
        this.TenSanPham = TenSanPham;
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

    public SanPham() {
    }

    public SanPham(int IDThuongHieu, String TenSanPham, String NgayTao, String NgaySua, int TrangThai) {
        this.IDThuongHieu = IDThuongHieu;
        this.TenSanPham = TenSanPham;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.TrangThai = TrangThai;
    }

    public SanPham(int IDSP, int IDThuongHieu, String TenSanPham, String NgayTao, String NgaySua, int TrangThai) {
        this.IDSP = IDSP;
        this.IDThuongHieu = IDThuongHieu;
        this.TenSanPham = TenSanPham;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.TrangThai = TrangThai;
    }
}
