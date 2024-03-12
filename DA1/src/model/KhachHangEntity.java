/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class KhachHangEntity {
    private int IDKH;
    private String MaKH,TenKH,SoDT,DiaChi,NgaySinh,EmailKH;
    private int GioiTinh;
    private String NgayTao,NgaySua;
    private int TrangThai;
    public String gioitinh() {
        String gt = "";
        if (GioiTinh == 0) {
            gt = "Nam";
        }else if (GioiTinh == 1) {
            gt = "Nữ";
        }else if(GioiTinh==2){
            gt="Không xác định";
        }
        return gt;
    }
    public String trangthai(){
        String tt=null;
        if(TrangThai==0){
            tt="KO HD";
        }else if(TrangThai==1){
            tt="Vẫn HD";
        }else{
            tt="Không biết";
        }
        return tt;
    } 
    public Object[] torow(){
        
        return new Object[]{
            MaKH,TenKH,SoDT,DiaChi,NgaySinh,EmailKH,gioitinh(),NgayTao,NgaySua,trangthai()
        };
    }
    public KhachHangEntity(String MaKH, String TenKH, String SoDT, String DiaChi, String NgaySinh, String EmailKH, int GioiTinh, String NgayTao, String NgaySua, int TrangThai) {
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.SoDT = SoDT;
        this.DiaChi = DiaChi;
        this.NgaySinh = NgaySinh;
        this.EmailKH = EmailKH;
        this.GioiTinh = GioiTinh;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.TrangThai = TrangThai;
    }

    public KhachHangEntity() {
    }

    public int getIDKH() {
        return IDKH;
    }

    public void setIDKH(int IDKH) {
        this.IDKH = IDKH;
    }

    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String MaKH) {
        this.MaKH = MaKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String TenKH) {
        this.TenKH = TenKH;
    }

    public String getSoDT() {
        return SoDT;
    }

    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getEmailKH() {
        return EmailKH;
    }

    public void setEmailKH(String EmailKH) {
        this.EmailKH = EmailKH;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
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

    public KhachHangEntity(int IDKH, String MaKH, String TenKH, String SoDT, String DiaChi, String NgaySinh, String EmailKH, int GioiTinh, String NgayTao, String NgaySua, int TrangThai) {
        this.IDKH = IDKH;
        this.MaKH = MaKH;
        this.TenKH = TenKH;
        this.SoDT = SoDT;
        this.DiaChi = DiaChi;
        this.NgaySinh = NgaySinh;
        this.EmailKH = EmailKH;
        this.GioiTinh = GioiTinh;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.TrangThai = TrangThai;
    }

    
}
