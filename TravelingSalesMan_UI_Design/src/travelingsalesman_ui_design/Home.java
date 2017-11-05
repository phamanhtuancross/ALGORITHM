/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package travelingsalesman_ui_design;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Home extends javax.swing.JFrame {

    //variables prototype
    private int[][] map = null;
    private int SIZE_OF_MAP;
    private int path[] = null;
    private String NAME_FILE_INPUT = null;
    private boolean canDrawPoint = false;
    private boolean canDrawLine = false;
    private boolean[][] IsDraw = null;
    private int count = 0;
    private ArrayList<Point> arrayListPoint = new ArrayList<>();
    private Color[] list_colors = {Color.GREEN, Color.pink, Color.cyan, Color.ORANGE, Color.RED};
    private TravelingSalesMan travelingSalesMan = new TravelingSalesMan();

    //-----------------------end of variables prototypes------------------------
    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
        //this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Initialization();
        this.DrawMaps();
        //travelingSalesMan.ExportPath();
        //this.setUndecorated(true);
    }
    //--------------------------------end of function---------------------------

    public void Initialization() {
        this.SIZE_OF_MAP = travelingSalesMan.getSIZE_OF_MAP();
        this.path = travelingSalesMan.getPath();
        this.map = travelingSalesMan.getMap();
        this.IsDraw = new boolean[this.SIZE_OF_MAP][this.SIZE_OF_MAP];

        for (int i = 0; i < this.SIZE_OF_MAP; i++) {
            for (int j = 0; j < this.SIZE_OF_MAP; j++) {
                this.IsDraw[i][j] = false;
            }
        }
    }

    public void DrawMaps() {
        this.pnl_maps.setLayout(new GridLayout(travelingSalesMan.getSIZE_OF_MAP(), travelingSalesMan.getSIZE_OF_MAP()));
        for (int i = 0; i < travelingSalesMan.getSIZE_OF_MAP(); i++) {
            for (int j = 0; j < travelingSalesMan.getSIZE_OF_MAP(); j++) {
                JButton temp = new JButton(travelingSalesMan.getMap()[i][j] + "");
                temp.setOpaque(true);
                temp.setBorderPainted(false);
                if (travelingSalesMan.getMap()[i][j] != 0) {
                    int index = new Random().nextInt(this.list_colors.length);
                    temp.setBackground(this.list_colors[index]);
                } else {
                    temp.setBackground(Color.gray);
                }
                this.pnl_maps.add(temp);

            }
        }
    }

    //--------------------------------end o function----------------------------
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_paint = new javax.swing.JPanel();
        pnl_paintMap = new javax.swing.JPanel();
        pnl_maps = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btn_drawPoin = new javax.swing.JButton();
        btn_drawLine = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_paint.setBackground(new java.awt.Color(51, 255, 204));
        pnl_paint.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnl_paintMap.setBackground(new java.awt.Color(0, 0, 0));
        pnl_paintMap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnl_paintMapMouseClicked(evt);
            }
        });
        pnl_paintMap.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnl_paint.add(pnl_paintMap, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, 340, 460));

        pnl_maps.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout pnl_mapsLayout = new javax.swing.GroupLayout(pnl_maps);
        pnl_maps.setLayout(pnl_mapsLayout);
        pnl_mapsLayout.setHorizontalGroup(
            pnl_mapsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        pnl_mapsLayout.setVerticalGroup(
            pnl_mapsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );

        pnl_paint.add(pnl_maps, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 210, 210));

        jButton2.setBackground(new java.awt.Color(51, 51, 51));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/travelingsalesman_ui_design/icons8_Rotate_Left_25px.png"))); // NOI18N
        jButton2.setText("UNDO PREVIOUS STEP");
        jButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton2.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        pnl_paint.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 210, 40));

        jLabel3.setBackground(new java.awt.Color(204, 0, 0));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("MAP");
        jLabel3.setOpaque(true);
        pnl_paint.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 210, 30));

        btn_drawPoin.setBackground(new java.awt.Color(51, 51, 51));
        btn_drawPoin.setForeground(new java.awt.Color(255, 255, 255));
        btn_drawPoin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/travelingsalesman_ui_design/icons8_Geo-fence_25px_1.png"))); // NOI18N
        btn_drawPoin.setText("DRAW  POINT");
        btn_drawPoin.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_drawPoin.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_drawPoin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_drawPoinActionPerformed(evt);
            }
        });
        pnl_paint.add(btn_drawPoin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 210, 40));

        btn_drawLine.setBackground(new java.awt.Color(51, 51, 51));
        btn_drawLine.setForeground(new java.awt.Color(255, 255, 255));
        btn_drawLine.setIcon(new javax.swing.ImageIcon(getClass().getResource("/travelingsalesman_ui_design/icons8_Design_25px_1.png"))); // NOI18N
        btn_drawLine.setText("DRAW LINE");
        btn_drawLine.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btn_drawLine.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        btn_drawLine.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_drawLineActionPerformed(evt);
            }
        });
        pnl_paint.add(btn_drawLine, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 210, 40));

        jButton5.setBackground(new java.awt.Color(51, 51, 51));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/travelingsalesman_ui_design/icons8_Delete_25px_1.png"))); // NOI18N
        jButton5.setText("CLEAR ALL");
        jButton5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton5.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        pnl_paint.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 210, 40));

        jButton6.setText("jButton2");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        pnl_paint.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 170, 40));

        getContentPane().add(pnl_paint, new org.netbeans.lib.awtextra.AbsoluteConstraints(-30, 0, 580, 460));

        jPanel1.setBackground(new java.awt.Color(36, 46, 68));

        jPanel2.setBackground(new java.awt.Color(36, 46, 68));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/travelingsalesman_ui_design/icons8_Facebook_25px.png"))); // NOI18N
        jLabel4.setText("facebook");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 420, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/travelingsalesman_ui_design/icons8_Gmail_25px.png"))); // NOI18N
        jLabel5.setText("gmail");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, -1, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/travelingsalesman_ui_design/icons8_Instagram_25px.png"))); // NOI18N
        jLabel6.setText("Instagram");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 420, -1, -1));

        jSeparator2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, 260, 10));

        jButton1.setBackground(new java.awt.Color(0, 204, 204));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("SEARCH PATH");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 360, 190, 40));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/travelingsalesman_ui_design/icons8_Male_User_100px_1.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 260, -1));

        jPanel3.setBackground(new java.awt.Color(51, 51, 51));
        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/travelingsalesman_ui_design/icons8_Joomla_25px.png"))); // NOI18N
        jLabel7.setText("VIEW PROCESS OF PATH STEP BY STEP");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 256, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, -1, -1));

        jPanel6.setBackground(new java.awt.Color(51, 51, 51));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/travelingsalesman_ui_design/icons8_Rubik's_Cube_25px.png"))); // NOI18N
        jLabel8.setText("IMPORT MAPS FOR THIS PROBLEMS");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 256, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, -1, -1));

        jPanel7.setBackground(new java.awt.Color(51, 51, 51));
        jPanel7.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/travelingsalesman_ui_design/icons8_Detective_25px_1.png"))); // NOI18N
        jLabel9.setText("PREVIEW DEMO TRAVELING SALESMAN");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 256, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 256, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 46, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 46, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, -1, -1));

        jLabel2.setFont(new java.awt.Font("Goudy Old Style", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 102, 102));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("TRAVELING SALESMAN");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 260, 30));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 260, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btn_drawPoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_drawPoinActionPerformed
        // TODO add your handling code here:
        this.canDrawLine = false;
        this.canDrawPoint = true;
    }//GEN-LAST:event_btn_drawPoinActionPerformed

    private void btn_drawLineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_drawLineActionPerformed
        // TODO add your handling code here:
        this.canDrawLine = true;
        this.canDrawPoint = false;
        if (arrayListPoint.size() == this.SIZE_OF_MAP) {
            Graphics g = this.pnl_paintMap.getGraphics();
            Graphics2D g2d = (Graphics2D) g;
            for (int i = 0; i < this.arrayListPoint.size(); i++) {
                for (int j = 0; j < this.arrayListPoint.size(); j++) {
                    if (map[i][j] != 0 && this.IsDraw[i][j] == false) {
                        try {
                            this.IsDraw[i][j] = this.IsDraw[j][i] = false;
                            Thread.sleep(400);
                            g2d.setColor(Color.white);
                            g2d.drawLine(this.arrayListPoint.get(i).x, this.arrayListPoint.get(i).y,
                                    this.arrayListPoint.get(j).x, this.arrayListPoint.get(j).y);

                            g2d.setColor(Color.red);
                            int midleX = (this.arrayListPoint.get(i).x + this.arrayListPoint.get(j).x) / 2;
                            int midleY = (this.arrayListPoint.get(i).y + this.arrayListPoint.get(j).y) / 2;
                            g2d.drawString(this.map[i][j] + " ", midleX, midleY);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            }
        }
    }//GEN-LAST:event_btn_drawLineActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void pnl_paintMapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnl_paintMapMouseClicked
        // TODO add your handling code here:
        if (this.canDrawPoint == true) {
            int x = evt.getX();
            int y = evt.getY();
            // JOptionPane.showMessageDialog(rootPane, x + "," + y);
            Graphics g = this.pnl_paintMap.getGraphics();
            Graphics2D g2d = (Graphics2D) g;
            g.setColor(Color.WHITE);
            //g2d.fillOval(x, y, 10, 10);
            g2d.setFont(new Font("TimesRoman", Font.PLAIN, 25));
            g2d.drawString(++count + " ", x, y);
            this.arrayListPoint.add(new Point(x, y));
        }
    }//GEN-LAST:event_pnl_paintMapMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (this.SIZE_OF_MAP == this.arrayListPoint.size()) {

            int[] path = travelingSalesMan.getBest_way();
            for (int i = this.SIZE_OF_MAP - 1; i >= 0; i--) {
                System.out.println(path[i]);
            }
            Graphics g = this.pnl_paintMap.getGraphics();
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.yellow);
            g2d.drawLine(this.arrayListPoint.get(0).x, this.arrayListPoint.get(0).y, this.arrayListPoint.get(path[this.SIZE_OF_MAP - 1]).x, this.arrayListPoint.get(path[this.SIZE_OF_MAP - 1]).y);
            for (int i = this.SIZE_OF_MAP - 2; i >= 0; i--) {
                g2d.drawLine(this.arrayListPoint.get(path[i + 1]).x, this.arrayListPoint.get(path[i + 1]).y, this.arrayListPoint.get(path[i]).x, this.arrayListPoint.get(path[i]).y);
            }
        }

    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_drawLine;
    private javax.swing.JButton btn_drawPoin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel pnl_maps;
    private javax.swing.JPanel pnl_paint;
    private javax.swing.JPanel pnl_paintMap;
    // End of variables declaration//GEN-END:variables
}
