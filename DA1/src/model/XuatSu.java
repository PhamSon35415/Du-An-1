/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class XuatSu {
    private int IDXS;
    private String TenXuatSu, NgayTao, NgaySua;
    private int TrangThai;

    public XuatSu(int IDXS, String TenXuatSu, String NgayTao, String NgaySua, int TrangThai) {
        this.IDXS = IDXS;
        this.TenXuatSu = TenXuatSu;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.TrangThai = TrangThai;
    }

    public XuatSu() {
    }

    public XuatSu(String TenXuatSu, String NgayTao, String NgaySua, int TrangThai) {
        this.TenXuatSu = TenXuatSu;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.TrangThai = TrangThai;
    }

    public int getIDXS() {
        return IDXS;
    }

    public void setIDXS(int IDXS) {
        this.IDXS = IDXS;
    }

    public String getTenXuatSu() {
        return TenXuatSu;
    }

    public void setTenXuatSu(String TenXuatSu) {
        this.TenXuatSu = TenXuatSu;
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
