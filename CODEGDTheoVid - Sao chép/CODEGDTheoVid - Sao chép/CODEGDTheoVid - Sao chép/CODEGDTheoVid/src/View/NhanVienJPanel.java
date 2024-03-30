/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import java.awt.Event;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import model.NhanVienEntity;
import service.NhanVienDao;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nongt
 */
public class NhanVienJPanel extends javax.swing.JPanel {
//IDNHANVIEN,TENNHANVIEN, GIOITINH, EMAIL, NGAYSINH, DIACHI, SODIENTHOAIN, TAIKHOAN, MATKHAU, CHUCVU, NGAYTAO, TRANGTHAI

    int index = -1;
    NhanVienDao nvdao = new NhanVienDao();
    String[] comlums = {
        "Id Nhân Viên", "Tên nhân viên", "Giới tính", "Email", "Ngay Sinh", "Dia chi", "Số diện thoại", "Tài khoản", "Mật khẩu", "Chức vụ", "Ngày tạo", "Ngày sửa", "Trạng thái"
    };
    List<NhanVienEntity> listnv = new ArrayList<>();
    DefaultTableModel model = new DefaultTableModel(comlums, 0);

    /**
     * Creates new form NhanVienJPanel
     */
    public NhanVienJPanel() {
        initComponents();
        tblNhanVien.setModel(model);
        listnv = nvdao.selectAll();
        filltable(listnv);
    }

    void filltable(List<NhanVienEntity> list) {
        model.setRowCount(0);
        for (NhanVienEntity nv : list) {
            model.addRow(nv.torow());
        }
    }

