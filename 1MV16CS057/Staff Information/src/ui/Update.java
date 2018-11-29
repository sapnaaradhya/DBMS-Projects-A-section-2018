/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import staff.information.SQLDAO;

/**
 *
 * @author Nasir Basha K
 */
public class Update extends javax.swing.JFrame {

    /**
     * Creates new form Update
     */
    String tableName;
    String key;
    Timer t = null;
    int n;
    String primaryKey;

    public Update() {
        initComponents();

        this.setLocationRelativeTo(this);

        isEnabled(false);

    }

    public Update(String tableName, String key) {
        initComponents();
        this.tableName = tableName;
        this.key = key;

        JLblName.setText(tableName.toUpperCase());

        this.setLocationRelativeTo(this);

        isEnabled(false);

        fetchTheRow();

    }

    private void fetchTheRow() {

        try {
            // get the selected row and display on selected table

            SQLDAO obj = new SQLDAO();
            //5 ,8,10

            n = obj.getCountOf(tableName);

            ResultSet rs1 = obj.getTheDescriptionOf(tableName);
            // if (rs1.next()) {

            //       System.out.println(rs1.getString(1));
            //while (rs1.next()) {
            //  System.out.println(rs1.getString(1));
            // }
            //}
            int count = 0;
            while (count != n) {
                count++;
                rs1.next();
                switch (count) {
                    case 1: {
                        JLbl1.setText(primaryKey=rs1.getString(1));
                    }
                    break;
                    case 2: {
                        JLbl2.setText(rs1.getString(1));
                    }
                    break;
                    case 3: {
                        JLbl3.setText(rs1.getString(1));
                    }
                    break;
                    case 4: {
                        JLbl4.setText(rs1.getString(1));
                    }
                    break;
                    case 5: {
                        JLbl5.setText(rs1.getString(1));
                    }
                    break;
                    case 6: {
                        JLbl6.setText(rs1.getString(1));
                    }
                    break;
                    case 7: {
                        JLbl7.setText(rs1.getString(1));
                    }
                    break;
                    case 8: {
                        JLbl8.setText(rs1.getString(1));
                    }
                    break;
                    case 9: {
                        JLbl9.setText(rs1.getString(1));
                    }
                    break;
                    case 10: {
                        JLbl10.setText(rs1.getString(1));
                    }
                    break;
                    default:
                        JOptionPane.showMessageDialog(this, "Invalid switch in while");

                }

            }

            ResultSet rs2 = obj.getSelectedRowFrom(tableName, key);

            if (rs2.next()) {
                for (int i = 1; i <= n; i++) {
                    System.out.println(rs2.getString(i));
                }
                switch (n) {
                    case 5: {
                        JTxt1.setText(rs2.getString(1));
                        JTxt2.setText(rs2.getString(2));
                        JTxt3.setText(rs2.getString(3));
                        JTxt4.setText(rs2.getString(4));
                        JTxt5.setText(rs2.getString(5));

                        t = new Timer(30, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae) {

                                JTxt6.setLocation(JTxt6.getLocation().x + 10, JTxt6.getLocation().y);
                                JTxt7.setLocation(JTxt7.getLocation().x + 10, JTxt7.getLocation().y);
                                JTxt8.setLocation(JTxt8.getLocation().x + 10, JTxt8.getLocation().y);
                                JTxt9.setLocation(JTxt9.getLocation().x + 10, JTxt9.getLocation().y);
                                JTxt10.setLocation(JTxt10.getLocation().x + 10, JTxt10.getLocation().y);
                                if (JTxt10.getLocation().x > getContentPane().getWidth()) {

                                    t.stop();
                                }

                            }
                        });
                        t.start();

                    }
                    break;
                    case 8: {
                        JTxt1.setText(rs2.getString(1));
                        JTxt2.setText(rs2.getString(2));
                        JTxt3.setText(rs2.getString(3));
                        JTxt4.setText(rs2.getString(4));
                        JTxt5.setText(rs2.getString(5));
                        JTxt6.setText(rs2.getString(6));
                        JTxt7.setText(rs2.getString(7));
                        JTxt8.setText(rs2.getString(8));

                        t = new Timer(30, new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent ae) {

                                JTxt9.setLocation(JTxt9.getLocation().x + 10, JTxt9.getLocation().y);
                                JTxt10.setLocation(JTxt10.getLocation().x + 10, JTxt10.getLocation().y);
                                if (JTxt10.getLocation().x > getContentPane().getWidth()) {

                                    t.stop();
                                }

                            }
                        });
                        t.start();

                    }
                    break;
                    case 10: {
                        JTxt1.setText(rs2.getString(1));
                        JTxt2.setText(rs2.getString(2));
                        JTxt3.setText(rs2.getString(3));
                        JTxt4.setText(rs2.getString(4));
                        JTxt5.setText(rs2.getString(5));
                        JTxt6.setText(rs2.getString(6));
                        JTxt7.setText(rs2.getString(7));
                        JTxt8.setText(rs2.getString(8));
                        JTxt9.setText(rs2.getString(9));
                        JTxt10.setText(rs2.getString(10));

                    }
                    break;
                    default:
                        JOptionPane.showMessageDialog(this, "Invalid switch case");

                }

            } else {
                JOptionPane.showMessageDialog(this, "Empty ResultSet");
            }

        } catch (SQLException ex) {
            Logger.getLogger(AdminUpdate.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void isEnabled(boolean b) {

        JTxt1.setEnabled(b);
        JTxt2.setEnabled(b);
        JTxt3.setEnabled(b);
        JTxt4.setEnabled(b);
        JTxt5.setEnabled(b);
        JTxt6.setEnabled(b);
        JTxt7.setEnabled(b);
        JTxt8.setEnabled(b);
        JTxt9.setEnabled(b);
        JTxt10.setEnabled(b);

        JBtnUpdate.setEnabled(b);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        JLblName = new javax.swing.JLabel();
        JLbl2 = new javax.swing.JLabel();
        JLbl1 = new javax.swing.JLabel();
        JLbl9 = new javax.swing.JLabel();
        JLbl10 = new javax.swing.JLabel();
        JLbl3 = new javax.swing.JLabel();
        JLbl4 = new javax.swing.JLabel();
        JLbl5 = new javax.swing.JLabel();
        JLbl6 = new javax.swing.JLabel();
        JLbl7 = new javax.swing.JLabel();
        JLbl8 = new javax.swing.JLabel();
        JTxt2 = new javax.swing.JTextField();
        JTxt3 = new javax.swing.JTextField();
        JTxt1 = new javax.swing.JTextField();
        JTxt5 = new javax.swing.JTextField();
        JTxt4 = new javax.swing.JTextField();
        JTxt10 = new javax.swing.JTextField();
        JTxt6 = new javax.swing.JTextField();
        JTxt7 = new javax.swing.JTextField();
        JTxt8 = new javax.swing.JTextField();
        JTxt9 = new javax.swing.JTextField();
        JBtnUpdate = new java.awt.Button();
        button2 = new java.awt.Button();
        button3 = new java.awt.Button();

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(45, 65, 85));

        JLblName.setFont(new java.awt.Font("Tahoma", 2, 16)); // NOI18N
        JLblName.setForeground(new java.awt.Color(255, 255, 255));
        JLblName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLblName.setText("jLabel1");

        JLbl2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        JLbl2.setForeground(new java.awt.Color(255, 255, 255));

        JLbl1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        JLbl1.setForeground(new java.awt.Color(255, 255, 255));

        JLbl9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        JLbl9.setForeground(new java.awt.Color(255, 255, 255));

        JLbl10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        JLbl10.setForeground(new java.awt.Color(255, 255, 255));

        JLbl3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        JLbl3.setForeground(new java.awt.Color(255, 255, 255));

        JLbl4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        JLbl4.setForeground(new java.awt.Color(255, 255, 255));

        JLbl5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        JLbl5.setForeground(new java.awt.Color(255, 255, 255));

        JLbl6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        JLbl6.setForeground(new java.awt.Color(255, 255, 255));

        JLbl7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        JLbl7.setForeground(new java.awt.Color(255, 255, 255));

        JLbl8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        JLbl8.setForeground(new java.awt.Color(255, 255, 255));

        JTxt2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        JTxt2.setDisabledTextColor(new java.awt.Color(45, 65, 85));
        JTxt2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTxt2ActionPerformed(evt);
            }
        });

        JTxt3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        JTxt3.setDisabledTextColor(new java.awt.Color(45, 65, 85));
        JTxt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTxt3ActionPerformed(evt);
            }
        });

        JTxt1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        JTxt1.setDisabledTextColor(new java.awt.Color(45, 65, 85));

        JTxt5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        JTxt5.setDisabledTextColor(new java.awt.Color(45, 65, 85));

        JTxt4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        JTxt4.setDisabledTextColor(new java.awt.Color(45, 65, 85));
        JTxt4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTxt4ActionPerformed(evt);
            }
        });

        JTxt10.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        JTxt10.setDisabledTextColor(new java.awt.Color(45, 65, 85));

        JTxt6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        JTxt6.setDisabledTextColor(new java.awt.Color(45, 65, 85));

        JTxt7.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        JTxt7.setDisabledTextColor(new java.awt.Color(45, 65, 85));
        JTxt7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTxt7ActionPerformed(evt);
            }
        });

        JTxt8.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        JTxt8.setDisabledTextColor(new java.awt.Color(45, 65, 85));
        JTxt8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTxt8ActionPerformed(evt);
            }
        });

        JTxt9.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        JTxt9.setDisabledTextColor(new java.awt.Color(45, 65, 85));
        JTxt9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTxt9ActionPerformed(evt);
            }
        });

        JBtnUpdate.setLabel("UPDATE");
        JBtnUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBtnUpdateActionPerformed(evt);
            }
        });

        button2.setLabel("EDIT");
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        button3.setLabel("CANCEL");
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(456, 456, 456)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(JLbl3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLbl2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLbl4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLbl5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLbl6, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLbl7, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLbl8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLbl9, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLbl10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(JLbl1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(546, 546, 546)
                                .addComponent(JLblName, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(JTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTxt5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTxt4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTxt10, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTxt6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTxt7, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTxt8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTxt9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(474, 474, 474)
                        .addComponent(JBtnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(335, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {JTxt1, JTxt10, JTxt2, JTxt3, JTxt4, JTxt5, JTxt6, JTxt7, JTxt8, JTxt9});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(JTxt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(JTxt2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(JTxt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(JLblName, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JLbl1)
                        .addGap(18, 18, 18)
                        .addComponent(JLbl2)
                        .addGap(18, 18, 18)
                        .addComponent(JLbl3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JLbl4)
                    .addComponent(JTxt4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JLbl5)
                    .addComponent(JTxt5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JLbl6)
                    .addComponent(JTxt6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JLbl7)
                    .addComponent(JTxt7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(JLbl8)
                    .addComponent(JTxt8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JLbl9)
                        .addGap(18, 18, 18)
                        .addComponent(JLbl10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(JTxt9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JTxt10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JBtnUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JTxt4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTxt4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTxt4ActionPerformed

    private void JTxt7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTxt7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTxt7ActionPerformed

    private void JTxt8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTxt8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTxt8ActionPerformed

    private void JTxt9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTxt9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTxt9ActionPerformed

    private void JTxt2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTxt2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTxt2ActionPerformed

    private void JTxt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTxt3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTxt3ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed

        isEnabled(true);


    }//GEN-LAST:event_button2ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed

        try {
            new AdminUpdate().setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_button3ActionPerformed

    private void JBtnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBtnUpdateActionPerformed

        try {
            //get the data from text fields and update into table
            switch (n) {
                case 5:  {
                    try {
                        SQLDAO obj = new SQLDAO();
                        
                        int num = obj.updateTheTable(tableName,primaryKey,key,
                                JTxt2.getText(),
                                JTxt3.getText(),
                                JTxt4.getText(),
                                JTxt5.getText());
                        if(num ==1){
                            JOptionPane.showMessageDialog(this, num+" rows got Updated Successfully");
                        }else{
                            JOptionPane.showMessageDialog(this, "Updation Failed");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                break;
                case 8: {
                    
                    try {
                        SQLDAO obj = new SQLDAO();
                        
                        int num = obj.updateTheTable(tableName,primaryKey,key,
                                JTxt2.getText(),
                                JTxt3.getText(),
                                JTxt4.getText(),
                                JTxt5.getText(),
                                JTxt6.getText(),
                                JTxt7.getText(),
                                JTxt8.getText());
                        if(num ==1){
                            JOptionPane.showMessageDialog(this, num+" rows got Updated Successfully");
                        }else{
                            JOptionPane.showMessageDialog(this, "Updation Failed");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                    
                    
                }
                break;
                case 10: {
                    
                    try {
                        SQLDAO obj = new SQLDAO();
                        
                        int num = obj.updateTheTable(tableName,primaryKey,key,
                                JTxt2.getText(),
                                JTxt3.getText(),
                                JTxt4.getText(),
                                JTxt5.getText(),
                                JTxt6.getText(),
                                JTxt7.getText(),
                                JTxt8.getText(),
                                JTxt9.getText(),
                                JTxt10.getText());
                        if(num ==1){
                            JOptionPane.showMessageDialog(this, num+" rows got Updated Successfully");
                        }else{
                            JOptionPane.showMessageDialog(this, "Updation Failed");
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    
                    
                }
                break;
                default:
                    JOptionPane.showMessageDialog(this, "Invalid switch entry in update");
                    
            }
            
            new AdminUpdate().setVisible(true);
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_JBtnUpdateActionPerformed

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
            java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Update.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Update().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button JBtnUpdate;
    private javax.swing.JLabel JLbl1;
    private javax.swing.JLabel JLbl10;
    private javax.swing.JLabel JLbl2;
    private javax.swing.JLabel JLbl3;
    private javax.swing.JLabel JLbl4;
    private javax.swing.JLabel JLbl5;
    private javax.swing.JLabel JLbl6;
    private javax.swing.JLabel JLbl7;
    private javax.swing.JLabel JLbl8;
    private javax.swing.JLabel JLbl9;
    private javax.swing.JLabel JLblName;
    private javax.swing.JTextField JTxt1;
    private javax.swing.JTextField JTxt10;
    private javax.swing.JTextField JTxt2;
    private javax.swing.JTextField JTxt3;
    private javax.swing.JTextField JTxt4;
    private javax.swing.JTextField JTxt5;
    private javax.swing.JTextField JTxt6;
    private javax.swing.JTextField JTxt7;
    private javax.swing.JTextField JTxt8;
    private javax.swing.JTextField JTxt9;
    private java.awt.Button button2;
    private java.awt.Button button3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
