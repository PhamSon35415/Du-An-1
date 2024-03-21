/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.VouCher;

/**
 *
 * @author Admin
 */
public class VouCherDao extends SysDAO<VouCher, String>{
     @Override
    public int insert(VouCher entity) {
        String sql = "INSERT INTO VOUCHER (MAVOUCHER, PHANCHAMGIAMGIA, NGAYBATDAU, NGAYKETTHUC, NGAYTAO, NGAYSUA, TRANGTHAI) VALUES (?,?,?,?, ?, ?, ?)";
        return DBConnect.update(sql,
                entity.getMaVC(),
                entity.getPhanTramGiam(),
                entity.getNgayBatDau(),
                entity.getNgayKetThuc(),
                entity.getNgayTao(),
                entity.getNgaySua(),
                entity.getTrangThai());
    }

    @Override
    public int update(VouCher entity,String ma) {
        String sql = "update VOUCHER set PHANCHAMGIAMGIA=?, NGAYBATDAU=?, NGAYKETTHUC=?, NGAYTAO=?, NGAYSUA=?, TRANGTHAI=? where IDVOUCHER like ?";
        return DBConnect.update(
                sql,
                entity.getPhanTramGiam(),
                entity.getNgayBatDau(),
                entity.getNgayKetThuc(),
                entity.getNgayTao(),
                entity.getNgaySua(),
                entity.getTrangThai(),
                ma
        );
    }

    @Override
    public int delete(String id) {
        String sql = "DELETE FROM VOUCHER where IDVOUCHER like ?";
        return DBConnect.update(sql, id);
    }

    @Override
    public VouCher selectById(String id) {
        String sql = "select IDVOUCHER,MAVOUCHER, PHANCHAMGIAMGIA, NGAYBATDAU, NGAYKETTHUC, NGAYTAO, NGAYSUA, TRANGTHAI from VOUCHER where IDVOUCHER like ?";
        List<VouCher> list = selectBySql(sql, id);
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public List<VouCher> selectAll() {
        String sql = "select IDVOUCHER,MAVOUCHER, PHANCHAMGIAMGIA, NGAYBATDAU, NGAYKETTHUC, NGAYTAO, NGAYSUA, TRANGTHAI from VOUCHER;";
        return selectBySql(sql);
    }

    @Override
    protected List<VouCher> selectBySql(String sql, Object... args) {
        List<VouCher> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = DBConnect.query(sql, args);
                while (rs.next()) {
                    VouCher xs=new VouCher(
                            rs.getInt(1),
                            rs.getString(2), 
                            rs.getDouble(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getInt(8));
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
