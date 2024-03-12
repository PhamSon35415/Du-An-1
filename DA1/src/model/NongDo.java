/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class NongDo {
    private int IDND;
    private String TenNongDo, NgayTao, NgaySua;
    private int TrangThai;

    public NongDo(int IDND, String TenNongDo, String NgayTao, String NgaySua, int TrangThai) {
        this.IDND = IDND;
        this.TenNongDo = TenNongDo;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.TrangThai = TrangThai;
    }

    public NongDo(String TenNongDo, String NgayTao, String NgaySua, int TrangThai) {
        this.TenNongDo = TenNongDo;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.TrangThai = TrangThai;
    }

    public NongDo() {
    }

    public int getIDND() {
        return IDND;
    }

    public void setIDND(int IDND) {
        this.IDND = IDND;
    }

    public String getTenNongDo() {
        return TenNongDo;
    }

    public void setTenNongDo(String TenNongDo) {
        this.TenNongDo = TenNongDo;
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
