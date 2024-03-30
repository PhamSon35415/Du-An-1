/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.util.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import service.ChiTietSpDao;
import service.SanPhamDao;
import model.*;

/**
 *
 * @author Admin
 */
public class TestSanPham extends javax.swing.JFrame {
    
    private final SanPhamDao spdao = new SanPhamDao();
    private final ChiTietSpDao ctdao = new ChiTietSpDao();
    String[] comlumssp = {
        "ID San pham", "Tên Sản phẩm", "Số lượng", "Ngày tao", "Ngày sửa", "Trạng thái"
    };
    //IDSANPHAMCHITIET, DOTOHUONG, THOIGIANNENDUNG, NAMPHATHANH, DUNGTICH, GIOITINH, LUUHUONG, ID_SP, ID_XUATXU, ID_NONGDO, ID_NHOMHUONG
    DefaultTableModel modelsp = new DefaultTableModel(comlumssp, 0);
    String[] comlumsspct = {
        "ID Sản Phẩm chi tiết", "ID Sản Phẩm", "Xuất sứ", "Nồng độ", "ID Nhóm hương", "Độ tỏa hương", "Thời gian nên dùng", "Năm phát hành", "Giới tính sử dụng",
        "Lưu hương", "Giá", "Dung tích", "Số lượng", "Trạng thái"
    };
    
    DefaultTableModel modelspct = new DefaultTableModel(comlumsspct, 0);

    /**
     * Creates new form TestSanPham
     */
    public TestSanPham() {
        initComponents();
        setcolums();
        
        filtablesp(spdao.selectAll());
    }

//IDSANPHAM, SOLUONG, TENSANPHAM, NGAYTAO, NGAYSUA, TRANGTHAI
    void filtablesp(List<SanPham> list) {
        modelsp.setRowCount(0);
        for (SanPham sp : list) {
            modelsp.addRow(sp.torow());
        }
    }

    //    IDSANPHAMCHITIET, ID_SP, ID_XUATXU, ID_NONGDO, ID_NHOMHUONG, DOTOHUONG, THOIGIANNENDUNG, NAMPHATHANH, "
//                + " GIOITINH, LUUHUONG, GIA,DUNGTICH, SOLUONG, TRANGTHAI
    void filtablespct(List<ChiTietSP> list) {
        modelspct.setRowCount(0);
        for (ChiTietSP sp : list) {
            String tt;
            tt = switch (sp.getTRANGTHAI()) {
                case 0 ->
                    "Hết hàng";
                case 1 ->
                    "Còn hàng";
                default ->
                    "Trạng thái không xác định";
            };
            String gt;
            gt = switch (sp.getGIOITINH()) {
                case 0 ->
                    "Nữ";
                case 1 ->
                    "Nam";
                default ->
                    "Không xác định";
            };
            modelspct.addRow(new Object[]{
                sp.getIDSANPHAMCHITIET(),
                sp.getID_SP(),
                ctdao.getIDXS(sp.getID_XUATXU()),
                ctdao.getIDND(sp.getID_NONGDO()),
                ctdao.getIDNH(sp.getID_NHOMHUONG()),
                sp.getDOTOHUONG(),
                sp.getTHOIGIANNENDUNG(),
                sp.getNAMPHATHANH(),
                gt,
                sp.getLUUHUONG(),
                sp.getGIA() + "VND",
                sp.getDUNGTICH() + "ml",
                sp.getSOLG(),
                tt            
            });
        }
    }
    
    public void setcolums() {
        tblctsp.setModel(modelspct);
        tablesp.setModel(modelsp);
//        tableviewsp.setModel(modelsp);
    }
//"ID San pham", "Tên Sản phẩm", "Số lượng","Ngày tao","Ngày sửa", "Trạng thái"

