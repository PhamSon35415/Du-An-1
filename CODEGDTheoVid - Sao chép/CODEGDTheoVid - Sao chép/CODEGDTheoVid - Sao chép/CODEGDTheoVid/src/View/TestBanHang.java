/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.HoaDon;
import model.HoaDonChiTiet;
import model.NhanVien;
import model.SanPhamMain;
import model.Voucher;
import model.khachHang;
import service.HoaDonChiTietService;
import service.HoaDonService;
import service.KhachHangService;
import service.NhanVienService;
import service.SanPhamService;
import service.VoucherService;

/**
 *
 * @author Admin
 */
public class TestBanHang extends javax.swing.JFrame {
//    goi cac doi tuong

    List<NhanVien> listNV = new ArrayList<>();
    List<SanPhamMain> listSP = new ArrayList<>();
    List<HoaDon> listHD = new ArrayList<>();
    List<Voucher> listVC = new ArrayList<>();
    List<HoaDonChiTiet> listHDCT = new ArrayList<>();
    List<khachHang> listKH = new ArrayList<>();
    HoaDonService serviceHD = new HoaDonService();
    SanPhamService serviceSP = new SanPhamService();
    KhachHangService serviceKH = new KhachHangService();
    HoaDonChiTietService serviceHDCT = new HoaDonChiTietService();
    VoucherService serviceVC = new VoucherService();
    NhanVienService serviceNV = new NhanVienService();
    int vthd = -1;
    DefaultTableModel tblModel = new DefaultTableModel();
//     dinh dang kieu du lieu 
    DecimalFormat currencyFormat = new DecimalFormat("#,##0");
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * Creates new form TestBanHang
     */
    public TestBanHang() {
        initComponents();
        listSP = serviceSP.getAllSanPham();
        fillToTableSanPham(listSP);
        initComboboxNhanVien(serviceNV.getAllKhachHang2());
        initComboboxKh(serviceKH.getcbkh());
    }

    public void initComboboxKhuyenMai(List<Voucher> list) {
        DefaultComboBoxModel cboModel = new DefaultComboBoxModel();
        cboModel.addElement("Không dùng");
        for (Voucher vc : list) {
            cboModel.addElement(vc.getIDVOUCHER());
        }
        cboMaKhuyenMai.setModel(cboModel);
    }

    public void initComboboxKh(List<String> list) {
        DefaultComboBoxModel cboModel = new DefaultComboBoxModel();
//        cboModel.addElement("Không dùng");
        for (String vc : list) {
            cboModel.addElement(vc);
        }
        cbkh.setModel(cboModel);
    }
// goi combox nhanvien

    public void initComboboxNhanVien(List<Integer> list) {
        DefaultComboBoxModel cboModel3 = new DefaultComboBoxModel();
        for (Integer integer : list) {
            cboModel3.addElement(integer);
        }
        cboNhanVien.setModel(cboModel3);
    }
//     day du lieu bang san pham len table

    public void fillToTableSanPham(List<SanPhamMain> list) {
        String Cols[] = {"Ten San Pham", "Do Toa Huong", "Luu HUong", "Xuat Xu", "Nong Do", "Nhom Huong", "So Luong", "Gia"};
        tblSanPhamHD.setModel(tblModel);
        tblModel.setColumnIdentifiers(Cols);
        tblModel.setRowCount(0);
        for (SanPhamMain sp : list) {
            String donGia = currencyFormat.format(sp.getGIA());
            tblModel.addRow(new Object[]{sp.getTENSANPHAM(), sp.getDOTOHUONG(), sp.getLUUHUONG(),
                sp.getXUATXU(), sp.getNONGDO(), sp.getNHOMHUONG(),
                sp.getSOLUONG(), donGia});
        }

    }

    // day du lieu len bang hoa don
    public void fillToTableHoaDon(List<HoaDon> list) {
        DefaultTableModel tblModel2 = new DefaultTableModel();
        String Cols[] = {"Mã HD", "Mã NV", "Mã KH", "Trạng Thái", "Ngày Tạo"};
        tblModel2.setColumnIdentifiers(Cols);
        tblModel2.setRowCount(0);
        for (model.HoaDon hd : list) {
            String tt = "";
            if (hd.getTRANGTHAI() == 0) {
                tt = "Chưa Thanh Toán";
            }
            tblModel2.addRow(new Object[]{hd.getIDHOADON(), hd.getID_NHANVIEN(),
                hd.getID_KHACHHANG(), tt, hd.getNGAYTAO()});
        }
        tblHoaDon.setModel(tblModel2);
        tblHoaDon.setRowSelectionInterval(0, 0);
    }

