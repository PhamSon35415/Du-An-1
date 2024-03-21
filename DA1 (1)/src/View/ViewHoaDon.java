/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import service.*;
import model.*;
import java.util.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author ACER
 */
public class ViewHoaDon extends javax.swing.JFrame {

    DefaultComboBoxModel cb = new DefaultComboBoxModel();
    HoaDonDao hdao = new HoaDonDao();
    HoaDonChiTietDao hdct = new HoaDonChiTietDao();
    String[] tablehd = {
        "IDHD", "Tên khách hàng", "Tên nhân viên", "Phương thức thanh toán", "VocCher", "Tổng tiền", "Ngày tạo", "Ngày Sửa", "Trạng thái"
    };
    //IDHD,IDSpCt,TenSanPham,SoLg,GiaBan,TongTien,NgayTao, NgaySua,TrangThai
    public String[] tablehdct2 = {
        "Id HDCT", "ID SPCT", "IDHD", "Tên SP", "Số lg", "Giá bán", "Tổng tiền", "Ngày tạo", "Ngày Sửa", "Trạng thái"
    };
    DefaultTableModel model = new DefaultTableModel(tablehd, 0);

    /**
     * Creates new form ViewHoaDo
     */
    DefaultTableModel xl = new DefaultTableModel(tablehdct2, 0);
    private List<HoaDon> listhd = hdao.selectAll();

    public ViewHoaDon() {
        initComponents();
        addcobo();
        tablehdct.setModel(xl);
        tablehoadon.setModel(model);
        filltable(hdao.selectAll());
        filltable2(hdct.selectAll());
        setLocationRelativeTo(null);

    }
//"IDHD", "Tên khách hàng", "Tên nhân viên", "Phương thức thanh toán", "VocCher", "Tổng tiền", "Ngày tạo", "Ngày Sửa", "Trạng thái"

    void filltable(List<HoaDon> list) {
        model.setRowCount(0);
        for (HoaDon hoaDon : list) {
            model.addRow(hoaDon.torow());
        }
    }

    void filltable2(List<HoaDonChiTiet> list) {
        xl.setRowCount(0);
        for (HoaDonChiTiet hoaDon : list) {
            xl.addRow(hoaDon.torow());
        }

    }

    public void addcobo() {
        cb = (DefaultComboBoxModel) cbkhachhang.getModel();
        cb.removeAllElements();
        for (String object : hdao.getkh()) {
            cb.addElement(object);
        }
        cb = (DefaultComboBoxModel) cbphuongthu.getModel();
        cb.removeAllElements();
        for (String object : hdao.getPhuongTT()) {
            cb.addElement(object);
        }
        cb = (DefaultComboBoxModel) cbtennv.getModel();
        cb.removeAllElements();
        for (String object : hdao.getNV()) {
            cb.addElement(object);
        }
    }

