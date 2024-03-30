/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.SanPham;
import JDBC.jdbc;

/**
 *
 * @author Admin
 */
public class SanPhamDao extends SysDAO<SanPham, Integer> {//IDSANPHAM, SOLUONG, TENSANPHAM, NGAYTAO, NGAYSUA, TRANGTHAI

    @Override
    public int insert(SanPham entity) {
        String sql = "INSERT INTO SANPHAM ( IDSANPHAM, SOLUONG, TENSANPHAM, NGAYTAO, NGAYSUA, TRANGTHAI) VALUES (?,?,?,getdate(),?, ?)";
        return jdbc.update(sql,
                entity.getIDSANPHAM(),
                entity.getSOLUONG(),
                entity.getTENSANPHAM(),
                entity.getNGAYSUA(),
                entity.getTRANGTHAI());
    }

    @Override
    public int update(SanPham entity, Integer ma) {
        String sql = "update SANPHAM set SOLUONG=?,TENSANPHAM=?, NGAYSUA=getdate(), TRANGTHAI=? where IDSANPHAM like ?";
        return jdbc.update(sql,
                entity.getSOLUONG(),
                entity.getTENSANPHAM(),
                entity.getTRANGTHAI(),
                ma
        );
    }

    @Override
    public int delete(Integer id) {
        String sql = "DELETE FROM SANPHAM where IDSANPHAM like ?";
        return jdbc.update(sql, id);
    }

    @Override
    public SanPham selectById(Integer id) {
        String sql = "select IDSANPHAM, SOLUONG, TENSANPHAM, NGAYTAO, NGAYSUA, TRANGTHAI from SANPHAM where IDSANPHAM like ?";
        List<SanPham> list = selectBySql(sql, id);
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public List<SanPham> selectAll() {
        String sql = "select IDSANPHAM, SOLUONG, TENSANPHAM, NGAYTAO, NGAYSUA, TRANGTHAI FROM SANPHAM;";
        return selectBySql(sql);
    }

    public int selectById4() {
        String sql = "select IDSANPHAM from SANPHAM order by IDSANPHAM";
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

    @Override
    protected List<SanPham> selectBySql(String sql, Object... args) {
        List<SanPham> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbc.query(sql, args);
                while (rs.next()) {
                    SanPham xs = new SanPham(
                            rs.getInt(1),
                            rs.getInt(2),
                            rs.getString(3),
                            rs.getDate(4),
                            rs.getDate(5),
                            rs.getInt(6));

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
