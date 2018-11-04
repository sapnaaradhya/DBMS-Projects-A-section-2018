/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import staff.information.MailTest;
import staff.information.OTPGeneration;
import staff.information.SQLDAO;

/**
 *
 * @author Nasir Basha K
 */
public class NewUser extends javax.swing.JFrame {

    /**
     * Creates new form NewUser
     */
    Timer tmDown;
    boolean reset = false;
    String uName, email;
    Long phone;
    String category;
    boolean otpSent = false;
    String sentOtp;

    public NewUser() {
        initComponents();
        this.setLocationRelativeTo(null);
        fullDown();
    }

    public NewUser(String category) {

        initComponents();
        this.setLocationRelativeTo(null);
        this.category = category;
        JLblTitle.setText(category);
        JOptionPane.showMessageDialog(null, category);
        fullDown();

    }

    public NewUser(String category, String uName, Long phone, boolean reset) throws SQLException {
        initComponents();
        this.setLocationRelativeTo(null);
        JLblTitle.setText(category + " Reset");
        this.category = category;
        this.reset = reset;
        this.uName = uName;
        this.phone = phone;

        JOptionPane.showMessageDialog(null, category + " " + reset);
        fullDown();
        updateTheFields();

    }

    public boolean verify(String s1, String s2) {

        return s1.equals(s2);

    }

    private void selectingTablesToUpdate() throws SQLException, Exception {

        SQLDAO obj = new SQLDAO();
        int n = 0;

        switch (category) {
            case "ADMIN":

                n = obj.updateAdmin(JTxtUname.getText(), JPass1.getText());
                if (n == 1) {
                    //updation successful
                    JOptionPane.showMessageDialog(null, "Updation Successful");
                    //leave this page and goto login page
                    new Login().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Updation failed");
                }

                break;
            case "TEACHER":

                n = obj.updateTeacher(JTxtUname.getText(), JPass1.getText());
                if (n == 1) {
                    //updation successful
                    JOptionPane.showMessageDialog(null, "Updation Successful");
                    //leave this page and goto login page
                    new Login().setVisible(true);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Updation failed");
                }

                break;
            default:
                JOptionPane.showMessageDialog(null, "error at the update method");
                break;
        }

    }

