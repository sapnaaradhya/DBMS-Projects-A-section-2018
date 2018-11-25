/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Nasir Basha K
 */
public class AnimationWelcome extends javax.swing.JFrame {

    /**
     * Creates new form AnimationWelcome
     */
    Timer tmDown, tmUp, tmDup, tmJoin;
    Random rand = new Random();
    long st, ed;
    boolean skipped = false;

    public AnimationWelcome() {
        initComponents();

        Toolkit tk = Toolkit.getDefaultToolkit();

        this.setSize(tk.getScreenSize().width, tk.getScreenSize().height);
        st = System.currentTimeMillis();
        //displayTimer();
        fullDown();
        //animate(JTxt1);
        //animate(JTxt2);

    }

    private void fullDown() {

//        System.out.println("Full Down");
        tmDown = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Point loc = JTxt2.getLocation();

                JTxt1.setLocation(JTxt1.getLocation().x, JTxt1.getLocation().y + 5);
                JTxt2.setLocation(JTxt2.getLocation().x, JTxt2.getLocation().y + 5);

                if (JTxt2.getLocation().y + 100 > getContentPane().getHeight()) {

                    JTxt1.setLocation(JTxt1.getLocation().x, JTxt1.getLocation().y);
                    JTxt2.setLocation(JTxt2.getLocation().x, JTxt2.getLocation().y);

                    tmDown.stop();

                    //fullUp();
                    divideUp();

                }

            }
        });
        tmDown.start();

    }

    private void fullUp() {

        System.out.println("fullUp");
        tmUp = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                Point locUp = JTxt2.getLocation();

                JTxt1.setLocation(JTxt1.getLocation().x, JTxt1.getLocation().y - 5);
                JTxt2.setLocation(JTxt2.getLocation().x, JTxt2.getLocation().y - 5);

                if (JTxt2.getLocation().y + 200 <= (getContentPane().getHeight()) / 2) {

                    JTxt1.setLocation(JTxt1.getLocation().x, JTxt1.getLocation().y);
                    JTxt2.setLocation(JTxt2.getLocation().x, JTxt2.getLocation().y);
                    tmUp.stop();
                }
            }
        });
        tmUp.start();
    }

    private void divideUp() {

        tmDup = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                JTxt1.setLocation(JTxt1.getLocation().x - 4, JTxt1.getLocation().y - 5);
                JTxt2.setLocation(JTxt2.getLocation().x + 4, JTxt2.getLocation().y - 5);

                if (JTxt2.getLocation().y + 200 <= (getContentPane().getHeight()) / 2) {

                    JTxt1.setLocation(JTxt1.getLocation().x, JTxt1.getLocation().y);
                    JTxt2.setLocation(JTxt2.getLocation().x, JTxt2.getLocation().y);
                    tmDup.stop();

                    joinAndStop();
                }

            }
        });

        tmDup.start();

    }

    private void joinAndStop() {

        tmJoin = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                    
                JTxt1.setLocation(JTxt1.getLocation().x + 2, JTxt1.getLocation().y);
                JTxt2.setLocation(JTxt2.getLocation().x - 2, JTxt2.getLocation().y);

                if (JTxt2.getLocation().x + 50 <= (getContentPane().getWidth()) / 2) {

                    JTxt1.setLocation(JTxt1.getLocation().x, JTxt1.getLocation().y);
                    JTxt2.setLocation(JTxt2.getLocation().x, JTxt2.getLocation().y);
                    tmJoin.stop();
                    if (!skipped) {
                        try {
                            openLogin();
                        } catch (SQLException ex) {
                            Logger.getLogger(AnimationWelcome.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }

            }
        });

        tmJoin.start();

    }

    
    private void openLogin() throws SQLException {
           skipped=true;
        new Login().setVisible(true);
        ed = System.currentTimeMillis();
        System.out.println((ed - st) / 1000);

        dispose();

    }
    int i = 8;
    Timer skip;

    void displayTimer() {

        new Thread(new Runnable() {
            @Override
            public void run() {

                skip = new Timer(100, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {

                        JBtnSkip.setText("SKIP in " + (i--) + " sec");
                        if (i == 0) {
                            JBtnSkip.setText("SKIP");
                            skip.stop();
                        }

                    }
                });
                skip.start();

            }
        }).start();

        /*new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = 8; i >= 0; i++) {

                    JBtnSkip.setText("SKIP in " + i + " sec");
                    if (i != 0) {

                    }
                }

            }
        }).start();
         */
    }

    private void animate(javax.swing.JLabel j) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                new Timer(50, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {

                        //if (!stop) {
                        j.setLocation(j.getX() + rand.nextInt(5) - 2, j.getY() + rand.nextInt(5) - 2);
                        j.setAlignmentY(TOP_ALIGNMENT);

                        // }
                    }
                }).start();

            }
        }).start();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        JTxt2 = new javax.swing.JLabel();
        JTxt1 = new javax.swing.JLabel();
        JBtnSkip = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(20, 20, 20));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        JTxt2.setBackground(new java.awt.Color(0, 0, 0));
        JTxt2.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        JTxt2.setForeground(new java.awt.Color(0, 0, 255));
        JTxt2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JTxt2.setText("Information");
        JTxt2.addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                JTxt2MouseWheelMoved(evt);
            }
        });
        JTxt2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTxt2MouseClicked(evt);
            }
        });
        jPanel1.add(JTxt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, -1, -1));

        JTxt1.setBackground(new java.awt.Color(0, 0, 0));
        JTxt1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        JTxt1.setForeground(new java.awt.Color(0, 0, 255));
        JTxt1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JTxt1.setText("Staff ");
        JTxt1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                JTxt1MouseDragged(evt);
            }
        });
        JTxt1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                JTxt1MouseClicked(evt);
            }
        });
        jPanel1.add(JTxt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 10, -1, -1));

        JBtnSkip.setBackground(new java.awt.Color(0, 255, 0));
        JBtnSkip.setText("SKIP");
        JBtnSkip.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBtnSkipActionPerformed(evt);
            }
        });
        jPanel1.add(JBtnSkip, new org.netbeans.lib.awtextra.AbsoluteConstraints(1095, 30, 170, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 851, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTxt2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTxt2MouseClicked

        JOptionPane.showMessageDialog(this, "Clicked");

    }//GEN-LAST:event_JTxt2MouseClicked

    private void JTxt1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTxt1MouseClicked

        JOptionPane.showMessageDialog(this, "Clicked");

    }//GEN-LAST:event_JTxt1MouseClicked

    private void JTxt1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JTxt1MouseDragged

        JTxt1.setLocation(getMousePosition(true));

    }//GEN-LAST:event_JTxt1MouseDragged

    private void JTxt2MouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_JTxt2MouseWheelMoved
        // TODO add your handling code here:

    }//GEN-LAST:event_JTxt2MouseWheelMoved

    private void JBtnSkipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBtnSkipActionPerformed

        long st = System.currentTimeMillis();

        try {
            openLogin();
        } catch (SQLException ex) {
            Logger.getLogger(AnimationWelcome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_JBtnSkipActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
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
            java.util.logging.Logger.getLogger(AnimationWelcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AnimationWelcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AnimationWelcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AnimationWelcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AnimationWelcome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBtnSkip;
    private javax.swing.JLabel JTxt1;
    private javax.swing.JLabel JTxt2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