    void loadform(int inde) {
        //"IDHD","Tên khách hàng", "Tên nhân viên", "Phương thức thanh toán", "VocCher","Tổng tiền","Ngày tạo", "Ngày Sửa","Trạng thái"
        cbkhachhang.setSelectedItem(tablehoadon.getValueAt(inde, 1));
        cbphuongthu.setSelectedItem(tablehoadon.getValueAt(inde, 3));
        cbtennv.setSelectedItem(tablehoadon.getValueAt(inde, 2));
        if (tablehoadon.getValueAt(inde, 4) != null) {
            txtvocher.setText(tablehoadon.getValueAt(inde, 4).toString());
        } else {
            txtvocher.setText(".................");
        }
        if (tablehoadon.getValueAt(inde, 5) != null) {
            txtTongtien.setText(tablehoadon.getValueAt(inde, 5).toString());
        } else {
            txtTongtien.setText("................................................");
        }
        if (tablehoadon.getValueAt(inde, 6) != null) {
            txtngaytao.setText(tablehoadon.getValueAt(inde, 6).toString());
        } else {
            txtngaytao.setText("................................................");
        }
        if (tablehoadon.getValueAt(inde, 7) != null) {
            txtngaysua.setText(tablehoadon.getValueAt(inde, 7).toString());
        } else {
            txtngaysua.setText("................................................");
        }
        if (tablehoadon.getValueAt(inde, 8) != null) {
            txttrangthai.setText(tablehoadon.getValueAt(inde, 8).toString());
        } else {
            txttrangthai.setText("................................................");
        }

    }

//    HoaDon getform() {
//        int idkh = hdao.getidKh(cbkhachhang.getSelectedItem().toString());
//        int idnv = hdao.getidNV(cbtennv.getSelectedItem().toString());
//        int idpt = hdao.getidPT(cbphuongthu.getSelectedItem().toString());
//        int idvc2 = 0;
//        if (txtvocher.getText().length() != 0) {
//            idvc2 = hdao.getidVC(txtvocher.getText());
//            if (idvc2 == 0) {
//                JOptionPane.showMessageDialog(this, "Ko tồn tại Voucher Này !");
//                return null;
//            } else {
//                idvc2 = 4;
//            }
//
//        } else {
//            idvc2 = 4;
//        }
//        LocalDateTime currentDateTime = LocalDateTime.now();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
//        String ngaytao = currentDateTime.format(formatter);
//        int c=tablehoadon.getSelectedRow();
//        double tongtien=Double.parseDouble((String) tablehoadon.getValueAt(c, 5));
//        
//        return new HoaDon(idkh, idnv, idpt, idvc2, tongtien, ngaytao, 1);
//    }
    HoaDon getform2() {
        int idvc2 = 4;
        if (txtvocher.getText().trim().length() == 0) {
            idvc2 = 4;
        } else {
            idvc2 = hdao.getidVC(txtvocher.getText());
            if (idvc2 == 0) {
                JOptionPane.showMessageDialog(this, "Ko tồn tại Voucher Này !");
                return null;
            }
        }
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

        String ngaySua = currentDateTime.format(formatter);
        return new HoaDon(hdao.getidKh(cbkhachhang.getSelectedItem().toString()),
                hdao.getidNV(cbtennv.getSelectedItem().toString()),
                hdao.getidPT(cbphuongthu.getSelectedItem().toString()),
                idvc2, 250000, ngaySua, 1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtvocher = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablehoadon = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnclear = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablehdct = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        txtTongtien = new javax.swing.JLabel();
        txtngaytao = new javax.swing.JLabel();
        txtngaysua = new javax.swing.JLabel();
        txttrangthai = new javax.swing.JLabel();
        cbtennv = new javax.swing.JComboBox<>();
        cbkhachhang = new javax.swing.JComboBox<>();
        cbphuongthu = new javax.swing.JComboBox<>();
        btncapnhap = new javax.swing.JButton();
        btnsua = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        loctheonv = new javax.swing.JComboBox<>();
        sapxep = new javax.swing.JComboBox<>();
        btntimkiem = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtdenngay = new com.toedter.calendar.JDateChooser();
        txttungay = new com.toedter.calendar.JDateChooser();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setType(java.awt.Window.Type.UTILITY);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Ngày Sửa");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Mã Voucher");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Ngày Tạo:");

        tablehoadon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tên kh", "Tên nv", "Phương thức tt", "Mã voucher", "Tổng tiền", "Ngày tạo", "Ngày sửa", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablehoadon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablehoadonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tablehoadon);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Hóa Đơn");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Tên Khác Hàng");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("Trang Thái");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Tên Nhân Viên");

        btnclear.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnclear.setText("Clear");
        btnclear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel10.setText("Hóa Đơn Chi tiết");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Tổng Tiền:");

        tablehdct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Tên sản phẩm", "Giá bán", "Số lượng", "Ngày tạo", "Ngày sửa", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tablehdct);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Phương Thức Thanh Toán");

        txtTongtien.setText("................................................");

        txtngaytao.setText("................................................");

        txtngaysua.setText("................................................");

        txttrangthai.setText("................................................");

        cbtennv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbkhachhang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbphuongthu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btncapnhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btncapnhap.setText("Cập nhâp trạng thái");
        btncapnhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncapnhapActionPerformed(evt);
            }
        });

        btnsua.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnsua.setText("Chỉnh sửa hóa đơn");
        btnsua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        loctheonv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Không", "Đã hủy", "Chưa thanh toán", "Đã thanh toán", "Đang giao", "Đã giao" }));
        loctheonv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loctheonvActionPerformed(evt);
            }
        });

        sapxep.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Không", "Tăng theo Tổng tiền", "Giảm theo tổng tiền", " " }));
        sapxep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sapxepActionPerformed(evt);
            }
        });

        btntimkiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btntimkiem.setText("Tìm kiếm");
        btntimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btntimkiemActionPerformed(evt);
            }
        });

        jLabel11.setText("Từ ngày:");

        jLabel12.setText("Trạng thái");

        jButton1.setText("Lọc");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtdenngay.setDateFormatString("dd-MM-yyyy");

        txttungay.setDateFormatString("dd-MM-yyyy");

        jLabel13.setText("Sắp xếp");

        jLabel14.setText("Đến ngày:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txttungay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(sapxep, 0, 226, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(loctheonv, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdenngay, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btntimkiem)
                                .addGap(45, 45, 45))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48))))))
            .addComponent(jSeparator2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txttungay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtdenngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loctheonv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sapxep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btntimkiem))
                .addContainerGap())
        );

        jButton2.setText("In hoa don");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel8))
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtvocher)
                                    .addComponent(cbtennv, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbkhachhang, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbphuongthu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(txttrangthai, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btncapnhap)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnclear)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnsua))
                                .addComponent(jScrollPane1)
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(494, 494, 494)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtngaysua, javax.swing.GroupLayout.DEFAULT_SIZE, 153, Short.MAX_VALUE)
                                        .addComponent(txtngaytao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(txtTongtien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                        .addContainerGap(12, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(267, 267, 267))
            .addGroup(layout.createSequentialGroup()
                .addGap(279, 279, 279)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jSeparator1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cbkhachhang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(cbtennv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(cbphuongthu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtvocher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtTongtien))
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtngaytao))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtngaysua))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txttrangthai))))
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btncapnhap)
                        .addComponent(jButton2))
                    .addComponent(btnsua)
                    .addComponent(btnclear))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablehoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablehoadonMouseClicked
        int index = tablehoadon.getSelectedRow();
        loadform(index);

    }//GEN-LAST:event_tablehoadonMouseClicked

    private void btntimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimkiemActionPerformed
        String timkiem = JOptionPane.showInputDialog("Nhập hóa dơn cần tìm:", null);
        if (timkiem != null && timkiem.trim().length() != 0) {
            filltable(hdao.selectById2(timkiem, timkiem, timkiem));
        }
    }//GEN-LAST:event_btntimkiemActionPerformed

    private void btncapnhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncapnhapActionPerformed
        String[] luachon = {
            "Hủy Hóa đơn", "Chưa thanh toán", "Đã thanh toán", "Đang giao", "Đã giao"
        };
        int x = JOptionPane.showOptionDialog(null, "Chọn trạng thái", "Trạng thái đơn hàng",
                JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                null, luachon, luachon[0]);
        //0:Da huy,1 Chua thanh toan, 2:da thanhtoan ,3:Dang giao,4:Da giao
        int index = tablehoadon.getSelectedRow();
        if (index >= 0) {
            if (x != -1) {
                hdao.updateTrangthai(x, tablehoadon.getValueAt(index, 0).toString());
                filltable(hdao.selectAll());
            }

        }
    }//GEN-LAST:event_btncapnhapActionPerformed

    private void btnsuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaActionPerformed
        HoaDon hd = getform2();
        if (hd != null) {
            int index = tablehoadon.getSelectedRow();
            if (index >= 0) {
                if (JOptionPane.showConfirmDialog(this, "Bạn có muốn sửa hóa đơn này ko :") == 0) {
                    if (hdao.update(hd, tablehoadon.getValueAt(index, 0).toString()) != 0) {
                        JOptionPane.showMessageDialog(this, "Sua thành công !");
                        filltable(hdao.selectAll());
                    } else {
                        JOptionPane.showMessageDialog(this, "Sua thất bại !");
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "Chưa chọn hóa đơn muốn sửa !");

            }

        }


    }//GEN-LAST:event_btnsuaActionPerformed

    private void btnclearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearActionPerformed
        cbkhachhang.setSelectedIndex(3);
        cbphuongthu.setSelectedIndex(0);
        cbtennv.setSelectedIndex(0);
        txtTongtien.setText("................................................");
        txtngaysua.setText("................................................");
        txtngaytao.setText("................................................");
        txttrangthai.setText("................................................");
        txtvocher.setText("");
    }//GEN-LAST:event_btnclearActionPerformed


    private void sapxepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sapxepActionPerformed
        filltable(hdao.sapxep(sapxep.getSelectedIndex(), listhd));
