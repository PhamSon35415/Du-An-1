/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controler.ChuyenManHinhControler;
import bean.DanhMucBean;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author nongt
 */
public class MainJFrame extends javax.swing.JFrame {

    public MainJFrame() {
        initComponents();
        jpnMenu.setBackground(new Color(76, 175, 80));
        jpnTrangChu.setBackground(new Color(76, 175, 80));
        jpnNuocHoa.setBackground(new Color(76, 175, 80));
        jpnBanHang.setBackground(new Color(76, 175, 80));
        jpnNhanVien.setBackground(new Color(76, 175, 80));
        jpnKhachHang.setBackground(new Color(76, 175, 80));
        jpnHoaDon.setBackground(new Color(76, 175, 80));
        jpnexit.setBackground(new Color(76, 175, 80));

        setTitle("Quan Ly Nuoc Hoa");
        ChuyenManHinhControler controller = new ChuyenManHinhControler(jpnView);
        controller.setView(jpnTrangChu, jlbTrangChu);
        List<DanhMucBean> listItem = new ArrayList<>();
        listItem.add(new DanhMucBean("Trang Chu", jpnTrangChu, jlbTrangChu));
        listItem.add(new DanhMucBean("NuocHoa", jpnNuocHoa, jlbNuocHoa));
        listItem.add(new DanhMucBean("BanHang", jpnBanHang, jlbBanHang));
        listItem.add(new DanhMucBean("NhanVien", jpnNhanVien, jlbNhanVien));
        listItem.add(new DanhMucBean("KhachHang", jpnKhachHang, jlbKhachHang));
        listItem.add(new DanhMucBean("HoaDon", jpnHoaDon, jlbHoaDon));
        listItem.add(new DanhMucBean("Exit", jpnexit, jLabel7));

        setLocationRelativeTo(null);
        controller.setEvent(listItem);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnRoot = new javax.swing.JPanel();
        jpnMenu = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jpnTrangChu = new javax.swing.JPanel();
        jlbTrangChu = new javax.swing.JLabel();
        jpnNuocHoa = new javax.swing.JPanel();
        jlbNuocHoa = new javax.swing.JLabel();
        jpnBanHang = new javax.swing.JPanel();
        jlbBanHang = new javax.swing.JLabel();
        jpnNhanVien = new javax.swing.JPanel();
        jlbNhanVien = new javax.swing.JLabel();
        jpnKhachHang = new javax.swing.JPanel();
        jlbKhachHang = new javax.swing.JLabel();
        jpnexit = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jpnHoaDon = new javax.swing.JPanel();
        jlbHoaDon = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jpnView = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnRoot.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jpnMenu.setBackground(new java.awt.Color(255, 255, 255));
        jpnMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(255, 51, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jpnMenu.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, -1));

