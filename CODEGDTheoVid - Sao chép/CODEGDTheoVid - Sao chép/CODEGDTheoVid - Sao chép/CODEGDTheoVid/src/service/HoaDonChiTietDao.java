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
import JDBC.jdbc;

/**
 *
 * @author Admin
 */
public class HoaDonChiTietDao extends SysDAO<HoaDonChiTiet, Integer> {
//IDHOADONCHITIET, ID_HOADON, ID_SANPHAMCHITIET, TENSANPHAM, GIABAN, SOLUONG, TONGTIEN, NGAYTAO, NGAYSUA, TRANGTHAI

    @Override
    public int insert(HoaDonChiTiet entity) {
        String sql = "INSERT INTO HOADONCHITIET (IDHOADON, IDSANPHAMCHITIET, SOLUONG, GIA, TRANGTHAI) VALUES (?,?,?,?,?)";
        return jdbc.update(sql,
                entity.getIDHOADON(),
                entity.getIDSANPHAMCHITIET(),
                entity.getSOLUONG(),
                entity.getGIA(),
                entity.getTRANGTHAI());
    }

    @Override
    public int update(HoaDonChiTiet entity, Integer ma) {
        String sql = "update HOADONCHITIET set IDSANPHAMCHITIET=?, SOLUONG=?, GIA=?, TRANGTHAI=? where IDHOADON like ?";
        return jdbc.update(
                sql,
                entity.getIDSANPHAMCHITIET(),
                entity.getSOLUONG(),
                entity.getGIA(),
                entity.getTRANGTHAI(),
                ma
        );
    }

    public int updatesolg(Integer sl, Integer id, Integer ct) {
        String sql = "update HOADONCHITIET set SOLUONG=? where IDHOADON=? and IDSANPHAMCHITIET =?";
        return jdbc.update(
                sql,
                sl,
                id,
                ct
        );
    }

    public int kiemtrasolg(Integer ct) {
        int x=-1;
        String sql = "SELECT SOLUONG FROM SANPHAMCHITIET where IDSANPHAMCHITIET =?";
        try {
            ResultSet rs = null;
            try {
                rs = jdbc.query(sql,ct);
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

    @Override
    public int delete(Integer id) {
        String sql = "DELETE FROM HOADONCHITIET where IDHOADON like ?";
        return jdbc.update(sql, id);
    }

    @Override
    public HoaDonChiTiet selectById(Integer id) {
        String sql = """
                     select IDHOADON, hdct.IDSANPHAMCHITIET, hdct.SOLUONG,sp.TENSANPHAM, hdct.GIA, (hdct.GIA*hdct.SOLUONG) as [T\u1ed5ng ti\u1ec1n],hdct.TRANGTHAI 
                                           from HOADONCHITIET hdct
                                           join SANPHAMCHITIET spct on spct.IDSANPHAMCHITIET=hdct.IDSANPHAMCHITIET
                                           join SANPHAM sp on sp.IDSANPHAM=spct.ID_SP 
                                           where IDHOADON=? and hdct.IDSANPHAMCHITIET =?""";
        List<HoaDonChiTiet> list = selectBySql(sql, id);
        return !list.isEmpty() ? list.get(0) : null;
    }

    public HoaDonChiTiet selectBySpHD2(Integer id, Integer x) {
        String sql = """
                     select IDHOADON, hdct.IDSANPHAMCHITIET, hdct.SOLUONG,sp.TENSANPHAM, hdct.GIA, (hdct.GIA*hdct.SOLUONG) as [T\u1ed5ng ti\u1ec1n],hdct.TRANGTHAI 
                                           from HOADONCHITIET hdct
                                           join SANPHAMCHITIET spct on spct.IDSANPHAMCHITIET=hdct.IDSANPHAMCHITIET
                                           join SANPHAM sp on sp.IDSANPHAM=spct.ID_SP 
                                           where IDHOADON=? and hdct.IDSANPHAMCHITIET =?""";
        List<HoaDonChiTiet> list = selectBySql(sql, id, x);
        return !list.isEmpty() ? list.get(0) : null;
    }

    public List<HoaDonChiTiet> selectById2(Integer id) {
        String sql = """
                      select IDHOADON, hdct.IDSANPHAMCHITIET, hdct.SOLUONG,sp.TENSANPHAM, hdct.GIA, (hdct.GIA*hdct.SOLUONG) as [T\u1ed5ng ti\u1ec1n],hdct.TRANGTHAI 
                      from HOADONCHITIET hdct
                      join SANPHAMCHITIET spct on spct.IDSANPHAMCHITIET=hdct.IDSANPHAMCHITIET
                      join SANPHAM sp on sp.IDSANPHAM=spct.ID_SP 
                      where IDHOADON=?""";
        return selectBySql(sql, id);

    }

    @Override
    public List<HoaDonChiTiet> selectAll() {
        String sql = """
                      select IDHOADON, hdct.IDSANPHAMCHITIET, hdct.SOLUONG,sp.TENSANPHAM, hdct.GIA, (hdct.GIA*hdct.SOLUONG) as [T\u1ed5ng ti\u1ec1n],hdct.TRANGTHAI 
                      from HOADONCHITIET hdct
                      join SANPHAMCHITIET spct on spct.IDSANPHAMCHITIET=hdct.IDSANPHAMCHITIET
                      join SANPHAM sp on sp.IDSANPHAM=spct.ID_SP""";
        return selectBySql(sql);
    }

    public int selectById4() {
        String sql = "select IDHOADON from HOADONCHITIET order by IDHOADON";
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
//       private int IDHOADON,IDSANPHAMCHITIET,SOLUONG,;
//   private String TENSANPHAM;
//   private double GIA THANHTIEN,;
    //,TRANGTHAI
    //IDHOADON, IDSANPHAMCHITIET, SOLUONG, GIA, TRANGTHAI

    @Override
    protected List<HoaDonChiTiet> selectBySql(String sql, Object... args) {
        List<HoaDonChiTiet> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbc.query(sql, args);
                while (rs.next()) {
                    HoaDonChiTiet xs = new HoaDonChiTiet(
                            rs.getInt(1),
                            rs.getInt(2),
                            rs.getInt(3),
                            rs.getString(4),
                            rs.getDouble(5),
                            rs.getDouble(6),
                            rs.getInt(7));

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
