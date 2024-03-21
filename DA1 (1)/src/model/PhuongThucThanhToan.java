/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class PhuongThucThanhToan {

    private int IDPhuongThucThanhToan;
    private String TenPhuongThucThanhToan, NgayTao, NgaySua;
    private int TrangThai;

    public int getIDPhuongThucThanhToan() {
        return IDPhuongThucThanhToan;
    }

    public void setIDPhuongThucThanhToan(int IDPhuongThucThanhToan) {
        this.IDPhuongThucThanhToan = IDPhuongThucThanhToan;
    }

    public String getTenPhuongThucThanhToan() {
        return TenPhuongThucThanhToan;
    }

    public void setTenPhuongThucThanhToan(String TenPhuongThucThanhToan) {
        this.TenPhuongThucThanhToan = TenPhuongThucThanhToan;
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

    public PhuongThucThanhToan(String TenPhuongThucThanhToan, String NgayTao, String NgaySua, int TrangThai) {
        this.TenPhuongThucThanhToan = TenPhuongThucThanhToan;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.TrangThai = TrangThai;
    }

    public PhuongThucThanhToan(int IDPhuongThucThanhToan, String TenPhuongThucThanhToan, String NgayTao, String NgaySua, int TrangThai) {
        this.IDPhuongThucThanhToan = IDPhuongThucThanhToan;
        this.TenPhuongThucThanhToan = TenPhuongThucThanhToan;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.TrangThai = TrangThai;
    }
}
