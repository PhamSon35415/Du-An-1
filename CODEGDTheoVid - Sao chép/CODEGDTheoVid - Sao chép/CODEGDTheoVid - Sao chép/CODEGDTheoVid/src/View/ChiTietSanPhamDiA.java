/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Date;
import java.util.Enumeration;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ChiTietSP;
import service.ChiTietSpDao;

/**
 *
 * @author Admin
 */
public class ChiTietSanPhamDiA extends javax.swing.JDialog {

    String[] comlumsspct = {
        "ID Sản Phẩm chi tiết", "ID Sản Phẩm", "ID Xuất sứ", "ID Nồng độ", "ID Nhóm hương", "Độ tỏa hương", "Thời gian nên dùng", "Năm phát hành", "Dung tích", "Giới tính sử dụng", "Lưu hương"
    };
    private final ChiTietSpDao ctdao = new ChiTietSpDao();
//    DefaultTableModel modelspct = new DefaultTableModel(comlumsspct, 0);
    DefaultComboBoxModel cb = new DefaultComboBoxModel();
    int mainidsp;

    /**
     * Creates new form ChiTietSanPhamDiA
     */
    public ChiTietSanPhamDiA(java.awt.Frame parent, boolean modal, int x) {
        super(parent, modal);
        initComponents();
        mainidsp = x;
        addcobo();
        seteditter(false);
        loadform(ctdao.selectById(x));

    }

    public void loadform(ChiTietSP ct) {
        txtdotoahuong.setText(ct.getDOTOHUONG());
        txtdungtich.setText(String.valueOf(ct.getDUNGTICH()));
        txtgia.setText(String.valueOf(ct.getGIA()));
        txtluuhuong.setText(String.valueOf(ct.getLUUHUONG()));
        txtmachitietsp.setText(String.valueOf(ct.getIDSANPHAMCHITIET()));
        txtmasp.setText(String.valueOf(ct.getID_SP()));
        txtnamphathanh.setText(ct.getNAMPHATHANH());
        txtsolg.setText(String.valueOf(ct.getSOLG()));
        txtthoigiannedung.setText(ct.getTHOIGIANNENDUNG());
        cbnhomhuong.setSelectedItem(ctdao.getTenNH2(ct.getID_NHOMHUONG()));
        cbnongdo.setSelectedItem(ctdao.getTenND2(ct.getID_NONGDO()));
        cbxuatsu.setSelectedItem(ctdao.getTenXS2(ct.getID_XUATXU()));
        switch (ct.getGIOITINH()) {
            case 0 ->
                rdnu.setSelected(true);
            case 1 ->
                rdnam.setSelected(true);
            default ->
                rdaicxdc.setSelected(true);
        }
        if (ct.getTRANGTHAI() == 0) {
            rdhethang.setSelected(true);
        } else {
            rdconhang.setSelected(true);
        }
    }

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

    public static void disableButtonGroup(ButtonGroup buttonGroup, boolean x) {
        for (Enumeration<AbstractButton> buttons = buttonGroup.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();
            button.setEnabled(x);
        }
    }

    void seteditter(boolean k) {
        txtdotoahuong.setEditable(k);
        txtdungtich.setEditable(k);
        txtgia.setEditable(k);
        txtluuhuong.setEditable(k);
        txtmachitietsp.setEditable(k);
        txtmasp.setEditable(k);
        txtnamphathanh.setEditable(k);
        txtsolg.setEditable(k);
        txtthoigiannedung.setEditable(k);
        cbnhomhuong.setEditable(k);
        cbnongdo.setEditable(k);
        cbxuatsu.setEditable(k);
        disableButtonGroup(buttonGroup1, k);
        disableButtonGroup(buttonGroup2, k);
    }

