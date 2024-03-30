/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package repository;

import JDBC.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.HoaDonChiTiet;

/**
 *
 * @author duck1
 */
public class HoaDonChiTietRepo {

    public List<HoaDonChiTiet> getAllHDCT1() {
        List<HoaDonChiTiet> listHDCT = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT SanPhamChiTiet.MaSPCT,TenSanPham,HoaDonChiTiet.SoLuong,DonGia,HoaDonChiTiet.SoLuong*DonGia\n"
                    + "FROM HoaDonChiTiet JOIN SanPhamChiTiet ON HoaDonChiTiet.MaCTSP=SanPhamChiTiet.MaSPCT\n"
                    + "				   JOIN SanPham ON SanPham.MaSanPham=SanPhamChiTiet.MaSanPham\n"
                    + "WHERE HoaDonChiTiet.MaHoaDon=(SELECT MAX(MaHoaDon) FROM HoaDon);";
            conn = jdbc.getConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                HoaDonChiTiet hdct = new HoaDonChiTiet();
                hdct.setIDSANPHAMCHITIET(rs.getInt(1));
                hdct.setTENSANPHAM(rs.getNString(2));
                hdct.setSOLUONG(rs.getInt(3));
                hdct.setGIA(rs.getDouble(4));
                hdct.setTHANHTIEN(rs.getDouble(5));
                listHDCT.add(hdct);
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
        return listHDCT;
    }

    public List<HoaDonChiTiet> getAllHDCT2(int MaHoaDon) {
        List<HoaDonChiTiet> listHDCT = new ArrayList<>();
        Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT SANPHAMCHITIET.IDSANPHAMCHITIET, SANPHAM.TENSANPHAM, HOADONCHITIET.SOLUONG, SANPHAMCHITIET.GIA, (HOADONCHITIET.SOLUONG * SANPHAMCHITIET.GIA) AS THANHTIEN\n"
                    + "FROM HOADONCHITIET\n"
                    + "JOIN SANPHAMCHITIET ON HOADONCHITIET.IDSANPHAMCHITIET = SANPHAMCHITIET.IDSANPHAMCHITIET\n"
                    + "JOIN SANPHAM ON SANPHAMCHITIET.ID_SP = SANPHAM.IDSANPHAM\n"
                    + "WHERE HOADONCHITIET.IDHOADON = ?";
            conn = jdbc.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setInt(1, MaHoaDon);
            rs = sttm.executeQuery();
            while (rs.next()) {
                HoaDonChiTiet hdct = new HoaDonChiTiet();
                hdct.setIDSANPHAMCHITIET(rs.getInt(1));
                hdct.setTENSANPHAM(rs.getNString(2));
                hdct.setSOLUONG(rs.getInt(3));
                hdct.setGIA(rs.getDouble(4));
                hdct.setTHANHTIEN(rs.getDouble(5));
                listHDCT.add(hdct);
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
        return listHDCT;
    }

    public int InsertHoaDonChiTiet(int IDHOADON, int IDSANPHAMCHITIET, int SoLuong) {
        HoaDonChiTiet hdct = null;
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "INSERT INTO HOADONCHITIET (IDHOADON, IDSANPHAMCHITIET, SOLUONG, GIA) "
                    + "VALUES (?, ?, ?, (SELECT GIA FROM SANPHAMCHITIET WHERE IDSANPHAMCHITIET = ?))";
            conn = jdbc.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setInt(1, IDHOADON);
            sttm.setInt(2, IDSANPHAMCHITIET);
            sttm.setInt(3, SoLuong);
            sttm.setInt(4, IDSANPHAMCHITIET);
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

    public int UpdateHDCT_SoLuong(int IDHOADON, int IDSANPHAMCHITIET, int SOLUONG) {
        HoaDonChiTiet hdct = null;
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "UPDATE SANPHAMCHITIET SET SOLUONG=SOLUONG+?\n"
                    + "				WHERE IDHOADON=? AND IDSANPHAMCHITIET=?;";
            conn = jdbc.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setInt(1, SOLUONG);
            sttm.setInt(2, IDHOADON);
            sttm.setInt(3, IDSANPHAMCHITIET);
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

    public int DeleteHDCT(int IDHOADON, int IDSANPHAMCHITIET) {
        HoaDonChiTiet hdct = null;
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "DELETE HOADONCHITIET  WHERE IDHOADON=? AND IDSANPHAMCHITIET=?;";
            conn = jdbc.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setInt(1, IDHOADON);
            sttm.setInt(2, IDSANPHAMCHITIET);
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

    public int DeleteAllHDCT(int IDHOADON) {
        HoaDonChiTiet hdct = null;
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "DELETE HOADONCHITIET WHERE IDHOADON=?";
            conn = jdbc.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setInt(1, IDHOADON);
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

    public List<HoaDonChiTiet> getAllHDCTTheoMa(int IDHOADON) {
        List<HoaDonChiTiet> listHDCT = new ArrayList<>();
        Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT * FROM HOADONCHITIET WHERE IDHOADON=?";
            conn = jdbc.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setInt(1, IDHOADON);
            rs = sttm.executeQuery();
            while (rs.next()) {
                HoaDonChiTiet hdct = new HoaDonChiTiet();
                hdct.setIDSANPHAMCHITIET(rs.getInt(2));
                hdct.setSOLUONG(rs.getInt(3));
                listHDCT.add(hdct);
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
        return listHDCT;
    }

}


