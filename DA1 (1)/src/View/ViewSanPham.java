/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
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
public class ViewSanPham extends javax.swing.JFrame {
//IDSP, String TenSanPham, String NgayTao, String NgaySua, int SoLg, int TrangThai

    private final ChiTietSpDao ctdao = new ChiTietSpDao();
    private final XuatXuDao xxdao = new XuatXuDao();
    private final NhomHuongDao nhdao = new NhomHuongDao();
    private final NongDoDao nddao = new NongDoDao();
    private final SanPhamDao spdao = new SanPhamDao();
    String[] comlumsxx = {
        "Ten Xuat xu", "Trang thai"
    };
    String[] comlumsnh = {
        "Ten nhom huong", "Trang thai"
    };
    String[] comlumsnd = {
        "Ten nong do", "Trang thai"
    };
    String[] comlumssp = {
        "ID San pham", "Tên Sản phẩm", "Số lượng", "Trạng thái"
    };
    DefaultTableModel modelxx = new DefaultTableModel(comlumsxx, 0);
    DefaultTableModel modelnh = new DefaultTableModel(comlumsnh, 0);
    DefaultTableModel modelnd = new DefaultTableModel(comlumsnd, 0);
    DefaultTableModel modelsp = new DefaultTableModel(comlumssp, 0);

    /**
     * Creates new form ViewSanPha
     */
    public ViewSanPham() {
        initComponents();
        setcolums();
        addcobo();
        filtablexx(xxdao.selectAll());
        filtablend(nddao.selectAll());
        filtablenh(nhdao.selectAll());
        filtablesp(spdao.selectAll());
        setLocationRelativeTo(null);
    }

    void filtablexx(List<XuatSu> list) {
        modelxx.setRowCount(0);
        for (XuatSu xuatSu : list) {
            modelxx.addRow(xuatSu.torow());
        }
    }

    void filtablesp(List<SanPham> list) {
        modelsp.setRowCount(0);
        for (SanPham sp : list) {
            modelsp.addRow(sp.torow());
        }
    }

    void filtablenh(List<NhomHuong> list) {
        modelnh.setRowCount(0);
        for (NhomHuong nhomHuong : list) {
            modelnh.addRow(nhomHuong.torow());
        }
    }

    void filtablend(List<NongDo> list) {
        modelnd.setRowCount(0);
        for (NongDo nongDo : list) {
            modelnd.addRow(nongDo.torow());
        }
    }

    XuatSu getformxx(int x) {//1 sua;0 tao
        String ten = txtxuatxu.getText().trim();
        if (ten.length() == 0) {
            JOptionPane.showMessageDialog(this, "Chua nhap ten Xuat xu!");
            return null;
        }
        int tt = -1;
        if (rdxxhd.isSelected()) {
            tt = 1;
        } else {
            tt = 0;
        }
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String ngaytao = currentDateTime.format(formatter);
        if (x == 0) {
            return new XuatSu(ten, ngaytao, null, tt);
        } else {
            return new XuatSu(ten, ngaytao, tt);
        }

    }

    NongDo getformnd(int x) {//1 sua;0 tao
        String ten = txtnd.getText().trim();
        if (ten.length() == 0) {
            JOptionPane.showMessageDialog(this, "Chua nhap ten nong do!");
            return null;
        }
        int tt = -1;
        if (rdndhd.isSelected()) {
            tt = 1;
        } else {
            tt = 0;
        }
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String ngaytao = currentDateTime.format(formatter);
        if (x == 0) {
            return new NongDo(ten, ngaytao, null, tt);
        } else {
            return new NongDo(ten, ngaytao, tt);
        }

    }

    NhomHuong getformnh(int x) {//1 sua;0 tao
        String ten = txtnhomhuong.getText().trim();
        if (ten.length() == 0) {
            JOptionPane.showMessageDialog(this, "Chua nhap ten Nhom huong!");
            return null;
        }
        int tt = -1;
        if (rdndhd.isSelected()) {
            tt = 1;
        } else {
            tt = 0;
        }
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String ngaytao = currentDateTime.format(formatter);
        if (x == 0) {
            return new NhomHuong(ten, ngaytao, null, tt);
        } else {
            return new NhomHuong(ten, ngaytao, tt);
        }

    }

