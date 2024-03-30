package repository;

import JDBC.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import model.HoaDon;
import model.Voucher;

public class VoucherRepository {

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public List<Voucher> getAllKhuyenMai() {
        List<Voucher> listKM = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT * FROM VOUCHER";
            conn = jdbc.getConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                Voucher km = new Voucher();
                km.setIDVOUCHER(rs.getString(1));
                km.setTENVOUCHER(rs.getNString(2));
                km.setSOHOADONAPDUNG(rs.getInt(3));
                km.setHINHTHUC(rs.getInt(4));
                km.setMUCGIAMGIAl(rs.getDouble(5));
                km.setNGAYBATDAU(rs.getDate(6));
                km.setNGAYKETTHUC(rs.getDate(7));
                km.setMoTa(rs.getNString(8));
                km.setNGAYTAO(rs.getDate(9));
                km.setNGAYSUA(rs.getDate(10));
                km.setTRANGTHAI(rs.getInt(11));
                km.setSOTIENMIN(rs.getDouble(12));
                km.setSOLUONG(rs.getInt(13));
                listKM.add(km);
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
        return listKM;
    }

    public List<Voucher> getAllKhuyenMaiTheoSoHDAP() {
        List<Voucher> listKM = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT * FROM VOUCHER\n"
                    + "ORDER BY SOHOADONAPDUNG DESC";
            conn = jdbc.getConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                Voucher km = new Voucher();
                km.setIDVOUCHER(rs.getString(1));
                km.setTENVOUCHER(rs.getNString(2));
                km.setSOHOADONAPDUNG(rs.getInt(3));
                km.setHINHTHUC(rs.getInt(4));
                km.setMUCGIAMGIAl(rs.getDouble(5));
                km.setNGAYBATDAU(rs.getDate(6));
                km.setNGAYKETTHUC(rs.getDate(7));
                km.setMoTa(rs.getNString(8));
                km.setNGAYTAO(rs.getDate(9));
                km.setNGAYSUA(rs.getDate(10));
                km.setTRANGTHAI(rs.getInt(11));
                km.setSOTIENMIN(rs.getDouble(12));
                km.setSOLUONG(rs.getInt(13));
                listKM.add(km);
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
        return listKM;
    }

    public List<Voucher> getAllKhuyenMaiTheoNgayKetThuc() {
        List<Voucher> listKM = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT * FROM VOUCHER\n"
                    + "ORDER BY NGAYKETTHUC DESC";
            conn = jdbc.getConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                Voucher km = new Voucher();
                km.setIDVOUCHER(rs.getString(1));
                km.setTENVOUCHER(rs.getNString(2));
                km.setSOHOADONAPDUNG(rs.getInt(3));
                km.setHINHTHUC(rs.getInt(4));
                km.setMUCGIAMGIAl(rs.getDouble(5));
                km.setNGAYBATDAU(rs.getDate(6));
                km.setNGAYKETTHUC(rs.getDate(7));
                km.setMoTa(rs.getNString(8));
                km.setNGAYTAO(rs.getDate(9));
                km.setNGAYSUA(rs.getDate(10));
                km.setTRANGTHAI(rs.getInt(11));
                km.setSOTIENMIN(rs.getDouble(12));
                km.setSOLUONG(rs.getInt(13));
                listKM.add(km);
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
        return listKM;
    }

