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

/**
 *
 * @author Admin
 */
public class ChiTietSpDao extends SysDAO<ChiTietSP, String> {

    public String getTen2(String sql, int ma) {
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
                rs = DBConnect.query(sql, x);
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

    public List<String> getTen(String sql) {
        List<String> x = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = DBConnect.query(sql);
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

    @Override
    public int insert(ChiTietSP entity) {
        String sql = "INSERT INTO SANPHAMCHITIET "
                + "(ID_SP, ID_XUATXU, ID_NONGDO, ID_NHOMHUONG, DOTOHUONG, THOIGIANNENDUNG, NAMPHATHANH, DUNGTICH, LUUHUONG, NGAYTAO, NGAYSUA, TRANGTHAI)"
                + " VALUES (?,?,?,?,?,?,?,?,?, ?, ?, ?)";
        return DBConnect.update(sql,
                entity.getIdSanPham(),
                entity.getIDXuatXu(),
                entity.getIDNongDo(),
                entity.getIDNhomHuong(),
                entity.getDoToaHuong(),
                entity.getThoiGianLenDung(),
                entity.getNamPhatHanh(),
                entity.getDungTich(),
                entity.getLuuHuong(),
                entity.getNgayTao(),
                entity.getNgaySua(),
                entity.getTrangThai());
    }

    @Override
    public int update(ChiTietSP entity, String ma) {
        String sql = "update SANPHAMCHITIET "
                + "set ID_SP=?, ID_XUATXU=?, ID_NONGDO=?, ID_NHOMHUONG=?, DOTOHUONG=?, THOIGIANNENDUNG=?, NAMPHATHANH=?, DUNGTICH=?, LUUHUONG=?, NGAYSUA=?, TRANGTHAI=?, TRANGTHAI=? "
                + "where IDSANPHAMCHITIET like ?";
        return DBConnect.update(sql,
                entity.getIdSanPham(),
                entity.getIDXuatXu(),
                entity.getIDNongDo(),
                entity.getIDNhomHuong(),
                entity.getDoToaHuong(),
                entity.getThoiGianLenDung(),
                entity.getNamPhatHanh(),
                entity.getDungTich(),
                entity.getLuuHuong(),
                entity.getNgaySua(),
                entity.getTrangThai(),
                ma
        );
    }

    @Override
    public int delete(String id) {
        String sql = "DELETE FROM SANPHAMCHITIET where IDSANPHAMCHITIET like ?";
        return DBConnect.update(sql, id);
    }

    public ChiTietSP selectById2(String id) {
        String sql = "select IDSANPHAMCHITIET,ID_SP, ID_XUATXU, ID_NONGDO, ID_NHOMHUONG, DOTOHUONG, THOIGIANNENDUNG, NAMPHATHANH, DUNGTICH, LUUHUONG, NGAYTAO, NGAYSUA, TRANGTHAI from SANPHAMCHITIET where ID_SP like ?";
        List<ChiTietSP> list = selectBySql(sql, id);
        return !list.isEmpty() ? list.get(0) : null;
    }
    public List<ChiTietSP> selectByTimKiem(String id,String id2) {
        String sql = "select IDSANPHAMCHITIET,ID_SP, ID_XUATXU, ID_NONGDO, ID_NHOMHUONG, DOTOHUONG, THOIGIANNENDUNG, NAMPHATHANH, DUNGTICH, LUUHUONG, NGAYTAO, NGAYSUA, TRANGTHAI from SANPHAMCHITIET where ID_SP like ?";
        List<ChiTietSP> list = selectBySql(sql, id);
        return list;
    }

    @Override
    public ChiTietSP selectById(String id) {
        String sql = "select IDSANPHAMCHITIET,ID_SP, ID_XUATXU, ID_NONGDO, ID_NHOMHUONG, DOTOHUONG, THOIGIANNENDUNG, NAMPHATHANH, DUNGTICH, LUUHUONG, NGAYTAO, NGAYSUA, TRANGTHAI from SANPHAMCHITIET where ID_SP like ?";
        List<ChiTietSP> list = selectBySql(sql, id);
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public List<ChiTietSP> selectAll() {
        String sql = "select IDSANPHAMCHITIET,ID_SP, ID_XUATXU, ID_NONGDO, ID_NHOMHUONG, DOTOHUONG, THOIGIANNENDUNG, NAMPHATHANH, DUNGTICH, LUUHUONG, NGAYTAO, NGAYSUA, TRANGTHAI from SANPHAMCHITIET";
        return selectBySql(sql);
    }

    @Override
    protected List<ChiTietSP> selectBySql(String sql, Object... args) {
        List<ChiTietSP> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = DBConnect.query(sql, args);
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
                            rs.getString(11),
                            rs.getString(12),
                            rs.getInt(13));

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
