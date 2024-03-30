/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.*;
import JDBC.jdbc;

/**
 *
 * @author Admin
 */
public class ChiTietSpDao extends SysDAO<ChiTietSP, Integer> {

    public String getTen2(String sql, int ma) {
        String x = null;
        try {
            ResultSet rs = null;
            try {
                rs = jdbc.query(sql, ma);
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
    public String getTenXS2(int ma) {
        String sql = "select TENXUATXU FROM XUATXU where IDXUATXU = ?";
        return getTen2(sql,ma);
    }

    public String getTenND2(int ma) {
        String sql = "select TENNONGDO FROM NONGDO where IDNONGDO = ?";
        return getTen2(sql,ma);
    }

    public String getTenNH2(int ma) {
        String sql = "select TENNHOMHUONG FROM NHOMHUONG where IDNHOMHUONG= ?";
        return getTen2(sql,ma);
    }

    public List<String> getTensp() {
        String sql = "select TENSANPHAM FROM SANPHAM where TRANGTHAI = 1";
        return getTen(sql);
    }

    public List<String> getTenXS() {
        String sql = "select TENXUATXU FROM XUATXU where TRANGTHAI = 1";
        return getTen(sql);
    }

    public List<String> getTenND() {
        String sql = "select TENNONGDO FROM NONGDO where TRANGTHAI = 1";
        return getTen(sql);
    }

    public List<String> getTenNH() {
        String sql = "select TENNHOMHUONG FROM NHOMHUONG where TRANGTHAI = 1";
        return getTen(sql);
    }
    public String getIDXS(int ma) {
        String sql = "select TENXUATXU FROM XUATXU where IDXUATXU like ?";
        String x = null;
        x = getTenID(sql, ma);
        return x;
    }
     public String getIDNH(int ma) {
        String sql = "select TENNHOMHUONG FROM NHOMHUONG where IDNHOMHUONG like ?";
        String x = null;
        x = getTenID(sql, ma);
        return x;
    }
      public String getIDND(int ma) {
        String sql = "select TENNONGDO FROM NONGDO where IDNONGDO like ?";
        String x = null;
        x = getTenID(sql, ma);
        return x;
    }

    public List<String> getTenSPct(int x) {
        String sql = "SELECT IDSANPHAMCHITIET from  SANPHAMCHITIET where ID_SP = ?";
        List<String> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbc.query(sql, x);
                while (rs.next()) {
                    list.add(rs.getString(1));
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
            return list;
        } catch (SQLException ex) {
            return null;
        }
//        return getTen(sql);
    }

    public String getTenID(String sql, int ma) {
        String x = null;
        try {
            ResultSet rs = null;
            try {
                rs = jdbc.query(sql, ma);
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
    public int getidND(String ma) {
        String sql = "select IDNONGDO FROM NONGDO where TENNONGDO = ?";
        return getid(sql, ma);
    }

    public int getiNH(String ma) {
        String sql = "select IDNHOMHUONG FROM NHOMHUONG where TENNHOMHUONG = ?";
        return getid(sql, ma);
    }

    public int getidXs(String ma) {
        String sql = "select IDXUATXU FROM XUATXU where TENXUATXU like ?";
        return getid(sql, ma);
    }
    public int getid(String sql, String ma) {
        int x = 0;
        try {
            ResultSet rs = null;
            try {
                rs = jdbc.query(sql, ma);
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

    public List<String> getTen(String sql) {
        List<String> x = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbc.query(sql);
                while (rs.next()) {
                    x.add(rs.getString(1));
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
            return x;
        } catch (SQLException ex) {
            return null;
        }
    }
//int IDSANPHAMCHITIET, int ID_SP, int ID_XUATXU, int LUUHUONG, int ID_NONGDO, int ID_NHOMHUONG, String DOTOHUONG, 
    //String THOIGIANNENDUNG, Date NAMPHATHANH, double GIA, int DUNGTICH, int SOLG, int GIOITINH, int TRANGTHAI
    @Override
    public int insert(ChiTietSP entity) {
        String sql = "INSERT INTO SANPHAMCHITIET "
                + "(IDSANPHAMCHITIET, ID_SP, ID_XUATXU, ID_NONGDO, ID_NHOMHUONG, DOTOHUONG, THOIGIANNENDUNG, NAMPHATHANH, "
                + " GIOITINH, LUUHUONG, GIA,DUNGTICH, SOLUONG, TRANGTHAI)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        return jdbc.update(sql,
                entity.getIDSANPHAMCHITIET(),
                entity.getID_SP(),
                entity.getID_XUATXU(),
                entity.getID_NONGDO(),
                entity.getID_NHOMHUONG(),
                entity.getDOTOHUONG(),
                entity.getTHOIGIANNENDUNG(),
                entity.getNAMPHATHANH(),
                entity.getGIOITINH(),
                entity.getLUUHUONG(),
                entity.getGIA(),
                entity.getDUNGTICH(),
                entity.getSOLG(),
                entity.getTRANGTHAI()            
                );
    }

    @Override
    public int update(ChiTietSP entity, Integer ma) {
String sql = "UPDATE SANPHAMCHITIET " +
                     "SET ID_SP = ?, " +
                     "    ID_XUATXU = ?, " +
                     "    ID_NONGDO = ?, " +
                     "    ID_NHOMHUONG = ?, " +
                     "    DOTOHUONG = ?, " +
                     "    THOIGIANNENDUNG = ?, " +
                     "    NAMPHATHANH = ?, " +
                     "    GIOITINH = ?, " +
                     "    LUUHUONG = ?, " +
                     "    GIA = ?, " +
                     "    DUNGTICH = ?, " +
                     "    SOLUONG = ?, " +
                     "    TRANGTHAI = ? " +
                     "WHERE IDSANPHAMCHITIET = ?";
        return jdbc.update(sql,
                entity.getID_SP(),
                entity.getID_XUATXU(),
                entity.getID_NONGDO(),
                entity.getID_NHOMHUONG(),
                entity.getDOTOHUONG(),
                entity.getTHOIGIANNENDUNG(),
                entity.getNAMPHATHANH(),
                entity.getGIOITINH(),
                entity.getLUUHUONG(),
                entity.getGIA(),
                entity.getDUNGTICH(),
                entity.getSOLG(),
                entity.getTRANGTHAI()  ,
                ma
        );
    }

    @Override
    public int delete(Integer id) {
        String sql = "DELETE FROM SANPHAMCHITIET where IDSANPHAMCHITIET like ?";
        return jdbc.update(sql, id);
    }
    public int selectById4() {
        String sql = "select IDSANPHAMCHITIET from SANPHAMCHITIET order by IDSANPHAMCHITIET";
        int x = -1;
        try {
            ResultSet rs = null;
            try {
                rs = jdbc.query(sql);
                while (rs.next()) {
                    x = rs.getInt(1);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return x;
    }


    public List<ChiTietSP> selectByIdctsp(Integer id) {
        String sql = "select IDSANPHAMCHITIET, ID_SP, ID_XUATXU, ID_NONGDO, ID_NHOMHUONG, DOTOHUONG, THOIGIANNENDUNG, NAMPHATHANH, "
                + " GIOITINH, LUUHUONG, GIA,DUNGTICH, SOLUONG, TRANGTHAI from SANPHAMCHITIET where ID_SP like ?";
        List<ChiTietSP> list = selectBySql(sql, id);
        return list;
    }
    public List<ChiTietSP> selectByTimKiem(String id,String id2) {
        String sql = "select IDSANPHAMCHITIET, ID_SP, ID_XUATXU, ID_NONGDO, ID_NHOMHUONG, DOTOHUONG, THOIGIANNENDUNG, NAMPHATHANH, "
                + " GIOITINH, LUUHUONG, GIA,DUNGTICH, SOLUONG, TRANGTHAI from SANPHAMCHITIET where ID_SP like ?";
        List<ChiTietSP> list = selectBySql(sql, id);
        return list;
    }

    @Override
    public ChiTietSP selectById(Integer id) {
        String sql = "select IDSANPHAMCHITIET, ID_SP, ID_XUATXU, ID_NONGDO, ID_NHOMHUONG, DOTOHUONG, THOIGIANNENDUNG, NAMPHATHANH, "
                + " GIOITINH, LUUHUONG, GIA,DUNGTICH, SOLUONG, TRANGTHAI from SANPHAMCHITIET where IDSANPHAMCHITIET like ?";
        List<ChiTietSP> list = selectBySql(sql, id);
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public List<ChiTietSP> selectAll() {
        String sql = "select IDSANPHAMCHITIET, ID_SP, ID_XUATXU, ID_NONGDO, ID_NHOMHUONG, DOTOHUONG, THOIGIANNENDUNG, NAMPHATHANH, "
                + " GIOITINH, LUUHUONG, GIA,DUNGTICH, SOLUONG, TRANGTHAI from SANPHAMCHITIET";
        return selectBySql(sql);
    }
//    private int IDSANPHAMCHITIET;
//    private int ID_SP;
//    private int ID_XUATXU;
//    private int ID_NONGDO;
//    private int ID_NHOMHUONG;
//    private String DOTOHUONG;
//    private String THOIGIANNENDUNG;
//    private Date NAMPHATHANH;
//    private int GIOITINH;
//    private int LUUHUONG;
//    private double GIA;
//    private int DUNGTICH;
//    private int SOLG;
//    private int TRANGTHAI;

    @Override
    protected List<ChiTietSP> selectBySql(String sql, Object... args) {
        List<ChiTietSP> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbc.query(sql, args);
                while (rs.next()) {
                    ChiTietSP xs = new ChiTietSP(
                            rs.getInt(1),
                            rs.getInt(2),
                            rs.getInt(3),
                            rs.getInt(4),
                            rs.getInt(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8),
                            rs.getInt(9),
                            rs.getInt(10),
                            rs.getDouble(11),
                            rs.getInt(12),
                            rs.getInt(13),
                            rs.getInt(14));

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
