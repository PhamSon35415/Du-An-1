/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package service;

import java.util.List;
import model.HoaDonChiTiet;
import repository.HoaDonChiTietRepo;

/**
 *
 * @author duck1
 */
public class HoaDonChiTietService {
    HoaDonChiTietRepo HDCTRepo = new HoaDonChiTietRepo();

    public void InsertHDCT(int IDHOADON, int IDSANPHAMCHITIET, int SOLUONG) {
        int x = HDCTRepo.InsertHoaDonChiTiet(IDHOADON, IDSANPHAMCHITIET, SOLUONG);
    }

    public List<HoaDonChiTiet> getAllHDCT1() {
        return HDCTRepo.getAllHDCT1();
    }

    public List<HoaDonChiTiet> getAllHDCT2(int IDHOADON) {
        return HDCTRepo.getAllHDCT2(IDHOADON);
    }

    public List<HoaDonChiTiet> getAllHDChiTietTheoMa(int IDHOADON) {
        return HDCTRepo.getAllHDCTTheoMa(IDHOADON);
    }

    public void UpdateHDCT_SoLuong(int IDHOADON, int IDSANPHAMCHITIET, int SOLUONG) {
        int x = HDCTRepo.UpdateHDCT_SoLuong(IDHOADON, IDSANPHAMCHITIET, SOLUONG);
    }

    public void DeleteHDCT(int IDHOADON, int IDSANPHAMCHITIET) {
        int x = HDCTRepo.DeleteHDCT(IDHOADON, IDSANPHAMCHITIET);
    }

    public void DeleteAllHDCT(int IDHOADON) {
        int x=HDCTRepo.DeleteAllHDCT(IDHOADON);
    }
}
