/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.NhomHuong;
import JDBC.jdbc;

/**
 *
 * @author Admin
 */
public class NhomHuongDao extends SysDAO<NhomHuong, String>{

     @Override
    public int insert(NhomHuong entity) {
        String sql = "INSERT INTO NHOMHUONG (TENNHOMHUONG, NGAYTAO, NGAYSUA, TRANGTHAI) VALUES (?, ?, ?, ?)";
        return jdbc.update(sql,
                entity.getTenNhomHuong(),
                entity.getNgayTao(),
                entity.getNgaySua(),
                entity.getTrangThai());
    }

    @Override
    public int update(NhomHuong entity,String ma) {
        String sql = "update NHOMHUONG set TENNHOMHUONG=?, NGAYTAO=?, NGAYSUA=?, TRANGTHAI=? where IDNHOMHUONG like ?";
        return jdbc.update(sql,
                entity.getTenNhomHuong(),
                entity.getNgayTao(),
                entity.getNgaySua(),
                entity.getTrangThai(),
                ma
        );
    }

    @Override
    public int delete(String id) {
        String sql = "DELETE FROM NHOMHUONG where IDNHOMHUONG like ?";
        return jdbc.update(sql, id);
    }

    @Override
    public NhomHuong selectById(String id) {
        String sql = "select IDNHOMHUONG,TENNHOMHUONG, NGAYTAO, NGAYSUA, TRANGTHAI from NHOMHUONG where IDNHOMHUONG like ?";
        List<NhomHuong> list = selectBySql(sql, id);
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public List<NhomHuong> selectAll() {
        String sql = "select IDNHOMHUONG,TENNHOMHUONG, NGAYTAO, NGAYSUA, TRANGTHAI from NHOMHUONG;";
        return selectBySql(sql);
    }

    @Override
    protected List<NhomHuong> selectBySql(String sql, Object... args) {
        List<NhomHuong> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbc.query(sql, args);
                while (rs.next()) {
                    NhomHuong xs=new NhomHuong(rs.getInt(1),
                            rs.getString(2), 
                            rs.getString(3), rs.getString(4),
                            rs.getInt(5));
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
