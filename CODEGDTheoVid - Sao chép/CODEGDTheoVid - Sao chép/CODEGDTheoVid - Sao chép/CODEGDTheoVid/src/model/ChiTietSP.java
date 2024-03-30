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
public class ChiTietSP {
    private int IDSANPHAMCHITIET;
    private int ID_SP;
    private int ID_XUATXU;
    private int ID_NONGDO;
    private int ID_NHOMHUONG;
    private String DOTOHUONG;
    private String THOIGIANNENDUNG;
    private String NAMPHATHANH;
    private int GIOITINH;
    private int LUUHUONG;
    private double GIA;
    private int DUNGTICH;
    private int SOLG;
    private int TRANGTHAI;

    public double getGIA() {
        return GIA;
    }

    public void setGIA(double GIA) {
        this.GIA = GIA;
    }

    public int getTRANGTHAI() {
        return TRANGTHAI;
    }

    public void setTRANGTHAI(int TRANGTHAI) {
        this.TRANGTHAI = TRANGTHAI;
    }

    public ChiTietSP(int IDSANPHAMCHITIET, int ID_SP, int ID_XUATXU, int ID_NONGDO, int ID_NHOMHUONG, String DOTOHUONG, String THOIGIANNENDUNG, String NAMPHATHANH, int GIOITINH, int LUUHUONG, double GIA, int DUNGTICH, int SOLG, int TRANGTHAI) {
        this.IDSANPHAMCHITIET = IDSANPHAMCHITIET;
        this.ID_SP = ID_SP;
        this.ID_XUATXU = ID_XUATXU;
        this.ID_NONGDO = ID_NONGDO;
        this.ID_NHOMHUONG = ID_NHOMHUONG;
        this.DOTOHUONG = DOTOHUONG;
        this.THOIGIANNENDUNG = THOIGIANNENDUNG;
        this.NAMPHATHANH = NAMPHATHANH;
        this.GIOITINH = GIOITINH;
        this.LUUHUONG = LUUHUONG;
        this.GIA = GIA;
        this.DUNGTICH = DUNGTICH;
        this.SOLG = SOLG;
        this.TRANGTHAI = TRANGTHAI;
    }

   
    public int getSOLG() {
        return SOLG;
    }

    public void setSOLG(int SOLG) {
        this.SOLG = SOLG;
    }



//    GIOITINH INT,
//    LUUHUONG INT,
//    GIA money,
//    SOLUONG INT,

    public ChiTietSP() {
    }

    public int getIDSANPHAMCHITIET() {
        return IDSANPHAMCHITIET;
    }

    public void setIDSANPHAMCHITIET(int IDSANPHAMCHITIET) {
        this.IDSANPHAMCHITIET = IDSANPHAMCHITIET;
    }

    public String getDOTOHUONG() {
        return DOTOHUONG;
    }

    public void setDOTOHUONG(String DOTOHUONG) {
        this.DOTOHUONG = DOTOHUONG;
    }

    public String getTHOIGIANNENDUNG() {
        return THOIGIANNENDUNG;
    }

    public void setTHOIGIANNENDUNG(String THOIGIANNENDUNG) {
        this.THOIGIANNENDUNG = THOIGIANNENDUNG;
    }

    public String getNAMPHATHANH() {
        return NAMPHATHANH;
    }

    public void setNAMPHATHANH(String NAMPHATHANH) {
        this.NAMPHATHANH = NAMPHATHANH;
    }

    public int getDUNGTICH() {
        return DUNGTICH;
    }

    public void setDUNGTICH(int DUNGTICH) {
        this.DUNGTICH = DUNGTICH;
    }

    public int getGIOITINH() {
        return GIOITINH;
    }

    public void setGIOITINH(int GIOITINH) {
        this.GIOITINH = GIOITINH;
    }

    public int getLUUHUONG() {
        return LUUHUONG;
    }

    public void setLUUHUONG(int LUUHUONG) {
        this.LUUHUONG = LUUHUONG;
    }

    public int getID_SP() {
        return ID_SP;
    }

    public void setID_SP(int ID_SP) {
        this.ID_SP = ID_SP;
    }

    public int getID_XUATXU() {
        return ID_XUATXU;
    }

    public void setID_XUATXU(int ID_XUATXU) {
        this.ID_XUATXU = ID_XUATXU;
    }

    public int getID_NONGDO() {
        return ID_NONGDO;
    }

    public void setID_NONGDO(int ID_NONGDO) {
        this.ID_NONGDO = ID_NONGDO;
    }

    public int getID_NHOMHUONG() {
        return ID_NHOMHUONG;
    }

    public void setID_NHOMHUONG(int ID_NHOMHUONG) {
        this.ID_NHOMHUONG = ID_NHOMHUONG;
    }

    public ChiTietSP(String DOTOHUONG, String THOIGIANNENDUNG, String NAMPHATHANH, int DUNGTICH, int GIOITINH, int LUUHUONG, int ID_SP, int ID_XUATXU, int ID_NONGDO, int ID_NHOMHUONG) {
        this.DOTOHUONG = DOTOHUONG;
        this.THOIGIANNENDUNG = THOIGIANNENDUNG;
        this.NAMPHATHANH = NAMPHATHANH;
        this.DUNGTICH = DUNGTICH;
        this.GIOITINH = GIOITINH;
        this.LUUHUONG = LUUHUONG;
        this.ID_SP = ID_SP;
        this.ID_XUATXU = ID_XUATXU;
        this.ID_NONGDO = ID_NONGDO;
        this.ID_NHOMHUONG = ID_NHOMHUONG;
    }

    public ChiTietSP(int ID_SP, int ID_XUATXU, int ID_NONGDO, int ID_NHOMHUONG, String DOTOHUONG, String THOIGIANNENDUNG, String NAMPHATHANH, int GIOITINH, int LUUHUONG, double GIA, int DUNGTICH, int SOLG, int TRANGTHAI) {
        this.ID_SP = ID_SP;
        this.ID_XUATXU = ID_XUATXU;
        this.ID_NONGDO = ID_NONGDO;
        this.ID_NHOMHUONG = ID_NHOMHUONG;
        this.DOTOHUONG = DOTOHUONG;
        this.THOIGIANNENDUNG = THOIGIANNENDUNG;
        this.NAMPHATHANH = NAMPHATHANH;
        this.GIOITINH = GIOITINH;
        this.LUUHUONG = LUUHUONG;
        this.GIA = GIA;
        this.DUNGTICH = DUNGTICH;
        this.SOLG = SOLG;
        this.TRANGTHAI = TRANGTHAI;
    }

    public ChiTietSP(int IDSANPHAMCHITIET, String DOTOHUONG, String THOIGIANNENDUNG, String NAMPHATHANH, int DUNGTICH, int GIOITINH, int LUUHUONG, int ID_SP, int ID_XUATXU, int ID_NONGDO, int ID_NHOMHUONG) {
        this.IDSANPHAMCHITIET = IDSANPHAMCHITIET;
        this.DOTOHUONG = DOTOHUONG;
        this.THOIGIANNENDUNG = THOIGIANNENDUNG;
        this.NAMPHATHANH = NAMPHATHANH;
        this.DUNGTICH = DUNGTICH;
        this.GIOITINH = GIOITINH;
        this.LUUHUONG = LUUHUONG;
        this.ID_SP = ID_SP;
        this.ID_XUATXU = ID_XUATXU;
        this.ID_NONGDO = ID_NONGDO;
        this.ID_NHOMHUONG = ID_NHOMHUONG;
    }

}