    SanPham getformsp(int x) {
        String tensp = txttensp.getText().trim();
        if (tensp.length() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa nhập tên sp!");
            return null;
        }
        int solg;
        if (txtssolg.getText().length() == 0) {
            JOptionPane.showMessageDialog(this, "Chưa nhập Số lượng!");
            return null;
        } else {
            try {
                solg = Integer.parseInt(txtssolg.getText());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Phải nhập vào 1 số");
                return null;
            }
        }
        int ttsp;
        if (rdconhangsp.isSelected()) {
            ttsp = 1;
        } else {
            ttsp = 0;
        }

        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
        String ngay = currentDateTime.format(formatter);
        if (x == 0) {
            return new SanPham(tensp, ngay, null, solg, ttsp);
        } else {
            return new SanPham(tensp, ngay, solg, ttsp);
        }
    }

    public void setcolums() {
        tablend.setModel(modelnd);
        tablexx.setModel(modelxx);
        tablenh.setModel(modelnh);
        tablesp.setModel(modelsp);
        tableviewsp.setModel(modelsp);
    }
    DefaultComboBoxModel cb = new DefaultComboBoxModel();

    public void addcobo() {
        cb = (DefaultComboBoxModel) cbnhomhuong.getModel();
        cb.removeAllElements();
        for (String object : ctdao.getTenNH()) {
            cb.addElement(object);
        }
        cb = (DefaultComboBoxModel) cbnongdo.getModel();
        cb.removeAllElements();
        for (String object : ctdao.getTenND()) {
            cb.addElement(object);
        }
        cb = (DefaultComboBoxModel) cbxuatsu.getModel();
        cb.removeAllElements();
        for (String object : ctdao.getTenXS()) {
            cb.addElement(object);
        }

    }

    void loadformxx(int indexxx) {
        txtxuatxu.setText(tablexx.getValueAt(indexxx, 0).toString());
        if (tablexx.getValueAt(indexxx, 1).toString().equalsIgnoreCase("Hoạt động")) {
            rdxxhd.setSelected(true);
        } else {
            rdxxkohd.setSelected(true);
        }
    }

    void loadformsp(int index) {
        txttensp.setText(tablesp.getValueAt(index, 1).toString());
        txtssolg.setText(tablesp.getValueAt(index, 2).toString());
        if (tablesp.getValueAt(index, 3).toString().equalsIgnoreCase("Còn hàng")) {
            rdconhangsp.setSelected(true);
        } else {
            rdhetsap.setSelected(true);
        }
    }

    void loadformnd(int indexnd) {
        txtnd.setText(tablend.getValueAt(indexnd, 0).toString());
        if (tablend.getValueAt(indexnd, 1).toString().equalsIgnoreCase("Hoạt động")) {
            rdndhd.setSelected(true);
        } else {
            rdndkhd.setSelected(true);
        }
    }