    NhanVienEntity getformnv(int x) {
        int IDNV=nvdao.selectById4()+1;
        String TenNV;
        TenNV = txtTenNhanVien.getText();
        if (TenNV.length() == 0) {
            JOptionPane.showMessageDialog(this, "Chua nhập tên nhân viên !");
            return null;
        }
        int GioiTinh;
        if (rdNam.isSelected()) {
            GioiTinh = 1;
        } else if (rdNu.isSelected()) {
            GioiTinh = 0;
        } else if (rdNu1.isSelected()) {
            GioiTinh = 2;
        } else {
            JOptionPane.showMessageDialog(this, "Chưa chọn Giới tính!");
            return null;
        }
        String EmailNV = txtEmail.getText();
        if (EmailNV.length() == 0) {
            JOptionPane.showMessageDialog(this, "Chua nhập Email nhân viên !");
            return null;
        }
        int ChucVu;
        if (rdquanly.isSelected()) {
            ChucVu = 1;
        } else if (rdnv.isSelected()) {
            ChucVu = 0;
        } else {
            JOptionPane.showMessageDialog(this, "Chưa chọn Chức vụ !");
            return null;
        }
        String NgaySinh, DiaChi, TaiKhoan, MatKhau;
        int soDT;
        NgaySinh = txtngaysinh.getText();
        if (NgaySinh.length() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa Nhập ngày sinh!");
            return null;
        }
        DiaChi = txtDiaChi.getText();
        if (DiaChi.length() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa Nhập địa chỉ!");
            return null;
        }
        String sdt2;
        if (txtSDT.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa Nhập địa chỉ!");
            return null;
        } else {
            try {
                soDT = Integer.parseInt(txtSDT.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Số diện thoại phải là số !");
                return null;
            }
            sdt2 = String.valueOf(soDT);
        }

        MatKhau = txtMatKhau.getText().trim();
//        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).+$";
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(MatKhau);
        if (MatKhau.trim().length() == 0) {
            JOptionPane.showMessageDialog(this, "Chua nhap MK");
            return null;
        } 
//        else if (matcher.matches()) {
//            JOptionPane.showMessageDialog(this, "Mk phải chứa Chữ in hoa,in thường,số và ký tự đặc biệt !");
//            return null;
//        }
        TaiKhoan = txtTaiKhoan.getText();
        if (TaiKhoan.length() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa nhập Tài khoản !");
            return null;
        }
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String ngay = currentDateTime.format(formatter);
        int TrangThai;
        if (rdHD.isSelected()) {
            TrangThai = 1;
        } else if (rdKHD.isSelected()) {
            TrangThai = 0;
        } else {
            JOptionPane.showMessageDialog(this, "Chưa chọn trạng thái !");
            return null;
        }
        //String TenNV, int GioiTinh, String EmailNV, int ChucVu, String NgaySinh, String DiaChi, String SoDT, String TaiKhoan, String MatKhau, String NgayTao, String NgaySua, int TrangThai
        if (x == 0) {
            return new NhanVienEntity(IDNV, TenNV, GioiTinh, EmailNV, ChucVu, NgaySinh, DiaChi, sdt2, TaiKhoan, MatKhau, ngay, TrangThai);
        } else {
            return new NhanVienEntity(TenNV, GioiTinh, EmailNV, ChucVu, NgaySinh, DiaChi, sdt2, TaiKhoan, MatKhau, ngay, TrangThai);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        txtSDT = new javax.swing.JTextField();
        txtTimKiem = new javax.swing.JTextField();
        btntimkiem = new javax.swing.JButton();
        txtTenNhanVien = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        rdNu = new javax.swing.JRadioButton();
        rdHD = new javax.swing.JRadioButton();
        txtTaiKhoan = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        rdNam = new javax.swing.JRadioButton();
        txtDiaChi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnXoa = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        btnSua = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        txtMatKhau = new javax.swing.JTextField();
        rdKHD = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblNhanVien = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        btnClear = new javax.swing.JButton();
        rdnv = new javax.swing.JRadioButton();
        rdquanly = new javax.swing.JRadioButton();
        rdNu1 = new javax.swing.JRadioButton();
        txtngaysinh = new javax.swing.JTextField();

        txtTimKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        btntimkiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btntimkiem.setText("Tìm Kiếm");
        btntimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimkiemActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Trang thái");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setText("Mật khẩu");

        buttonGroup2.add(rdNu);
        rdNu.setText("Nữ");

        buttonGroup1.add(rdHD);
        rdHD.setText("Vẫn làm");

        buttonGroup2.add(rdNam);
        rdNam.setText("Nam");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setText("Ngày sinh");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setText("Chức vụ");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Email");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Giới tính");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setText("Tên nhân viên");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Nhân Viên");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setText("Số điện thoại");

        btnXoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setText("Địa chỉ");

        btnSua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnSua.setText("Sửa ");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnThem.setText("Thêm ");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdKHD);
        rdKHD.setText("Nghỉ rồi");

        tblNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Nhân Viên", "Tên nv", "Giới tính", "Email", "Chức vụ", "Ngày sinh", "Địa chỉ", "SĐT", "Tài Khoản", "Mật Khẩu", "Trạng Thái"
            }
        ));
        tblNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblNhanVienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblNhanVien);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setText("Tài khoản");

        btnClear.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        buttonGroup3.add(rdnv);
        rdnv.setText("Nhân viên");

        buttonGroup3.add(rdquanly);
        rdquanly.setText("Quản lý");

        buttonGroup2.add(rdNu1);
        rdNu1.setText("KXĐ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 815, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(59, 59, 59)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTenNhanVien)
                                    .addComponent(txtDiaChi)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdNam)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdNu)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rdNu1))
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdnv)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rdquanly)))
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel6)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnThem)
                                .addGap(18, 18, 18)
                                .addComponent(btnSua)
                                .addGap(18, 18, 18)
                                .addComponent(btnXoa)
                                .addGap(18, 18, 18)
                                .addComponent(btnClear)))
                        .addGap(78, 78, 78)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(rdHD)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdKHD))
                            .addComponent(txtSDT)
                            .addComponent(txtTaiKhoan)
                            .addComponent(txtMatKhau)
                            .addComponent(txtngaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btntimkiem)
                        .addGap(59, 59, 59)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtngaysinh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdHD)
                            .addComponent(rdKHD)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(116, 116, 116)
                                .addComponent(jLabel10)
                                .addGap(14, 14, 14)
                                .addComponent(jLabel13))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rdNam)
                                    .addComponent(rdNu)
                                    .addComponent(jLabel3)
                                    .addComponent(rdNu1))
                                .addGap(8, 8, 8)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7))
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(rdnv)
                                    .addComponent(rdquanly))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnSua)
                            .addComponent(btnXoa)
                            .addComponent(btnClear))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btntimkiem)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 23, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed

    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed

    }//GEN-LAST:event_btnXoaActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        // TODO add your handling code here:
        index = tblNhanVien.getSelectedRow();
        NhanVienEntity nv = getformnv(1);
        if (index >= 0) {
            if (nv != null) {
                int id = (int) tblNhanVien.getValueAt(index, 0);
                if (JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn sửa ko ?") == 0) {
                    if (nvdao.update(nv, id) > 0) {
                        JOptionPane.showMessageDialog(this, "Sua thanh cong !");
                        filltable(nvdao.selectAll());
                    } else {
                        JOptionPane.showMessageDialog(this, "Sua that bai !");
                    }
                }

            } else {
                JOptionPane.showMessageDialog(this, "Sua that bai !");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Chưa chọn dòng muốn sửa!");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        NhanVienEntity nv = getformnv(0);
        if (nv != null) {
            if (JOptionPane.showConfirmDialog(this, "Bạn có chắc muốn sửa ko ?") == 0) {
                if (nvdao.insert(nv) > 0) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công !");
                    filltable(nvdao.selectAll());
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm that bai 1!");
                }
            }

        } else {
            JOptionPane.showMessageDialog(this, "Thêm that bai 2!");
        }
    }//GEN-LAST:event_btnThemActionPerformed
