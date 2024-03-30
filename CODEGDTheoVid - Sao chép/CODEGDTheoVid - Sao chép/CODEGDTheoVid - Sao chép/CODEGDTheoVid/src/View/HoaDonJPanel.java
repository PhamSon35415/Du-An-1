/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.HoaDon;
import model.HoaDonChiTiet;
import service.HoaDonChiTietDao;
import service.HoaDonDao;

/**
 *
 * @author Admin
 */
public class HoaDonJPanel extends javax.swing.JPanel {

    DefaultComboBoxModel cb = new DefaultComboBoxModel();
    HoaDonDao hdao = new HoaDonDao();
    //IDHOADON, ID_KHACHHANG, ID_NHANVIEN, ID_VOUCHER, ID_PHUONGTHUCTHANHTOAN, TONGTIEN, THANHTIEN, GiamGia, NGAYTHANHTOAN, NGAYTAO, NGAYSUA, TRANGTHAI
    HoaDonChiTietDao hdct = new HoaDonChiTietDao();
    String[] tablehd = {
        "IDHD", "Tên khách hàng", "Tên nhân viên", "VocCher", "Phương thức thanh toán", "Tổng tiền", "Thành tiền", "Giảm giá", "Ngày thanh toán", "Ngày tạo", "Ngày Sửa", "Trạng thái"
    };
    //IDHOADON, hdct.IDSANPHAMCHITIET, hdct.SOLUONG,sp.TENSANPHAM, hdct.GIA

