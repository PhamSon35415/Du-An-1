/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package model;

/**
 *
 * @author duck1
 */
public class GioHangChiTiet {
    private int ID_GIOHANG,ID_GIOHANGCHITIET_SANPHAMCHITIET;
    private int SOLUONG,TRANGTHAI;

    public GioHangChiTiet() {
    }

    public GioHangChiTiet(int ID_GIOHANG, int ID_GIOHANGCHITIET_SANPHAMCHITIET, int SOLUONG, int TRANGTHAI) {
        this.ID_GIOHANG = ID_GIOHANG;
        this.ID_GIOHANGCHITIET_SANPHAMCHITIET = ID_GIOHANGCHITIET_SANPHAMCHITIET;
        this.SOLUONG = SOLUONG;
        this.TRANGTHAI = TRANGTHAI;
    }

    public int getID_GIOHANG() {
        return ID_GIOHANG;
    }

    public void setID_GIOHANG(int ID_GIOHANG) {
        this.ID_GIOHANG = ID_GIOHANG;
    }

    public int getID_GIOHANGCHITIET_SANPHAMCHITIET() {
        return ID_GIOHANGCHITIET_SANPHAMCHITIET;
    }

    public void setID_GIOHANGCHITIET_SANPHAMCHITIET(int ID_GIOHANGCHITIET_SANPHAMCHITIET) {
        this.ID_GIOHANGCHITIET_SANPHAMCHITIET = ID_GIOHANGCHITIET_SANPHAMCHITIET;
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
    
}
