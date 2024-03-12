/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class NhomHuong {

    private int IDNH;
    private String TenNhomHuong, NgayTao, NgaySua;
    private int TrangThai;

    public int getIDNH() {
        return IDNH;
    }

    public void setIDNH(int IDNH) {
        this.IDNH = IDNH;
    }

    public String getTenNhomHuong() {
        return TenNhomHuong;
    }

    public void setTenNhomHuong(String TenNhomHuong) {
        this.TenNhomHuong = TenNhomHuong;
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

    public NhomHuong(String TenNhomHuong, String NgayTao, String NgaySua, int TrangThai) {
        this.TenNhomHuong = TenNhomHuong;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.TrangThai = TrangThai;
    }

    public NhomHuong(int IDNH, String TenNhomHuong, String NgayTao, String NgaySua, int TrangThai) {
        this.IDNH = IDNH;
        this.TenNhomHuong = TenNhomHuong;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.TrangThai = TrangThai;
    }

}
