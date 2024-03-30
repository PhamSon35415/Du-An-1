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
import java.util.*;
import model.HoaDon;

/**
 *
 * @author duck1
 */
public class HoaDonRepository {
public int InsertHoaDon(HoaDon hd) {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "INSERT INTO HOADON(IDHOADON,ID_NHANVIEN,ID_KHACHHANG,TRANGTHAI,NGAYTAO) "
                    + "VALUES(?,?,?,0,GETDATE());";
            conn = jdbc.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setInt(1, hd.getIDHOADON());
            sttm.setInt(2, hd.getID_NHANVIEN());
            sttm.setInt(3, hd.getID_KHACHHANG());
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

    public int InsertHoaDonKHnull(HoaDon hd) {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "INSERT INTO HoaDon(IDHOADON,ID_NHANVIEN,TRANGTHAI,NGAYTAO) "
                    + "VALUES(?,?,0,GETDATE());";
            conn = jdbc.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setInt(1, hd.getIDHOADON());
            sttm.setInt(2, hd.getID_NHANVIEN());
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
     public int layphantucuoi() {
        Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs=null;
        int ptcuoi=-1;
        try {
            String sSQL = "select IDHOADON from HOADON ORDER BY IDHOADON;";
            conn = jdbc.getConnection();
            sttm = conn.prepareStatement(sSQL);
            rs=sttm.executeQuery();
            while (rs.next()) {                
                ptcuoi=rs.getInt(1);
            }
         } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            sttm.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ptcuoi;
    }
    
    public int UpdateHoaDon(double TongTien, double GiamGia, double ThanhTien, int MaHoaDon) {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "UPDATE HOADON SET TONGTIEN=?,GiamGia=?,THANHTIEN=? \n"
                    + "WHERE IDHOADON=?";
            conn = jdbc.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setDouble(1, TongTien);
            sttm.setDouble(2, GiamGia);
            sttm.setDouble(3, ThanhTien);
            sttm.setInt(4, MaHoaDon);
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

    public List<HoaDon> getAllHoaDonCho() {
        List<HoaDon> listHD = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = """
                               select IDHOADON, ID_KHACHHANG, ID_NHANVIEN, NGAYTAO, TRANGTHAI 
                                               from HOADON ORDER BY IDHOADON;""";
            conn = jdbc.getConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            HoaDon hd = new HoaDon();
            while (rs.next()) {
                
                hd.setIDHOADON(rs.getInt(1));
                hd.setID_NHANVIEN(rs.getInt(3));
                hd.setID_KHACHHANG(rs.getInt(2));
                hd.setNGAYTAO(rs.getString(4));
                hd.setTRANGTHAI(rs.getInt(5));
                
            }
            listHD.add(hd);
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
        return listHD;
    }
    
    public List<HoaDon> getAllHoaDon() {
        List<HoaDon> listHD = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT * FROM HoaDon\n"
                    + "ORDER BY IDHOADON DESC;";
            conn = jdbc.getConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setIDHOADON(rs.getInt(1));
                hd.setID_NHANVIEN(rs.getInt(2));
                hd.setID_KHACHHANG(rs.getInt(3));
                hd.setNGAYTAO(rs.getString(6));
                hd.setTRANGTHAI(rs.getInt(12));
                listHD.add(hd);
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
        return listHD;
    }

    public int UpdateTrangThai(int TrangThai, int MaHoaDon) {

        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "UPDATE HOADON SET TRANGTHAI=? WHERE IDHOADON=?";
            conn = jdbc.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setInt(1, TrangThai);
            sttm.setInt(2, MaHoaDon);
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

    public int UpdateHoaDonTT(HoaDon hd) {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "UPDATE HOADON SET TRANGTHAI=1, ID_VOUCHER=?,\n"
                    + "ID_PHUONGTHUCTHANHTOAN=?,NGAYTHANHTOAN=GETDATE(),\n"
                    + "TONGTIEN=?,GiamGia=?,THANHTIEN=?\n"
                    + "WHERE MaHoaDon=?";
            conn = jdbc.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, hd.getID_VOUCHER());
            sttm.setString(2,hd.getID_PHUONGTHUCTHANHTOAN());
            sttm.setDouble(3, hd.getTONGTIEN());
            sttm.setDouble(4, hd.getGiamGia());
            sttm.setDouble(5, hd.getTHANHTIEN());
            sttm.setInt(6, hd.getIDHOADON());
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

}
