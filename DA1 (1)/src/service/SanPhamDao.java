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
/**
 *
 * @author Admin
 */
public class SanPhamDao extends SysDAO<SanPham, String>{
     @Override
    public int insert(SanPham entity) {
        String sql = "INSERT INTO SANPHAM ( TENSANPHAM, NGAYTAO, NGAYSUA,SOLUONG, TRANGTHAI) VALUES (?,?,?, ?, ?, ?)";
        return DBConnect.update(sql,
                entity.getTenSanPham(),
                entity.getNgayTao(),
                entity.getNgaySua(),
                entity.getSoLg(),
                entity.getTrangThai());
    }

    @Override
    public int update(SanPham entity,String ma) {
        String sql = "update SANPHAM set TENSANPHAM=?, NGAYSUA=?,SOLUONG=?, TRANGTHAI=? where IDSANPHAM like ?";
        return DBConnect.update(sql,
               entity.getTenSanPham(),
                entity.getNgaySua(),
                entity.getSoLg(),
                entity.getTrangThai(),
                ma
        );
    }

    @Override
    public int delete(String id) {
        String sql = "DELETE FROM SANPHAM where IDSANPHAM like ?";
        return DBConnect.update(sql, id);
    }

    @Override
    public SanPham selectById(String id) {
        String sql = "select IDSANPHAM, TENSANPHAM, NGAYTAO, NGAYSUA,SOLUONG, TRANGTHAI from SANPHAM where IDSANPHAM like ?";
        List<SanPham> list = selectBySql(sql, id);
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public List<SanPham> selectAll() {
        String sql = "select IDSANPHAM, TENSANPHAM, NGAYTAO, NGAYSUA,SOLUONG, TRANGTHAI FROM SANPHAM;";
        return selectBySql(sql);
    }

    @Override
    protected List<SanPham> selectBySql(String sql, Object... args) {
        List<SanPham> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = DBConnect.query(sql, args);
                while (rs.next()) {
                    SanPham xs=new SanPham(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)
                            , rs.getInt(5), rs.getInt(6));
                            
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
