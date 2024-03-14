/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class voucher {
    private int IDVoucher;
    private String MaVC;
    private double PhanTramGiam;
    private String NgayTao,NgaySua;
    private int TrangThai;

    public int getIDVoucher() {
        return IDVoucher;
    }

    public void setIDVoucher(int IDVoucher) {
        this.IDVoucher = IDVoucher;
    }

    public String getMaVC() {
        return MaVC;
    }

    public void setMaVC(String MaVC) {
        this.MaVC = MaVC;
    }

    public double getPhanTramGiam() {
        return PhanTramGiam;
    }

    public void setPhanTramGiam(double PhanTramGiam) {
        this.PhanTramGiam = PhanTramGiam;
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

    public voucher() {
    }
    public String trangthai(){
        String tt=null;
        if(TrangThai==0){
            tt="Hết";
        }else if(TrangThai==1){
            tt="Còn";
        }
        return tt;
    } 

    public voucher(String MaVC, double PhanTramGiam, String NgayTao, String NgaySua, int TrangThai) {
        this.MaVC = MaVC;
        this.PhanTramGiam = PhanTramGiam;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.TrangThai = TrangThai;
    }

    public voucher(int IDVoucher, String MaVC, double PhanTramGiam, String NgayTao, String NgaySua, int TrangThai) {
        this.IDVoucher = IDVoucher;
        this.MaVC = MaVC;
        this.PhanTramGiam = PhanTramGiam;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.TrangThai = TrangThai;
    }
}