    public void selectingTablesToInsert() throws Exception {
        SQLDAO obj = new SQLDAO();
        int n = 0;
        switch (category) {
            case "ADMIN":

                if (obj.checkForUniqueAdmin("email_id", JTxtEmail.getText())) {

                    JOptionPane.showMessageDialog(null, "Email Id already exists");
                    JTxtEmail.setFocusable(true);

                } else if (obj.checkForUniqueAdmin("username", JTxtUname.getText())) {

                    JOptionPane.showMessageDialog(null, "User Name already exists");
                    JTxtUname.setFocusable(true);
                } else if (obj.checkForUniqueAdmin(new Long(JTxtPhone.getText()))) {

                    JOptionPane.showMessageDialog(null, "Phone No. already exists");
                    JTxtPhone.setFocusable(true);

                } else {

                    try {
                        n = obj.insertIntoAdmin(JTxtName.getText(),
                                JTxtDest.getText(),
                                JTxtDob.getText(),
                                Long.valueOf(JTxtPhone.getText()),
                                JTxtEmail.getText(),
                                JTxtUname.getText(),
                                JPass1.getText());
                        if (n == 1) {
                            JOptionPane.showMessageDialog(null, n + "rows updated");
                            new Login().setVisible(true);
                            this.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Data not entered successfully");
                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(NewUser.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
            case "TEACHER":

                if (obj.checkForUniqueTeacher("email_id", JTxtEmail.getText())) {

                    JOptionPane.showMessageDialog(null, "Email Id already exists");
                    JTxtEmail.setFocusable(true);

                } else if (obj.checkForUniqueTeacher("username", JTxtUname.getText())) {

                    JOptionPane.showMessageDialog(null, "User Name already exists");
                    JTxtUname.setFocusable(true);
                } else if (obj.checkForUniqueTeacher(new Long(JTxtPhone.getText()))) {

                    JOptionPane.showMessageDialog(null, "Phone No. already exists");
                    JTxtPhone.setFocusable(true);

                } else {

                    try {

                        n = obj.insertIntoTeacher(JTxtName.getText(),
                                JTxtDest.getText(),
                                JTxtDob.getText(),
                                Long.valueOf(JTxtPhone.getText()),
                                JTxtEmail.getText(),
                                JTxtUname.getText(),
                                JPass1.getText());
                        if (n == 1) {
                            JOptionPane.showMessageDialog(null, n + "rows updated");
                            new Login().setVisible(true);
                            this.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "Data not entered successfully");
                        }

                    } catch (SQLException ex) {
                        Logger.getLogger(NewUser.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

                break;
            default:
                JOptionPane.showMessageDialog(null, "error at the insert method");
                break;
        }

    }

    public void updateTheFields() throws SQLException {
        System.out.println("updateTheFields");
        SQLDAO obj = new SQLDAO();

        ResultSet rs = null;

        if (category.equals("ADMIN")) {
            // JOptionPane.showMessageDialog(null, category+" "+reset);
            System.out.println("ADMIN table");
            rs = obj.checkForResetAdmin(uName, phone);
            System.out.println(uName + " " + phone);

        } else if (category.equals("TEACHER")) {
            //JOptionPane.showMessageDialog(null, category+" "+reset);
            System.out.println("TEACHER table");
            rs = obj.checkForResetTeacher(uName, phone);
            System.out.println(uName + " " + phone);

        } else {
            JOptionPane.showMessageDialog(null, "error");
        }

        if (rs.next()) {
            System.out.println("Records found");
            //System.out.println(rs.getString(2)+rs.getString(3)+rs.getDate(4)+rs.getInt(5)+rs.getString(6)+rs.getString(7)+rs.getString(8));

            JTxtName.setText(rs.getString(2));
            JTxtName.setEditable(false);
            JTxtName.setBackground(Color.white);

            JTxtDest.setText(rs.getString(3));
            JTxtDest.setEditable(false);
            JTxtDest.setBackground(Color.white);

            JTxtDob.setText(rs.getDate(4).toString());
            JTxtDob.setEditable(false);
            JTxtDob.setBackground(Color.white);

            JTxtPhone.setText(rs.getLong(5) + "");
            JTxtPhone.setEditable(false);
            JTxtPhone.setBackground(Color.white);

            JTxtEmail.setText(rs.getString(6));
            this.email = rs.getString(6);
            System.out.println(email);
            JTxtEmail.setEditable(false);
            JTxtEmail.setBackground(Color.white);

            JTxtUname.setText(rs.getString(7));
            JTxtUname.setEditable(false);
            JTxtUname.setBackground(Color.white);

            while (rs.next()) {
                System.out.println(rs.getString(2) + rs.getString(3) + rs.getDate(4) + rs.getInt(5) + rs.getString(6) + rs.getString(7) + rs.getString(8));
            }
        } else {
            System.out.println("Records not found");
        }

    }

    private void fullDown() {

        System.out.println("Full Down");
        tmDown = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                JP4.setLocation(JP4.getLocation().x, JP4.getLocation().y + 5);
                // JTxt2.setLocation(JTxt2.getLocation().x, JTxt2.getLocation().y + 5);

                if (JP4.getLocation().y + 10 > getContentPane().getHeight()) {

                    JP4.setLocation(JP4.getLocation().x, JP4.getLocation().y);
                    // JTxt2.setLocation(JTxt2.getLocation().x, JTxt2.getLocation().y);

                    tmDown.stop();

                    //fullUp();
                    //divideUp();
                }

            }
        });
        tmDown.start();

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
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        JLblTitle = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        JTxtDest = new javax.swing.JTextField();
        JTxtName = new javax.swing.JTextField();
        JTxtPhone = new javax.swing.JTextField();
        JTxtDob = new javax.swing.JTextField();
        JTxtUname = new javax.swing.JTextField();
        JTxtEmail = new javax.swing.JTextField();
        JPass2 = new javax.swing.JPasswordField();
        JPass1 = new javax.swing.JPasswordField();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        JTxtOtp = new javax.swing.JTextField();
        JBtnOtp = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        JP4 = new javax.swing.JPanel();
        JP3 = new javax.swing.JPanel();
        JP2 = new javax.swing.JPanel();
        JP1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(5, 20, 24));

        jPanel2.setBackground(new java.awt.Color(112, 112, 112));

        jPanel4.setBackground(new java.awt.Color(112, 112, 112));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Name");
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 0, 101, 28));

        jLabel4.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Designation");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, 28));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("DoB");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 101, 28));

        jLabel6.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Phone No.");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 101, 28));

        jLabel10.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("E mail Id");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 101, 28));

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("UserName");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 101, 28));

        jLabel8.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Password");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 101, 28));

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Confirm Password");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 330, -1, 30));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(306, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Cancel-Button2.png"))); // NOI18N
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel13MouseClicked(evt);
            }
        });

        JLblTitle.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        JLblTitle.setForeground(new java.awt.Color(255, 255, 255));
        JLblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        JLblTitle.setText("New User");

        jPanel3.setBackground(new java.awt.Color(112, 112, 112));

        JTxtDest.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JTxtDest.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTxtDestActionPerformed(evt);
            }
        });
        JTxtDest.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTxtDestKeyPressed(evt);
            }
        });

        JTxtName.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JTxtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTxtNameActionPerformed(evt);
            }
        });
        JTxtName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTxtNameKeyPressed(evt);
            }
        });

        JTxtPhone.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JTxtPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTxtPhoneActionPerformed(evt);
            }
        });
        JTxtPhone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTxtPhoneKeyPressed(evt);
            }
        });

        JTxtDob.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JTxtDob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTxtDobActionPerformed(evt);
            }
        });
        JTxtDob.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTxtDobKeyPressed(evt);
            }
        });

        JTxtUname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JTxtUname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTxtUnameActionPerformed(evt);
            }
        });
        JTxtUname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTxtUnameKeyPressed(evt);
            }
        });

        JTxtEmail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JTxtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTxtEmailActionPerformed(evt);
            }
        });
        JTxtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTxtEmailKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTxtEmailKeyReleased(evt);
            }
        });

        JPass2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JPass2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JPass2KeyPressed(evt);
            }
        });

        JPass1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JPass1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JPass1KeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("OTP");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Enter the OTP sent to ur inbox");

        JTxtOtp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        JTxtOtp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                JTxtOtpKeyPressed(evt);
            }
        });

        JBtnOtp.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        JBtnOtp.setForeground(new java.awt.Color(0, 0, 255));
        JBtnOtp.setText("SEND");
        JBtnOtp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JBtnOtpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(JBtnOtp)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(JTxtOtp, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(JTxtOtp, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JBtnOtp))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(JPass1)
                                    .addComponent(JTxtUname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                    .addComponent(JTxtEmail, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                    .addComponent(JPass2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JTxtPhone, javax.swing.GroupLayout.Alignment.LEADING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(JTxtDob, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 230, Short.MAX_VALUE)
                                    .addComponent(JTxtDest))
                                .addGap(50, 50, 50)))
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(JTxtName, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(JTxtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(JTxtDest, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JTxtDob, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JTxtPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(JTxtUname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(JPass1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(JPass2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/submit-button.png"))); // NOI18N
        jLabel12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel12MouseClicked(evt);
            }
        });

        JP4.setBackground(new java.awt.Color(5, 30, 34));

        JP3.setBackground(new java.awt.Color(25, 50, 54));

        JP2.setBackground(new java.awt.Color(35, 60, 64));

        JP1.setBackground(new java.awt.Color(55, 80, 84));

        javax.swing.GroupLayout JP1Layout = new javax.swing.GroupLayout(JP1);
        JP1.setLayout(JP1Layout);
        JP1Layout.setHorizontalGroup(
            JP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1145, Short.MAX_VALUE)
        );
        JP1Layout.setVerticalGroup(
            JP1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout JP2Layout = new javax.swing.GroupLayout(JP2);
        JP2.setLayout(JP2Layout);
        JP2Layout.setHorizontalGroup(
            JP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JP1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JP2Layout.setVerticalGroup(
            JP2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP2Layout.createSequentialGroup()
                .addComponent(JP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 110, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JP3Layout = new javax.swing.GroupLayout(JP3);
        JP3.setLayout(JP3Layout);
        JP3Layout.setHorizontalGroup(
            JP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JP2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JP3Layout.setVerticalGroup(
            JP3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP3Layout.createSequentialGroup()
                .addComponent(JP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 105, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout JP4Layout = new javax.swing.GroupLayout(JP4);
        JP4.setLayout(JP4Layout);
        JP4Layout.setHorizontalGroup(
            JP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(JP3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        JP4Layout.setVerticalGroup(
            JP4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JP4Layout.createSequentialGroup()
                .addComponent(JP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 175, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(437, 437, 437)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel13))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(59, 59, 59))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(374, 374, 374)
                .addComponent(JLblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(JP4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(JLblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(JP4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(47, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MouseClicked
        //cancel button

        //JOptionPane.showMessageDialog(null, "Cancel");
        new Login().setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jLabel13MouseClicked

    private void JTxtDestActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTxtDestActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTxtDestActionPerformed

    private void JTxtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTxtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTxtNameActionPerformed

    private void JTxtPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTxtPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTxtPhoneActionPerformed

    private void JTxtDobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTxtDobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTxtDobActionPerformed

    private void JTxtUnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTxtUnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTxtUnameActionPerformed

    private void JTxtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTxtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTxtEmailActionPerformed

    public void normalSignUP() {

    }


    private void jLabel12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel12MouseClicked

        //Submit button
        int fName = JTxtName.getDocument().getLength();
        int fDest = JTxtDest.getDocument().getLength();
        int fDob = JTxtDob.getDocument().getLength();
        int fPhone = JTxtPhone.getDocument().getLength();
        int fEmail = JTxtEmail.getDocument().getLength();
        int fUname = JTxtUname.getDocument().getLength();
        int fPass1 = JPass1.getDocument().getLength();
        int fPass2 = JPass2.getDocument().getLength();

        if (!reset) {

            if (fName == 0 && fDest == 0 && fDob == 0 && fPhone == 0 && fEmail == 0 && fUname == 0 && fPass1 == 0 && fPass2 == 0) {

                JOptionPane.showMessageDialog(null, "Please fill all the details ");

            } else if (fName == 0) {
                JOptionPane.showMessageDialog(null, "Name Field can't be empty");

            } else if (fDest == 0) {
                JOptionPane.showMessageDialog(null, "Designation Field can't be empty");

            } else if (fDob == 0) {
                JOptionPane.showMessageDialog(null, "provide the dob in 'YYYY-MM-DD' formate");

            } else if (fPhone == 0) {
                JOptionPane.showMessageDialog(null, "Phone no Field can't be empty");

            } else if (fEmail == 0) {
                JOptionPane.showMessageDialog(null, "Email Field can't be empty");

            } else if (fUname == 0) {
                JOptionPane.showMessageDialog(null, "User name Field can't be empty");

            } else if (fPass1 == 0) {
                JOptionPane.showMessageDialog(null, "Password Field can't be empty");

            } else if (fPass2 == 0) {
                JOptionPane.showMessageDialog(null, "Confirm the password");

            } else if (fName > 30) {
                JOptionPane.showMessageDialog(null, "Name Field can't exceed 30 characters");

            } else if (fDest > 10) {
                JOptionPane.showMessageDialog(null, "Designation Field can't exceed 10 characters");

            } else if (fDob > 10) {
                JOptionPane.showMessageDialog(null, "Dob Field can't exceed 10 characters");

            } else if (fPhone > 10) {
                JOptionPane.showMessageDialog(null, "Phone no Field can't exceed 10 characters");

            } else if (fEmail > 35) {
                JOptionPane.showMessageDialog(null, "Email Field can't exceed 35 characters");

            } else if (fUname > 25) {
                JOptionPane.showMessageDialog(null, "User name Field can't exceed 25 characters");

            } else if (fPass1 > 25) {
                JOptionPane.showMessageDialog(null, "Password Field can't exceed 25 characters");

            } else if (fPass2 > 25) {
                JOptionPane.showMessageDialog(null, "Password show be same as above");

            } else {

                if (verify(JPass1.getText(), JPass2.getText())) {

                    //JOptionPane.showMessageDialog(null, "Both the passwords are same");
                    if (otpSent) {

                        if (JTxtOtp.getDocument().getLength() != 0) {

                            if (verify(sentOtp, JTxtOtp.getText())) {
                                JOptionPane.showMessageDialog(null, "Otp validation successful");

                                try {
                                    selectingTablesToInsert();
                                } catch (Exception ex) {
                                    Logger.getLogger(NewUser.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "Enter the OTP");
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Confirm the OTP varification");
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Both the passwords must be same");
                }

                //code here
            }
        } else {
            // JOptionPane.showMessageDialog(null, "Password reset");

            if (verify(JPass1.getText(), JPass2.getText())) {

                if (!otpSent) {
                    JOptionPane.showMessageDialog(null, "Confirm the OTP varification");
                } else {
                    if (verify(sentOtp, JTxtOtp.getText())) {
                        JOptionPane.showMessageDialog(null, "Otp validation successful");
                        try {
                            //get the details and update the particular table
                            selectingTablesToUpdate();
                        } catch (SQLException ex) {
                            Logger.getLogger(NewUser.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (Exception ex) {
                            Logger.getLogger(NewUser.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Otp validation Failed");
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Both the passwords must be same");
            }

        }

        //JOptionPane.showMessageDialog(null, "Submit");
    }//GEN-LAST:event_jLabel12MouseClicked

    private void JBtnOtpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JBtnOtpActionPerformed

        //Otp send button
        int fEmail = JTxtEmail.getDocument().getLength();

        if (fEmail == 0) {
            JOptionPane.showMessageDialog(null, "Please Provide a valid email");
        } else {

            OTPGeneration otpg = new OTPGeneration();

            String otp = otpg.randomAlphaNumeric(2);
            sentOtp = otp;
            otpSent = true;//implement for mail not sent condition

            System.out.println(sentOtp);

            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {

                    try {
                        MailTest mail = new MailTest();
                        mail.sendMail(JTxtEmail.getText(), sentOtp, uName);
                        otpSent = true;
                    } catch (Exception mailError) {
                        otpSent = false;
                        JBtnOtp.setEnabled(true);
                        JOptionPane.showMessageDialog(null, "Couldn't connect to Internet. Please check your connection!!");
                    }

                }
            });
            t.start();
            JBtnOtp.setText("SENT");
            JBtnOtp.setEnabled(false);

        }

        // OTPGeneration otp = new OTPGeneration();
        //JTxtOtp.setText(otp.randomAlphaNumeric(2));
        //JBtnOtp.setEnabled(false);

    }//GEN-LAST:event_JBtnOtpActionPerformed

    private void JTxtPhoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTxtPhoneKeyPressed

        if (!reset) {
            int key = evt.getKeyCode();

            if (key >= evt.VK_0 && key <= evt.VK_9 || key >= evt.VK_NUMPAD0 && key <= evt.VK_NUMPAD9 || key == evt.VK_BACK_SPACE) {

                JTxtPhone.setEditable(true);
                JTxtPhone.setBackground(Color.yellow);

            } else {

                JTxtPhone.setEditable(false);
                JTxtPhone.setBackground(Color.red);

            }
        } else {
            JTxtPhone.setBackground(Color.yellow);
        }

    }//GEN-LAST:event_JTxtPhoneKeyPressed

    private void JTxtNameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTxtNameKeyPressed

        if (!reset) {
            int key = evt.getKeyCode();

            if (key >= evt.VK_A && key <= evt.VK_Z || key == evt.VK_BACK_SPACE || key == evt.VK_SPACE) {

                JTxtName.setEditable(true);
                JTxtName.setBackground(Color.yellow);

            } else {

                JTxtName.setEditable(false);
                JTxtName.setBackground(Color.red);

            }
        } else {
            JTxtName.setBackground(Color.yellow);
        }
    }//GEN-LAST:event_JTxtNameKeyPressed

    private void JTxtDestKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTxtDestKeyPressed

        if (!reset) {
            int key = evt.getKeyCode();

            if (key >= evt.VK_A && key <= evt.VK_Z || key == evt.VK_BACK_SPACE || key == evt.VK_SPACE) {

                JTxtDest.setEditable(true);
                JTxtDest.setBackground(Color.yellow);

            } else {

                JTxtDest.setEditable(false);
                JTxtDest.setBackground(Color.red);

            }
        } else {
            JTxtDest.setBackground(Color.yellow);
        }


    }//GEN-LAST:event_JTxtDestKeyPressed

    private void JTxtDobKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTxtDobKeyPressed

        if (!reset) {
            int key = evt.getKeyCode();

            if (key >= evt.VK_0 && key <= evt.VK_9 || key >= evt.VK_NUMPAD0 && key <= evt.VK_NUMPAD9 || key == evt.VK_BACK_SPACE || key == evt.VK_MINUS || key == 109) {//109 for NUMPAD_MINUS

                JTxtDob.setEditable(true);
                JTxtDob.setBackground(Color.yellow);

            } else {

                JTxtDob.setEditable(false);
                JTxtDob.setBackground(Color.red);

            }
        } else {
            JTxtDob.setBackground(Color.yellow);
        }


    }//GEN-LAST:event_JTxtDobKeyPressed

    private void JTxtOtpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTxtOtpKeyPressed

        int key = evt.getKeyCode();

        if (key >= evt.VK_A && key <= evt.VK_Z || key == evt.VK_BACK_SPACE || key >= evt.VK_0 && key <= evt.VK_9 || key >= evt.VK_NUMPAD0 && key <= evt.VK_NUMPAD9) {

            JTxtOtp.setEditable(true);
            JTxtOtp.setBackground(Color.yellow);

        } else {

            JTxtOtp.setEditable(false);
            JTxtOtp.setBackground(Color.red);

        }


    }//GEN-LAST:event_JTxtOtpKeyPressed

    private void JTxtUnameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTxtUnameKeyPressed

        JTxtUname.setBackground(Color.yellow);
    }//GEN-LAST:event_JTxtUnameKeyPressed

    private void JPass1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JPass1KeyPressed

        JPass1.setBackground(Color.yellow);

    }//GEN-LAST:event_JPass1KeyPressed

    private void JPass2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JPass2KeyPressed

        JPass2.setBackground(Color.yellow);

    }//GEN-LAST:event_JPass2KeyPressed

    private void JTxtEmailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTxtEmailKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_JTxtEmailKeyReleased

    private void JTxtEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTxtEmailKeyPressed

        JTxtEmail.setBackground(Color.yellow);

    }//GEN-LAST:event_JTxtEmailKeyPressed

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
            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewUser().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JBtnOtp;
    private javax.swing.JLabel JLblTitle;
    private javax.swing.JPanel JP1;
    private javax.swing.JPanel JP2;
    private javax.swing.JPanel JP3;
    private javax.swing.JPanel JP4;
    private javax.swing.JPasswordField JPass1;
    private javax.swing.JPasswordField JPass2;
    private javax.swing.JTextField JTxtDest;
    private javax.swing.JTextField JTxtDob;
    private javax.swing.JTextField JTxtEmail;
    private javax.swing.JTextField JTxtName;
    private javax.swing.JTextField JTxtOtp;
    private javax.swing.JTextField JTxtPhone;
    private javax.swing.JTextField JTxtUname;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables

}
