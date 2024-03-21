/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.HoaDonChiTiet;

/**
 *
 * @author Admin
 */
public class HoaDonChiTietDao extends SysDAO<HoaDonChiTiet, String> {

    @Override
    public int insert(HoaDonChiTiet entity) {
        String sql = "INSERT INTO HOADONCHITIET (ID_HOADON, ID_SANPHAMCHITIET, TENSANPHAM, GIABAN, SOLUONG, TONGTIEN, NGAYTAO, NGAYSUA, TRANGTHAI) VALUES (?,?,?,?,?, ?, ?,?, ?)";
        return DBConnect.update(sql,
                entity.getIDHD(),
                entity.getIDSpCt(),
                entity.getTenSanPham(),
                entity.getGiaBan(),
                entity.getSoLg(),
                entity.getTongTien(),
                entity.getNgayTao(),
                entity.getNgaySua(),
                entity.getTrangThai());
    }

    @Override
    public int update(HoaDonChiTiet entity, String ma) {
        String sql = "update HOADONCHITIET set ID_HOADON=?, ID_SANPHAMCHITIET=?, TENSANPHAM=?, GIABAN=?, SOLUONG=?, TONGTIEN=?, NGAYTAO=?, NGAYSUA=?, TRANGTHAI=? where IDHOADONCHITIET like ?";
        return DBConnect.update(
                sql,
                entity.getIDHD(),
                entity.getIDSpCt(),
                entity.getTenSanPham(),
                entity.getGiaBan(),
                entity.getSoLg(),
                entity.getTongTien(),
                entity.getNgayTao(),
                entity.getNgaySua(),
                entity.getTrangThai(),
                ma
        );
    }

    @Override
    public int delete(String id) {
        String sql = "DELETE FROM HOADONCHITIET where IDHOADONCHITIET like ?";
        return DBConnect.update(sql, id);
    }

    @Override
    public HoaDonChiTiet selectById(String id) {
        String sql = """
                     select IDHOADONCHITIET,ID_HOADON, ID_SANPHAMCHITIET, TENSANPHAM, GIABAN, SOLUONG, TONGTIEN, NGAYTAO, NGAYSUA, TRANGTHAI from HOADONCHITIET where IDHOADONCHITIET like ?""";
        List<HoaDonChiTiet> list = selectBySql(sql, id);
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public List<HoaDonChiTiet> selectAll() {
        String sql = "select IDHOADONCHITIET,ID_HOADON, ID_SANPHAMCHITIET, TENSANPHAM,SOLUONG, GIABAN, TONGTIEN, NGAYTAO, NGAYSUA, TRANGTHAI from HOADONCHITIET";
        return selectBySql(sql);
    }

//    private int IDHD,IDKhacHang, IDNhanVien, IDPhuongThucThanhToan, IDVoucher;
//    private double TongTien;
//    private String NgayTao, NgaySua;
//    private int TrangThai;
    @Override
    protected List<HoaDonChiTiet> selectBySql(String sql, Object... args) {
        List<HoaDonChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = DBConnect.query(sql, args);
                while (rs.next()) {
                    HoaDonChiTiet xs = new HoaDonChiTiet(
                            rs.getInt(1), 
                            rs.getInt(2),
                            rs.getInt(3),
                            rs.getString(4),
                            rs.getInt(5),
                            rs.getDouble(6),
                            rs.getDouble(7),
                            rs.getString(8),
                            rs.getString(9),
                            rs.getInt(10));

                    list.add(xs);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return list;
    }

}
