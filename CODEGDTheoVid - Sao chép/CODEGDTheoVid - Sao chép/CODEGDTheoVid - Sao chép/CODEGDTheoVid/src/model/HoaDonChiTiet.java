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
public class HoaDonChiTiet {

    public HoaDonChiTiet(int IDHOADON, int IDSANPHAMCHITIET, int SOLUONG, String TENSANPHAM, double GIA, double THANHTIEN, int TRANGTHAI) {
        this.IDHOADON = IDHOADON;
        this.IDSANPHAMCHITIET = IDSANPHAMCHITIET;
        this.SOLUONG = SOLUONG;
        this.TRANGTHAI = TRANGTHAI;
        this.TENSANPHAM = TENSANPHAM;
        this.THANHTIEN = THANHTIEN;
        this.GIA = GIA;
    }

    public HoaDonChiTiet(int IDSANPHAMCHITIET, int SOLUONG, int TRANGTHAI, String TENSANPHAM, double GIA) {
        this.IDSANPHAMCHITIET = IDSANPHAMCHITIET;
        this.SOLUONG = SOLUONG;
        this.TRANGTHAI = TRANGTHAI;
        this.TENSANPHAM = TENSANPHAM;
        this.GIA = GIA;
    }
   private int IDHOADON,IDSANPHAMCHITIET,SOLUONG,TRANGTHAI;
   private String TENSANPHAM;
   private double THANHTIEN,GIA;

    public String trangthathd() {
        String x;
        x = switch (TRANGTHAI) {
            case 0 ->
                "Đã hủy";
            case 1 ->
                "Chưa thanh toán";
            case 2 ->
                "Đã thanh toán";
            default ->
                "Trạng thái không xác định";
        };
        return x;
    }
   public Object[] torow(){
       return new Object[]{
           IDHOADON,IDSANPHAMCHITIET,SOLUONG,TENSANPHAM,THANHTIEN,GIA,trangthathd()
       };
   }
    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int IDHOADON, int IDSANPHAMCHITIET, int SOLUONG, int TRANGTHAI, double GIA,double THANHTIEN,String TENSANPHAM) {
        this.IDHOADON = IDHOADON;
        this.IDSANPHAMCHITIET = IDSANPHAMCHITIET;
        this.SOLUONG = SOLUONG;
        this.TRANGTHAI = TRANGTHAI;
        this.GIA = GIA;
    }

    public String getTENSANPHAM() {
        return TENSANPHAM;
    }

    public void setTENSANPHAM(String TENSANPHAM) {
        this.TENSANPHAM = TENSANPHAM;
    }

    public int getIDHOADON() {
        return IDHOADON;
    }

    public double getTHANHTIEN() {
        return THANHTIEN;
    }

    public void setTHANHTIEN(double THANHTIEN) {
        this.THANHTIEN = THANHTIEN;
    }
    public void setIDHOADON(int IDHOADON) {
        this.IDHOADON = IDHOADON;
    }

    public int getIDSANPHAMCHITIET() {
        return IDSANPHAMCHITIET;
    }

    public void setIDSANPHAMCHITIET(int IDSANPHAMCHITIET) {
        this.IDSANPHAMCHITIET = IDSANPHAMCHITIET;
    }

    public int getSOLUONG() {
        return SOLUONG;
    }

    public void setSOLUONG(int SOLUONG) {
        this.SOLUONG = SOLUONG;
    }

    public int getTRANGTHAI() {
        return TRANGTHAI;
    }

    public void setTRANGTHAI(int TRANGTHAI) {
        this.TRANGTHAI = TRANGTHAI;
    }

    public double getGIA() {
        return GIA;
    }

    public void setGIA(double GIA) {
        this.GIA = GIA;
    }
   
    
}
