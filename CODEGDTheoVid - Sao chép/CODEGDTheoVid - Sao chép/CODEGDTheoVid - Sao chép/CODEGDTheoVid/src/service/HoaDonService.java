/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package service;

import java.util.List;
import model.HoaDon;
import repository.HoaDonRepository;

/**
 *
 * @author duck1
 */
public class HoaDonService {

    HoaDonRepository hdRepo = new HoaDonRepository();
    public int layphantucuoi(){
        return hdRepo.layphantucuoi();
    }
    public void InsertHoaDon(HoaDon hd) {
        int x = hdRepo.InsertHoaDon(hd);
    }

    public void UpdateHoaDon(double TONGTIEN, double GiamGia, double THANHTIEN, int IDHOADON) {
        int x = hdRepo.UpdateHoaDon(TONGTIEN, GiamGia, THANHTIEN, IDHOADON);
    }

    public List<HoaDon> getDSHoaDonCho() {
        return hdRepo.getAllHoaDonCho();
    }

    public List<HoaDon> getAllHoaDon() {
        return hdRepo.getAllHoaDon();
    }

    public void UpdateTrangThai(int TRANGTHAI, int IDHOADON) {
        int x = hdRepo.UpdateTrangThai(TRANGTHAI, IDHOADON);
    }

    public void UpdateHoaDonTT(HoaDon hd) {
        int x = hdRepo.UpdateHoaDonTT(hd);
    }

    public void InsertHoaDonKHnull(HoaDon hd) {
        int x = hdRepo.InsertHoaDonKHnull(hd);
    }
    

}