    void loadformsp(int index) {
        txttensp.setText(tablesp.getValueAt(index, 1).toString());
        txtssolg.setText(tablesp.getValueAt(index, 2).toString());
        if (tablesp.getValueAt(index, 5).toString().equalsIgnoreCase("Còn hàng")) {
            rdconhangsp.setSelected(true);
        } else {
            rdhetsap.setSelected(true);
        }
    }
    
    SanPham getformsp(int x) {
        
        int idsp = spdao.selectById4() + 1;
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
        if (x == 0) {
            return new SanPham(idsp, solg, tensp, null, ttsp);
        } else {
            return new SanPham(solg, tensp, ttsp);
        }
    }
    
    public void clearformsp() {
        txttensp.setText("");
        txtssolg.setText("");
        rdconhangsp.setSelected(true);
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
        jLabel28 = new javax.swing.JLabel();
        txtssolg = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblctsp = new javax.swing.JTable();
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
        btnthemspct = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel28.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel28.setText("Tên sản phẩm:");

        tblctsp.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblctsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblctspMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblctsp);

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel17.setText("Quản lý sản phẩm");

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel20.setText("Số lượng:");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel21.setText("Trạng Thái:");

        buttonGroup1.add(rdconhangsp);
        rdconhangsp.setText("Còn Hàng");

        buttonGroup1.add(rdhetsap);
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

        btnthemspct.setText("Thêm sản phẩm chi tiết");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel20)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtssolg, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnthemspct, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel21)
                                                .addGap(29, 29, 29))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel28)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(rdconhangsp, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(rdhetsap))
                                            .addComponent(txttensp, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnthemsp)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnsuasp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnclearsp, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 689, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel17)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txttensp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel28))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(txtssolg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdconhangsp)
                            .addComponent(rdhetsap)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnclearsp)
                            .addComponent(btnthemsp)
                            .addComponent(btnsuasp))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnthemspct))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnthemspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnthemspMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnthemspMouseClicked

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

    private void btnsuaspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaspActionPerformed
        SanPham Sp = getformsp(1);
        int index = tablesp.getSelectedRow();
        if (index >= 0) {
            if (Sp != null) {
                int x = spdao.selectAll().get(index).getIDSANPHAM();
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

    private void btnclearspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearspActionPerformed
        clearformsp();
    }//GEN-LAST:event_btnclearspActionPerformed

    private void tablespMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablespMouseClicked
        int x = 0;
        int index = tablesp.getSelectedRow();
        if (index >= 0) {
            x = (int) tablesp.getValueAt(index, 0);
            //            System.out.println(index);
            List<ChiTietSP> chitiet = ctdao.selectByIdctsp((Integer) tablesp.getValueAt(x - 1, 0));
            if (chitiet != null) {
                filtablespct(chitiet);
            }
            loadformsp(index);
//            cb = (DefaultComboBoxModel) cbmactsp.getModel();
//            cb.removeAllElements();
//            for (String object : ctdao.getTenSPct(x)) {
//                cb.addElement(object);
//            }

        }
    }//GEN-LAST:event_tablespMouseClicked

    private void tblctspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblctspMouseClicked
        int in = tblctsp.getSelectedRow();
        if (in >= 0) {
            int cf=Integer.parseInt(tblctsp.getValueAt(in, 0).toString());
            System.out.println(cf);
            ChiTietSanPhamDiA dia = new ChiTietSanPhamDiA(null, true, cf);
            
            dia.setVisible(true);
        }
    }//GEN-LAST:event_tblctspMouseClicked

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
            java.util.logging.Logger.getLogger(TestSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TestSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TestSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TestSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TestSanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnclearsp;
    private javax.swing.JButton btnsuasp;
    private javax.swing.JButton btnthemsp;
    private javax.swing.JButton btnthemspct;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JRadioButton rdconhangsp;
    private javax.swing.JRadioButton rdhetsap;
    private javax.swing.JTable tablesp;
    private javax.swing.JTable tblctsp;
    private javax.swing.JTextField txtssolg;
    private javax.swing.JTextField txttensp;
    // End of variables declaration//GEN-END:variables
}
