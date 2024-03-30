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
public class khachHang {
    
    private int IDKHACHHANG;
    private String TENKHACHHANG;
    private String SODIENTHOAI;
    private String DIACHI;
    private String EMAIL;
    private Date NGAYSINH;
    private int GIOITINH;
    private Date NGAYTAO;
    private Date NGAYSUA;
    private int TRANGTHAI;

    public khachHang() {
    }

    public khachHang(int IDKHACHHANG, String TENKHACHHANG, String SODIENTHOAI, String DIACHI, String EMAIL, Date NGAYSINH, int GIOITINH, Date NGAYTAO, Date NGAYSUA, int TRANGTHAI) {
        this.IDKHACHHANG = IDKHACHHANG;
        this.TENKHACHHANG = TENKHACHHANG;
        this.SODIENTHOAI = SODIENTHOAI;
        this.DIACHI = DIACHI;
        this.EMAIL = EMAIL;
        this.NGAYSINH = NGAYSINH;
        this.GIOITINH = GIOITINH;
        this.NGAYTAO = NGAYTAO;
        this.NGAYSUA = NGAYSUA;
        this.TRANGTHAI = TRANGTHAI;
    }

    public int getIDKHACHHANG() {
        return IDKHACHHANG;
    }

    public void setIDKHACHHANG(int IDKHACHHANG) {
        this.IDKHACHHANG = IDKHACHHANG;
    }

    public String getTENKHACHHANG() {
        return TENKHACHHANG;
    }

    public void setTENKHACHHANG(String TENKHACHHANG) {
        this.TENKHACHHANG = TENKHACHHANG;
    }

    public String getSODIENTHOAI() {
        return SODIENTHOAI;
    }

    public void setSODIENTHOAI(String SODIENTHOAI) {
        this.SODIENTHOAI = SODIENTHOAI;
    }

    public String getDIACHI() {
        return DIACHI;
    }

    public void setDIACHI(String DIACHI) {
        this.DIACHI = DIACHI;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public Date getNGAYSINH() {
        return NGAYSINH;
    }

    public void setNGAYSINH(Date NGAYSINH) {
        this.NGAYSINH = NGAYSINH;
    }

    public int getGIOITINH() {
        return GIOITINH;
    }

    public void setGIOITINH(int GIOITINH) {
        this.GIOITINH = GIOITINH;
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
