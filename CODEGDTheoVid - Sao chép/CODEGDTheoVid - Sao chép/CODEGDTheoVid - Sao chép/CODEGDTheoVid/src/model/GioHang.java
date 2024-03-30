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
public class GioHang {
    private int IDGIOHANG;
    private int ID_GIOHANG_KHACHHANG;
    private Date NGAYTAO,NGAYSUA;
    private int TRANGTHAI;

    public GioHang() {
    }

    public GioHang(int IDGIOHANG, int ID_GIOHANG_KHACHHANG, Date NGAYTAO, Date NGAYSUA, int TRANGTHAI) {
        this.IDGIOHANG = IDGIOHANG;
        this.ID_GIOHANG_KHACHHANG = ID_GIOHANG_KHACHHANG;
        this.NGAYTAO = NGAYTAO;
        this.NGAYSUA = NGAYSUA;
        this.TRANGTHAI = TRANGTHAI;
    }

    public int getIDGIOHANG() {
        return IDGIOHANG;
    }

    public void setIDGIOHANG(int IDGIOHANG) {
        this.IDGIOHANG = IDGIOHANG;
    }

    public int getID_GIOHANG_KHACHHANG() {
        return ID_GIOHANG_KHACHHANG;
    }

    public void setID_GIOHANG_KHACHHANG(int ID_GIOHANG_KHACHHANG) {
        this.ID_GIOHANG_KHACHHANG = ID_GIOHANG_KHACHHANG;
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
    
}
