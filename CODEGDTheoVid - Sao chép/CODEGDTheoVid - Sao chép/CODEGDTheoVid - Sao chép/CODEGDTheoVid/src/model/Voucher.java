/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package model;

import java.util.Date;

/**
 *
 * @author duck1
 */
public class Voucher {

    private String IDVOUCHER;
    private float PHANCHAMGIAMGIA;
    private Date NGAYBATDAU, NGAYKETTHUC, NGAYTAO, NGAYSUA;
    private int TRANGTHAI;
    private int SOLUONG, HINHTHUC, SOHOADONAPDUNG;
    private double SOTIENMIN;
    private String MoTa, TENVOUCHER;
    private double MUCGIAMGIAl;

    public Voucher() {
    }

    public Voucher(String IDVOUCHER, float PHANCHAMGIAMGIA, Date NGAYBATDAU, Date NGAYKETTHUC, Date NGAYTAO, Date NGAYSUA, int TRANGTHAI, int SOLUONG, int HINHTHUC, int SOHOADONAPDUNG, double SOTIENMIN, String MoTa, String TENVOUCHER, double MUCGIAMGIAl) {
        this.IDVOUCHER = IDVOUCHER;
        this.PHANCHAMGIAMGIA = PHANCHAMGIAMGIA;
        this.NGAYBATDAU = NGAYBATDAU;
        this.NGAYKETTHUC = NGAYKETTHUC;
        this.NGAYTAO = NGAYTAO;
        this.NGAYSUA = NGAYSUA;
        this.TRANGTHAI = TRANGTHAI;
        this.SOLUONG = SOLUONG;
        this.HINHTHUC = HINHTHUC;
        this.SOHOADONAPDUNG = SOHOADONAPDUNG;
        this.SOTIENMIN = SOTIENMIN;
        this.MoTa = MoTa;
        this.TENVOUCHER = TENVOUCHER;
        this.MUCGIAMGIAl = MUCGIAMGIAl;
    }

    public String getIDVOUCHER() {
        return IDVOUCHER;
    }

    public void setIDVOUCHER(String IDVOUCHER) {
        this.IDVOUCHER = IDVOUCHER;
    }

    public float getPHANCHAMGIAMGIA() {
        return PHANCHAMGIAMGIA;
    }

    public void setPHANCHAMGIAMGIA(float PHANCHAMGIAMGIA) {
        this.PHANCHAMGIAMGIA = PHANCHAMGIAMGIA;
    }

    public Date getNGAYBATDAU() {
        return NGAYBATDAU;
    }

    public void setNGAYBATDAU(Date NGAYBATDAU) {
        this.NGAYBATDAU = NGAYBATDAU;
    }

    public Date getNGAYKETTHUC() {
        return NGAYKETTHUC;
    }

    public void setNGAYKETTHUC(Date NGAYKETTHUC) {
        this.NGAYKETTHUC = NGAYKETTHUC;
    }

    public Date getNGAYTAO() {
        return NGAYTAO;
    }

    public void setNGAYTAO(Date NGAYTAO) {
        this.NGAYTAO = NGAYTAO;
    }

    public Date getNGAYSUA() {
        return NGAYSUA;
    }

    public void setNGAYSUA(Date NGAYSUA) {
        this.NGAYSUA = NGAYSUA;
    }

    public int getTRANGTHAI() {
        return TRANGTHAI;
    }

    public void setTRANGTHAI(int TRANGTHAI) {
        this.TRANGTHAI = TRANGTHAI;
    }

    public int getSOLUONG() {
        return SOLUONG;
    }

    public void setSOLUONG(int SOLUONG) {
        this.SOLUONG = SOLUONG;
    }

    public int getHINHTHUC() {
        return HINHTHUC;
    }

    public void setHINHTHUC(int HINHTHUC) {
        this.HINHTHUC = HINHTHUC;
    }

    public int getSOHOADONAPDUNG() {
        return SOHOADONAPDUNG;
    }

    public void setSOHOADONAPDUNG(int SOHOADONAPDUNG) {
        this.SOHOADONAPDUNG = SOHOADONAPDUNG;
    }

    public double getSOTIENMIN() {
        return SOTIENMIN;
    }

    public void setSOTIENMIN(double SOTIENMIN) {
        this.SOTIENMIN = SOTIENMIN;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public String getTENVOUCHER() {
        return TENVOUCHER;
    }

    public void setTENVOUCHER(String TENVOUCHER) {
        this.TENVOUCHER = TENVOUCHER;
    }

    public double getMUCGIAMGIAl() {
        return MUCGIAMGIAl;
    }

    public void setMUCGIAMGIAl(double MUCGIAMGIAl) {
        this.MUCGIAMGIAl = MUCGIAMGIAl;
    }

}