    public void fillHDCTOver() {
        DefaultTableModel tblModel1 = new DefaultTableModel();
        String Cols2[] = {"STT", "Mã SP", "Tên Sản Phẩm", "Số Lượng", "Đơn Giá", "Thành Tiền"};
        tblModel1.setColumnIdentifiers(Cols2);
        tblModel1.setRowCount(0);
        tblGioHang.setModel(tblModel1);
    }

    public void fillToTableHDCT(List<HoaDonChiTiet> list) {
        DefaultTableModel tblModel3 = new DefaultTableModel();
        String Cols[] = {"STT", "Mã SP", "Tên Sản Phẩm", "Số Lượng", "Đơn Giá", "Thành Tiền"};
        tblModel3.setColumnIdentifiers(Cols);
        tblModel3.setRowCount(0);
        int i = 0;
        double tongTien = 0;
        for (HoaDonChiTiet hdct : list) {
            i++;
            String formatDonGia = currencyFormat.format(hdct.getGIA());
            String formatThanhTien = currencyFormat.format(hdct.getTHANHTIEN());
            tblModel3.addRow(new Object[]{i, hdct.getIDSANPHAMCHITIET(), hdct.getTENSANPHAM(), hdct.getSOLUONG(), formatDonGia, formatThanhTien});
            tongTien = tongTien + hdct.getTHANHTIEN();
        }
        tblGioHang.setModel(tblModel3);
        lblTongTien.setText(currencyFormat.format(tongTien));
        lblTienGiam.setText("0");
        double TienGiam = 0;//suDungMaKhuyenMai();
        double thanhTien = tongTien - TienGiam;
        lblThanhTien.setText(currencyFormat.format(thanhTien));
        serviceHD.UpdateHoaDon(tongTien, TienGiam, tongTien - TienGiam, Integer.parseInt(lblMaHoaDon.getText()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPhamHD = new javax.swing.JTable();
        btnTimKiem = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        btnHuyTK = new javax.swing.JButton();
        jpl125 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblGioHang = new javax.swing.JTable();
        btnXoaSanPham = new javax.swing.JButton();
        btnXoaTat = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txtSoDienThoai = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        lblTongTien = new javax.swing.JLabel();
        lblTienGiam = new javax.swing.JLabel();
        lblThanhTien = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        cboHTTT = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        lblTienThua = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        btnThanhToan = new javax.swing.JButton();
        btnTaoHoaDon = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        lblMaHoaDon = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cboMaKhuyenMai = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        cboNhanVien = new javax.swing.JComboBox<>();
        cbkh = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Danh Sách Sản Phẩm"));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblSanPhamHD.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblSanPhamHD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamHDMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPhamHD);

        jPanel5.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 69, 910, 210));

        btnTimKiem.setText("Tìm Kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });
        jPanel5.add(btnTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, -1, 30));
        jPanel5.add(txtTimKiem, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 168, 30));

