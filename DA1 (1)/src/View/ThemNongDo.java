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
import model.NongDo;
import service.NongDoDao;


/**
 *
 * @author Admin
 */
public class ThemNongDo extends javax.swing.JDialog {
    private NongDoDao nddao = new NongDoDao();
    String[] colums = {
        "Tên", "Trạng thái"
    };
    DefaultTableModel model = new DefaultTableModel(colums, 0);

    /**
     * Creates new form ThemNongDo
     */
    public ThemNongDo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        table.setModel(model);
        this.setLocationRelativeTo(null);
        filltable(nddao.selectAll());
    }

    void filltable(List<NongDo> list) {
        model.setRowCount(0);
        for (NongDo nd : list) {
            model.addRow(nd.torow());
        }
    }
        void loadformnd(int indexnd) {
        txtnd.setText(table.getValueAt(indexnd, 0).toString());
        if (table.getValueAt(indexnd, 1).toString().equalsIgnoreCase("Hoạt động")) {
            rdndhd.setSelected(true);
        } else {
            rdndkhd.setSelected(true);
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
        public void clearformnd() {
        txtnd.setText("");
        rdndhd.setSelected(true);
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
        table = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel38.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel38.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel38.setText("Nồng độ");

        jLabel39.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel39.setText("Tên nồng độ");

        jLabel40.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel40.setText("Trạng Thái:");

        buttonGroup1.add(rdndhd);
        rdndhd.setText("Hoạt động");

        buttonGroup1.add(rdndkhd);
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

        table.setModel(new javax.swing.table.DefaultTableModel(
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
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(table);

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdndhd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rdndkhd))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(jLabel39)
                                .addGap(18, 18, 18)
                                .addComponent(txtnd))))
                    .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                            .addGap(12, 12, 12)
                            .addComponent(btnthemnd)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnsuanongdo)
                            .addGap(45, 45, 45)
                            .addComponent(btnclearnd))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel14Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(14, 14, 14))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnthemnd)
                    .addComponent(btnsuanongdo)
                    .addComponent(btnclearnd))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnthemndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnthemndActionPerformed
        NongDo nd = getformnd(0);
        if (nd != null) {
            if (JOptionPane.showConfirmDialog(this, "Bạn có chăc muốn thêm không !") == 0) {
                if (nddao.insert(nd) != 0) {
                    JOptionPane.showMessageDialog(this, "Thêm thành công nồng độ!");
                    filltable(
                            nddao.selectAll());
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

    private void btnsuanongdoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsuanongdoActionPerformed
        NongDo nd = getformnd(1);
        int index = table.getSelectedRow();
        if (index >= 0) {
            if (nd != null) {
                String x = String.valueOf(nddao.selectAll().get(index).getIDND());
                if (JOptionPane.showConfirmDialog(this, "Bạn có chăc muốn Sửa không !") == 0) {
                    if (nddao.update(nd, x) != 0) {
                        JOptionPane.showMessageDialog(this, "Sửa thành công nồng độ!");
                        filltable(nddao.selectAll());
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

    private void btnclearndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearndActionPerformed
        clearformnd();
    }//GEN-LAST:event_btnclearndActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        int index = table.getSelectedRow();
        loadformnd(index);
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
            java.util.logging.Logger.getLogger(ThemNongDo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThemNongDo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThemNongDo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThemNongDo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ThemNongDo dialog = new ThemNongDo(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnclearnd;
    private javax.swing.JButton btnsuanongdo;
    private javax.swing.JButton btnthemnd;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JRadioButton rdndhd;
    private javax.swing.JRadioButton rdndkhd;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtnd;
    // End of variables declaration//GEN-END:variables
}