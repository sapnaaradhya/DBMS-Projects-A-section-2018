/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.Color;
import static java.awt.Component.TOP_ALIGNMENT;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Nasir Basha K
 */
public class Welcome extends javax.swing.JFrame {

    /**
     * Creates new form Welcome
     */
    Timer tm, tmDown;
    Timer tmUp;
    int i;
    Timer time;
    boolean flag = false, stop = false;
    Random rand = new Random();

    private void disappear(boolean b) {
        J1.setVisible(b);
        J2.setVisible(b);
        J3.setVisible(b);
        J4.setVisible(b);
        J5.setVisible(b);
        J6.setVisible(b);
        J7.setVisible(b);
        J8.setVisible(b);
        J9.setVisible(b);
        J10.setVisible(b);
        J11.setVisible(b);
        J12.setVisible(b);
        J13.setVisible(b);
        J14.setVisible(b);
        J15.setVisible(b);
        J16.setVisible(b);
    }

    private void divideUp() {

        System.out.println("divideUp");
        //disappear(true);
        /*
         animate(J1);
        animate(J2);
        animate(J3);
        animate(J4);
        animate(J5);
        animate(J6);
        animate(J7);
        animate(J8);
        animate(J9);
        animate(J10);
        animate(J11);
        animate(J12);
        animate(J13);
        animate(J14);
        animate(J15);
        animate(J16);
        
        
         J1.setForeground(Color.YELLOW);
        J2.setForeground(Color.CYAN);
        J3.setForeground(Color.CYAN);
        J4.setForeground(Color.CYAN);
        J5.setForeground(Color.CYAN);
        J6.setForeground(Color.CYAN);
        J7.setForeground(Color.CYAN);
        J8.setForeground(Color.CYAN);
        J9.setForeground(Color.CYAN);
        J10.setForeground(Color.CYAN);
        J11.setForeground(Color.CYAN);
        J12.setForeground(Color.CYAN);
        J13.setForeground(Color.CYAN);
        J14.setForeground(Color.CYAN);
        J15.setForeground(Color.CYAN);
        J16.setForeground(Color.CYAN);
        */

        time = new Timer(50, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                 System.out.println("inside divideUp");
                Point p1 = J1.getLocation();
                Point p2 = J2.getLocation();
                Point p3 = J3.getLocation();
                Point p4 = J4.getLocation();
                Point p5 = J5.getLocation();
                Point p6 = J6.getLocation();
                Point p7 = J7.getLocation();
                Point p8 = J8.getLocation();
                Point p9 = J9.getLocation();
                Point p10 = J10.getLocation();
                Point p11 = J11.getLocation();
                Point p12 = J12.getLocation();
                Point p13 = J13.getLocation();
                Point p14 = J14.getLocation();
                Point p15 = J15.getLocation();
                Point p16 = J16.getLocation();

                J1.setLocation(p1.x - 4, p1.y - 5);
                J2.setLocation(p2.x - 4, p2.y - 5);
                J3.setLocation(p3.x - 4, p3.y - 5);
                J4.setLocation(p4.x - 4, p4.y - 5);
                J5.setLocation(p5.x - 4, p5.y - 5);

                J6.setLocation(p6.x + 4, p6.y - 5);
                J7.setLocation(p7.x + 4, p7.y - 5);
                J8.setLocation(p8.x + 4, p8.y - 5);
                J9.setLocation(p9.x + 4, p9.y - 5);
                J10.setLocation(p10.x + 4, p10.y - 5);
                J11.setLocation(p11.x + 4, p11.y - 5);
                J12.setLocation(p12.x + 4, p12.y - 5);
                J13.setLocation(p13.x + 4, p13.y - 5);
                J14.setLocation(p14.x + 4, p14.y - 5);
                J15.setLocation(p15.x + 4, p15.y - 5);
                J16.setLocation(p16.x + 4, p16.y - 5);

                if (p1.y + 200 <= (getContentPane().getHeight()) / 2) {
                    J1.setLocation(p1.x, p1.y);
                    J2.setLocation(p2.x, p1.y);
                    J3.setLocation(p3.x, p1.y);
                    J4.setLocation(p4.x, p1.y);
                    J5.setLocation(p5.x, p5.y);

                    J6.setLocation(p6.x, p6.y);
                    J7.setLocation(p7.x, p7.y);
                    J8.setLocation(p8.x, p8.y);
                    J9.setLocation(p9.x, p9.y);
                    J10.setLocation(p10.x, p10.y);
                    J11.setLocation(p11.x, p11.y);
                    J12.setLocation(p12.x, p12.y);
                    J13.setLocation(p13.x, p13.y);
                    J14.setLocation(p14.x, p14.y);
                    J15.setLocation(p15.x, p15.y);
                    J16.setLocation(p16.x, p16.y);
                    stop=true;
                    time.stop();
                    
                    allignFinal();
                    
                }

            }
        });
        time.start();
        
         System.out.println("divideUp done");

    }
     Timer  t ;
    private void allignFinal(){
            System.out.println("Allign ");
           t = new Timer (40,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                
                J1.setLocation(J1.getLocation().x+5,J1.getLocation().y);
                J2.setLocation(J2.getLocation().x+5,J2.getLocation().y);
                J3.setLocation(J3.getLocation().x+5,J3.getLocation().y);
                J4.setLocation(J4.getLocation().x+5,J4.getLocation().y);
                J5.setLocation(J5.getLocation().x+5,J5.getLocation().y);
                J6.setLocation(J6.getLocation().x-3,J6.getLocation().y);
                
                if(J5.getLocation().x+100 > getContentPane().getWidth()/2){
                    
                    J1.setLocation(470,200);
                    J2.setLocation(500,200);
                    J3.setLocation(540,200);
                    J4.setLocation(575,200);
                    J5.setLocation(600,200);
                    J6.setLocation(J6.getLocation().x,200);
                    J7.setLocation(J7.getLocation().x,200);
                    J8.setLocation(J8.getLocation().x,200);
                    J9.setLocation(J9.getLocation().x,200);
                    J10.setLocation(J10.getLocation().x,200);
                    J11.setLocation(J11.getLocation().x,200);
                    J12.setLocation(J12.getLocation().x,200);
                    J13.setLocation(J13.getLocation().x,200);
                    J14.setLocation(J14.getLocation().x,200);
                    J15.setLocation(J15.getLocation().x,200);
                    J16.setLocation(J16.getLocation().x,200);
                    
                    System.out.println("X,Y pos "+J1.getLocation());
                     System.out.println("X,Y pos "+J2.getLocation());
                     System.out.println("X,Y pos "+J3.getLocation());
                     System.out.println("X,Y pos "+J4.getLocation());
                      System.out.println("X,Y pos "+J5.getLocation());
                     System.out.println("X,Y pos "+J6.getLocation());
                     System.out.println("X,Y pos "+J7.getLocation());
                     System.out.println("X,Y pos "+J8.getLocation());
                   
                    
                    t.stop();
                }
            
            
            }
        });
        t.start();
            
        
    }

    private void fullDown() {

        System.out.println("Full Down");
        tmDown = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Point loc = jLabel1.getLocation();
                jLabel1.setLocation(loc.x, loc.y + 5);
                
                if (loc.y + 100 > getContentPane().getHeight()) {
                    jLabel1.setLocation(loc.x, loc.y + 100);

                    tmDown.stop();
                    
                    fullUp();
                    divideUp();
                   
                }

            }
        });
        tmDown.start();

    }

    private void fullUp() {

        System.out.println("fullUp");
        tm = new Timer(30, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                Point locUp = jLabel1.getLocation();
                jLabel1.setLocation(locUp.x, locUp.y - 5);

                if (locUp.y + 200 <= (getContentPane().getHeight()) / 2) {
                    jLabel1.setLocation(locUp.x, locUp.y);
                    tm.stop();
                }
            }
        });
        tm.start();
    }

    private void animate(javax.swing.JLabel j) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                new Timer(50, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {

                        if (!stop) {
                            j.setLocation(j.getX() + rand.nextInt(5) - 2, j.getY() + rand.nextInt(5) - 2);
                            j.setAlignmentY(TOP_ALIGNMENT);

                        }

                    }
                }).start();

            }
        }).start();

    }

    public Welcome() {
        
        this.setAlwaysOnTop(true);
        this.setBackground(Color.getColor("808080"));
        
        initComponents();
        Toolkit tk = Toolkit.getDefaultToolkit();
        
        this.setSize(tk.getScreenSize().width, tk.getScreenSize().height);
        
        setLocationRelativeTo(null);

        disappear(true);
        getContentPane().setBackground(Color.getColor("808080"));
        jFrame1.setBackground(Color.getColor("808080"));
       
       
        
        //J1.setLocation(J1.getLocation().x, J1.getLocation().y + 100);
        /*
        J1.setForeground(Color.white);
        J2.setForeground(Color.white);
        J3.setForeground(Color.white);
        J4.setForeground(Color.white);
        J5.setForeground(Color.white);
        J6.setForeground(Color.white);
        J7.setForeground(Color.white);
        J8.setForeground(Color.white);
        J9.setForeground(Color.white);
        J10.setForeground(Color.white);
        J11.setForeground(Color.white);
        J12.setForeground(Color.white);
        J13.setForeground(Color.white);
        J14.setForeground(Color.white);
        J15.setForeground(Color.white);
        J16.setForeground(Color.white);
        */
        fullDown();
        System.out.println(J1.getAlignmentX());
        System.out.println(J1.getAlignmentY());
        //animate(jLabel1);
       
        //fullDown();
        //divideUp();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFrame1 = new javax.swing.JFrame();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        J9 = new javax.swing.JLabel();
        J10 = new javax.swing.JLabel();
        J11 = new javax.swing.JLabel();
        J12 = new javax.swing.JLabel();
        J13 = new javax.swing.JLabel();
        J14 = new javax.swing.JLabel();
        J15 = new javax.swing.JLabel();
        J16 = new javax.swing.JLabel();
        J1 = new javax.swing.JLabel();
        J2 = new javax.swing.JLabel();
        J3 = new javax.swing.JLabel();
        J4 = new javax.swing.JLabel();
        J5 = new javax.swing.JLabel();
        J6 = new javax.swing.JLabel();
        J7 = new javax.swing.JLabel();
        J8 = new javax.swing.JLabel();

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 200, 151));
        setForeground(java.awt.Color.white);
        setResizable(false);
        setSize(new java.awt.Dimension(1200, 600));

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(216, 138, 136)));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Staff Information");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        J9.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        J9.setText("o");

        J10.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        J10.setText("r");

        J11.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        J11.setText("m");

        J12.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        J12.setText("a");

        J13.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        J13.setText("t");

        J14.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        J14.setText("i");

        J15.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        J15.setText("o");

        J16.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        J16.setText("n");

        J1.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        J1.setText("S");
        J1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                J1MouseDragged(evt);
            }
        });

        J2.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        J2.setText("t");
        J2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                J2MouseMoved(evt);
            }
        });

        J3.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        J3.setText("a");

        J4.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        J4.setText("f");

        J5.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        J5.setText("f");

        J6.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        J6.setText("I");

        J7.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        J7.setText("n");

        J8.setFont(new java.awt.Font("Tahoma", 1, 50)); // NOI18N
        J8.setText("f");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(239, 239, 239)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                .addGap(236, 236, 236))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(J1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(J2)
                .addGap(2, 2, 2)
                .addComponent(J3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(J4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(J5)
                .addGap(50, 50, 50)
                .addComponent(J6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(J7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(J8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(J9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(J10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(J11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(J12)
                .addGap(2, 2, 2)
                .addComponent(J13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(J14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(J15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(J16)
                .addGap(160, 160, 160))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(90, 90, 90)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3768, 3768, 3768)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(J4)
                        .addComponent(J5)
                        .addComponent(J6)
                        .addComponent(J7)
                        .addComponent(J8)
                        .addComponent(J9)
                        .addComponent(J10)
                        .addComponent(J11)
                        .addComponent(J12)
                        .addComponent(J13)
                        .addComponent(J14)
                        .addComponent(J15)
                        .addComponent(J16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(J2, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(J3)
                        .addComponent(J1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 4008, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 24, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked

        JOptionPane.showMessageDialog(this, "Clicked");
        
    }//GEN-LAST:event_jLabel1MouseClicked

    private void J1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_J1MouseDragged
        J1.setLocation(getMousePosition(true));
    }//GEN-LAST:event_J1MouseDragged

    private void J2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_J2MouseMoved
        
    }//GEN-LAST:event_J2MouseMoved

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
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Welcome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Welcome().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel J1;
    private javax.swing.JLabel J10;
    private javax.swing.JLabel J11;
    private javax.swing.JLabel J12;
    private javax.swing.JLabel J13;
    private javax.swing.JLabel J14;
    private javax.swing.JLabel J15;
    private javax.swing.JLabel J16;
    private javax.swing.JLabel J2;
    private javax.swing.JLabel J3;
    private javax.swing.JLabel J4;
    private javax.swing.JLabel J5;
    private javax.swing.JLabel J6;
    private javax.swing.JLabel J7;
    private javax.swing.JLabel J8;
    private javax.swing.JLabel J9;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