        btnHuyTK.setText("Hủy");
        btnHuyTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyTKActionPerformed(evt);
            }
        });
        jPanel5.add(btnHuyTK, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, 93, 30));

        jpl125.setBackground(new java.awt.Color(255, 255, 204));
        jpl125.setBorder(javax.swing.BorderFactory.createTitledBorder("Hóa Đơn"));
        jpl125.setName(""); // NOI18N

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã HD", "Mã NV", "Tên KH", "Trạng Thái", "Ngày Tạo"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(tblHoaDon);

        javax.swing.GroupLayout jpl125Layout = new javax.swing.GroupLayout(jpl125);
        jpl125.setLayout(jpl125Layout);
        jpl125Layout.setHorizontalGroup(
            jpl125Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpl125Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 914, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpl125Layout.setVerticalGroup(
            jpl125Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpl125Layout.createSequentialGroup()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(204, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Giỏ Hàng"));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tblGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã SP", "Tên SP", "Số lượng", "Đơn giá", "Thành Tiền", "Trạng Thái"
            }
        ));
        jScrollPane5.setViewportView(tblGioHang);

        jPanel6.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 910, 140));

        btnXoaSanPham.setText("Xóa Sản Phẩm");
        btnXoaSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSanPhamActionPerformed(evt);
            }
        });
        jPanel6.add(btnXoaSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 140, 30));

        btnXoaTat.setText("Xóa tất cả");
        btnXoaTat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTatActionPerformed(evt);
            }
        });
        jPanel6.add(btnXoaTat, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 139, 30));

        jPanel7.setBackground(new java.awt.Color(255, 204, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Tạo Hóa Đơn"));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setText("SDT");
        jPanel7.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

        txtSoDienThoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoDienThoaiActionPerformed(evt);
            }
        });
        jPanel7.add(txtSoDienThoai, new org.netbeans.lib.awtextra.AbsoluteConstraints(69, 24, 260, 30));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        jPanel7.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1, 163, 350, 10));

        jLabel23.setText("Tổng Tiền");
        jPanel7.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        jLabel24.setText("Tiền Giảm");
        jPanel7.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, -1, -1));

        jLabel25.setText("Thành Tiền");
        jPanel7.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        lblTongTien.setText("0");
        jPanel7.add(lblTongTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 240, 192, -1));

        lblTienGiam.setText("0");
        jPanel7.add(lblTienGiam, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 320, 185, -1));

        lblThanhTien.setText("0");
        jPanel7.add(lblThanhTien, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 360, 187, -1));

        jLabel11.setText("HT ThanhToán");
        jPanel7.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        cboHTTT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Chọn phương thức--", "Chuyển khoản", "Tiền Mặt" }));
        jPanel7.add(cboHTTT, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 400, -1, -1));

        jLabel12.setText("Tiền Khách Đưa");
        jPanel7.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 440, -1, -1));

        jLabel14.setText("Tiền Thừa");
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, -1, -1));

        lblTienThua.setText("0");
        jPanel7.add(lblTienThua, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 480, 168, -1));

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jSeparator2.setForeground(new java.awt.Color(0, 0, 0));
        jPanel7.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 520, 350, 10));

        btnThanhToan.setBackground(new java.awt.Color(0, 204, 0));
        btnThanhToan.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnThanhToan.setForeground(new java.awt.Color(255, 255, 255));
        btnThanhToan.setText("Thanh Toán");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });
        jPanel7.add(btnThanhToan, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, -1, 44));

        btnTaoHoaDon.setBackground(new java.awt.Color(51, 51, 255));
        btnTaoHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnTaoHoaDon.setForeground(new java.awt.Color(255, 255, 255));
        btnTaoHoaDon.setText("Tạo Hóa Đơn");
        btnTaoHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTaoHoaDonActionPerformed(evt);
            }
        });
        jPanel7.add(btnTaoHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 540, 160, 47));

        btnHuy.setBackground(new java.awt.Color(255, 102, 102));
        btnHuy.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnHuy.setForeground(new java.awt.Color(255, 255, 255));
        btnHuy.setText("Hủy ");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });
        jPanel7.add(btnHuy, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 610, 160, 47));

        jLabel26.setText("Tên KH");
        jPanel7.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        txtTienKhachDua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTienKhachDuaActionPerformed(evt);
            }
        });
        jPanel7.add(txtTienKhachDua, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 440, 112, -1));

        jLabel29.setText("Mã Hóa Đơn");
        jPanel7.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        lblMaHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jPanel7.add(lblMaHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(91, 176, 110, 23));

        jLabel15.setText("Mã KM");
        jPanel7.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, -1, -1));

        cboMaKhuyenMai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Không dùng", "KM001", "KM002", "KM003" }));
        cboMaKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboMaKhuyenMaiActionPerformed(evt);
            }
        });
        jPanel7.add(cboMaKhuyenMai, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 280, 123, -1));

        jLabel9.setText("MaNV");
        jPanel7.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        cboNhanVien.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cboNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboNhanVienActionPerformed(evt);
            }
        });
        jPanel7.add(cboNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 110, 174, -1));

        cbkh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbkh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbkhActionPerformed(evt);
            }
        });
        jPanel7.add(cbkh, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 260, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jpl125, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jpl125, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblSanPhamHDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamHDMouseClicked
        int selectedRow = -1;
        selectedRow = tblSanPhamHD.getSelectedRow();
        String x = JOptionPane.showInputDialog("Nhập số lượng:");
        if (x != null) {
            try {
                int xx = Integer.parseInt(x);
                SanPhamMain sp = listSP.get(selectedRow);
                int idSPCT = sp.getIDSANPHAMCHITIET();
                int SoLuongThuc = sp.getSOLUONG();
                if (xx > SoLuongThuc) {
                    JOptionPane.showMessageDialog(this, "Số lượng mua lớn hơn số lượng còn lại của sản phẩm");
                    return;
                }
                serviceSP.UpdateSoLuong(xx, idSPCT);
                vthd = tblHoaDon.getSelectedRow();
                HoaDon hd = listHD.get(vthd);
                int dem = 0;
                for (HoaDonChiTiet hdct11 : listHDCT) {
                    if (hdct11.getIDSANPHAMCHITIET() == idSPCT) {
                        dem++;
                    }
                }
                if (dem == 0) {
                    serviceHDCT.InsertHDCT(hd.getIDHOADON(), idSPCT, xx);
                } else {
                    serviceHDCT.UpdateHDCT_SoLuong(Integer.parseInt(lblMaHoaDon.getText()), idSPCT, xx);
                }
                listHDCT = serviceHDCT.getAllHDCT2(hd.getIDHOADON());
                fillToTableHDCT(listHDCT);
                listSP = serviceSP.getAllSanPham();
                fillToTableSanPham(listSP);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Số lượng phải là số");
                return;
            }
        }

    }//GEN-LAST:event_tblSanPhamHDMouseClicked

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        String TenSanPham = txtTimKiem.getText();
        listSP = serviceSP.getSearchSanPham(TenSanPham);
        fillToTableSanPham(listSP);
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void btnHuyTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyTKActionPerformed
        listSP = serviceSP.getAllSanPham();
        fillToTableSanPham(listSP);
    }//GEN-LAST:event_btnHuyTKActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        vthd = tblHoaDon.getSelectedRow();
        HoaDon hd = listHD.get(vthd);
        int IDHoaDon = hd.getIDHOADON();
        lblMaHoaDon.setText(String.valueOf(IDHoaDon));
        int MaKH = hd.getID_KHACHHANG();
        if (MaKH > 0) {
            listKH = serviceKH.getAllKhachHangTheoMa(MaKH);
            khachHang kh = listKH.get(0);
            txtSoDienThoai.setText(kh.getSODIENTHOAI());
            cbkh.setSelectedItem(kh.getTENKHACHHANG());
        } else {
            txtSoDienThoai.setText("");
             cbkh.setSelectedIndex(0);
        }

        listHDCT = serviceHDCT.getAllHDCT2(IDHoaDon);
        fillToTableHDCT(listHDCT);
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnXoaSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSanPhamActionPerformed
        int choice = JOptionPane.showConfirmDialog(this, "Bạn xác nhận xóa sản phẩm này chứ", "Xác nhận yêu cầu", JOptionPane.YES_NO_CANCEL_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            int vt = -1;
            vt = tblGioHang.getSelectedRow();
            if (vt < 0) {
                JOptionPane.showMessageDialog(this, "Bạn phải chọn sản phẩm muốn xóa");
                return;
            } else {
                HoaDonChiTiet hdct = listHDCT.get(vt);
                int MaHoaDon = Integer.parseInt(lblMaHoaDon.getText());
                int MaSPCT = hdct.getIDSANPHAMCHITIET();
                int SoLuong = hdct.getSOLUONG();
                System.out.println("MaHoaDon = " + MaHoaDon);
                System.out.println("MaSPCT = " + MaSPCT);
                serviceHDCT.DeleteHDCT(MaHoaDon, MaSPCT);
                serviceSP.UpdateSoLuongVe(SoLuong, MaSPCT);
                listHDCT = serviceHDCT.getAllHDCT2(MaHoaDon);
                fillToTableHDCT(listHDCT);
                listSP = serviceSP.getAllSanPham();
                fillToTableSanPham(listSP);
            }
        }
    }//GEN-LAST:event_btnXoaSanPhamActionPerformed

    private void btnXoaTatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaTatActionPerformed
        int choice = JOptionPane.showConfirmDialog(this, "Bạn xác nhận xóa tất cả sản phẩm chứ", "Xác nhận yêu cầu", JOptionPane.YES_NO_CANCEL_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            int MaHoaDon = Integer.parseInt(lblMaHoaDon.getText());
            listHDCT = serviceHDCT.getAllHDChiTietTheoMa(MaHoaDon);
            for (HoaDonChiTiet hdct : listHDCT) {
                int MaSPCT = hdct.getIDSANPHAMCHITIET();
                int SoLuong = hdct.getSOLUONG();
                serviceSP.UpdateSoLuongVe(SoLuong, MaSPCT);
            }
            serviceHDCT.DeleteAllHDCT(MaHoaDon);
            listHDCT = serviceHDCT.getAllHDCT2(MaHoaDon);
            fillToTableHDCT(listHDCT);
            listSP = serviceSP.getAllSanPham();
            fillToTableSanPham(listSP);
        }
    }//GEN-LAST:event_btnXoaTatActionPerformed

    private void txtSoDienThoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoDienThoaiActionPerformed
        String SoDT = txtSoDienThoai.getText();
        if (SoDT.trim().equals("")) {
            cbkh.setSelectedIndex(0);
            return;
        }
        listKH = serviceKH.getAllKhachHangTheoSDT(SoDT);
        khachHang kh = listKH.get(0);
        cbkh.setSelectedItem(kh.getTENKHACHHANG());

    }//GEN-LAST:event_txtSoDienThoaiActionPerformed

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        try {
            int choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn Thanh Toán không?", "Xác nhận yêu cầu", JOptionPane.YES_NO_CANCEL_OPTION);
            if (choice == JOptionPane.YES_OPTION) {
                vthd = tblHoaDon.getSelectedRow();
                HoaDon hd = listHD.get(vthd);
                String idvoucher = (String) cboMaKhuyenMai.getSelectedItem();
                if (cboMaKhuyenMai.getSelectedIndex() == 0) {
                    idvoucher = null;
                }
                double tongTien = currencyFormat.parse(lblTongTien.getText()).doubleValue();
                double giamGia = currencyFormat.parse(lblTienGiam.getText()).doubleValue();
                double thanhTien = tongTien - giamGia;
                int vtHTTT = cboHTTT.getSelectedIndex();
                if (vtHTTT == 0) {
                    JOptionPane.showMessageDialog(this, "Ban phai chon HTTT");
                    return;
                }
                String IDPHUONGTHUCTHANHTOAN;
                if (vtHTTT == 1) {
                    IDPHUONGTHUCTHANHTOAN = "PTTT001";
                } else if (vtHTTT == 2) {
                    IDPHUONGTHUCTHANHTOAN = "PTTT002";
                } else if (vtHTTT == 3) {
                    IDPHUONGTHUCTHANHTOAN = "PTTT003";
                } else {
                    JOptionPane.showMessageDialog(this, "Bạn phải chọn hình thức thanh toán");
                    return;
                }
                hd.setTONGTIEN(tongTien);
                hd.setID_VOUCHER(idvoucher);
                hd.setGiamGia(giamGia);
                hd.setTHANHTIEN(thanhTien);
                hd.setID_PHUONGTHUCTHANHTOAN(IDPHUONGTHUCTHANHTOAN);
                if (cboMaKhuyenMai.getSelectedIndex() != 0) {
                    listVC = serviceVC.getAllKhuyenMaiByMa(idvoucher);
                    Voucher km = listVC.get(0);
                    serviceVC.UpdateSoLuongKhuyenMai(km);
                }
                //In hóa đơn

                serviceHD.UpdateTrangThai(1, hd.getIDHOADON());
                JOptionPane.showMessageDialog(this, "Bạn đã thanh toán hóa đơn thành công");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void btnTaoHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTaoHoaDonActionPerformed
        int choice = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm không?", "Xác nhận yêu cầu", JOptionPane.YES_NO_CANCEL_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            if (txtSoDienThoai.getText().trim().equals("")) {
                System.out.println("SDT Null nhé!");
                HoaDon hd1 = new HoaDon();
                //hd1.setMaKhachHang(0);
                hd1.setIDHOADON(serviceHD.layphantucuoi() + 1);
                hd1.setID_NHANVIEN((int) cboNhanVien.getSelectedItem());
                serviceHD.InsertHoaDonKHnull(hd1);
                listHD = serviceHD.getDSHoaDonCho();
                fillToTableHoaDon(listHD);
                HoaDon hd = listHD.get(0);
                lblMaHoaDon.setText(String.valueOf(hd.getIDHOADON()));
            } else {
                HoaDon hd1 = new HoaDon();
                int maKH = listKH.get(0).getIDKHACHHANG();
                hd1.setIDHOADON(serviceHD.layphantucuoi() + 1);
                hd1.setID_KHACHHANG(maKH);
                hd1.setID_NHANVIEN((int) cboNhanVien.getSelectedItem());
                serviceHD.InsertHoaDon(hd1);
                listHD = serviceHD.getDSHoaDonCho();
                fillToTableHoaDon(listHD);
                HoaDon hd = listHD.get(0);
                lblMaHoaDon.setText(String.valueOf(hd.getIDHOADON()));
            }

        }
    }//GEN-LAST:event_btnTaoHoaDonActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        int choice = JOptionPane.showConfirmDialog(this, "Bạn xác nhận Hủy Hóa Đơn chứ", "Xác nhận yêu cầu", JOptionPane.YES_NO_CANCEL_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            vthd = tblHoaDon.getSelectedRow();
            HoaDon hd = listHD.get(vthd);
            serviceHD.UpdateTrangThai(2, hd.getIDHOADON());
            listHD = serviceHD.getDSHoaDonCho();
            int MaHoaDon = hd.getIDHOADON();
            listHDCT = serviceHDCT.getAllHDChiTietTheoMa(MaHoaDon);
            for (HoaDonChiTiet hdct : listHDCT) {
                int MaSPCT = hdct.getIDSANPHAMCHITIET();
                int SoLuong = hdct.getSOLUONG();
                serviceSP.UpdateSoLuongVe(SoLuong, MaSPCT);
            }
            fillToTableHoaDon(listHD);
            fillHDCTOver();
            listSP = serviceSP.getAllSanPham();
            fillToTableSanPham(listSP);
            txtTienKhachDua.setText("");
            lblThanhTien.setText("");
            lblTienGiam.setText("");
            lblTienThua.setText("");
            lblTongTien.setText("");
            lblMaHoaDon.setText("");
        }
    }//GEN-LAST:event_btnHuyActionPerformed

    private void txtTienKhachDuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTienKhachDuaActionPerformed
        double s = -1;
        double thanhTien;
        try {
            s = currencyFormat.parse(txtTienKhachDua.getText()).doubleValue();
            thanhTien = currencyFormat.parse(lblThanhTien.getText()).doubleValue();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Tiền khách đưa phải là số");
            return;
        }
        if (s < thanhTien) {
            JOptionPane.showMessageDialog(this, "Tiền khách đưa phải lớn hơn Thành Tiền");
            return;
        }
        lblTienThua.setText(currencyFormat.format(s - thanhTien));
    }//GEN-LAST:event_txtTienKhachDuaActionPerformed

    private void cboMaKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboMaKhuyenMaiActionPerformed
        try {
            if (cboMaKhuyenMai.getSelectedIndex() == 0) {
                lblTienGiam.setText("0");
                lblThanhTien.setText(lblTongTien.getText());
                return;
            }
            String MaKhuyenMai = (String) cboMaKhuyenMai.getSelectedItem();
            System.out.println("MaKM: " + MaKhuyenMai);
            double tongTien = currencyFormat.parse(lblTongTien.getText()).doubleValue();
            double giamGia = 0;
            List<Voucher> listKM1 = new ArrayList<>();
            listKM1 = serviceVC.getAllKhuyenMaiByMa(MaKhuyenMai);
            Voucher km = listKM1.get(0);
            System.out.println("HinhThucKM: " + km.getHINHTHUC());
            if (tongTien >= km.getSOTIENMIN()) {
                if (km.getHINHTHUC() == 0) {
                    giamGia = km.getMUCGIAMGIAl();
                } else {
                    giamGia = (tongTien * km.getMUCGIAMGIAl()) / 100.0;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Bạn không thể áp dụng được mã này "
                        + "vì tổng tiền nhỏ hơn số tiền tối thiểu của khuyến mại");
                cboMaKhuyenMai.setSelectedIndex(0);
            }
            lblTienGiam.setText(currencyFormat.format(giamGia));
            lblThanhTien.setText(currencyFormat.format(tongTien - giamGia));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_cboMaKhuyenMaiActionPerformed

    private void cboNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboNhanVienActionPerformed

    }//GEN-LAST:event_cboNhanVienActionPerformed

    private void cbkhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbkhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbkhActionPerformed

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
            java.util.logging.Logger.getLogger(TestBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestBanHang.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestBanHang().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnHuyTK;
    private javax.swing.JButton btnTaoHoaDon;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoaSanPham;
    private javax.swing.JButton btnXoaTat;
    private javax.swing.JComboBox<String> cbkh;
    private javax.swing.JComboBox<String> cboHTTT;
    private javax.swing.JComboBox<String> cboMaKhuyenMai;
    private javax.swing.JComboBox<String> cboNhanVien;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel jpl125;
    private javax.swing.JLabel lblMaHoaDon;
    private javax.swing.JLabel lblThanhTien;
    private javax.swing.JLabel lblTienGiam;
    private javax.swing.JLabel lblTienThua;
    private javax.swing.JLabel lblTongTien;
    private javax.swing.JTable tblGioHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTable tblSanPhamHD;
    private javax.swing.JTextField txtSoDienThoai;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