    DefaultTableModel xl = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Trả về false nếu muốn các ô không thể chỉnh sửa
        }
    };
    DefaultTableModel model = new DefaultTableModel(tablehd, 0) {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false; // Trả về false nếu muốn các ô không thể chỉnh sửa
        }
    };

    private List<HoaDon> listhd = hdao.selectAll();

    /**
     * Creates new form HoaDonJPanel
     */
    public HoaDonJPanel() {
        initComponents();
        tablehoadon.setModel(model);
        filltable(hdao.selectAll());
    }
    //IDHOADON, ID_KHACHHANG, ID_NHANVIEN, ID_VOUCHER, ID_PHUONGTHUCTHANHTOAN, TONGTIEN, THANHTIEN, GiamGia, NGAYTHANHTOAN, NGAYTAO, NGAYSUA, TRANGTHAI

    void filltable(List<HoaDon> list) {
        model.setRowCount(0);
        for (HoaDon hoaDon : list) {
            String tt;
            tt = switch (hoaDon.getTRANGTHAI()) {
                case 0 ->
                    "Đã hủy";
                case 1 ->
                    "Chưa thanh toán";
                case 2 ->
                    "Đã thanh toán";
                default ->
                    "Trạng thái không xác định";
            };
            model.addRow(new Object[]{
                hoaDon.getIDHOADON(),
                hdao.getTenKH(hoaDon.getID_KHACHHANG()),
                hdao.getTenNV(hoaDon.getID_NHANVIEN()),
                hoaDon.getID_VOUCHER(),
                hdao.getTenPT(hoaDon.getID_PHUONGTHUCTHANHTOAN()),
                hoaDon.getTONGTIEN(),
                hoaDon.getTHANHTIEN(),
                hoaDon.getGiamGia(),
                hoaDon.getNGAYTHANHTOAN(),
                hoaDon.getNGAYTAO(),
                hoaDon.getNGAYSUA(),
                tt
            });
        }
    }

    void filltable2(List<HoaDonChiTiet> list) {
        if (!list.isEmpty()) {
            String[] tablehdct2 = {
                "Id Hóa đơn", "ID SPCT", "Số lg", "Tên SP", "Giá bán", "Tổng tiền", "Trạng thái"
            };
            xl.setColumnIdentifiers(tablehdct2);
            tablehdct.setModel(xl);
            xl.setRowCount(
                    0);
            for (HoaDonChiTiet hoaDon : list) {
                xl.addRow(hoaDon.torow());
            }
        } else {
            String[] d = {"Hóa đơn chi tiết"};
            xl.setColumnIdentifiers(d);
            tablehdct.setModel(xl);
            xl.setRowCount(0);
            xl.addRow(new Object[]{"Hóa đơn này chưa có chưa có hóa đơn chi tiết !"});
        }

    }

    void loadform(int inde) {
        //"IDHD", "Tên khách hàng", "Tên nhân viên",  "VocCher", "Phương thức thanh toán","Tổng tiền","Thành tiền","Giảm giá","Ngày thanh toán", "Ngày tạo", "Ngày Sửa", "Trạng thái"
        if (tablehoadon.getValueAt(inde, 1) != null) {
            txttenkh.setText(tablehoadon.getValueAt(inde, 1).toString());
        } else {
            txttenkh.setText(".................");
        }

        if (tablehoadon.getValueAt(inde, 2) != null) {
            txttennv.setText(tablehoadon.getValueAt(inde, 2).toString());
        } else {
            txttennv.setText(".................");
        }

        if (tablehoadon.getValueAt(inde, 4) != null) {
            txtpttt.setText(tablehoadon.getValueAt(inde, 4).toString());
        } else {
            txtpttt.setText(".................");
        }
        if (tablehoadon.getValueAt(inde, 3) != null) {
            txtvocher.setText(tablehoadon.getValueAt(inde, 3).toString());
        } else {
            txtvocher.setText(".................");
        }
        if (tablehoadon.getValueAt(inde, 5) != null) {
            txtTongtien.setText("Tổng Tiền:" + tablehoadon.getValueAt(inde, 5).toString());
        } else {
            txtTongtien.setText("Tổng Tiền: ??????");
        }
        if (tablehoadon.getValueAt(inde, 9) != null) {
            txtngaytao.setText(tablehoadon.getValueAt(inde, 9).toString());
        } else {
            txtngaytao.setText("................................................");
        }
        if (tablehoadon.getValueAt(inde, 8) != null) {
            txtngaytt.setText(tablehoadon.getValueAt(inde, 8).toString());
        } else {
            txtngaytt.setText("Chưa thanh toán");
        }
        if (tablehoadon.getValueAt(inde, 7) != null) {
            txtgiamgia.setText(tablehoadon.getValueAt(inde, 7).toString());
        } else {
            txtgiamgia.setText("................................................");
        }
        if (tablehoadon.getValueAt(inde, 10) != null) {
            txtngaytt.setText(tablehoadon.getValueAt(inde, 10).toString());
        } else {
            txtngaytt.setText("Chưa thanh toán");
        }
        if (tablehoadon.getValueAt(inde, 11) != null) {
            txttrangthai.setText(tablehoadon.getValueAt(inde, 11).toString());
        } else {
            txttrangthai.setText("................................................");
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tablehoadon = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        loctheonv = new javax.swing.JComboBox<>();
        sapxep = new javax.swing.JComboBox<>();
        btntimkiem = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jButton3 = new javax.swing.JButton();
        txttungay = new com.toedter.calendar.JDateChooser();
        txtdenngay = new com.toedter.calendar.JDateChooser();
        jSeparator4 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        tablehdct = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        txttenkh = new javax.swing.JLabel();
        btncapnhap = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTongtien = new javax.swing.JLabel();
        txtngaytao = new javax.swing.JLabel();
        txttennv = new javax.swing.JLabel();
        txtngaytt = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txttrangthai = new javax.swing.JLabel();
        txtpttt = new javax.swing.JLabel();
        txtvocher = new javax.swing.JLabel();
        txtgiamgia = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

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

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        loctheonv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Không", "Đã hủy", "Chưa thanh toán", "Đã thanh toán" }));
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

        jLabel13.setText("Sắp xếp");

        jLabel14.setText("Đến ngày:");

        jButton3.setText("Hủy");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        txttungay.setDateFormatString("dd-MM-yyyy");

        txtdenngay.setDateFormatString("dd-MM-yyyy");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttungay, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sapxep, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtdenngay, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(loctheonv, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btntimkiem)
                        .addGap(59, 59, 59))))
            .addComponent(jSeparator2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(txttungay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton1)
                                .addComponent(jButton3))
                            .addComponent(txtdenngay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
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

        jSeparator4.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        tablehdct.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Hóa đơn chi tiết"
            }
        ));
        tablehdct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablehdctMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tablehdct);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Hóa đơn chi tiết:");

        jSeparator5.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Hóa đơn :");

        jPanel2.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txttenkh.setBackground(new java.awt.Color(153, 255, 204));
        txttenkh.setText("................................................");

        btncapnhap.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btncapnhap.setText("Cập nhâp trạng thái");
        btncapnhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncapnhapActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel15.setText("Gảm giá:");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel7.setText("Phương Thức Thanh Toán");

        txtTongtien.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        txtTongtien.setText("Tổng Tiền:");

        txtngaytao.setText("................................................");

        txttennv.setText("................................................");

        txtngaytt.setText("................................................");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel4.setText("Ngày thanh toán: ");

        txttrangthai.setText("................................................");

        txtpttt.setText("................................................");

        txtvocher.setText("................................................");

        txtgiamgia.setText("................................................");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Tên Khác Hàng");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel9.setText("Trang Thái");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel8.setText("Mã Voucher");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel6.setText("Tên Nhân Viên");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel5.setText("Ngày Tạo:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel7))
                            .addComponent(jLabel9)
                            .addComponent(jLabel15)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtngaytt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtngaytao, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtpttt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txttennv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txttenkh, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtvocher, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txttrangthai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtgiamgia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(txtTongtien, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncapnhap))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(txttenkh, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txttennv))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtpttt))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(txtvocher))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtngaytao))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtngaytt))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addComponent(txttrangthai))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(txtgiamgia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtTongtien)
                .addGap(18, 18, 18)
                .addComponent(btncapnhap)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator5)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jSeparator4)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3))
                .addContainerGap(84, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btncapnhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncapnhapActionPerformed
        String[] luachon = {
            "Hủy Hóa đơn", "Chưa thanh toán", "Đã thanh toán"
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

    private void tablehoadonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablehoadonMouseClicked
        int index = tablehoadon.getSelectedRow();
        if (index >= 0) {
            loadform(index);
            int x = (int) tablehoadon.getValueAt(index, 0);
            List<HoaDonChiTiet> listct = hdct.selectById2(x);
            filltable2(listct);

        }
    }//GEN-LAST:event_tablehoadonMouseClicked

    private void loctheonvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loctheonvActionPerformed

        filltable(hdao.trangthai(loctheonv.getSelectedIndex() - 1, listhd));
    }//GEN-LAST:event_loctheonvActionPerformed

    private void sapxepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sapxepActionPerformed
        filltable(hdao.sapxep(sapxep.getSelectedIndex(), listhd));
        //        if()
    }//GEN-LAST:event_sapxepActionPerformed

    private void btntimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btntimkiemActionPerformed
        String timkiem = JOptionPane.showInputDialog("Nhập hóa dơn cần tìm:", null);
        if (timkiem != null && timkiem.trim().length() != 0) {
            filltable(hdao.selectById2(timkiem));
        }
    }//GEN-LAST:event_btntimkiemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date denngay = txtdenngay.getDate();
        Date tungay = txttungay.getDate();
        String formattedDate;
        String formattedDate1;
        //        LocalDateTime currentDateTime = LocalDateTime.now();
        //        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
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

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        listhd = hdao.selectAll();
        filltable(listhd);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void tablehdctMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablehdctMouseClicked
        int index1 = tablehdct.getSelectedRow();

        if (!tablehdct.getValueAt(index1, 0).toString().equalsIgnoreCase("Hóa đơn này chưa có chưa có hóa đơn chi tiết !")) {
            int x = (int) tablehdct.getValueAt(index1, 0);
            int x2 = (int) tablehdct.getValueAt(index1, 1);
            HoaDonChiTietDiA dia = new HoaDonChiTietDiA(null, true, x, x2);
            if (index1 >= 0) {
                WindowListener dialogWindowListener = new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        filltable2(hdct.selectById2(x));
                    }
                };
                dia.addWindowListener(dialogWindowListener);
                dia.setVisible(true);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Hóa đơn này chưa có chưa có hóa đơn chi tiết !");
        }


    }//GEN-LAST:event_tablehdctMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncapnhap;
    private javax.swing.JButton btntimkiem;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JComboBox<String> loctheonv;
    private javax.swing.JComboBox<String> sapxep;
    private javax.swing.JTable tablehdct;
    private javax.swing.JTable tablehoadon;
    private javax.swing.JLabel txtTongtien;
    private com.toedter.calendar.JDateChooser txtdenngay;
    private javax.swing.JLabel txtgiamgia;
    private javax.swing.JLabel txtngaytao;
    private javax.swing.JLabel txtngaytt;
    private javax.swing.JLabel txtpttt;
    private javax.swing.JLabel txttenkh;
    private javax.swing.JLabel txttennv;
    private javax.swing.JLabel txttrangthai;
    private com.toedter.calendar.JDateChooser txttungay;
    private javax.swing.JLabel txtvocher;
    // End of variables declaration//GEN-END:variables
}
