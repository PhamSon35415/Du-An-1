
package service;

import java.util.List;
import model.NhanVien;
import repository.NhanVienRepository;

public class NhanVienService {
      NhanVienRepository nhanVienRepo = new NhanVienRepository();
     public List<NhanVien> getAllKhachHang() {
        return nhanVienRepo.getallNhanVien();
    }
     public List<Integer> getAllKhachHang2() {
        return nhanVienRepo.getallIDNhanVien();
    }
     
     
}
