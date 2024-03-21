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
    private int IDSP;
    private String TenSanPham, NgayTao, NgaySua;   
    private int SoLg,TrangThai;

    public int getIDSP() {
        return IDSP;
    }
     public Object[] torow() {
        String x = null;
        if (TrangThai == 1) {
            x = "Còn hàng";
        } else {
            x = "Hết hàng";
        }
        return new Object[]{
            IDSP,TenSanPham,SoLg, x
        };
    }

    public SanPham(int IDSP, String TenSanPham, String NgayTao, String NgaySua, int SoLg, int TrangThai) {
        this.IDSP = IDSP;
        this.TenSanPham = TenSanPham;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.SoLg = SoLg;
        this.TrangThai = TrangThai;
    }

    public SanPham(String TenSanPham, String NgayTao, String NgaySua, int SoLg, int TrangThai) {
        this.TenSanPham = TenSanPham;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.SoLg = SoLg;
        this.TrangThai = TrangThai;
    }

    public SanPham(String TenSanPham, String NgaySua, int SoLg, int TrangThai) {
        this.TenSanPham = TenSanPham;
        this.NgaySua = NgaySua;
        this.SoLg = SoLg;
        this.TrangThai = TrangThai;
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

    public int getSoLg() {
        return SoLg;
    }

    public void setSoLg(int SoLg) {
        this.SoLg = SoLg;
    }

    public void setTrangThai(int TrangThai) {
        this.TrangThai = TrangThai;
    }

    public SanPham() {
    }

   

}
