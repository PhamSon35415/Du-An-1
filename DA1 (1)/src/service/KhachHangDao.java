/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.KhachHangEntity;
/**
 *
 * @author Admin
 */
public class KhachHangDao extends SysDAO<KhachHangEntity, String>{

 @Override
    public int insert(KhachHangEntity entity) {
        String sql = "INSERT INTO KHACHHANG (TENKHACHHANG, SODIENTHOAI, DIACHI, EMAIL, NGAYSINH, GIOITINH, NGAYTAO, NGAYSUA, TRANGTHAI) VALUES (?,?,?,?, ?, ?, ?)";
        return DBConnect.update(sql,
                entity.getTenKH(),
                entity.getSoDT(),
                entity.getDiaChi(),
                entity.getEmailKH(),
                entity.getEmailKH(),
                entity.getEmailKH(),
                entity.getNgayTao(),
                entity.getNgaySua(),
                entity.getTrangThai());
    }

    @Override
    public int update(KhachHangEntity entity,String ma) {
        String sql = "update KHACHHANG set TENKHACHHANG=?, SODIENTHOAI=?, DIACHI=?, EMAIL=?, NGAYSINH=?, GIOITINH=?, NGAYTAO=?, NGAYSUA=?, TRANGTHAI=? where IDKHACHHANG like ?";
        return DBConnect.update(
                sql,
                entity.getTenKH(),
                entity.getSoDT(),
                entity.getDiaChi(),
                entity.getEmailKH(),
                entity.getEmailKH(),
                entity.getEmailKH(),
                entity.getNgayTao(),
                entity.getNgaySua(),
                entity.getTrangThai(),
                ma
        );
    }

    @Override
    public int delete(String id) {
        String sql = "DELETE FROM KHACHHANG where IDKHACHHANG like ?";
        return DBConnect.update(sql, id);
    }

    @Override
    public KhachHangEntity selectById(String id) {
        String sql = "select IDKHACHHANG,TENKHACHHANG, SODIENTHOAI, DIACHI, EMAIL, NGAYSINH, GIOITINH, NGAYTAO, NGAYSUA, TRANGTHAI from KHACHHANG where IDKHACHHANG like ?";
        List<KhachHangEntity> list = selectBySql(sql, id);
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public List<KhachHangEntity> selectAll() {
        String sql = "select IDKHACHHANG,TENKHACHHANG, SODIENTHOAI, DIACHI, EMAIL, NGAYSINH, GIOITINH, NGAYTAO, NGAYSUA, TRANGTHAI from KHACHHANG;";
        return selectBySql(sql);
    }

    @Override
    protected List<KhachHangEntity> selectBySql(String sql, Object... args) {
        List<KhachHangEntity> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = DBConnect.query(sql, args);
                while (rs.next()) {
                    KhachHangEntity xs=new KhachHangEntity(
                            rs.getInt(1),
                            rs.getString(2), 
                            rs.getString(3), 
                            rs.getString(4), 
                            rs.getString(5), 
                            rs.getString(6), 
                            rs.getString(7),
                            rs.getInt(8),
                            rs.getString(9),
                            rs.getString(10),
                            rs.getInt(11));
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
