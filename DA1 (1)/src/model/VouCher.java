/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class VouCher {
    private int IDVouCher;
    private String MaVC;
    private double PhanTramGiam;
    private String NgayBatDau,NgayKetThuc,NgayTao,NgaySua;
    private int TrangThai;

    public int getIDVoucher() {
        return IDVouCher;
    }

    public void setIDVoucher(int IDVoucher) {
        this.IDVouCher = IDVoucher;
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

    public int getIDVouCher() {
        return IDVouCher;
    }

    public void setIDVouCher(int IDVouCher) {
        this.IDVouCher = IDVouCher;
    }

    public String getNgayBatDau() {
        return NgayBatDau;
    }

    public void setNgayBatDau(String NgayBatDau) {
        this.NgayBatDau = NgayBatDau;
    }

    public String getNgayKetThuc() {
        return NgayKetThuc;
    }

    public void setNgayKetThuc(String NgayKetThuc) {
        this.NgayKetThuc = NgayKetThuc;
    }

    public VouCher() {
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

    public VouCher(int IDVouCher, String MaVC, double PhanTramGiam, String NgayBatDau, String NgayKetThuc, String NgayTao, String NgaySua, int TrangThai) {
        this.IDVouCher = IDVouCher;
        this.MaVC = MaVC;
        this.PhanTramGiam = PhanTramGiam;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.TrangThai = TrangThai;
    }

    public VouCher(String MaVC, double PhanTramGiam, String NgayBatDau, String NgayKetThuc, String NgayTao, String NgaySua, int TrangThai) {
        this.MaVC = MaVC;
        this.PhanTramGiam = PhanTramGiam;
        this.NgayBatDau = NgayBatDau;
        this.NgayKetThuc = NgayKetThuc;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.TrangThai = TrangThai;
    }

}