        jpnTrangChu.setBackground(new java.awt.Color(102, 153, 255));
        jpnTrangChu.setAlignmentX(1.0F);
        jpnTrangChu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jlbTrangChu.setBackground(new java.awt.Color(255, 170, 89));
        jlbTrangChu.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlbTrangChu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbTrangChu.setText("Trang Chủ");
        jlbTrangChu.setToolTipText("hủ");
        jpnTrangChu.add(jlbTrangChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 50));

        jpnMenu.add(jpnTrangChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 240, 50));

        jpnNuocHoa.setBackground(new java.awt.Color(102, 153, 255));
        jpnNuocHoa.setToolTipText("");

        jlbNuocHoa.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlbNuocHoa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbNuocHoa.setText("Sản Phẩm");

        javax.swing.GroupLayout jpnNuocHoaLayout = new javax.swing.GroupLayout(jpnNuocHoa);
        jpnNuocHoa.setLayout(jpnNuocHoaLayout);
        jpnNuocHoaLayout.setHorizontalGroup(
            jpnNuocHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnNuocHoaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlbNuocHoa, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnNuocHoaLayout.setVerticalGroup(
            jpnNuocHoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnNuocHoaLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlbNuocHoa, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jpnMenu.add(jpnNuocHoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 240, 50));

        jpnBanHang.setBackground(new java.awt.Color(102, 153, 255));

        jlbBanHang.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlbBanHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbBanHang.setText("Bán Hàng");

        javax.swing.GroupLayout jpnBanHangLayout = new javax.swing.GroupLayout(jpnBanHang);
        jpnBanHang.setLayout(jpnBanHangLayout);
        jpnBanHangLayout.setHorizontalGroup(
            jpnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnBanHangLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlbBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jpnBanHangLayout.setVerticalGroup(
            jpnBanHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnBanHangLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlbBanHang, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jpnMenu.add(jpnBanHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 260, 240, 50));

        jpnNhanVien.setBackground(new java.awt.Color(102, 153, 255));

        jlbNhanVien.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlbNhanVien.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbNhanVien.setText("Nhân Viên");

        javax.swing.GroupLayout jpnNhanVienLayout = new javax.swing.GroupLayout(jpnNhanVien);
        jpnNhanVien.setLayout(jpnNhanVienLayout);
        jpnNhanVienLayout.setHorizontalGroup(
            jpnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbNhanVien, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );
        jpnNhanVienLayout.setVerticalGroup(
            jpnNhanVienLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnNhanVienLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jpnMenu.add(jpnNhanVien, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 240, 50));

        jpnKhachHang.setBackground(new java.awt.Color(102, 153, 255));

        jlbKhachHang.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlbKhachHang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbKhachHang.setText("Khách Hàng");

        javax.swing.GroupLayout jpnKhachHangLayout = new javax.swing.GroupLayout(jpnKhachHang);
        jpnKhachHang.setLayout(jpnKhachHangLayout);
        jpnKhachHangLayout.setHorizontalGroup(
            jpnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnKhachHangLayout.createSequentialGroup()
                .addComponent(jlbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jpnKhachHangLayout.setVerticalGroup(
            jpnKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpnKhachHangLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jlbKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jpnMenu.add(jpnKhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 380, 240, 50));

        jpnexit.setBackground(new java.awt.Color(102, 153, 255));
        jpnexit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jpnexitMouseClicked(evt);
            }
        });

        jLabel7.setText("Exit");

        javax.swing.GroupLayout jpnexitLayout = new javax.swing.GroupLayout(jpnexit);
        jpnexit.setLayout(jpnexitLayout);
        jpnexitLayout.setHorizontalGroup(
            jpnexitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnexitLayout.createSequentialGroup()
                .addGap(107, 107, 107)
                .addComponent(jLabel7)
                .addContainerGap(114, Short.MAX_VALUE))
        );
        jpnexitLayout.setVerticalGroup(
            jpnexitLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnexitLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel7)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jpnMenu.add(jpnexit, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 660, 240, 50));

        jlbHoaDon.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jlbHoaDon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbHoaDon.setText("Hóa Đơn");
        jlbHoaDon.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jlbHoaDon.setFocusable(false);
        jlbHoaDon.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        javax.swing.GroupLayout jpnHoaDonLayout = new javax.swing.GroupLayout(jpnHoaDon);
        jpnHoaDon.setLayout(jpnHoaDonLayout);
        jpnHoaDonLayout.setHorizontalGroup(
            jpnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbHoaDon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 240, Short.MAX_VALUE)
        );
        jpnHoaDonLayout.setVerticalGroup(
            jpnHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnHoaDonLayout.createSequentialGroup()
                .addComponent(jlbHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 1, Short.MAX_VALUE))
        );

        jpnMenu.add(jpnHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 240, 40));
        jpnHoaDon.getAccessibleContext().setAccessibleName("");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/icons8-user-100.png"))); // NOI18N
        jpnMenu.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, -1, -1));

        javax.swing.GroupLayout jpnViewLayout = new javax.swing.GroupLayout(jpnView);
        jpnView.setLayout(jpnViewLayout);
        jpnViewLayout.setHorizontalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1438, Short.MAX_VALUE)
        );
        jpnViewLayout.setVerticalGroup(
            jpnViewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 846, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jpnRootLayout = new javax.swing.GroupLayout(jpnRoot);
        jpnRoot.setLayout(jpnRootLayout);
        jpnRootLayout.setHorizontalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jpnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpnView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpnRootLayout.setVerticalGroup(
            jpnRootLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addComponent(jpnMenu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jpnRootLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpnView, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jpnRoot, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jpnRoot, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jpnexitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jpnexitMouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jpnexitMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel jlbBanHang;
    private javax.swing.JLabel jlbHoaDon;
    private javax.swing.JLabel jlbKhachHang;
    private javax.swing.JLabel jlbNhanVien;
    private javax.swing.JLabel jlbNuocHoa;
    private javax.swing.JLabel jlbTrangChu;
    private javax.swing.JPanel jpnBanHang;
    private javax.swing.JPanel jpnHoaDon;
    private javax.swing.JPanel jpnKhachHang;
    private javax.swing.JPanel jpnMenu;
    private javax.swing.JPanel jpnNhanVien;
    private javax.swing.JPanel jpnNuocHoa;
    private javax.swing.JPanel jpnRoot;
    private javax.swing.JPanel jpnTrangChu;
    private javax.swing.JPanel jpnView;
    private javax.swing.JPanel jpnexit;
    // End of variables declaration//GEN-END:variables
}
