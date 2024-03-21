/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.NhanVienEntity;
/**
 *
 * @author Admin
 */
public class NhanVienDao extends SysDAO<NhanVienEntity, String>{
     @Override
    public int insert(NhanVienEntity entity) {
        String sql = "INSERT INTO NHANVIEN (TENNHANVIEN, GIOITINH, EMAIL, NGAYSINH, DIACHI, SODIENTHOAIN, TAIKHOAN, MATKHAU, CHUCVU, NGAYTAO, NGAYSUA, TRANGTHAI) VALUES (?,?,?,?, ?, ?, ?)";
        return DBConnect.update(sql,
                entity.getTenNV(),
                entity.getGioiTinh(),
                entity.getDiaChi(),
                entity.getNgayTao(),
                entity.getNgaySua(),
                entity.getTrangThai());
    }

    @Override
    public int update(NhanVienEntity entity,String ma) {
        String sql = "update KHACHHANG set TENKHACHHANG=?, SODIENTHOAI=?, DIACHI=?, EMAIL=?, NGAYSINH=?, GIOITINH=?, NGAYTAO=?, NGAYSUA=?, TRANGTHAI=? where IDKHACHHANG like ?";
        return DBConnect.update(
                sql,
                entity.getTenNV(),
                entity.getSoDT(),
                entity.getDiaChi(),
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
    public NhanVienEntity selectById(String id) {
        String sql = "select IDKHACHHANG,TENKHACHHANG, SODIENTHOAI, DIACHI, EMAIL, NGAYSINH, GIOITINH, NGAYTAO, NGAYSUA, TRANGTHAI from KHACHHANG where IDKHACHHANG like ?";
        List<NhanVienEntity> list = selectBySql(sql, id);
        return !list.isEmpty() ? list.get(0) : null;
    }

    @Override
    public List<NhanVienEntity> selectAll() {
        String sql = "select IDKHACHHANG,TENKHACHHANG, SODIENTHOAI, DIACHI, EMAIL, NGAYSINH, GIOITINH, NGAYTAO, NGAYSUA, TRANGTHAI from KHACHHANG;";
        return selectBySql(sql);
    }

//    private int IDNV;
//    private String MaNV,TenNV;
//    private int GioiTinh;
//    private String EmailNV;
//    private int ChucVu;
//    private String NgaySinh,DiaChi,SoDT,TaiKhoan,MatKhau,NgayTao,NgaySua;
//    private int TrangThai;
    @Override
    protected List<NhanVienEntity> selectBySql(String sql, Object... args) {
        List<NhanVienEntity> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = DBConnect.query(sql, args);
                while (rs.next()) {
                    NhanVienEntity xs=new NhanVienEntity(
                            rs.getInt(1),
                            rs.getString(2), 
                            rs.getString(3), 
                            rs.getInt(4),
                            rs.getString(5), 
                            rs.getInt(6),
                            rs.getString(7), 
                            rs.getString(8), 
                            rs.getString(9),
                            rs.getString(10),
                            rs.getString(11),
                            rs.getString(12),
                            rs.getString(13),
                            rs.getInt(14));
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
