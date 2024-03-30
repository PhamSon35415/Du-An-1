/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package service;

import java.util.List;
import model.Voucher;
import repository.VoucherRepository;

/**
 *
 * @author duck1
 */
public class VoucherService {
    VoucherRepository khuyenMaiRepo = new VoucherRepository();

    public List<Voucher> getAllKhuyenMai() {
        return khuyenMaiRepo.getAllKhuyenMai();
    }

    public List<Voucher> getAllKhuyenMaiTheoSoHDAP() {
        return khuyenMaiRepo.getAllKhuyenMaiTheoSoHDAP();
    }
    
    public List<Voucher> getAllKhuyenMaiTheoNgayKetThuc() {
        return khuyenMaiRepo.getAllKhuyenMaiTheoNgayKetThuc();
    }
    
    public List<Voucher> getAllKhuyenMaiByMa(String MaKhuyenMai) {
        return khuyenMaiRepo.getAllKhuyenMaiByMa(MaKhuyenMai);
    }

    public List<Voucher> getAllKhuyenMaiByTrangThai(int TrangThai) {
        return khuyenMaiRepo.getAllKhuyenMaiByTrangThai(TrangThai);
    }
    
    public List<Voucher> getAllKhuyenMaiTheo_SoHDAP_TT(int TrangThai) {
        return khuyenMaiRepo.getAllKhuyenMaiTheo_SoHDAP_TT(TrangThai);
    }
    
    public List<Voucher> getAllKhuyenMaiTheo_NgayKetThuc_TT(int TrangThai) {
        return khuyenMaiRepo.getAllKhuyenMaiTheo_NgayKetThuc_TT(TrangThai);
    }
    
    public String InsertKhuyenMai(Voucher km) {
        int x = khuyenMaiRepo.InsertKhuyenMai(km);
        if (x >= 0) {
            return "Thêm thành công";
        } else {
            return "Thêm thất bại";
        }
    }

    public String UpdateKhuyenMai(Voucher km) {
        int x = khuyenMaiRepo.UpdateKhuyenMai(km);
        if (x >= 0) {
            return "Cập nhật thành công";
        } else {
            return "Cập nhật thất bại";
        }
    }

    public void UpdateTrangThaiKM(Voucher km) {
        int x = khuyenMaiRepo.UpdateTrangThaiKM(km);
    }
    
    public void UpdateSoLuongKhuyenMai(Voucher km) {
        int x=khuyenMaiRepo.UpdateSoLuongKhuyenMai(km);
    }
    
    public String UpdateTrangThaiKMTrucTiep(String MaKhuyenMai) {
        int x=khuyenMaiRepo.UpdateTrangThaiKMTrucTiep(MaKhuyenMai);
        if (x >= 0) {
            return "Kết thúc khuyến mãi thành công";
        } else {
            return "Kết thúc khuyến mãi thất bại";
        }
    }
    
}
