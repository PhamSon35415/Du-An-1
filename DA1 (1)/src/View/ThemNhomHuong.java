/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.NhomHuong;
import service.NhomHuongDao;

/**
 *
 * @author Admin
 */
public class ThemNhomHuong extends javax.swing.JDialog {

    private NhomHuongDao nhdao = new NhomHuongDao();
    String[] colums = {
        "Tên", "Trạng thái"
    };
    DefaultTableModel model = new DefaultTableModel(colums, 0);

    /**
     * Creates new form ThemNhomHuong
     */
    public ThemNhomHuong(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        table.setModel(model);
        this.setLocationRelativeTo(null);
        filltable(nhdao.selectAll());
    }

    void filltable(List<NhomHuong> list) {
        model.setRowCount(0);
        for (NhomHuong nh : list) {
            model.addRow(nh.torow());
        }
    }

    NhomHuong getformnh(int x) {//1 sua;0 tao
        String ten = txtnhomhuong.getText().trim();
        if (ten.length() == 0) {
            JOptionPane.showMessageDialog(this, "Chua nhap ten Nhom huong!");
            return null;
        }
        int tt = -1;
        if (rdnhhd.isSelected()) {
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

    public void clearformnh() {
        txtnhomhuong.setText("");
        rdnhhd.setSelected(true);
    }
    void loadformnh(int indexnh) {
        txtnhomhuong.setText(table.getValueAt(indexnh, 0).toString());
        if (table.getValueAt(indexnh, 1).toString().equalsIgnoreCase("Hoạt động")) {
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

        buttonGroup1 = new javax.swing.ButtonGroup();
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
        table = new javax.swing.JTable();
        txtnhomhuong = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel35.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel35.setText("Nhóm Hương");

        jLabel36.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel36.setText("Tên nhóm hương");

        jLabel37.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel37.setText("Trạng Thái:");

        buttonGroup1.add(rdnhhd);
        rdnhhd.setText("Hoạt động");

        buttonGroup1.add(rdnhkohd);
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

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(table);

        javax.swing.GroupLayout txtnhLayout = new javax.swing.GroupLayout(txtnh);
        txtnh.setLayout(txtnhLayout);
        txtnhLayout.setHorizontalGroup(
            txtnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(txtnhLayout.createSequentialGroup()
                .addGroup(txtnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(txtnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(txtnhLayout.createSequentialGroup()
                            .addGap(14, 14, 14)
                            .addGroup(txtnhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(txtnhLayout.createSequentialGroup()
                                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(rdnhhd)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(rdnhkohd))
                                .addGroup(txtnhLayout.createSequentialGroup()
                                    .addComponent(jLabel36)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtnhomhuong, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))))
                        .addGroup(txtnhLayout.createSequentialGroup()
                            .addGap(100, 100, 100)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(txtnhLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnthemnh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnsuanh)
                        .addGap(54, 54, 54)
                        .addComponent(btnclearnh)))
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(txtnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtnh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnthemnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemnhActionPerformed
        NhomHuong nh = getformnh(0);
        if (nh != null) {
            if (JOptionPane.showConfirmDialog(this, "Bạn có chăc muốn thêm không !") == 0) {
                if (nhdao.insert(nh) != 0) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công nhóm hương !");
                    filltable(nhdao.selectAll());
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

    private void btnsuanhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuanhActionPerformed
        NhomHuong nh = getformnh(1);
        int index = table.getSelectedRow();
        if (index >= 0) {
            if (nh != null) {
                String x = String.valueOf(nhdao.selectAll().get(index).getIDNH());
                if (JOptionPane.showConfirmDialog(this, "Bạn có chăc muốn Sửa không !") == 0) {
                    if (nhdao.update(nh, x) != 0) {
                        JOptionPane.showMessageDialog(this, "Sửa thành công Nhom hương!");
                        filltable(nhdao.selectAll());
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

    private void btnclearnhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearnhActionPerformed
        clearformnh();
    }//GEN-LAST:event_btnclearnhActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int index = table.getSelectedRow();
        loadformnh(index);
    }//GEN-LAST:event_tableMouseClicked

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
            java.util.logging.Logger.getLogger(ThemNhomHuong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemNhomHuong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemNhomHuong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemNhomHuong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ThemNhomHuong dialog = new ThemNhomHuong(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnclearnh;
    private javax.swing.JButton btnsuanh;
    private javax.swing.JButton btnthemnh;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JRadioButton rdnhhd;
    private javax.swing.JRadioButton rdnhkohd;
    private javax.swing.JTable table;
    private javax.swing.JPanel txtnh;
    private javax.swing.JTextField txtnhomhuong;
    // End of variables declaration//GEN-END:variables
}
