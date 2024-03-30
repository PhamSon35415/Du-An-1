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
public class SanPham {

    private int IDSANPHAM;
    private int SOLUONG;
    private String TENSANPHAM;
    private Date NGAYTAO;
    private Date NGAYSUA;
    private int TRANGTHAI;
//IDSANPHAM, SOLUONG, TENSANPHAM, NGAYTAO, NGAYSUA, TRANGTHAI
    public Object[] torow() {
        String x = null;
        if (TRANGTHAI == 1) {
            x = "Còn hàng";
        } else {
            x = "Hết hàng";
        }
        return new Object[]{
            IDSANPHAM,TENSANPHAM,SOLUONG,NGAYTAO,NGAYSUA, x
        };
    }

    public int getIDSANPHAM() {
        return IDSANPHAM;
    }

    public void setIDSANPHAM(int IDSANPHAM) {
        this.IDSANPHAM = IDSANPHAM;
    }

    public int getSOLUONG() {
        return SOLUONG;
    }

    public void setSOLUONG(int SOLUONG) {
        this.SOLUONG = SOLUONG;
    }

    public String getTENSANPHAM() {
        return TENSANPHAM;
    }

    public void setTENSANPHAM(String TENSANPHAM) {
        this.TENSANPHAM = TENSANPHAM;
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

    public SanPham(int IDSANPHAM, int SOLUONG, String TENSANPHAM, Date NGAYTAO, Date NGAYSUA, int TRANGTHAI) {
        this.IDSANPHAM = IDSANPHAM;
        this.SOLUONG = SOLUONG;
        this.TENSANPHAM = TENSANPHAM;
        this.NGAYTAO = NGAYTAO;
        this.NGAYSUA = NGAYSUA;
        this.TRANGTHAI = TRANGTHAI;
    }
        public SanPham(int IDSANPHAM, int SOLUONG, String TENSANPHAM, Date NGAYSUA, int TRANGTHAI) {
        this.IDSANPHAM = IDSANPHAM;
        this.SOLUONG = SOLUONG;
        this.TENSANPHAM = TENSANPHAM;
        this.NGAYSUA = NGAYSUA;
        this.TRANGTHAI = TRANGTHAI;
    }

    public SanPham(int SOLUONG, String TENSANPHAM, int TRANGTHAI) {
        this.SOLUONG = SOLUONG;
        this.TENSANPHAM = TENSANPHAM;
        this.TRANGTHAI = TRANGTHAI;
    }

    public SanPham() {
    }

}