    public List<Voucher> getAllKhuyenMaiByMa(String MaKhuyenMai) {
        List<Voucher> listKM = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT * FROM VOUCHER WHERE IDVOUCHER like '%" + MaKhuyenMai + "%'";
            conn = jdbc.getConnection();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()) {
                Voucher km = new Voucher();
                km.setIDVOUCHER(rs.getString(1));
                km.setTENVOUCHER(rs.getNString(2));
                km.setSOHOADONAPDUNG(rs.getInt(3));
                km.setHINHTHUC(rs.getInt(4));
                km.setMUCGIAMGIAl(rs.getDouble(5));
                km.setNGAYBATDAU(rs.getDate(6));
                km.setNGAYKETTHUC(rs.getDate(7));
                km.setMoTa(rs.getNString(8));
                km.setNGAYTAO(rs.getDate(9));
                km.setNGAYSUA(rs.getDate(10));
                km.setTRANGTHAI(rs.getInt(11));
                km.setSOTIENMIN(rs.getDouble(12));
                km.setSOLUONG(rs.getInt(13));
                listKM.add(km);
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
        return listKM;
    }

    public List<Voucher> getAllKhuyenMaiByTrangThai(int TrangThai) {
        List<Voucher> listKM = new ArrayList<>();
        Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT * FROM VOUCHER WHERE TRANGTHAI=?";
            conn = jdbc.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setInt(1, TrangThai);
            rs = sttm.executeQuery();
            while (rs.next()) {
                Voucher km = new Voucher();
                km.setIDVOUCHER(rs.getString(1));
                km.setTENVOUCHER(rs.getNString(2));
                km.setSOHOADONAPDUNG(rs.getInt(3));
                km.setHINHTHUC(rs.getInt(4));
                km.setMUCGIAMGIAl(rs.getDouble(5));
                km.setNGAYBATDAU(rs.getDate(6));
                km.setNGAYKETTHUC(rs.getDate(7));
                km.setMoTa(rs.getNString(8));
                km.setNGAYTAO(rs.getDate(9));
                km.setNGAYSUA(rs.getDate(10));
                km.setTRANGTHAI(rs.getInt(11));
                km.setSOTIENMIN(rs.getDouble(12));
                km.setSOLUONG(rs.getInt(13));
                listKM.add(km);
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
        return listKM;
    }

    public List<Voucher> getAllKhuyenMaiTheo_SoHDAP_TT(int TrangThai) {
        List<Voucher> listKM = new ArrayList<>();
        Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT * FROM VOUCHER\n"
                    + "WHERE TRANGTHAI=?\n"
                    + "ORDER BY SOHOADONAPDUNG DESC";
            conn = jdbc.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setInt(1, TrangThai);
            rs = sttm.executeQuery();
            while (rs.next()) {
                Voucher km = new Voucher();
                km.setIDVOUCHER(rs.getString(1));
                km.setTENVOUCHER(rs.getNString(2));
                km.setSOHOADONAPDUNG(rs.getInt(3));
                km.setHINHTHUC(rs.getInt(4));
                km.setMUCGIAMGIAl(rs.getDouble(5));
                km.setNGAYBATDAU(rs.getDate(6));
                km.setNGAYKETTHUC(rs.getDate(7));
                km.setMoTa(rs.getNString(8));
                km.setNGAYTAO(rs.getDate(9));
                km.setNGAYSUA(rs.getDate(10));
                km.setTRANGTHAI(rs.getInt(11));
                km.setSOTIENMIN(rs.getDouble(12));
                km.setSOLUONG(rs.getInt(13));
                listKM.add(km);
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
        return listKM;
    }

    public List<Voucher> getAllKhuyenMaiTheo_NgayKetThuc_TT(int TrangThai) {
        List<Voucher> listKM = new ArrayList<>();
        Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        try {
            String sSQL = "SELECT * FROM VOUCHER\n"
                    + "WHERE TRANGTHAI=?\n"
                    + "ORDER BY NGAYKETTHUC DESC";
            conn = jdbc.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setInt(1, TrangThai);
            rs = sttm.executeQuery();
            while (rs.next()) {
                Voucher km = new Voucher();
                km.setIDVOUCHER(rs.getString(1));
                km.setTENVOUCHER(rs.getNString(2));
                km.setSOHOADONAPDUNG(rs.getInt(3));
                km.setHINHTHUC(rs.getInt(4));
                km.setMUCGIAMGIAl(rs.getDouble(5));
                km.setNGAYBATDAU(rs.getDate(6));
                km.setNGAYKETTHUC(rs.getDate(7));
                km.setMoTa(rs.getNString(8));
                km.setNGAYTAO(rs.getDate(9));
                km.setNGAYSUA(rs.getDate(10));
                km.setTRANGTHAI(rs.getInt(11));
                km.setSOTIENMIN(rs.getDouble(12));
                km.setSOLUONG(rs.getInt(13));
                listKM.add(km);
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
        return listKM;
    }
// can sua lai

    public int InsertKhuyenMai(Voucher km) {
        HoaDon hd = null;
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "INSERT INTO VOUCHER VALUES(?,?,0,?,?,?,?,NULL,GETDATE(),NULL,1,?,?);";
            conn = jdbc.getConnection();
            sttm.setString(1, km.getIDVOUCHER());
            sttm.setFloat(2, km.getPHANCHAMGIAMGIA());
            sttm.setString(3, dateFormat.format(km.getNGAYBATDAU()));
            sttm.setString(4, dateFormat.format(km.getNGAYKETTHUC()));
            sttm.setInt(5, km.getTRANGTHAI());
            sttm.setInt(6, km.getSOLUONG());
            sttm.setInt(7, km.getHINHTHUC());
            sttm.setInt(8, km.getSOHOADONAPDUNG());
            sttm.setDouble(9, km.getSOTIENMIN());
            sttm.setDouble(10, km.getMUCGIAMGIAl());
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
// can sua lai
    public int UpdateKhuyenMai(Voucher km) {
        HoaDon hd = null;
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "UPDATE VOUCHER SET TENVOUCHER=?, PHANCHAMGIAMGIA=?, NGAYBATDAU=?, NGAYKETTHUC=?, HINHTHUC=?, MUCGIAMGIA=?, SOTIENMIN=?, SOLUONG=? WHERE IDVOUCHER=?";
            conn = jdbc.getConnection();
            sttm = conn.prepareStatement(sSQL);

            sttm.setString(1, km.getTENVOUCHER());
            sttm.setFloat(2, km.getPHANCHAMGIAMGIA());
            sttm.setString(3, dateFormat.format(km.getNGAYBATDAU()));
            sttm.setString(4, dateFormat.format(km.getNGAYKETTHUC()));
            sttm.setInt(5, km.getHINHTHUC());
            sttm.setDouble(6, km.getMUCGIAMGIAl());
            sttm.setDouble(7, km.getSOTIENMIN());
            sttm.setInt(8, km.getSOLUONG());
            sttm.setString(9, km.getIDVOUCHER());
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

    public int UpdateTrangThaiKM(Voucher km) {
        HoaDon hd = null;
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "EXEC Update_TrangThaiVC ?,?,?";
            conn = jdbc.getConnection();
            sttm = conn.prepareCall(sSQL);
            sttm.setString(1, km.getIDVOUCHER());
            sttm.setString(2, dateFormat.format(km.getNGAYBATDAU()));
            sttm.setString(3, dateFormat.format(km.getNGAYKETTHUC()));
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

    public int UpdateSoLuongKhuyenMai(Voucher km) {
        HoaDon hd = null;
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "EXEC Update_TrangThaiVC ?,?,?";
            conn = jdbc.getConnection();
            sttm = conn.prepareCall(sSQL);
            sttm.setString(1, km.getIDVOUCHER());           
            sttm.setInt(2, km.getSOHOADONAPDUNG());
            sttm.setInt(3, km.getSOLUONG());
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

    public int UpdateTrangThaiKMTrucTiep(String MaKhuyenMai) {
        HoaDon hd = null;
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "UPDATE VOUCHER SET TRANGTHAI=0\n"
                    + "WHERE IDVOUCHER=?";
            conn = jdbc.getConnection();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1, MaKhuyenMai);
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
