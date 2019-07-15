
import java.awt.event.KeyEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
public class Sepage extends javax.swing.JFrame {
    public Sepage() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setBounds(350,100, 698, 399);
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
        jTxt36 = new javax.swing.JLabel();
        jTxt37 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        bid = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(null);

        jTxt36.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jTxt36.setText("RETRIEVE FACULTY IN A BRANCH");
        jPanel1.add(jTxt36);
        jTxt36.setBounds(87, 11, 591, 44);

        jTxt37.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTxt37.setText("BRANCH ID:");
        jPanel1.add(jTxt37);
        jTxt37.setBounds(139, 109, 164, 30);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton1.setText("SEARCH");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(180, 180, 117, 37);

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("BACK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(420, 180, 93, 37);

        bid.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bidKeyPressed(evt);
            }
        });
        jPanel1.add(bid);
        bid.setBounds(313, 112, 143, 30);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null}
            },
            new String [] {
                "Title 1", "Title 2"
            }
        ));
        jScrollPane1.setViewportView(table);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(110, 240, 452, 112);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/i9.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 690, 420);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 412, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
          Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=(com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","dolly");
        } catch (Exception ex) {
            System.out.println(ex);
        }
  try{
            ResultSet rs=null;
            String m=bid.getText();
       // String sql="SELECT faculty_id,faculty_name FROM FACULTY WHERE branch_id='"+m+"'";
       // PreparedStatement pst=con.prepareStatement(sql);   
       // pst.setString(1,FID.getText());
String query1 = "{CALL inc(?)}";
CallableStatement stmt = con.prepareCall(query1);
stmt.setString(1, m);
ResultSet rs1 = stmt.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs1));
             // rs1=pst.executeQuery();
             rs1 = stmt.executeQuery();
              if(!rs1.next())
              {
                  JOptionPane.showMessageDialog(null,"Search not found");
              }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        fpage f=new fpage();
        f.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void bidKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bidKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode()==KeyEvent.VK_ENTER)
        {
            
         Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=(com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","dolly");

        } catch (Exception ex) {
            System.out.println(ex);
        }
  try{  
                   ResultSet rs=null;
            String m=bid.getText();
String query1 = "{CALL inc(?)}";
CallableStatement stmt = con.prepareCall(query1);
stmt.setString(1, m);
ResultSet rs1 = stmt.executeQuery();
            table.setModel(DbUtils.resultSetToTableModel(rs1));
              if(!rs1.next())
              {
                  JOptionPane.showMessageDialog(null,"Search not found");
              }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_bidKeyPressed
    }
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
            java.util.logging.Logger.getLogger(Sepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sepage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sepage().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bid;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jTxt36;
    private javax.swing.JLabel jTxt37;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
