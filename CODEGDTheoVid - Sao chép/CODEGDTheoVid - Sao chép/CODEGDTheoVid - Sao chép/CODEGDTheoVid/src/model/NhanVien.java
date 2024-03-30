package model;

import java.util.Date;

public class NhanVien {

    private int IDNHANVIEN;
    private String TENNHANVIEN;
    private int GIOITINH;
    private String EMAIL;
    private Date NGAYSINH;
    private String DIACHI; 
    private String SODIENTHOAI; 
    private String TAIKHOAN;
    private String MATKHAU;
    private int CHUCVU;
    private Date NGAYTAO;
    private Date NGAYSUA;
    private int TRANGTHAI;

    public NhanVien() {
    }

    public NhanVien(int IDNHANVIEN, String TENNHANVIEN, int GIOITINH, String EMAIL, Date NGAYSINH, String DIACHI, String SODIENTHOAI, String TAIKHOAN, String MATKHAU, int CHUCVU, Date NGAYTAO, Date NGAYSUA, int TRANGTHAI) {
        this.IDNHANVIEN = IDNHANVIEN;
        this.TENNHANVIEN = TENNHANVIEN;
        this.GIOITINH = GIOITINH;
        this.EMAIL = EMAIL;
        this.NGAYSINH = NGAYSINH;
        this.DIACHI = DIACHI;
        this.SODIENTHOAI = SODIENTHOAI;
        this.TAIKHOAN = TAIKHOAN;
        this.MATKHAU = MATKHAU;
        this.CHUCVU = CHUCVU;
        this.NGAYTAO = NGAYTAO;
        this.NGAYSUA = NGAYSUA;
        this.TRANGTHAI = TRANGTHAI;
    }

    public int getIDNHANVIEN() {
        return IDNHANVIEN;
    }

    public void setIDNHANVIEN(int IDNHANVIEN) {
        this.IDNHANVIEN = IDNHANVIEN;
    }

    public String getTENNHANVIEN() {
        return TENNHANVIEN;
    }

    public void setTENNHANVIEN(String TENNHANVIEN) {
        this.TENNHANVIEN = TENNHANVIEN;
    }

    public int getGIOITINH() {
        return GIOITINH;
    }

    public void setGIOITINH(int GIOITINH) {
        this.GIOITINH = GIOITINH;
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

    public String getDIACHI() {
        return DIACHI;
    }

    public void setDIACHI(String DIACHI) {
        this.DIACHI = DIACHI;
    }

    public String getSODIENTHOAI() {
        return SODIENTHOAI;
    }

    public void setSODIENTHOAI(String SODIENTHOAI) {
        this.SODIENTHOAI = SODIENTHOAI;
    }

    public String getTAIKHOAN() {
        return TAIKHOAN;
    }

    public void setTAIKHOAN(String TAIKHOAN) {
        this.TAIKHOAN = TAIKHOAN;
    }

    public String getMATKHAU() {
        return MATKHAU;
    }

    public void setMATKHAU(String MATKHAU) {
        this.MATKHAU = MATKHAU;
    }

    public int getCHUCVU() {
        return CHUCVU;
    }

    public void setCHUCVU(int CHUCVU) {
        this.CHUCVU = CHUCVU;
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