    ChiTietSP getformspct() {
        int idctsp, idsp;
        int xs, nd, nh, solg = 0, tt;
        String doth;
        String thoigian;
        String nam;
        double gia = 0;
        try {
            gia = Double.parseDouble(txtgia.getText());
        } catch (NumberFormatException e) {
        }
        try {
            solg = Integer.parseInt(txtsolg.getText());
        } catch (NumberFormatException e) {
        }
        int dungtich, luuhuong, gt;
        idctsp = ctdao.selectById4() + 1;
        idsp = Integer.parseInt(txtmasp.getText());
        xs = ctdao.getidXs(cbxuatsu.getSelectedItem().toString());
        nd = ctdao.getidND(cbnongdo.getSelectedItem().toString());
        nh = ctdao.getiNH(cbnhomhuong.getSelectedItem().toString());
        doth = txtdotoahuong.getText();
        thoigian = txtthoigiannedung.getText();
        nam = txtnamphathanh.getText();
        dungtich = Integer.parseInt(txtdungtich.getText());
        luuhuong = Integer.parseInt(txtluuhuong.getText());
        if (rdnam.isSelected()) {
            gt = 1;
        } else if (rdnu.isSelected()) {
            gt = 0;
        } else {
            gt = 2;
        }
        if (rdconhang.isSelected()) {
            tt = 1;
        } else {
            tt = 0;
        }

        return new ChiTietSP(idctsp, idsp, xs,
                nd, nh, doth, thoigian, nam,
                gt, luuhuong, gia, dungtich, solg, tt);

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
        jPanel1 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        rdnam = new javax.swing.JRadioButton();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        btnNhomHuong = new javax.swing.JButton();
        btnXuatXu = new javax.swing.JButton();
        jLabel29 = new javax.swing.JLabel();
        txtluuhuong = new javax.swing.JTextField();
        btnthemct = new javax.swing.JButton();
        jLabel31 = new javax.swing.JLabel();
        rdnu = new javax.swing.JRadioButton();
        txtmasp = new javax.swing.JTextField();
        txtthoigiannedung = new javax.swing.JTextField();
        btnclear = new javax.swing.JButton();
        cbnhomhuong = new javax.swing.JComboBox<>();
        txtdotoahuong = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        cbnongdo = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        btnsuct = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        txtnamphathanh = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        btnNongDo = new javax.swing.JButton();
        cbxuatsu = new javax.swing.JComboBox<>();
        txtdungtich = new javax.swing.JTextField();
        txtmachitietsp = new javax.swing.JTextField();
        rdaicxdc = new javax.swing.JRadioButton();
        txtsolg = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        txtgia = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        rdhethang = new javax.swing.JRadioButton();
        rdconhang = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("ID Sp:");

        jLabel26.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel26.setText("Dung tích:");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel27.setText("Lưu Hương");

        buttonGroup1.add(rdnam);
        rdnam.setText("Nam");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel30.setText("Nhóm hương:");

        jLabel32.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel32.setText("Nồng độ:");

        jLabel22.setBackground(new java.awt.Color(0, 0, 255));
        jLabel22.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 204));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Chi tiết sản phẩm");

        btnNhomHuong.setText("Sửa");
        btnNhomHuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhomHuongActionPerformed(evt);
            }
        });

        btnXuatXu.setText("Sửa");
        btnXuatXu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuatXuActionPerformed(evt);
            }
        });

        jLabel29.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel29.setText("Xuất xứ:");

        txtluuhuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtluuhuongActionPerformed(evt);
            }
        });

        btnthemct.setText("Thêm mới");
        btnthemct.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnthemctMouseClicked(evt);
            }
        });
        btnthemct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnthemctActionPerformed(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel31.setText("Đối tượng SD:");

        buttonGroup1.add(rdnu);
        rdnu.setText("Nữ");

        txtmasp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmaspActionPerformed(evt);
            }
        });

        txtthoigiannedung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtthoigiannedungActionPerformed(evt);
            }
        });

        btnclear.setText("Clear");

        cbnhomhuong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtdotoahuong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdotoahuongActionPerformed(evt);
            }
        });

        jLabel24.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel24.setText("Năm phát hành:");

        cbnongdo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel25.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel25.setText("Mã chi tiết sản phẩm:");

        btnsuct.setText("Sửa");
        btnsuct.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsuctActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel15.setText("Độ tỏa hương:");

        txtnamphathanh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnamphathanhActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel16.setText("Thời gian nên dùng:");

        btnNongDo.setText("Sửa");
        btnNongDo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNongDoActionPerformed(evt);
            }
        });

        cbxuatsu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtdungtich.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdungtichActionPerformed(evt);
            }
        });

        txtmachitietsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmachitietspActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdaicxdc);
        rdaicxdc.setText("Ai dùng cũng được");

        txtsolg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsolgActionPerformed(evt);
            }
        });

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setText("Số lượng:");

        txtgia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgiaActionPerformed(evt);
            }
        });

        jLabel33.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel33.setText("Giá:");

        jLabel34.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel34.setText("Trạng thái:");

        buttonGroup2.add(rdhethang);
        rdhethang.setText("Hết hàng");

        buttonGroup2.add(rdconhang);
        rdconhang.setText("Còn hàng");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnthemct, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnsuct, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnclear))
                    .addComponent(jLabel23)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15)
                                    .addComponent(jLabel25)
                                    .addComponent(jLabel24)
                                    .addComponent(jLabel16))
                                .addGap(12, 12, 12))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel26)
                                .addGap(82, 82, 82)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtdungtich, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtmasp, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE)
                                .addComponent(txtnamphathanh)
                                .addComponent(txtthoigiannedung)
                                .addComponent(txtdotoahuong)
                                .addComponent(txtmachitietsp, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel29)
                                .addComponent(jLabel32)
                                .addComponent(jLabel30, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel27)
                            .addComponent(jLabel31)
                            .addComponent(jLabel28)
                            .addComponent(jLabel33)
                            .addComponent(jLabel34))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtgia)
                            .addComponent(txtsolg)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rdnam, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdnu, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdaicxdc, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(cbxuatsu, javax.swing.GroupLayout.Alignment.TRAILING, 0, 213, Short.MAX_VALUE)
                                    .addComponent(cbnhomhuong, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cbnongdo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(btnNongDo, javax.swing.GroupLayout.PREFERRED_SIZE, 53, Short.MAX_VALUE)
                                    .addComponent(btnNhomHuong, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                    .addComponent(btnXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                            .addComponent(txtluuhuong)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(rdconhang, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(rdhethang, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel22)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(txtmasp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(txtmachitietsp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addComponent(txtdotoahuong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtthoigiannedung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(txtnamphathanh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel26))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtdungtich, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel28))
                    .addComponent(txtsolg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel29)
                        .addGap(8, 8, 8)
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel27))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbnhomhuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnNhomHuong, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cbxuatsu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnNongDo, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbnongdo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(btnXuatXu, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtluuhuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdnam)
                            .addComponent(rdnu)
                            .addComponent(rdaicxdc)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel31)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel33)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtgia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel34)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(rdhethang)
                        .addComponent(rdconhang)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthemct)
                    .addComponent(btnclear)
                    .addComponent(btnsuct))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNhomHuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhomHuongActionPerformed
        ThemNhomHuong xs = new ThemNhomHuong(null, true);
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
    }//GEN-LAST:event_btnNhomHuongActionPerformed

    private void btnXuatXuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuatXuActionPerformed
        ThemXs xs = new ThemXs(null, true);
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
    }//GEN-LAST:event_btnXuatXuActionPerformed

    private void txtluuhuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtluuhuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtluuhuongActionPerformed

    private void btnthemctMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnthemctMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnthemctMouseClicked
    int test = 0;
    private void btnthemctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemctActionPerformed
        ChiTietSP xx = getformspct();
        if (test % 2 == 0) {
            btnthemct.setText("OK");
            seteditter(true);
            test++;

        } else {
            if (xx != null) {
                if (JOptionPane.showConfirmDialog(this, "Bạn có chăc muốn thêm không !") == 0) {
                    if (ctdao.insert(xx) != 0) {
                        JOptionPane.showMessageDialog(this, "Thêm thành công CT Sản phẩm!");
                        test++;
                        btnthemct.setText("Thêm mới");
                        seteditter(false);
                    } else {
                        JOptionPane.showMessageDialog(this, "Thêm thất bại2 !");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Đã hủy thêm !");
                    test = 0;
                    btnthemct.setText("Thêm mới");
                    seteditter(false);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Thêm thất bại2 !");
            }
        }

    }//GEN-LAST:event_btnthemctActionPerformed

    private void txtmaspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmaspActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmaspActionPerformed

    private void txtthoigiannedungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtthoigiannedungActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtthoigiannedungActionPerformed

    private void txtdotoahuongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdotoahuongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdotoahuongActionPerformed
    int test2 = 0;
    private void btnsuctActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuctActionPerformed
        ChiTietSP Sp = getformspct();
        if (test2 % 2 == 0) {
            btnsuct.setText("OK rồi");
            seteditter(true);
            test2++;
        } else {
            if (Sp != null) {
                if (JOptionPane.showConfirmDialog(this, "Bạn có chăc muốn Sửa không !") == 0) {
                    if (ctdao.update(Sp, mainidsp) != 0) {
                        JOptionPane.showMessageDialog(this, "Sửa thành công !");
                        btnsuct.setText("Sửa");
                        seteditter(false);
                        test2++;
                    } else {
                        JOptionPane.showMessageDialog(this, "Sửa thất bại1 !");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Đã hủy Sửa !");
                    btnsuct.setText("Sửa");
                    seteditter(false);
                    test2 = 0;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Sửa thất bại2 !");
            }
        }


    }//GEN-LAST:event_btnsuctActionPerformed

    private void txtnamphathanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnamphathanhActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnamphathanhActionPerformed

    private void btnNongDoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNongDoActionPerformed
        ThemNongDo xs = new ThemNongDo(null, true);
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
    }//GEN-LAST:event_btnNongDoActionPerformed

    private void txtdungtichActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdungtichActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdungtichActionPerformed

    private void txtmachitietspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmachitietspActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmachitietspActionPerformed

    private void txtsolgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsolgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsolgActionPerformed

    private void txtgiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgiaActionPerformed

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
            java.util.logging.Logger.getLogger(ChiTietSanPhamDiA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChiTietSanPhamDiA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChiTietSanPhamDiA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChiTietSanPhamDiA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ChiTietSanPhamDiA dialog = new ChiTietSanPhamDiA(new javax.swing.JFrame(), true, 0);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNhomHuong;
    private javax.swing.JButton btnNongDo;
    private javax.swing.JButton btnXuatXu;
    private javax.swing.JButton btnclear;
    private javax.swing.JButton btnsuct;
    private javax.swing.JButton btnthemct;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbnhomhuong;
    private javax.swing.JComboBox<String> cbnongdo;
    private javax.swing.JComboBox<String> cbxuatsu;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton rdaicxdc;
    private javax.swing.JRadioButton rdconhang;
    private javax.swing.JRadioButton rdhethang;
    private javax.swing.JRadioButton rdnam;
    private javax.swing.JRadioButton rdnu;
    private javax.swing.JTextField txtdotoahuong;
    private javax.swing.JTextField txtdungtich;
    private javax.swing.JTextField txtgia;
    private javax.swing.JTextField txtluuhuong;
    private javax.swing.JTextField txtmachitietsp;
    private javax.swing.JTextField txtmasp;
    private javax.swing.JTextField txtnamphathanh;
    private javax.swing.JTextField txtsolg;
    private javax.swing.JTextField txtthoigiannedung;
    // End of variables declaration//GEN-END:variables
}
