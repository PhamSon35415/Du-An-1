/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package service;

import java.util.List;
import model.khachHang;
import repository.KhachHangRepository;

/**
 *
 * @author duck1
 */
public class KhachHangService {

    KhachHangRepository KhachHangRepo = new KhachHangRepository();

    public List<khachHang> getAllKhachHang() {
        return KhachHangRepo.getallKhachHang();
    }
    public List<String> getcbkh() {
        return KhachHangRepo.getcbkh();
    }
    public String InsertKhachHang(khachHang kh) {
        int x = KhachHangRepo.InsertKhachHang(kh);
        if (x < 0) {
            return "Thêm mới thất bại";
        } else {
            return "Thêm mới thành công";
        }
    }

    public String UpdateKhachHang(khachHang kh) {
        int x = KhachHangRepo.UpdateKhachHang(kh);
        if (x >= 0) {
            return "Cập nhật thành công";
        } else {
            return "Cập nhật thất bại";
        }
    }

    public List<khachHang> getAllKhachHangTheoMa(int maKH) {
        return KhachHangRepo.getAllKhachHangTheoMa(maKH);
    }

    public List<khachHang> getAllKhachHangTheoTen(String hoTen) {
        return KhachHangRepo.getAllKhachHangTheoTen(hoTen);
    }

    public List<khachHang> getAllKhachHangTheoSDT(String SDT) {
        return KhachHangRepo.getAllKhachHangTheoSDT(SDT);
    }

    public List<khachHang> getAllKhachHangSapXepTheoNgayTao() {
        return KhachHangRepo.getAllKhachHangSapXepTheoNgayTao();
    }

//    public List<khachHang> getAllKhachHangSXTheoSoHoaDon() {
//        return KhachHangRepo.getAllKhachHangSXTheoSoHoaDon();
//    }
//
//    public List<khachHang> getAllKhachHangSXTheoTongTien() {
//        return KhachHangRepo.getAllKhachHangSXTheoTongTien();
//    }
//
//    public List<khachHang> getAllKhachHangTheoMa(int MaKH) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
}
