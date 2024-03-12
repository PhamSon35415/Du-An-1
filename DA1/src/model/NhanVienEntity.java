/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class NhanVienEntity {

    public NhanVienEntity() {
    }
    private int IDNV;
    private String MaNV,TenNV;
    private int GioiTinh;
    private String EmailNV;
    private int ChucVu;
    private String NgaySinh,DiaChi,SoDT,TaiKhoan,MatKhau,NgayTao,NgaySua;
    private int TrangThai;
    public Object[] torow(){
        String tt=null;
        if(TrangThai==0){
            tt="Đã nghỉ việc";
        }else if(TrangThai==1){
            tt="Vẫn làm";
        }else{
            tt="Không biết";
        }
        return new Object[]{
            MaNV,TenNV,GioiTinh,EmailNV,getVaiTro(),NgaySinh,DiaChi,SoDT,TaiKhoan,MatKhau,NgayTao,NgaySua,tt
        };
    }
    public String getVaiTro(){
        String result=null;
        if(ChucVu==0){
            result= "Nhân viên";
        }else if(ChucVu==1){
            result= "Trưởng phòng";
        }
        return result;
    }

    public NhanVienEntity(int IDNV, String MaNV, String TenNV, int GioiTinh, String EmailNV, int ChucVu, String NgaySinh, String DiaChi, String SoDT, String TaiKhoan, String MatKhau, String NgayTao, String NgaySua, int TrangThai) {
        this.IDNV = IDNV;
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.GioiTinh = GioiTinh;
        this.EmailNV = EmailNV;
        this.ChucVu = ChucVu;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
        this.SoDT = SoDT;
        this.TaiKhoan = TaiKhoan;
        this.MatKhau = MatKhau;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.TrangThai = TrangThai;
    }

    public NhanVienEntity(String MaNV, String TenNV, int GioiTinh, String EmailNV, int ChucVu, String NgaySinh, String DiaChi, String SoDT, String TaiKhoan, String MatKhau, String NgayTao, String NgaySua, int TrangThai) {
        this.MaNV = MaNV;
        this.TenNV = TenNV;
        this.GioiTinh = GioiTinh;
        this.EmailNV = EmailNV;
        this.ChucVu = ChucVu;
        this.NgaySinh = NgaySinh;
        this.DiaChi = DiaChi;
        this.SoDT = SoDT;
        this.TaiKhoan = TaiKhoan;
        this.MatKhau = MatKhau;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.TrangThai = TrangThai;
    }

    public int getIDNV() {
        return IDNV;
    }

    public void setIDNV(int IDNV) {
        this.IDNV = IDNV;
    }

    public String getMaNV() {
        return MaNV;
    }

    public void setMaNV(String MaNV) {
        this.MaNV = MaNV;
    }

    public String getTenNV() {
        return TenNV;
    }

    public void setTenNV(String TenNV) {
        this.TenNV = TenNV;
    }

    public int getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(int GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getEmailNV() {
        return EmailNV;
    }

    public void setEmailNV(String EmailNV) {
        this.EmailNV = EmailNV;
    }

    public int getChucVu() {
        return ChucVu;
    }

    public void setChucVu(int ChucVu) {
        this.ChucVu = ChucVu;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getDiaChi() {
        return DiaChi;
    }

    public void setDiaChi(String DiaChi) {
        this.DiaChi = DiaChi;
    }

    public String getSoDT() {
        return SoDT;
    }

    public void setSoDT(String SoDT) {
        this.SoDT = SoDT;
    }

    public String getTaiKhoan() {
        return TaiKhoan;
    }

    public void setTaiKhoan(String TaiKhoan) {
        this.TaiKhoan = TaiKhoan;
    }

    public String getMatKhau() {
        return MatKhau;
    }

    public void setMatKhau(String MatKhau) {
        this.MatKhau = MatKhau;
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
    

}
