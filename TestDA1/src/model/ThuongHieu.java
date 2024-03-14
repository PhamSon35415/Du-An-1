/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class ThuongHieu {
    private int IDThuongHieu;
    private String TenThuongHieu, NgayTao, NgaySua;
    private int TrangThai;

    public int getIDThuongHieu() {
        return IDThuongHieu;
    }

    public void setIDThuongHieu(int IDThuongHieu) {
        this.IDThuongHieu = IDThuongHieu;
    }

    public String getTenThuongHieu() {
        return TenThuongHieu;
    }

    public void setTenThuongHieu(String TenThuongHieu) {
        this.TenThuongHieu = TenThuongHieu;
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

    public ThuongHieu() {
    }

    public ThuongHieu(String TenThuongHieu, String NgayTao, String NgaySua, int TrangThai) {
        this.TenThuongHieu = TenThuongHieu;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.TrangThai = TrangThai;
    }

    public ThuongHieu(int IDThuongHieu, String TenThuongHieu, String NgayTao, String NgaySua, int TrangThai) {
        this.IDThuongHieu = IDThuongHieu;
        this.TenThuongHieu = TenThuongHieu;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.TrangThai = TrangThai;
    }

}
