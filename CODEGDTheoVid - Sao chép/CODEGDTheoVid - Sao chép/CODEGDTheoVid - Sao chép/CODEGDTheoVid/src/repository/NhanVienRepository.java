package repository;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.NhanVien;
import model.khachHang;
import JDBC.jdbc;

public class NhanVienRepository {

    public List<NhanVien> getallNhanVien() {
        List<NhanVien> listNV = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT * FROM NHANVIEN";
            conn = jdbc.getConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                NhanVien nv = new NhanVien();
                nv.setIDNHANVIEN(rs.getInt(1));
                nv.setTENNHANVIEN(rs.getString(2));
                nv.setGIOITINH(rs.getInt(3));
                nv.setEMAIL(rs.getString(4));
                nv.setNGAYSINH(rs.getDate(5));
                nv.setDIACHI(rs.getString(6));
                nv.setSODIENTHOAI(rs.getString(7));
                nv.setCHUCVU(rs.getInt(8));
                nv.setNGAYTAO(rs.getDate(9));
                nv.setNGAYSUA(rs.getDate(10));
                nv.setTRANGTHAI(rs.getInt(11));
                listNV.add(nv);
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
        return listNV;
    }

    public List<Integer> getallIDNhanVien() {
        List<Integer> listNV = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT IDNHANVIEN FROM NHANVIEN";
            conn = jdbc.getConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                listNV.add(rs.getInt(1));
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
        return listNV;
    }

}