    void loadformnh(int indexnh) {
        txtnhomhuong.setText(tablenh.getValueAt(indexnh, 0).toString());
        if (tablenh.getValueAt(indexnh, 1).toString().equalsIgnoreCase("Hoạt động")) {
            rdnhhd.setSelected(true);
        } else {
            rdnhkohd.setSelected(true);
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

        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel7 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel11 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        txtxuatxu = new javax.swing.JTextField();
        rdxxhd = new javax.swing.JRadioButton();
        rdxxkohd = new javax.swing.JRadioButton();
        btnthemxx = new javax.swing.JButton();
        btnsuaxx = new javax.swing.JButton();
        btnclearxx = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tablexx = new javax.swing.JTable();
        txtnh = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        rdnhhd = new javax.swing.JRadioButton();
        rdnhkohd = new javax.swing.JRadioButton();
        btnthemnh = new javax.swing.JButton();
        btnsuanh = new javax.swing.JButton();
        btnclearnh = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tablenh = new javax.swing.JTable();
        txtnhomhuong = new javax.swing.JTextField();
        jPanel14 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txtnd = new javax.swing.JTextField();
        rdndhd = new javax.swing.JRadioButton();
        rdndkhd = new javax.swing.JRadioButton();
        btnthemnd = new javax.swing.JButton();
        btnsuanongdo = new javax.swing.JButton();
        btnclearnd = new javax.swing.JButton();
        jScrollPane9 = new javax.swing.JScrollPane();
        tablend = new javax.swing.JTable();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tableviewsp = new javax.swing.JTable();
        btntimkiem = new javax.swing.JButton();
        txttimkiem = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        txttensp = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        rdconhangsp = new javax.swing.JRadioButton();
        rdhetsap = new javax.swing.JRadioButton();
        btnthemsp = new javax.swing.JButton();
        btnsuasp = new javax.swing.JButton();
        btnclearsp = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tablesp = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        txtmaspct = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        txtthoigiannedung = new javax.swing.JTextField();
        txtnamphathanh = new javax.swing.JTextField();
        txtdotoahuong = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        txtdungtich = new javax.swing.JTextField();
        rdhetctsp = new javax.swing.JRadioButton();
        rdconctsp = new javax.swing.JRadioButton();
        jButton23 = new javax.swing.JButton();
        jButton24 = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jLabel28 = new javax.swing.JLabel();
        txtssolg = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtluuhuong = new javax.swing.JTextField();
        cbnhomhuong = new javax.swing.JComboBox<>();
        cbxuatsu = new javax.swing.JComboBox<>();
        cbnongdo = new javax.swing.JComboBox<>();
        cbmactsp = new javax.swing.JComboBox<>();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel18.setText("Mã sản phẩm");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setType(java.awt.Window.Type.UTILITY);

        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel33.setText("Xuất Xứ");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel13.setText("Tên xuất xứ");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel34.setText("Trạng Thái:");

        buttonGroup1.add(rdxxhd);
        rdxxhd.setText("Hoạt động");

        buttonGroup1.add(rdxxkohd);
        rdxxkohd.setText("Không HĐ");

        btnthemxx.setText("Thêm ");
        btnthemxx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemxxActionPerformed(evt);
            }
        });

        btnsuaxx.setText("Sửa");
        btnsuaxx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaxxActionPerformed(evt);
            }
        });

        btnclearxx.setText("Clear");
        btnclearxx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearxxActionPerformed(evt);
            }
        });

        tablexx.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tên xuất xứ", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablexx.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablexxMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tablexx);

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(txtxuatxu, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdxxhd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnclearxx)
                                    .addComponent(rdxxkohd)))
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(btnthemxx)
                                .addGap(18, 18, 18)
                                .addComponent(btnsuaxx))))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtxuatxu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(rdxxhd)
                    .addComponent(rdxxkohd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthemxx)
                    .addComponent(btnsuaxx)
                    .addComponent(btnclearxx))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel35.setText("Nhóm Hương");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel36.setText("Tên nhóm hương");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel37.setText("Trạng Thái:");

        buttonGroup2.add(rdnhhd);
        rdnhhd.setText("Hoạt động");

        buttonGroup2.add(rdnhkohd);
        rdnhkohd.setText("Không HĐ");

        btnthemnh.setText("Thêm ");
        btnthemnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemnhActionPerformed(evt);
            }
        });

        btnsuanh.setText("Sửa");
        btnsuanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuanhActionPerformed(evt);
            }
        });

        btnclearnh.setText("Clear");
        btnclearnh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearnhActionPerformed(evt);
            }
        });

        tablenh.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tên nhóm hương", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablenh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablenhMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tablenh);

        javax.swing.GroupLayout txtnhLayout = new javax.swing.GroupLayout(txtnh);
        txtnh.setLayout(txtnhLayout);
        txtnhLayout.setHorizontalGroup(
            txtnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtnhLayout.createSequentialGroup()
                .addGroup(txtnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(txtnhLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(txtnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(txtnhLayout.createSequentialGroup()
                                .addComponent(jLabel36)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtnhomhuong))
                            .addGroup(txtnhLayout.createSequentialGroup()
                                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdnhhd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(txtnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnclearnh)
                                    .addComponent(rdnhkohd)))
                            .addGroup(txtnhLayout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(btnthemnh)
                                .addGap(18, 18, 18)
                                .addComponent(btnsuanh))))
                    .addGroup(txtnhLayout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(txtnhLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        txtnhLayout.setVerticalGroup(
            txtnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtnhLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(txtnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(txtnhomhuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(txtnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(rdnhhd)
                    .addComponent(rdnhkohd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(txtnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthemnh)
                    .addComponent(btnsuanh)
                    .addComponent(btnclearnh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel38.setText("Nồng độ");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel39.setText("Tên nồng độ");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel40.setText("Trạng Thái:");

        buttonGroup3.add(rdndhd);
        rdndhd.setText("Hoạt động");

        buttonGroup3.add(rdndkhd);
        rdndkhd.setText("Không HĐ");

        btnthemnd.setText("Thêm ");
        btnthemnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemndActionPerformed(evt);
            }
        });

        btnsuanongdo.setText("Sửa");
        btnsuanongdo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuanongdoActionPerformed(evt);
            }
        });

        btnclearnd.setText("Clear");
        btnclearnd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearndActionPerformed(evt);
            }
        });

        tablend.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tên nồng độ", "Trạng Thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablend.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablendMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tablend);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdndhd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdndkhd))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel39)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtnd)
                                    .addGroup(jPanel14Layout.createSequentialGroup()
                                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnthemnd)
                        .addGap(18, 18, 18)
                        .addComponent(btnsuanongdo)
                        .addGap(29, 29, 29)
                        .addComponent(btnclearnd)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel38)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(txtnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(rdndhd)
                    .addComponent(rdndkhd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthemnd)
                    .addComponent(btnsuanongdo)
                    .addComponent(btnclearnd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(7, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 180, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Thuộc tính", jPanel11);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel14.setText("Sản Phẩm ");

        tableviewsp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Trang thái"
            }
        ));
        jScrollPane5.setViewportView(tableviewsp);

        btntimkiem.setText("Tìm Kiếm");

        txttimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttimkiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(364, 364, 364)
                        .addComponent(jLabel14))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(218, 218, 218)
                        .addComponent(btntimkiem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel14)
                .addGap(46, 46, 46)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btntimkiem))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Sản Phẩm", jPanel8);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Quản lý sản phẩm");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Số lượng:");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Trạng Thái:");

        buttonGroup4.add(rdconhangsp);
        rdconhangsp.setText("Còn Hàng");

        buttonGroup4.add(rdhetsap);
        rdhetsap.setText("Hết Hàng");

        btnthemsp.setText("Thêm ");
        btnthemsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnthemspMouseClicked(evt);
            }
        });
        btnthemsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemspActionPerformed(evt);
            }
        });

        btnsuasp.setText("Sửa");
        btnsuasp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuaspActionPerformed(evt);
            }
        });

        btnclearsp.setText("Clear");
        btnclearsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearspActionPerformed(evt);
            }
        });

        tablesp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã SP", "Tên SP", "Trang thái"
            }
        ));
        tablesp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablespMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tablesp);

        jLabel22.setBackground(new java.awt.Color(0, 0, 255));
        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 204));
        jLabel22.setText("Chi tiết sản phẩm");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("ID Sp:");

        txtmaspct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmaspctActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("Mã chi tiết sản phẩm");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Độ tỏa hương");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Thời gian nên dùng");

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("Năm phát hành");

        txtthoigiannedung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtthoigiannedungActionPerformed(evt);
            }
        });

        txtnamphathanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamphathanhActionPerformed(evt);
            }
        });

        txtdotoahuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdotoahuongActionPerformed(evt);
            }
        });

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("Dung tích");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setText("Lưu Hương");

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setText("Xuất xứ");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setText("Nhóm hương");

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setText("Trạng thái");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel32.setText("Nồng độ");

        txtdungtich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdungtichActionPerformed(evt);
            }
        });

        buttonGroup5.add(rdhetctsp);
        rdhetctsp.setText("Hết");

        buttonGroup5.add(rdconctsp);
        rdconctsp.setText("Còn");

        jButton23.setText("Thêm ");
        jButton23.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton23MouseClicked(evt);
            }
        });

        jButton24.setText("Sửa");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });

        jButton25.setText("Clear");

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setText("Tên sản phẩm:");

        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        txtluuhuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtluuhuongActionPerformed(evt);
            }
        });

        cbnhomhuong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxuatsu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbnongdo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbmactsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbmactspMouseClicked(evt);
            }
        });
        cbmactsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbmactspActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel9Layout.createSequentialGroup()
                                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel9Layout.createSequentialGroup()
                                            .addComponent(jLabel21)
                                            .addGap(29, 29, 29))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                            .addComponent(jLabel28)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(jPanel9Layout.createSequentialGroup()
                                            .addComponent(rdconhangsp, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(rdhetsap))
                                        .addComponent(txttensp, javax.swing.GroupLayout.Alignment.LEADING)))
                                .addGroup(jPanel9Layout.createSequentialGroup()
                                    .addComponent(jLabel20)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtssolg, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(btnclearsp)
                                .addGap(17, 17, 17)
                                .addComponent(btnsuasp)
                                .addGap(20, 20, 20)
                                .addComponent(btnthemsp)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(74, 74, 74))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel16)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel26))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtmaspct, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                                    .addComponent(txtnamphathanh)
                                    .addComponent(txtthoigiannedung)
                                    .addComponent(txtdotoahuong)
                                    .addComponent(txtdungtich)
                                    .addComponent(cbmactsp, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jLabel23))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel31)
                                            .addComponent(jLabel27))
                                        .addGap(28, 28, 28)
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel9Layout.createSequentialGroup()
                                                .addComponent(rdconctsp, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(rdhetctsp, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(txtluuhuong)))
                                    .addGroup(jPanel9Layout.createSequentialGroup()
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel9Layout.createSequentialGroup()
                                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel29)
                                                    .addComponent(jLabel32))
                                                .addGap(42, 42, 42))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel9Layout.createSequentialGroup()
                                                .addComponent(cbnongdo, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel9Layout.createSequentialGroup()
                                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(cbnhomhuong, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(cbxuatsu, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                .addGap(77, 77, 77))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jButton23)
                                .addGap(18, 18, 18)
                                .addComponent(jButton24)
                                .addGap(18, 18, 18)
                                .addComponent(jButton25)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 832, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(10, 10, 10)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttensp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txtssolg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdconhangsp)
                            .addComponent(rdhetsap)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnclearsp)
                            .addComponent(btnsuasp)
                            .addComponent(btnthemsp)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel22)
                .addGap(27, 27, 27)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel30)
                                .addComponent(cbnhomhuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel29)
                                    .addComponent(cbxuatsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel32)
                                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbnongdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtluuhuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel31)
                                    .addComponent(rdconctsp)
                                    .addComponent(rdhetctsp)))
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(txtmaspct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(cbmactsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtdotoahuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtthoigiannedung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24)
                            .addComponent(txtnamphathanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtdungtich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton23)
                    .addComponent(jButton24)
                    .addComponent(jButton25))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Cập Nhật", jPanel9);

        jTabbedPane1.addTab("Sản Phẩm", jTabbedPane2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 896, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnsuanongdoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuanongdoActionPerformed
        NongDo nd = getformnd(1);
        int index = tablend.getSelectedRow();
        if (index >= 0) {
            if (nd != null) {
                String x = String.valueOf(nddao.selectAll().get(index).getIDND());
                if (JOptionPane.showConfirmDialog(this, "Bạn có chăc muốn Sửa không !") == 0) {
                    if (nddao.update(nd, x) != 0) {
                        JOptionPane.showMessageDialog(this, "Sửa thành công nồng độ!");
                        filtablend(nddao.selectAll());
                        clearformnd();
                    } else {
                        JOptionPane.showMessageDialog(this, "Sửa thất bại !");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Đã hủy Sửa !");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Sửa thất bại !");
            }
        }
    }//GEN-LAST:event_btnsuanongdoActionPerformed

    private void btnsuanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuanhActionPerformed
        NhomHuong nh = getformnh(1);
        int index = tablenh.getSelectedRow();
        if (index >= 0) {
            if (nh != null) {
                String x = String.valueOf(nhdao.selectAll().get(index).getIDNH());
                if (JOptionPane.showConfirmDialog(this, "Bạn có chăc muốn Sửa không !") == 0) {
                    if (nhdao.update(nh, x) != 0) {
                        JOptionPane.showMessageDialog(this, "Sửa thành công Nhom hương!");
                        filtablenh(nhdao.selectAll());
                        clearformnh();
                    } else {
                        JOptionPane.showMessageDialog(this, "Sửa thất bại !");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Đã hủy Sửa !");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Sửa thất bại !");
            }
        }
    }//GEN-LAST:event_btnsuanhActionPerformed

    private void btnsuaxxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaxxActionPerformed
        XuatSu xx = getformxx(1);
        int index = tablexx.getSelectedRow();
        if (index >= 0) {
            if (xx != null) {
                String x = String.valueOf(xxdao.selectAll().get(index).getIDXS());
                if (JOptionPane.showConfirmDialog(this, "Bạn có chăc muốn Sửa không !") == 0) {
                    if (xxdao.update(xx, x) != 0) {
                        JOptionPane.showMessageDialog(this, "Sửa thành công xuất xứ !");
                        filtablexx(xxdao.selectAll());
                        clearformxx();
                    } else {
                        JOptionPane.showMessageDialog(this, "Sửa thất bại !");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Đã hủy Sửa !");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Sửa thất bại !");
            }
        }

    }//GEN-LAST:event_btnsuaxxActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton23MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton23MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton23MouseClicked

    private void txtdungtichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdungtichActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdungtichActionPerformed

    private void txtdotoahuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdotoahuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdotoahuongActionPerformed

    private void txtnamphathanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamphathanhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamphathanhActionPerformed

    private void txtthoigiannedungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtthoigiannedungActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtthoigiannedungActionPerformed

    private void txtmaspctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmaspctActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmaspctActionPerformed

    private void btnsuaspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaspActionPerformed
        SanPham Sp = getformsp(1);
        int index = tablesp.getSelectedRow();
        if (index >= 0) {
            if (Sp != null) {
                String x = String.valueOf(spdao.selectAll().get(index).getIDSP());
                if (JOptionPane.showConfirmDialog(this, "Bạn có chăc muốn Sửa không !") == 0) {
                    if (spdao.update(Sp, x) != 0) {
                        JOptionPane.showMessageDialog(this, "Sửa thành công !");
                        filtablesp(spdao.selectAll());
                        clearformsp();
                    } else {
                        JOptionPane.showMessageDialog(this, "Sửa thất bại !");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Đã hủy Sửa !");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Sửa thất bại !");
            }
        }
    }//GEN-LAST:event_btnsuaspActionPerformed

    private void btnthemspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnthemspMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnthemspMouseClicked

    private void txttimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttimkiemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttimkiemActionPerformed

    private void tablexxMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablexxMouseClicked
        int index = tablexx.getSelectedRow();
        loadformxx(index);

    }//GEN-LAST:event_tablexxMouseClicked

    private void tablenhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablenhMouseClicked
        int index = tablenh.getSelectedRow();
        loadformnh(index);

    }//GEN-LAST:event_tablenhMouseClicked

    private void tablendMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablendMouseClicked
        int index = tablend.getSelectedRow();
        loadformnd(index);

    }//GEN-LAST:event_tablendMouseClicked

    private void btnthemxxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemxxActionPerformed
        XuatSu xx = getformxx(0);
        if (xx != null) {
            if (JOptionPane.showConfirmDialog(this, "Bạn có chăc muốn thêm không !") == 0) {
                if (xxdao.insert(xx) != 0) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công xuất xứ !");
                    filtablexx(xxdao.selectAll());
                    clearformxx();
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại !");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Đã hủy thêm !");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại !");
        }
    }//GEN-LAST:event_btnthemxxActionPerformed

    private void btnthemnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemnhActionPerformed
        NhomHuong nh = getformnh(0);
        if (nh != null) {
            if (JOptionPane.showConfirmDialog(this, "Bạn có chăc muốn thêm không !") == 0) {
                if (nhdao.insert(nh) != 0) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công nhóm hương !");
                    filtablenh(nhdao.selectAll());
                    clearformnh();
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại !");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Đã hủy thêm !");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại !");
        }
    }//GEN-LAST:event_btnthemnhActionPerformed

    private void btnthemndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemndActionPerformed
        NongDo nd = getformnd(0);
        if (nd != null) {
            if (JOptionPane.showConfirmDialog(this, "Bạn có chăc muốn thêm không !") == 0) {
                if (nddao.insert(nd) != 0) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công nồng độ!");
                    filtablend(nddao.selectAll());
                    clearformnd();
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại !");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Đã hủy thêm !");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại !");
        }
    }//GEN-LAST:event_btnthemndActionPerformed

    public void clearformxx() {
        txtxuatxu.setText("");
        rdxxhd.setSelected(true);
    }

    public void clearformnd() {
        txtnd.setText("");
        rdndhd.setSelected(true);
    }

    public void clearformnh() {
        txtnhomhuong.setText("");
        rdnhhd.setSelected(true);
    }

    public void clearformsp() {
        txttensp.setText("");
        txtssolg.setText("");
        rdconhangsp.setSelected(true);
    }
    private void btnclearxxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearxxActionPerformed
        clearformxx();
    }//GEN-LAST:event_btnclearxxActionPerformed

    private void btnclearnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearnhActionPerformed
        clearformnh();
    }//GEN-LAST:event_btnclearnhActionPerformed

    private void btnclearndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearndActionPerformed
        clearformnd();
    }//GEN-LAST:event_btnclearndActionPerformed

    public void setLaiform() {

    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        ThemNhomHuong xs = new ThemNhomHuong(this, rootPaneCheckingEnabled);
        WindowListener dialogWindowListener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                String cbnd = cbnhomhuong.getSelectedItem().toString();
                cb = (DefaultComboBoxModel) cbnhomhuong.getModel();
                cb.removeAllElements();
                for (String object : ctdao.getTenNH()) {
                    cb.addElement(object);
                }
                cbnhomhuong.setSelectedItem(cbnd);
            }
        };
        xs.addWindowListener(dialogWindowListener);
        xs.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtluuhuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtluuhuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtluuhuongActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        ThemXs xs = new ThemXs(this, rootPaneCheckingEnabled);
        WindowListener dialogWindowListener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                String cbnd = cbxuatsu.getSelectedItem().toString();
                cb = (DefaultComboBoxModel) cbxuatsu.getModel();
                cb.removeAllElements();
                for (String object : ctdao.getTenXS()) {
                    cb.addElement(object);
                }
                cbxuatsu.setSelectedItem(cbnd);
            }
        };
        xs.addWindowListener(dialogWindowListener);
        xs.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        ThemNongDo xs = new ThemNongDo(this, rootPaneCheckingEnabled);
        WindowListener dialogWindowListener = new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                String cbnd = cbnongdo.getSelectedItem().toString();
                cb = (DefaultComboBoxModel) cbnongdo.getModel();
                cb.removeAllElements();
                for (String object : ctdao.getTenND()) {
                    cb.addElement(object);
                }
                cbnongdo.setSelectedItem(cbnd);
            }
        };
        xs.addWindowListener(dialogWindowListener);
        xs.setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnthemspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemspActionPerformed
        SanPham xx = getformsp(0);
        if (xx != null) {
            if (JOptionPane.showConfirmDialog(this, "Bạn có chăc muốn thêm không !") == 0) {
                if (spdao.insert(xx) != 0) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công Sản phẩm!");
                    filtablesp(spdao.selectAll());
                    clearformsp();
                } else {
                    JOptionPane.showMessageDialog(this, "Thêm thất bại !");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Đã hủy thêm !");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại !");
        }
    }//GEN-LAST:event_btnthemspActionPerformed

    private void btnclearspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearspActionPerformed
        clearformsp();
    }//GEN-LAST:event_btnclearspActionPerformed

    void loadformctsp(ChiTietSP chitiet) {
        txtmaspct.setText(String.valueOf(chitiet.getIdSanPham()));
        txtdotoahuong.setText(String.valueOf(chitiet.getDoToaHuong()));
        txtdungtich.setText(String.valueOf(chitiet.getDungTich()));
        txtthoigiannedung.setText(String.valueOf(chitiet.getThoiGianLenDung()));
        txtnamphathanh.setText(String.valueOf(chitiet.getNamPhatHanh()));
        txtluuhuong.setText(String.valueOf(chitiet.getLuuHuong()));
        cbnhomhuong.setSelectedItem(ctdao.getIDNH(chitiet.getIDNhomHuong()));
        cbxuatsu.setSelectedItem(ctdao.getIDNH(chitiet.getIDXuatXu()));
        cbnongdo.setSelectedItem(ctdao.getIDNH(chitiet.getIDNongDo()));
        if (chitiet.getTrangThai() == 1) {
            rdconctsp.setSelected(true);
        } else {
            rdhetctsp.setSelected(true);
        }
    }
    private void tablespMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablespMouseClicked
        int x = 0;
        int index = tablesp.getSelectedRow();
        if (index >= 0) {
            x = (int) tablesp.getValueAt(index, 0);
//            System.out.println(index);
            ChiTietSP chitiet = ctdao.selectById(tablesp.getValueAt(x - 1, 0).toString());
            loadformctsp(chitiet);
            loadformsp(index);
            cb = (DefaultComboBoxModel) cbmactsp.getModel();
            cb.removeAllElements();
            for (String object : ctdao.getTenSPct(x)) {
                cb.addElement(object);
            }

        }
    }//GEN-LAST:event_tablespMouseClicked

    private void cbmactspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbmactspMouseClicked
        System.out.println(cbmactsp.getSelectedItem());
    }//GEN-LAST:event_cbmactspMouseClicked

    private void cbmactspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbmactspActionPerformed
//        if (cbmactsp.getSelectedItem() != null) {
//            ChiTietSP chitiet=ctdao.selectById(tablesp.getValueAt((int) cbmactsp.getSelectedItem(), 0).toString());
//            loadformctsp(chitiet);
//            System.out.println(cbmactsp.getSelectedItem());
//
//        }
    }//GEN-LAST:event_cbmactspActionPerformed

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
            java.util.logging.Logger.getLogger(ViewSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewSanPham().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnclearnd;
    private javax.swing.JButton btnclearnh;
    private javax.swing.JButton btnclearsp;
    private javax.swing.JButton btnclearxx;
    private javax.swing.JButton btnsuanh;
    private javax.swing.JButton btnsuanongdo;
    private javax.swing.JButton btnsuasp;
    private javax.swing.JButton btnsuaxx;
    private javax.swing.JButton btnthemnd;
    private javax.swing.JButton btnthemnh;
    private javax.swing.JButton btnthemsp;
    private javax.swing.JButton btnthemxx;
    private javax.swing.JButton btntimkiem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.JComboBox<String> cbmactsp;
    private javax.swing.JComboBox<String> cbnhomhuong;
    private javax.swing.JComboBox<String> cbnongdo;
    private javax.swing.JComboBox<String> cbxuatsu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JRadioButton rdconctsp;
    private javax.swing.JRadioButton rdconhangsp;
    private javax.swing.JRadioButton rdhetctsp;
    private javax.swing.JRadioButton rdhetsap;
    private javax.swing.JRadioButton rdndhd;
    private javax.swing.JRadioButton rdndkhd;
    private javax.swing.JRadioButton rdnhhd;
    private javax.swing.JRadioButton rdnhkohd;
    private javax.swing.JRadioButton rdxxhd;
    private javax.swing.JRadioButton rdxxkohd;
    private javax.swing.JTable tablend;
    private javax.swing.JTable tablenh;
    private javax.swing.JTable tablesp;
    private javax.swing.JTable tableviewsp;
    private javax.swing.JTable tablexx;
    private javax.swing.JTextField txtdotoahuong;
    private javax.swing.JTextField txtdungtich;
    private javax.swing.JTextField txtluuhuong;
    private javax.swing.JTextField txtmaspct;
    private javax.swing.JTextField txtnamphathanh;
    private javax.swing.JTextField txtnd;
    private javax.swing.JPanel txtnh;
    private javax.swing.JTextField txtnhomhuong;
    private javax.swing.JTextField txtssolg;
    private javax.swing.JTextField txttensp;
    private javax.swing.JTextField txtthoigiannedung;
    private javax.swing.JTextField txttimkiem;
    private javax.swing.JTextField txtxuatxu;
    // End of variables declaration//GEN-END:variables
}
