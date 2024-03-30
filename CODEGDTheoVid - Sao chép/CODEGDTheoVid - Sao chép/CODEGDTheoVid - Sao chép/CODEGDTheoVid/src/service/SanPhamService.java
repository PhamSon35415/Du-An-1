/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package service;

import java.util.List;
import model.SanPham;
import model.SanPhamMain;
import repository.SanPhamRepository;

/**
 *
 * @author duck1
 */
public class SanPhamService {

    SanPhamRepository SanPhamRepo = new SanPhamRepository();

    public List<SanPhamMain> getAllSanPham() {
        return SanPhamRepo.getAllSanPham();
    }
    
    public List<SanPhamMain> getSearchSanPham(String TENSANPHAM) {
        return SanPhamRepo.getSearchSanPham(TENSANPHAM);
    }

    public void UpdateSoLuong(int SOLUONG, int IDSANPHAMCHITIET) {
        int x = SanPhamRepo.UpdateSoLuong(SOLUONG, IDSANPHAMCHITIET);
    }

    public void UpdateSoLuongVe(int SOLUONG, int IDSANPHAMCHITIET) {
        int x = SanPhamRepo.UpdateSoLuongVe(SOLUONG, IDSANPHAMCHITIET);
    }
    
    public SanPham getSanPhamByMa(String MaSPCT){
        return SanPhamRepo.getSanPhamByMa(MaSPCT);
    }
    
}
