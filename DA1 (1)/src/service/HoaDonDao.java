/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.*;

/**
 *
 * @author Admin
 */
public class HoaDonDao extends SysDAO<HoaDon, String> {

    public List<String> getkh() {
        List<String> list = new ArrayList<>();
        String sql = "select IDKHACHHANG,TENKHACHHANG FROM KHACHHANG ";
        try {
            ResultSet rs = null;
            try {
                rs = DBConnect.query(sql);
                while (rs.next()) {
                    list.add(rs.getString(2));
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    public String getTenNV(int ma) {
        String sql = "select TENNHANVIEN FROM NHANVIEN where IDNHANVIEN like ?";
        String x = null;
        x = getTen(sql, ma);
        return x;
    }

    public String getTenKH(int ma) {
        String sql = "select TENKHACHHANG FROM KHACHHANG where IDKHACHHANG like ?";
        String x = null;
        x = getTen(sql, ma);
        return x;
    }

    public String getTenPT(int ma) {
        String sql = "select TENPHUONGTHUCTHANHTOAN FROM PHUONGTHUCTHANHTOAN  where IDPHUONGTHUCTHANHTOAN like ?";
        String x = null;
        x = getTen(sql, ma);
        return x;
    }

    public int getidNV(String ma) {
        String sql = "select IDNHANVIEN FROM NHANVIEN where TENNHANVIEN = ?";
        return getid(sql, ma);
    }

    public int getidKh(String ma) {
        String sql = "select IDKHACHHANG FROM KHACHHANG where TENKHACHHANG = ?";
        return getid(sql, ma);
    }

    public int getidPT(String ma) {
        String sql = "select IDPHUONGTHUCTHANHTOAN FROM PHUONGTHUCTHANHTOAN where TENPHUONGTHUCTHANHTOAN = ?";
        return getid(sql, ma);
    }

    public int getidVC(String ma) {
        String sql = "select IDVOUCHER FROM VOUCHER where MAVOUCHER = ?";
        return getid(sql, ma);
    }

    public int getid(String sql, String ma) {
        int x = 0;
        try {
            ResultSet rs = null;
            try {
                rs = DBConnect.query(sql, ma);
                while (rs.next()) {
                    x = rs.getInt(1);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
            return x;
        } catch (SQLException ex) {
            return 0;
        }
    }

    public String getTen(String sql, int ma) {
        String x = null;
        try {
            ResultSet rs = null;
            try {
                rs = DBConnect.query(sql, ma);
                while (rs.next()) {
                    x = rs.getString(1);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
            return x;
        } catch (SQLException ex) {
            return null;
        }
    }

    public String getTenVC(int ma) {
        String sql = "select MAVOUCHER FROM VOUCHER where IDVOUCHER = ?";
        String x =  getTen(sql, ma);
         return x;
    }

    public List<String> getNV() {
        List<String> list = new ArrayList<>();
        String sql = "select IDNHANVIEN,TENNHANVIEN FROM NHANVIEN ";
        try {
            ResultSet rs = null;
            try {
                rs = DBConnect.query(sql);
                while (rs.next()) {
                    list.add(rs.getString(2));
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    public List<String> getPhuongTT() {
        List<String> list = new ArrayList<>();
        String sql = "select IDPHUONGTHUCTHANHTOAN,TENPHUONGTHUCTHANHTOAN FROM PHUONGTHUCTHANHTOAN ";
        try {
            ResultSet rs = null;
            try {
                rs = DBConnect.query(sql);
                while (rs.next()) {
                    list.add(rs.getString(2));
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
            return list;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public int insert(HoaDon entity) {
        String sql = "INSERT INTO HOADON (IDHOADON,ID_KHACHHANG, ID_NHANVIEN,  ID_PHUONGTHUCTHANHTOAN,ID_VOUCHER, TONGTIEN, NGAYTAO, NGAYSUA, TRANGTHAI) VALUES (?,?,?,?,?, ?, ?, ?)";
        return DBConnect.update(sql,
                entity.getIDHD(),
                entity.getIDKhacHang(),
                entity.getIDNhanVien(),
                entity.getIDVoucher(),
                entity.getIDPhuongThucThanhToan(),
                entity.getTongTien(),
                entity.getNgayTao(),
                entity.getNgaySua(),
                entity.getTrangThai());
    }

    public int updateTrangthai(int tt, String ma) {
        String sql = "update HOADON set TRANGTHAI=? where IDHOADON like ?";
        return DBConnect.update(
                sql,
                tt,
                ma
        );
    }

    @Override
    public int update(HoaDon entity, String ma) {
        String sql = "update HOADON set ID_KHACHHANG=?, ID_NHANVIEN=?, ID_PHUONGTHUCTHANHTOAN=?,ID_VOUCHER=?, TONGTIEN=?, NGAYSUA=?, TRANGTHAI=? where IDHOADON = ?";
        return DBConnect.update(
                sql,
                entity.getIDKhacHang(),
                entity.getIDNhanVien(),
                entity.getIDPhuongThucThanhToan(),
                entity.getIDVoucher(),
                entity.getTongTien(),
                entity.getNgaySua(),
                entity.getTrangThai(),
                ma
        );
        //idkh, idnv, idpt, idvc2, tongtien, ngaytao, 1
    }

    @Override
    public int delete(String id) {
        String sql = "DELETE FROM HOADON where IDHOADON like ?";
        return DBConnect.update(sql, id);
    }

    public List<HoaDon> selectById2(String hd, String kh, String nv) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<HoaDon> list = new ArrayList<>();
        String sql = """
                     select IDHOADON,HD.ID_KHACHHANG, HD.ID_NHANVIEN, HD.ID_PHUONGTHUCTHANHTOAN ,HD.ID_VOUCHER,TONGTIEN,HD.NGAYTAO, HD.NGAYSUA, HD.TRANGTHAI  
                     from HOADON HD join NHANVIEN NV on HD.ID_NHANVIEN=NV.IDNHANVIEN join KHACHHANG kh on HD.ID_KHACHHANG=kh.IDKHACHHANG
                     join PHUONGTHUCTHANHTOAN pt on pt.IDPHUONGTHUCTHANHTOAN=HD.ID_PHUONGTHUCTHANHTOAN join VOUCHER vc on vc.IDVOUCHER=HD.ID_VOUCHER 
                     where IDHOADON like ? or TENKHACHHANG like ? or TENNHANVIEN like ?""";
        try {
            conn = DBConnect.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1, "%" + hd + "%");
            ps.setObject(2, "%" + kh + "%");
            ps.setObject(3, "%" + nv + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon xs = new HoaDon(
                        rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getDouble(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getInt(9));

                list.add(xs);
            }
            return list;
        } catch (SQLException e) {
            return null;
        }
    }

    @Override
    public HoaDon selectById(String hd) {
        String sql = """
                     select IDHOADON,HD.ID_KHACHHANG, HD.ID_NHANVIEN, HD.ID_PHUONGTHUCTHANHTOAN, HD.ID_VOUCHER,TONGTIEN,HD.NGAYTAO, HD.NGAYSUA, HD.TRANGTHAI  
                     from HOADON HD join NHANVIEN NV on HD.ID_NHANVIEN=NV.IDNHANVIEN join KHACHHANG kh on HD.ID_KHACHHANG=kh.IDKHACHHANG
                     where IDHOADON like ? or TENKHACHHANG like ? or TENNHANVIEN like ?""";
        List<HoaDon> list = selectBySql(sql, hd);
        return !list.isEmpty() ? list.get(0) : null;
    }
//"IDHD", "Tên khách hàng", "Tên nhân viên", "Phương thức thanh toán", "VocCher", "Tổng tiền", "Ngày tạo", "Ngày Sửa", "Trạng thái"
    //IDHOADON,ID_KHACHHANG, ID_NHANVIEN,  ID_PHUONGTHUCTHANHTOAN,ID_VOUCHER, TONGTIEN, NGAYTAO, NGAYSUA, TRANGTHAI
    @Override
    public List<HoaDon> selectAll() {
        String sql = """
                     select IDHOADON,ID_KHACHHANG, ID_NHANVIEN,  ID_PHUONGTHUCTHANHTOAN,ID_VOUCHER, TONGTIEN, NGAYTAO, NGAYSUA, TRANGTHAI 
                     from HOADON""";
        return selectBySql(sql);
    }
    public List<HoaDon> sapxep(int index,List<HoaDon> list){
        List<HoaDon> result = list;
        if (index == 2) {
            Collections.sort(result, (hd1, hd2) -> Double.compare(hd2.getTongTien(), hd1.getTongTien()));
        } else if (index == 1) {
            Collections.sort(result, (hd1, hd2) -> Double.compare(hd1.getTongTien(), hd2.getTongTien()));
        }else if(index==0){
            Collections.sort(result, (hd1, hd2) -> Double.compare(hd1.getIDHD(), hd2.getIDHD()));
        }
        return result;
    }
    public List<HoaDon> trangthai(int index,List<HoaDon> list){
        List<HoaDon> result=new ArrayList<>();
        //0:Da huy,1 Chua thanh toan, 2:da thanhtoan ,3:Dang giao,4:Da giao
        if (index != -1) {
            for (HoaDon hoaDon : list) {
                if(hoaDon.getTrangThai()==index){
                    result.add(hoaDon);
                }
            }
        }else{
            return list;
        }
        return result;
    }

    public List<HoaDon> selectByTrangThai(int hd) {
        String sql;
        if (hd != -1) {
            sql = "select IDHOADON,ID_KHACHHANG, ID_NHANVIEN,  ID_PHUONGTHUCTHANHTOAN,ID_VOUCHER, TONGTIEN, NGAYTAO, NGAYSUA, TRANGTHAI from HOADON where TRANGTHAI = ?";
            return selectBySql(sql, hd);
        } else {
            return selectAll();
        }

    }

    public List<HoaDon> selectByNgay(String tungay, String denngay) {
        String sql = """
                     select IDHOADON,ID_KHACHHANG, ID_NHANVIEN,  ID_PHUONGTHUCTHANHTOAN,ID_VOUCHER, TONGTIEN, NGAYTAO, NGAYSUA, TRANGTHAI 
                     from HOADON where NGAYTAO BETWEEN ? AND ?;""";
        return selectBySql(sql, tungay, denngay);
    }

    public List<HoaDon> sapxeptien(int x) {
        String sql;
        sql = switch (x) {
            case 1 ->
                "select IDHOADON,ID_KHACHHANG, ID_NHANVIEN,  ID_PHUONGTHUCTHANHTOAN,ID_VOUCHER, TONGTIEN, NGAYTAO, NGAYSUA, TRANGTHAI from HOADON ORDER BY TONGTIEN ASC";
            case 2 ->
                "select IDHOADON,ID_KHACHHANG, ID_NHANVIEN,  ID_PHUONGTHUCTHANHTOAN,ID_VOUCHER, TONGTIEN, NGAYTAO, NGAYSUA, TRANGTHAI from HOADON ORDER BY TONGTIEN desc";
            default ->
                "select IDHOADON,ID_KHACHHANG, ID_NHANVIEN, ID_VOUCHER, ID_PHUONGTHUCTHANHTOAN, TONGTIEN, NGAYTAO, NGAYSUA, TRANGTHAI from HOADON";
        };
        return selectBySql(sql);
    }

    @Override
    protected List<HoaDon> selectBySql(String sql, Object... args) {
        List<HoaDon> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = DBConnect.query(sql, args);
                while (rs.next()) {
                    HoaDon xs = new HoaDon(
                            rs.getInt(1),
                            rs.getInt(2),
                            rs.getInt(3),
                            rs.getInt(4),
                            rs.getInt(5),
                            rs.getDouble(6),
                            rs.getString(7),
                            rs.getString(8),
                            rs.getInt(9));

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
