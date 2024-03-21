/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.NongDo;
/**
 *
 * @author Admin
 */
public class NongDoDao extends SysDAO<NongDo, String>{

    @Override
    public int insert(NongDo entity) {
        String sql = "INSERT INTO NONGDO (TENNONGDO, NGAYTAO, NGAYSUA, TRANGTHAI) VALUES (?, ?, ?, ?)";
        return DBConnect.update(sql,
                entity.getTenNongDo(),
                entity.getNgayTao(),
                entity.getNgaySua(),
                entity.getTrangThai());
    }

    @Override
    public int update(NongDo entity,String ma) {
        String sql = "update NONGDO set TENNONGDO=?, NGAYTAO=?, NGAYSUA=?, TRANGTHAI=? where IDNONGDO like ?";
        return DBConnect.update(sql,
                entity.getTenNongDo(),
                entity.getNgayTao(),
                entity.getNgaySua(),
                entity.getTrangThai(),
                ma
        );
    }

    @Override
    public int delete(String id) {
        String sql = "DELETE FROM NONGDO where IDNONGDO like ?";
        return DBConnect.update(sql, id);
    }

    @Override
    public NongDo selectById(String id) {
        String sql = "select IDNONGDO,TENNONGDO, NGAYTAO, NGAYSUA, TRANGTHAI from NONGDO where IDNONGDO like ?";
        List<NongDo> list = selectBySql(sql, id);
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public List<NongDo> selectAll() {
        String sql = "select IDNONGDO,TENNONGDO, NGAYTAO, NGAYSUA, TRANGTHAI FROM NONGDO;";
        return selectBySql(sql);
    }

    @Override
    protected List<NongDo> selectBySql(String sql, Object... args) {
        List<NongDo> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = DBConnect.query(sql, args);
                while (rs.next()) {
                    NongDo xs=new NongDo(rs.getInt(1),
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
