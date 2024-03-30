package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Statement;
import java.util.List;
import model.khachHang;
import JDBC.jdbc;

public class KhachHangRepository {

    public List<khachHang> getallKhachHang() {
        List<khachHang> listKH = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT * FROM KhachHang";
            conn = jdbc.getConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                khachHang kh = new khachHang();
                kh.setIDKHACHHANG(rs.getInt(1));
                kh.setTENKHACHHANG(rs.getString(2));
                kh.setSODIENTHOAI(rs.getString(3));
                kh.setDIACHI(rs.getString(4));
                kh.setEMAIL(rs.getString(5));
                kh.setNGAYSINH(rs.getDate(6));
                kh.setGIOITINH(rs.getInt(7));
                kh.setNGAYTAO(rs.getDate(8));
                kh.setNGAYSUA(rs.getDate(9));
                kh.setTRANGTHAI(rs.getInt(10));
                listKH.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            rs.close();
            sttm.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKH;
    }

    public int InsertKhachHang(khachHang kh) {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "INSERT INTO KhachHang(IDKHACHHANG,TENKHACHHANG,SODIENTHOAI,DIACHI,EMAIL,NGAYSINH,GIOITINH,NGAYTAO,NGAYSUA,TRANGTHAI)"
                    + " VALUES(?,?,?,?,?,?,?,GETDATE(),GETDATE(),?);";
            conn = jdbc.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setInt(1, kh.getIDKHACHHANG());
            sttm.setString(2, kh.getTENKHACHHANG());
            sttm.setString(3, kh.getSODIENTHOAI());
            sttm.setString(4, kh.getDIACHI());
            sttm.setString(5, kh.getEMAIL());
            java.util.Date utilDate = kh.getNGAYSINH();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            sttm.setDate(6, sqlDate);
            sttm.setInt(7, kh.getGIOITINH());

            sttm.setInt(8, kh.getTRANGTHAI());
            return sttm.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        try {
            sttm.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int UpdateKhachHang(khachHang kh) {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "UPDATE KhachHang SET IDKHACHHANG = ?,TENKHACHHANG= ?,SODIENTHOAI= ?,DIACHI= ?,EMAIL= ?,NGAYSINH= ?,GIOITINH= ?,TRANGTHAI= ?\n"
                    + "WHERE IDKHACHHANG = ?";
            conn = jdbc.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setInt(1, kh.getIDKHACHHANG());
            sttm.setString(2, kh.getTENKHACHHANG());
            sttm.setString(3, kh.getSODIENTHOAI());
            sttm.setString(4, kh.getDIACHI());
            sttm.setString(5, kh.getEMAIL());
            java.util.Date utilDate = kh.getNGAYSINH();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            sttm.setDate(6, sqlDate);
            sttm.setInt(7, kh.getGIOITINH());
            sttm.setInt(8, kh.getTRANGTHAI());
            sttm.setInt(9, kh.getIDKHACHHANG());
            return sttm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            sttm.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return -1;
    }

    public List<khachHang> getAllKhachHangTheoTen(String hoTen) {
        List<khachHang> listKH = new ArrayList<>();
        Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT * FROM KHACHHANG\n"
                    + "WHERE TENKHACHHANG like '%" + hoTen + "%'";
            conn = jdbc.getConnection();
            sttm = conn.prepareStatement(sSQL);
            rs = sttm.executeQuery();
            while (rs.next()) {
                khachHang kh = new khachHang();
                kh.setIDKHACHHANG(rs.getInt(1));
                kh.setTENKHACHHANG(rs.getNString(2));
                kh.setSODIENTHOAI(rs.getString(3));
                kh.setDIACHI(rs.getNString(4));
                kh.setTRANGTHAI(rs.getInt(5));
                kh.setNGAYTAO(rs.getDate(6));
                listKH.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            rs.close();
            sttm.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKH;
    }

    public List<khachHang> getAllKhachHangTheoSDT(String SDT) {
        List<khachHang> listKH = new ArrayList<>();
        Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT IDKHACHHANG, TENKHACHHANG, SODIENTHOAI, DIACHI,TRANGTHAI,NGAYTAO, NGAYSUA FROM KHACHHANG\n"
                    + "WHERE SODIENTHOAI like '%" + SDT + "%'";
            conn = jdbc.getConnection();
            sttm = conn.prepareStatement(sSQL);
            rs = sttm.executeQuery();
            while (rs.next()) {
                khachHang kh = new khachHang();
                kh.setIDKHACHHANG(rs.getInt(1));
                kh.setTENKHACHHANG(rs.getNString(2));
                kh.setSODIENTHOAI(rs.getString(3));
                kh.setDIACHI(rs.getNString(4));
                kh.setTRANGTHAI(rs.getInt(5));
                kh.setNGAYTAO(rs.getDate(6));
                listKH.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            rs.close();
            sttm.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKH;
    }
    public List<String> getcbkh() {
        List<String> listKH = new ArrayList<>();
        Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT TENKHACHHANG from KHACHHANG order by IDKHACHHANG";
            conn = jdbc.getConnection();
            sttm = conn.prepareStatement(sSQL);
            rs = sttm.executeQuery();
            while (rs.next()) {
                listKH.add(rs.getString(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            rs.close();
            sttm.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKH;
    }


    public List<khachHang> getAllKhachHangTheoMa(int maKH) {
        List<khachHang> listKH = new ArrayList<>();
        Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT * FROM KHACHHANG\n"
                    + "WHERE IDKHACHHANG=?";
            conn = jdbc.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setInt(1, maKH);
            rs = sttm.executeQuery();
            while (rs.next()) {
              khachHang kh = new khachHang();
                kh.setIDKHACHHANG(rs.getInt(1));
                kh.setTENKHACHHANG(rs.getNString(2));
                kh.setSODIENTHOAI(rs.getString(3));
                kh.setDIACHI(rs.getNString(4));
                kh.setTRANGTHAI(rs.getInt(5));
                kh.setNGAYTAO(rs.getDate(6));
                listKH.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            rs.close();
            sttm.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKH;
    }

    public List<khachHang> getAllKhachHangSapXepTheoNgayTao() {
        List<khachHang> listKH = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT * FROM KHACHHANG\n"
                    + "ORDER BY NGAYTAO DESC";
            conn = jdbc.getConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
               khachHang kh = new khachHang();
                kh.setIDKHACHHANG(rs.getInt(1));
                kh.setTENKHACHHANG(rs.getNString(2));
                kh.setSODIENTHOAI(rs.getString(3));
                kh.setDIACHI(rs.getNString(4));
                kh.setTRANGTHAI(rs.getInt(5));
                kh.setNGAYTAO(rs.getDate(6));
                listKH.add(kh);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            rs.close();
            sttm.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKH;
    }

//    public List<khachHang> getAllKhachHangSXTheoSoHoaDon() {
//        List<khachHang> listKH = new ArrayList<>();
//        Connection conn = null;
//        Statement sttm = null;
//        ResultSet rs = null;
//        try {
//            String sSQL = "SELECT KhachHang.*, COUNT(HoaDon.MaHoaDon) AS SoLuongHoaDon, SUM(ThanhTien)\n"
//                    + "FROM KhachHang\n"
//                    + "JOIN HoaDon ON KhachHang.MaKH = HoaDon.MaKH\n"
//                    + "WHERE HoaDon.TrangThai=1\n"
//                    + "GROUP BY KhachHang.MaKH, HoTen, SoDienThoai, DiaChi ,KhachHang.TrangThai, KhachHang.NgayTao\n"
//                    + "ORDER BY COUNT(HoaDon.MaHoaDon) DESC;";
//            conn = DBConnection.getDBConect();
//            sttm = conn.createStatement();
//            rs = sttm.executeQuery(sSQL);
//            while (rs.next()) {
//                khachHang kh = new khachHang();
//                kh.setMaKhachHang(rs.getInt(1));
//                kh.setHoTen(rs.getNString(2));
//                kh.setSDT(rs.getString(3));
//                kh.setDiaChi(rs.getNString(4));
//                kh.setTrangThai(rs.getInt(5));
//                kh.setNgayTao(rs.getDate(6));
//                kh.setSoDonHang(rs.getInt(7));
//                kh.setTongTien(rs.getDouble(8));
//                listKH.add(kh);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            rs.close();
//            sttm.close();
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return listKH;
//    }
//
//    public List<khachHang> getAllKhachHangSXTheoTongTien() {
//        List<khachHang> listKH = new ArrayList<>();
//        Connection conn = null;
//        Statement sttm = null;
//        ResultSet rs = null;
//        try {
//            String sSQL = "SELECT KhachHang.*, COUNT(HoaDon.MaHoaDon) AS SoLuongHoaDon, SUM(ThanhTien)\n"
//                    + "FROM KhachHang\n"
//                    + "JOIN HoaDon ON KhachHang.MaKH = HoaDon.MaKH\n"
//                    + "WHERE HoaDon.TrangThai=1\n"
//                    + "GROUP BY KhachHang.MaKH, HoTen, SoDienThoai, DiaChi ,KhachHang.TrangThai, KhachHang.NgayTao\n"
//                    + "ORDER BY SUM(ThanhTien) DESC;";
//            conn = DBConnection.getDBConect();
//            sttm = conn.createStatement();
//            rs = sttm.executeQuery(sSQL);
//            while (rs.next()) {
//                khachHang kh = new khachHang();
//                kh.setMaKhachHang(rs.getInt(1));
//                kh.setHoTen(rs.getNString(2));
//                kh.setSDT(rs.getString(3));
//                kh.setDiaChi(rs.getNString(4));
//                kh.setTrangThai(rs.getInt(5));
//                kh.setNgayTao(rs.getDate(6));
//                kh.setSoDonHang(rs.getInt(7));
//                kh.setTongTien(rs.getDouble(8));
//                listKH.add(kh);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        try {
//            rs.close();
//            sttm.close();
//            conn.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return listKH;
//    }

}
