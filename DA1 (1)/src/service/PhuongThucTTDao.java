/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.PhuongThucThanhToan;
/**
 *
 * @author Admin
 */
public class PhuongThucTTDao extends SysDAO<PhuongThucThanhToan, String>{
     @Override
    public int insert(PhuongThucThanhToan entity) {
        String sql = "INSERT INTO PHUONGTHUCTHANHTOAN (TENPHUONGTHUCTHANHTOAN, NGAYTAO, NGAYSUA, TRANGTHAI) VALUES (?, ?, ?, ?)";
        return DBConnect.update(sql,
                entity.getTenPhuongThucThanhToan(),
                entity.getNgayTao(),
                entity.getNgaySua(),
                entity.getTrangThai());
    }

    @Override
    public int update(PhuongThucThanhToan entity,String ma) {
        String sql = "update PHUONGTHUCTHANHTOAN set TENPHUONGTHUCTHANHTOAN=?, NGAYTAO=?, NGAYSUA=?, TRANGTHAI=? where IDPHUONGTHUCTHANHTOAN like ?";
        return DBConnect.update(sql,
                entity.getTenPhuongThucThanhToan(),
                entity.getNgayTao(),
                entity.getNgaySua(),
                entity.getTrangThai(),
                ma
        );
    }

    @Override
    public int delete(String id) {
        String sql = "DELETE FROM PHUONGTHUCTHANHTOAN where IDPHUONGTHUCTHANHTOAN like ?";
        return DBConnect.update(sql, id);
    }

    @Override
    public PhuongThucThanhToan selectById(String id) {
        String sql = "select IDPHUONGTHUCTHANHTOAN,TENPHUONGTHUCTHANHTOAN, NGAYTAO, NGAYSUA, TRANGTHAI from PHUONGTHUCTHANHTOAN where IDPHUONGTHUCTHANHTOAN like ?";
        List<PhuongThucThanhToan> list = selectBySql(sql, id);
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public List<PhuongThucThanhToan> selectAll() {
        String sql = "select IDPHUONGTHUCTHANHTOAN,TENPHUONGTHUCTHANHTOAN, NGAYTAO, NGAYSUA, TRANGTHAI FROM PHUONGTHUCTHANHTOAN;";
        return selectBySql(sql);
    }

    @Override
    protected List<PhuongThucThanhToan> selectBySql(String sql, Object... args) {
        List<PhuongThucThanhToan> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = DBConnect.query(sql, args);
                while (rs.next()) {
                    PhuongThucThanhToan xs=new PhuongThucThanhToan(rs.getInt(1),
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
