/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import java.awt.Color;
import javax.swing.JPanel;

/**
 *
 * @author ACER
 */
public class ViewTrangChu extends javax.swing.JFrame {

    private JPanel jpn;
    /**
     * Creates new form ViewTrangChu
     */
    public ViewTrangChu() {
         initComponents();
         setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnmain = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnsp = new javax.swing.JButton();
        btnkh = new javax.swing.JButton();
        btnnv = new javax.swing.JButton();
        btnhd = new javax.swing.JButton();
        btnvoucher = new javax.swing.JButton();
        btnexit = new javax.swing.JButton();
        tbnbanhang1 = new javax.swing.JButton();
        tbnbanhang = new javax.swing.JButton();
        btnvoucher1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setType(java.awt.Window.Type.POPUP);

        jpnmain.setBackground(new java.awt.Color(255, 153, 255));

        javax.swing.GroupLayout jpnmainLayout = new javax.swing.GroupLayout(jpnmain);
        jpnmain.setLayout(jpnmainLayout);
        jpnmainLayout.setHorizontalGroup(
            jpnmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 849, Short.MAX_VALUE)
        );
        jpnmainLayout.setVerticalGroup(
            jpnmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btnsp.setBackground(new java.awt.Color(153, 204, 255));
        btnsp.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnsp.setText("Sản Phẩm");
        btnsp.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnspMouseClicked(evt);
            }
        });
        btnsp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnspActionPerformed(evt);
            }
        });

        btnkh.setBackground(new java.awt.Color(255, 204, 204));
        btnkh.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnkh.setText("Khách Hàng");
        btnkh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnkhMouseClicked(evt);
            }
        });

        btnnv.setBackground(new java.awt.Color(204, 255, 204));
        btnnv.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnnv.setText("Nhân Viên");
        btnnv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnnvMouseClicked(evt);
            }
        });

        btnhd.setBackground(new java.awt.Color(102, 102, 255));
        btnhd.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnhd.setText("Hóa Đơn");
        btnhd.setToolTipText("");
        btnhd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnhdMouseClicked(evt);
            }
        });

        btnvoucher.setBackground(new java.awt.Color(0, 255, 204));
        btnvoucher.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnvoucher.setText("Đổi Mật Khẩu");
        btnvoucher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnvoucherMouseClicked(evt);
            }
        });
        btnvoucher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvoucherActionPerformed(evt);
            }
        });

        btnexit.setBackground(new java.awt.Color(255, 102, 102));
        btnexit.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnexit.setText("Đăng Xuất");
        btnexit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnexitMouseClicked(evt);
            }
        });
        btnexit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexitActionPerformed(evt);
            }
        });

        tbnbanhang1.setBackground(new java.awt.Color(204, 255, 255));
        tbnbanhang1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tbnbanhang1.setText("Thống Kê");
        tbnbanhang1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbnbanhang1MouseClicked(evt);
            }
        });
        tbnbanhang1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnbanhang1ActionPerformed(evt);
            }
        });

        tbnbanhang.setBackground(new java.awt.Color(153, 255, 153));
        tbnbanhang.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        tbnbanhang.setText("Bán Hàng");
        tbnbanhang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbnbanhangMouseClicked(evt);
            }
        });
        tbnbanhang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tbnbanhangActionPerformed(evt);
            }
        });

        btnvoucher1.setBackground(new java.awt.Color(255, 255, 153));
        btnvoucher1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        btnvoucher1.setText("Vourcher");
        btnvoucher1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnvoucher1MouseClicked(evt);
            }
        });
        btnvoucher1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnvoucher1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnsp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnnv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnhd, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnvoucher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnexit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnkh, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(tbnbanhang1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tbnbanhang, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(btnvoucher1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(jSeparator1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(tbnbanhang, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tbnbanhang1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnsp, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnkh, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnnv, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnhd, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnvoucher1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(btnvoucher, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnexit, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnmain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpnmain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbnbanhangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnbanhangActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_tbnbanhangActionPerformed

    private void btnvoucherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvoucherActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnvoucherActionPerformed

    private void btnexitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexitActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnexitActionPerformed

    private void btnspActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnspActionPerformed

        
//        ViewSanPham s = new ViewSanPham();
//        s.setVisible(true);
    }//GEN-LAST:event_btnspActionPerformed

    private void btnspMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnspMouseClicked

        new ViewSanPham().setVisible(true);
    }//GEN-LAST:event_btnspMouseClicked

    private void btnexitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnexitMouseClicked
        // TODO add your handling code here:
        System.exit(0);
        
        
    }//GEN-LAST:event_btnexitMouseClicked

    private void btnkhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnkhMouseClicked
        // TODO add your handling code here:
         new ViewKhachHang().setVisible(true);
    }//GEN-LAST:event_btnkhMouseClicked

    private void btnnvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnnvMouseClicked
        // TODO add your handling code here:
         new ViewNhanVien().setVisible(true);
    }//GEN-LAST:event_btnnvMouseClicked

    private void btnhdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnhdMouseClicked
        // TODO add your handling code here:
         new ViewHoaDon().setVisible(true);
    }//GEN-LAST:event_btnhdMouseClicked

    private void btnvoucherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnvoucherMouseClicked
        // TODO add your handling code here:
         new ViewVoucher().setVisible(true);
    }//GEN-LAST:event_btnvoucherMouseClicked

    private void tbnbanhangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbnbanhangMouseClicked
        // TODO add your handling code here:
         new ViewBanHang().setVisible(true);
    }//GEN-LAST:event_tbnbanhangMouseClicked

    private void tbnbanhang1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbnbanhang1MouseClicked
        // TODO add your handling code here:
        new ViewThongKe().setVisible(true);
    }//GEN-LAST:event_tbnbanhang1MouseClicked

    private void tbnbanhang1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tbnbanhang1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tbnbanhang1ActionPerformed

    private void btnvoucher1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnvoucher1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnvoucher1MouseClicked

    private void btnvoucher1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnvoucher1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnvoucher1ActionPerformed

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
            java.util.logging.Logger.getLogger(ViewTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewTrangChu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewTrangChu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnexit;
    private javax.swing.JButton btnhd;
    private javax.swing.JButton btnkh;
    private javax.swing.JButton btnnv;
    private javax.swing.JButton btnsp;
    private javax.swing.JButton btnvoucher;
    private javax.swing.JButton btnvoucher1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jpnmain;
    private javax.swing.JButton tbnbanhang;
    private javax.swing.JButton tbnbanhang1;
    // End of variables declaration//GEN-END:variables
}
