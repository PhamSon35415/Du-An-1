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
import JDBC.jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author Admin
 */
public class NhanVienDao extends SysDAO<NhanVienEntity, Integer> {

    @Override
    public int insert(NhanVienEntity entity) {
        String sql = "INSERT INTO NHANVIEN (IDNHANVIEN,TENNHANVIEN, GIOITINH, EMAIL, NGAYSINH, DIACHI, SODIENTHOAIN, TAIKHOAN, MATKHAU, CHUCVU, NGAYTAO, TRANGTHAI) VALUES "
                + "(?,?,?,?, ?, ?, ?,?,?,?,getdate(),?)";
        return jdbc.update(sql,
                entity.getIDNV(),
                entity.getTenNV(),
                entity.getGioiTinh(),
                entity.getEmailNV(),
                entity.getNgaySinh(),
                entity.getDiaChi(),
                entity.getSoDT(),
                entity.getTaiKhoan(),
                entity.getMatKhau(),
                entity.getChucVu(),
                entity.getTrangThai());
    }

    @Override
    public int update(NhanVienEntity entity, Integer ma) {
        String sql = "update NHANVIEN set TENNHANVIEN=?, GIOITINH=?, EMAIL=?, NGAYSINH=?, DIACHI=?, SODIENTHOAIN=?, TAIKHOAN=?, MATKHAU=?, CHUCVU=?, NGAYSUA=?, TRANGTHAI=? where IDNHANVIEN like ?";
        return jdbc.update(
                sql,
                entity.getTenNV(),
                entity.getGioiTinh(),
                entity.getEmailNV(),
                entity.getNgaySinh(),
                entity.getDiaChi(),
                entity.getSoDT(),
                entity.getTaiKhoan(),
                entity.getMatKhau(),
                entity.getChucVu(),
                entity.getNgaySua(),
                entity.getTrangThai(),
                ma
        );
    }

    @Override
    public int delete(Integer id) {
        String sql = "DELETE FROM NHANVIEN where IDNHANVIEN like ?";
        return jdbc.update(sql, id);
    }

    @Override
    public NhanVienEntity selectById(Integer id) {
        String sql = "select IDNHANVIEN,TENNHANVIEN, GIOITINH, EMAIL, NGAYSINH, DIACHI, SODIENTHOAIN, TAIKHOAN, MATKHAU, CHUCVU, NGAYTAO,NGAYSUA, TRANGTHAI from NHANVIEN where IDNHANVIEN like ?";
        List<NhanVienEntity> list = selectBySql(sql, id);
        return !list.isEmpty() ? list.get(0) : null;
    }

    public int selectById4() {
        String sql = "select IDNHANVIEN from NHANVIEN order by IDNHANVIEN";
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
    public List<NhanVienEntity> selectAll() {
        String sql = "select IDNHANVIEN,TENNHANVIEN, GIOITINH, EMAIL, NGAYSINH, DIACHI, SODIENTHOAIN, TAIKHOAN, MATKHAU, CHUCVU, NGAYTAO,NGAYSUA, TRANGTHAI from NHANVIEN;";
        return selectBySql(sql);
    }

    public List<NhanVienEntity> timkiemnv(String x) {
        String sql = """
              SELECT IDNHANVIEN, TENNHANVIEN, GIOITINH, EMAIL, NGAYSINH, DIACHI, SODIENTHOAIN, TAIKHOAN, MATKHAU, CHUCVU, NGAYTAO, NGAYSUA, TRANGTHAI
              FROM NHANVIEN
              WHERE IDNHANVIEN = ? OR TENNHANVIEN LIKE '?' OR SODIENTHOAIN LIKE '?' OR TAIKHOAN LIKE '?'
            """;
         Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<NhanVienEntity> list = new ArrayList<>();
        try {
            conn = jdbc.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setObject(1, "%" + x + "%");
            ps.setObject(2, "%" + x + "%");
            ps.setObject(3, "%" + x + "%");
            ps.setObject(4, "%" + x + "%");
            rs = ps.executeQuery();
            while (rs.next()) {
                NhanVienEntity xs = new NhanVienEntity(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getString(4),
                        rs.getInt(10),
                        rs.getString(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(11),
                        rs.getString(12),
                        rs.getInt(13));
                list.add(xs);
            }
            return list;
        } catch (SQLException e) {
            return null;
        }
    }
//IDNHANVIEN, TENNHANVIEN, GIOITINH, EMAIL, NGAYSINH, DIACHI, SODIENTHOAIN, TAIKHOAN, MATKHAU, CHUCVU, NGAYTAO, NGAYSUA, TRANGTHAI
//    private int IDNV 1;
//    private String TenNV 2;
//    private int GioiTinh 3;
//    private String EmailNV 4;
//    private int ChucVu 10;
//    private String NgaySinh 5,DiaChi 6,SoDT 7,TaiKhoan 8,MatKhau 9,NgayTao 11,NgaySua 12;
//    private int TrangThai 13;

    @Override
    protected List<NhanVienEntity> selectBySql(String sql, Object... args) {
        List<NhanVienEntity> list = new ArrayList<>();
        try {
            ResultSet rs = null;
            try {
                rs = jdbc.query(sql, args);
                while (rs.next()) {
                    NhanVienEntity xs = new NhanVienEntity(
                            rs.getInt(1),
                            rs.getString(2),
                            rs.getInt(3),
                            rs.getString(4),
                            rs.getInt(10),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8),
                            rs.getString(9),
                            rs.getString(11),
                            rs.getString(12),
                            rs.getInt(13));
                    list.add(xs);
                }
            } finally {
                rs.getStatement().getConnection().close();
            }
        } catch (SQLException ex) {
            return null;
        }
        return list;
    }

}