//        if()
    }//GEN-LAST:event_sapxepActionPerformed

    private void loctheonvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loctheonvActionPerformed

        filltable(hdao.trangthai(loctheonv.getSelectedIndex() - 1, listhd));
    }//GEN-LAST:event_loctheonvActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date denngay = txtdenngay.getDate();
        Date tungay = txttungay.getDate();
        String formattedDate;
        String formattedDate1;
        if (denngay == null || tungay == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn ngày!");
        } else {
            formattedDate = outputFormat.format(tungay);
            formattedDate1 = outputFormat.format(denngay);
            if (tungay.compareTo(denngay) > 0) {
                JOptionPane.showMessageDialog(this, "Ngày phải theo thứ tự");
            } else {
                listhd = hdao.selectByNgay(formattedDate, formattedDate1);
                filltable(listhd);

            }
        }


    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncapnhap;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btnsua;
    private javax.swing.JButton btntimkiem;
    private javax.swing.JComboBox<String> cbkhachhang;
    private javax.swing.JComboBox<String> cbphuongthu;
    private javax.swing.JComboBox<String> cbtennv;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JComboBox<String> loctheonv;
    private javax.swing.JComboBox<String> sapxep;
    private javax.swing.JTable tablehdct;
    private javax.swing.JTable tablehoadon;
    private javax.swing.JLabel txtTongtien;
    private com.toedter.calendar.JDateChooser txtdenngay;
    private javax.swing.JLabel txtngaysua;
    private javax.swing.JLabel txtngaytao;
    private javax.swing.JLabel txttrangthai;
    private com.toedter.calendar.JDateChooser txttungay;
    private javax.swing.JTextField txtvocher;
    // End of variables declaration//GEN-END:variables
}
