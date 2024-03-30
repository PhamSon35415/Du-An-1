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
public class PhuongThucThanhToan {
    private String IDPHUONGTHUCTHANHTOAN;
    private String TENPHUONGTHUCTHANHTOAN;
    private Date NGAYTAO;
    private Date NGAYSUA;
    private int TRANGTHAI;

    public PhuongThucThanhToan() {
    }

    public PhuongThucThanhToan(String IDPHUONGTHUCTHANHTOAN, String TENPHUONGTHUCTHANHTOAN, Date NGAYTAO, Date NGAYSUA, int TRANGTHAI) {
        this.IDPHUONGTHUCTHANHTOAN = IDPHUONGTHUCTHANHTOAN;
        this.TENPHUONGTHUCTHANHTOAN = TENPHUONGTHUCTHANHTOAN;
        this.NGAYTAO = NGAYTAO;
        this.NGAYSUA = NGAYSUA;
        this.TRANGTHAI = TRANGTHAI;
    }

    public String getIDPHUONGTHUCTHANHTOAN() {
        return IDPHUONGTHUCTHANHTOAN;
    }

    public void setIDPHUONGTHUCTHANHTOAN(String IDPHUONGTHUCTHANHTOAN) {
        this.IDPHUONGTHUCTHANHTOAN = IDPHUONGTHUCTHANHTOAN;
    }

    public String getTENPHUONGTHUCTHANHTOAN() {
        return TENPHUONGTHUCTHANHTOAN;
    }

    public void setTENPHUONGTHUCTHANHTOAN(String TENPHUONGTHUCTHANHTOAN) {
        this.TENPHUONGTHUCTHANHTOAN = TENPHUONGTHUCTHANHTOAN;
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
