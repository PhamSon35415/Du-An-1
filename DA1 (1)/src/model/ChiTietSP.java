/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Admin
 */
public class ChiTietSP {
    //(ID_SP, ID_XUATXU, ID_NONGDO, ID_NHOMHUONG, DOTOHUONG, THOIGIANNENDUNG, NAMPHATHANH, DUNGTICH, LUUHUONG, NGAYTAO, NGAYSUA, TRANGTHAI
    private int IDChiTiet,IdSanPham, IDXuatXu, IDNongDo, IDNhomHuong;
    private String DoToaHuong, thoiGianLenDung, NamPhatHanh;
    private int  DungTich, LuuHuong;
    private String NgayTao,NgaySua;
    private int TrangThai;

    public int getIDChiTiet() {
        return IDChiTiet;
    }

    public ChiTietSP() {
    }

    public int getIdSanPham() {
        return IdSanPham;
    }

    public void setIdSanPham(int IdSanPham) {
        this.IdSanPham = IdSanPham;
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

   

    public void setIDChiTiet(int IDChiTiet) {
        this.IDChiTiet = IDChiTiet;
    }

   

    public int getIDXuatXu() {
        return IDXuatXu;
    }

    public void setIDXuatXu(int IDXuatXu) {
        this.IDXuatXu = IDXuatXu;
    }

    public int getIDNongDo() {
        return IDNongDo;
    }

    public void setIDNongDo(int IDNongDo) {
        this.IDNongDo = IDNongDo;
    }

    public int getIDNhomHuong() {
        return IDNhomHuong;
    }

    public void setIDNhomHuong(int IDNhomHuong) {
        this.IDNhomHuong = IDNhomHuong;
    }

    public String getDoToaHuong() {
        return DoToaHuong;
    }

    public void setDoToaHuong(String DoToaHuong) {
        this.DoToaHuong = DoToaHuong;
    }

    public String getThoiGianLenDung() {
        return thoiGianLenDung;
    }

    public void setThoiGianLenDung(String thoiGianLenDung) {
        this.thoiGianLenDung = thoiGianLenDung;
    }

    public String getNamPhatHanh() {
        return NamPhatHanh;
    }

    public void setNamPhatHanh(String NamPhatHanh) {
        this.NamPhatHanh = NamPhatHanh;
    }

   

    public int getDungTich() {
        return DungTich;
    }

    public void setDungTich(int DungTich) {
        this.DungTich = DungTich;
    }

    public int getLuuHuong() {
        return LuuHuong;
    }

    public void setLuuHuong(int LuuHuong) {
        this.LuuHuong = LuuHuong;
    }

    public ChiTietSP(int IdSanPham, int IDXuatXu, int IDNongDo, int IDNhomHuong, String DoToaHuong, String thoiGianLenDung, String NamPhatHanh, int DungTich, int LuuHuong, String NgayTao, String NgaySua, int TrangThai) {
        this.IdSanPham = IdSanPham;
        this.IDXuatXu = IDXuatXu;
        this.IDNongDo = IDNongDo;
        this.IDNhomHuong = IDNhomHuong;
        this.DoToaHuong = DoToaHuong;
        this.thoiGianLenDung = thoiGianLenDung;
        this.NamPhatHanh = NamPhatHanh;
        this.DungTich = DungTich;
        this.LuuHuong = LuuHuong;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.TrangThai = TrangThai;
    }

    public ChiTietSP(int IDChiTiet, int IdSanPham, int IDXuatXu, int IDNongDo, int IDNhomHuong, String DoToaHuong, String thoiGianLenDung, String NamPhatHanh, int DungTich, int LuuHuong, String NgayTao, String NgaySua, int TrangThai) {
        this.IDChiTiet = IDChiTiet;
        this.IdSanPham = IdSanPham;
        this.IDXuatXu = IDXuatXu;
        this.IDNongDo = IDNongDo;
        this.IDNhomHuong = IDNhomHuong;
        this.DoToaHuong = DoToaHuong;
        this.thoiGianLenDung = thoiGianLenDung;
        this.NamPhatHanh = NamPhatHanh;
        this.DungTich = DungTich;
        this.LuuHuong = LuuHuong;
        this.NgayTao = NgayTao;
        this.NgaySua = NgaySua;
        this.TrangThai = TrangThai;
    }

    public ChiTietSP(int IdSanPham, int IDXuatXu, int IDNongDo, int IDNhomHuong, String DoToaHuong, String thoiGianLenDung, String NamPhatHanh, int DungTich, int LuuHuong, String NgaySua, int TrangThai) {
        this.IdSanPham = IdSanPham;
        this.IDXuatXu = IDXuatXu;
        this.IDNongDo = IDNongDo;
        this.IDNhomHuong = IDNhomHuong;
        this.DoToaHuong = DoToaHuong;
        this.thoiGianLenDung = thoiGianLenDung;
        this.NamPhatHanh = NamPhatHanh;
        this.DungTich = DungTich;
        this.LuuHuong = LuuHuong;
        this.NgaySua = NgaySua;
        this.TrangThai = TrangThai;
    }

   
    
}
