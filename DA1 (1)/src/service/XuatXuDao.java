/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.XuatSu;

/**
 *
 * @author Admin
 */
public class XuatXuDao extends SysDAO<XuatSu, String> {

    @Override
    public int insert(XuatSu entity) {
        String sql = "INSERT INTO XUATXU (TENXUATXU, NGAYSUA, TRANGTHAI) VALUES (?, ?, ?, ?)";
        return DBConnect.update(sql,
                entity.getTenXuatSu(),
                entity.getNgayTao(),
                entity.getNgaySua(),
                entity.getTrangThai());
    }

    @Override
    public int update(XuatSu entity,String ma) {
        String sql = "update XUATXU set TENXUATXU=?, NGAYSUA=?, TRANGTHAI=? where IDXUATXU like ?";
        return DBConnect.update(sql,
                entity.getTenXuatSu(),
                entity.getNgaySua(),
                entity.getTrangThai(),
                ma
        );
    }

    @Override
    public int delete(String id) {
        String sql = "DELETE FROM XUATXU where IDXUATXU like ?";
        return DBConnect.update(sql, id);
    }

    @Override
    public XuatSu selectById(String id) {
        String sql = "select IDXUATXU,TENXUATXU, NGAYTAO, NGAYSUA, TRANGTHAI from XUATXU where IDXUATXU like ?";
        List<XuatSu> list = selectBySql(sql, id);
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public List<XuatSu> selectAll() {
        String sql = "select IDXUATXU,TENXUATXU, NGAYTAO, NGAYSUA, TRANGTHAI FROM XUATXU;";
        return selectBySql(sql);
    }

    @Override
    protected List<XuatSu> selectBySql(String sql, Object... args) {
        List<XuatSu> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = DBConnect.query(sql, args);
                while (rs.next()) {
                    XuatSu xs=new XuatSu(rs.getInt(1),
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
