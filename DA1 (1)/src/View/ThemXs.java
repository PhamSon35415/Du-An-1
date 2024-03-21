/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package View;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.naming.ldap.Rdn;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.XuatSu;

import service.XuatXuDao;

/**
 *
 * @author Admin
 */
public class ThemXs extends javax.swing.JDialog {
    private XuatXuDao ser = new XuatXuDao();
    String[] colums = {
        "Tên", "Trạng thái"
    };
    DefaultTableModel model = new DefaultTableModel(colums, 0);
    /**
     * Creates new form ThemXs
     */
    public ThemXs(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
          table.setModel(model);
        this.setLocationRelativeTo(null);
        filltable(ser.selectAll());
    }

    void filltable(List<XuatSu> list) {
        model.setRowCount(0);
        for (XuatSu xuatSu : list) {
            model.addRow(xuatSu.torow());
        }
    }

    public void clearformxx() {
        txtten.setText("");
        rdhd.setSelected(true);
    }

    void loadformxx(int indexxx) {
        txtten.setText(table.getValueAt(indexxx, 0).toString());
        if (table.getValueAt(indexxx, 1).toString().equalsIgnoreCase("Hoạt động")) {
            rdhd.setSelected(true);
        } else {
            rdkhd.setSelected(true);
        }
    }

    XuatSu getformxx(int x) {//1 sua;0 tao
        String ten = txtten.getText().trim();
        if (ten.length() == 0) {
            JOptionPane.showMessageDialog(this, "Chua nhap ten Xuat xu!");
            return null;
        }
        int tt = -1;
        if (rdhd.isSelected()) {
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
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        rdkhd = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        txtten = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        btnthemxx = new javax.swing.JButton();
        btnsuaxx = new javax.swing.JButton();
        btnclearxx = new javax.swing.JButton();
        jLabel33 = new javax.swing.JLabel();
        rdhd = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        buttonGroup1.add(rdkhd);
        rdkhd.setText("KHD");

        jLabel1.setText("Tên:");

        jLabel2.setText("Trạng thái:");

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table);

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

        jLabel33.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel33.setText("Xuất Xứ");

        buttonGroup1.add(rdhd);
        rdhd.setText("HD");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnthemxx)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnclearxx))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtten)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(24, 24, 24)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addComponent(btnsuaxx))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(rdhd)
                                                .addGap(55, 55, 55)
                                                .addComponent(rdkhd)))
                                        .addGap(0, 35, Short.MAX_VALUE)))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(101, 101, 101))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel33)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(rdhd)
                    .addComponent(rdkhd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthemxx)
                    .addComponent(btnsuaxx)
                    .addComponent(btnclearxx))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 183, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int index=table.getSelectedRow();
        loadformxx(index);
    }//GEN-LAST:event_tableMouseClicked

    private void btnthemxxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemxxActionPerformed
        XuatSu xx = getformxx(0);
        if (xx != null) {
            if (JOptionPane.showConfirmDialog(this, "Bạn có chăc muốn thêm không !") == 0) {
                if (ser.insert(xx) != 0) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công xuất xứ !");
                    filltable(ser.selectAll());
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

    private void btnsuaxxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuaxxActionPerformed
        XuatSu xx = getformxx(1);
        int index = table.getSelectedRow();
        if (index >= 0) {
            if (xx != null) {
                String x = String.valueOf(ser.selectAll().get(index).getIDXS());
                if (JOptionPane.showConfirmDialog(this, "Bạn có chăc muốn Sửa không !") == 0) {
                    if (ser.update(xx, x) != 0) {
                        JOptionPane.showMessageDialog(this, "Sửa thành công xuất xứ !");
                        filltable(ser.selectAll());
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

    private void btnclearxxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearxxActionPerformed
        clearformxx();
    }//GEN-LAST:event_btnclearxxActionPerformed

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
            java.util.logging.Logger.getLogger(ThemXs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemXs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemXs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemXs.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ThemXs dialog = new ThemXs(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnclearxx;
    private javax.swing.JButton btnsuaxx;
    private javax.swing.JButton btnthemxx;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdhd;
    private javax.swing.JRadioButton rdkhd;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtten;
    // End of variables declaration//GEN-END:variables
}