// "Id Nhân Viên"0, "Tên nhân viên"1, "Giới tính"2, "Email"3, "Ngay Sinh"4, "Dia chi"5, "Số diện thoại"6,
    //"Tài khoản"7, "Mật khẩu"8, "Chức vụ"9, "Ngày tạo"10, "Ngày sửa"11, "Trạng thái"12

    void showData(int index) {
        txtTenNhanVien.setText(tblNhanVien.getValueAt(index, 1).toString());
        txtDiaChi.setText(tblNhanVien.getValueAt(index, 5).toString());
        txtEmail.setText(tblNhanVien.getValueAt(index, 3).toString());
        if (tblNhanVien.getValueAt(index, 2).toString().equalsIgnoreCase("Nam")) {
            rdNam.setSelected(true);
        } else if (tblNhanVien.getValueAt(index, 2).toString().equalsIgnoreCase("Nữ")) {
            rdNu.setSelected(true);
        } else {
            rdNu1.setSelected(true);
        }
        if (tblNhanVien.getValueAt(index, 12).toString().equalsIgnoreCase("Đã nghỉ việc")) {
            rdKHD.setSelected(true);
        } else if (tblNhanVien.getValueAt(index, 12).toString().equalsIgnoreCase("Vẫn làm")) {
            rdHD.setSelected(true);
        }
        if (tblNhanVien.getValueAt(index, 9).toString().equalsIgnoreCase("Nhân viên")) {
            rdnv.setSelected(true);
        } else {
            rdquanly.setSelected(true);
        }
        txtngaysinh.setText(tblNhanVien.getValueAt(index, 4).toString());
        txtSDT.setText(tblNhanVien.getValueAt(index, 6).toString());
        txtTaiKhoan.setText(tblNhanVien.getValueAt(index, 7).toString());
        txtMatKhau.setText(tblNhanVien.getValueAt(index, 8).toString());
    }
    private void tblNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblNhanVienMouseClicked
        // TODO add your handling code here:
        index = tblNhanVien.getSelectedRow();
        this.showData(index);
    }//GEN-LAST:event_tblNhanVienMouseClicked

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        txtTenNhanVien.setText("");
        txtDiaChi.setText("");
        txtEmail.setText("");
        rdHD.setSelected(true);
        rdNam.setSelected(true);
        rdnv.setSelected(true);
        txtSDT.setText("");
        txtTaiKhoan.setText("");
        txtMatKhau.setText("");
    }//GEN-LAST:event_btnClearActionPerformed

    private void btntimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimkiemActionPerformed
        String timkiem=txtTimKiem.getText();
        if(timkiem!=null){
            List<NhanVienEntity> list=nvdao.timkiemnv(timkiem);
            if(list!=null){
                filltable(list);
            }else{
                JOptionPane.showMessageDialog(this, "không có nhân viên nào phù hợp !");
            }
            
        }
    }//GEN-LAST:event_btntimkiemActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btntimkiem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdHD;
    private javax.swing.JRadioButton rdKHD;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JRadioButton rdNu1;
    private javax.swing.JRadioButton rdnv;
    private javax.swing.JRadioButton rdquanly;
    private javax.swing.JTable tblNhanVien;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMatKhau;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTaiKhoan;
    private javax.swing.JTextField txtTenNhanVien;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtngaysinh;
    // End of variables declaration//GEN-END:variables
}
