/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package repository;

import JDBC.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.SanPham;
import model.SanPhamMain;

/**
 *
 * @author duck1
 */
public class SanPhamRepository {

    public List<SanPhamMain> getAllSanPham() {
        List<SanPhamMain> listSP = new ArrayList<>();
        Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        try {
            //"Ten San Pham", "Do Toa Huong", "Luu HUong", "Xuat Xu", "Nong Do", "Nhom Huong", "So Luong", "Gia"
            String sSQL = """
                          SELECT SANPHAMCHITIET.IDSANPHAMCHITIET, 
                           SANPHAM.TENSANPHAM, 
                           XUATXU.TENXUATXU, 
                           NONGDO.TENNONGDO , 
                           NHOMHUONG.TENNHOMHUONG ,
                           SANPHAMCHITIET.DOTOHUONG, 
                           SANPHAMCHITIET.LUUHUONG  ,  SANPHAMCHITIET.SOLUONG, 
                           SANPHAMCHITIET.GIA
                           FROM SANPHAM JOIN SANPHAMCHITIET ON SANPHAM.IDSANPHAM = SANPHAMCHITIET.ID_SP
                           JOIN XUATXU ON SANPHAMCHITIET.ID_XUATXU = XUATXU.IDXUATXU
                           JOIN NHOMHUONG ON SANPHAMCHITIET.ID_NHOMHUONG = NHOMHUONG.IDNHOMHUONG
                           JOIN NONGDO ON SANPHAMCHITIET.ID_NONGDO = NONGDO.IDNONGDO
                            WHERE SANPHAMCHITIET.TRANGTHAI = 1""";
            conn = jdbc.getConnection();
            sttm = conn.prepareStatement(sSQL);
            rs = sttm.executeQuery();
            while (rs.next()) {
                SanPhamMain sp = new SanPhamMain();
                sp.setIDSANPHAMCHITIET(rs.getInt(1));
                sp.setTENSANPHAM(rs.getString(2));
                sp.setXUATXU(rs.getString(3));
                sp.setNONGDO(rs.getString(4));
                sp.setNHOMHUONG(rs.getString(5));
                sp.setDOTOHUONG(rs.getString(6));
                sp.setLUUHUONG(rs.getString(7));
                sp.setSOLUONG(rs.getInt(8));
                sp.setGIA(rs.getDouble(9));
                listSP.add(sp);
            }
        } catch (SQLException e) {
        }
        try {
            rs.getStatement().getConnection().close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSP;
    }

    public List<SanPhamMain> getSearchSanPham(String TenSanPham) {
        List<SanPhamMain> listSP = new ArrayList<>();
        Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT SANPHAMCHITIET.IDSANPHAMCHITIET AS MaSPCT, "
                    + "SANPHAM.TENSANPHAM AS TenSanPham, "
                    + "XUATXU.TENXUATXU AS TenThuongHieu, "
                    + "NONGDO.TENNONGDO AS TenMau, "
                    + "NHOMHUONG.TENNHOMHUONG AS TenChatLieu, "
                    + "SANPHAMCHITIET.DOTOHUONG AS TenKieuDang, "
                    + "SANPHAMCHITIET.SOLUONG AS SoLuong, "
                    + "SANPHAMCHITIET.GIA AS DonGia "
                    + "FROM SANPHAM "
                    + "JOIN SANPHAMCHITIET ON SANPHAM.IDSANPHAM = SANPHAMCHITIET.ID_SP "
                    + "JOIN XUATXU ON SANPHAMCHITIET.ID_XUATXU = XUATXU.IDXUATXU "
                    + "JOIN NHOMHUONG ON SANPHAMCHITIET.ID_NHOMHUONG = NHOMHUONG.IDNHOMHUONG "
                    + "JOIN NONGDO ON SANPHAMCHITIET.ID_NONGDO = NONGDO.IDNONGDO "
                    + "WHERE SANPHAM.TENSANPHAM LIKE ? AND SANPHAMCHITIET.TRANGTHAI = 1";

            conn = jdbc.getConnection();
            sttm = conn.prepareStatement(sSQL);
//            sttm.setString(1,TenSanPham);
            rs = sttm.executeQuery();
            while (rs.next()) {
                SanPhamMain sp = new SanPhamMain();
                sp.setIDSANPHAMCHITIET(rs.getInt(1));
                sp.setTENSANPHAM(rs.getNString(2));
                sp.setDOTOHUONG(rs.getNString(3));
                sp.setLUUHUONG(rs.getNString(4));
                sp.setXUATXU(rs.getNString(5));
                sp.setNONGDO(rs.getString(6));
                sp.setNHOMHUONG(rs.getString(7));
                sp.setSOLUONG(rs.getInt(8));
                sp.setGIA(rs.getDouble(9));
                listSP.add(sp);
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
        return listSP;
    }

    public int UpdateSoLuong(int SOLUONG, int IDSANPHAMCHITIET) {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "UPDATE SANPHAMCHITIET SET SOLUONG=SOLUONG-? WHERE IDSANPHAMCHITIET=?";
            conn = jdbc.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setInt(1, SOLUONG);
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

    public int UpdateSoLuongVe(int SOLUONG, int IDSANPHAMCHITIET) {
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "UPDATE SANPHAMCHITIET SET SOLUONG=SOLUONG+? WHERE IDSANPHAMCHITIET=?";
            conn = jdbc.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setInt(1, SOLUONG);
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

    public SanPham getSanPhamByMa(String IDSANPHAMCHITIET) {
        SanPham sp = new SanPham();
        Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT * FROM SANPHAMCHITIET WHERE IDSANPHAMCHITIET=?";
            conn = jdbc.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, IDSANPHAMCHITIET);
            rs = sttm.executeQuery();
            while (rs.next()) {
                sp.setSOLUONG(rs.getInt(7));
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
        return sp;
    }

}
