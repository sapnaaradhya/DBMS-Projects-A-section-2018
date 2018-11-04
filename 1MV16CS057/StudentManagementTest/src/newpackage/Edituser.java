package newpackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class Edituser extends JInternalFrame implements ActionListener {

    private JRadioButton rdoStudent;
    private JRadioButton rdoAdmin;
    private JLabel lblUName;
    private JComboBox cmbUName;
    private JButton btnUpdate;
    private ButtonGroup group;

    public Edituser() {
        super("Edit User", false, true, false, true);
        setBounds(350, 200, 300, 200);
        setLayout(null);
        rdoStudent = new JRadioButton("Student");
        rdoAdmin = new JRadioButton("Administrator");
        lblUName = new JLabel("User name");
        cmbUName = new JComboBox();
        btnUpdate = new JButton("Update", new ImageIcon(ClassLoader.getSystemResource("Images/update.png")));
        group = new ButtonGroup();
        lblUName.setBounds(30, 30, 100, 30);
        cmbUName.setBounds(140, 30, 100, 25);
        rdoStudent.setBounds(30, 70, 100, 30);
        rdoAdmin.setBounds(140, 70, 150, 30);
        btnUpdate.setBounds(100, 110, 100, 25);
        add(lblUName);
        add(cmbUName);
        group.add(rdoAdmin);
        group.add(rdoStudent);
        add(rdoAdmin);
        add(rdoStudent);
        add(btnUpdate);
        btnUpdate.addActionListener(this);
        rdoStudent.setSelected(true);
        try {
            String name;
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //Connection con = DriverManager.getConnection("jdbc:odbc:student");
            Class.forName("com.mysql.jdbc.Driver");                
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select Username from UAD");
            while (rs.next()) {
                name = rs.getString(1);
                if (!name.equalsIgnoreCase("admin")) {
                    cmbUName.addItem(name);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error while loading users list, Closing window");
            this.dispose();
        }//try catch clsoed
    }//constructor closed
    public void actionPerformed(ActionEvent e) {

        try {
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //Connection con = DriverManager.getConnection("jdbc:odbc:student");
            Class.forName("com.mysql.jdbc.Driver");                
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
            Statement st = con.createStatement();
            try {
                String Type;
                if (e.getSource() == btnUpdate) {
                    if (rdoStudent.isSelected()) {
                        Type = "Student";
                    } else {
                        Type = "Admin";
                    }
                    String sql = "update UAD set Type ='" + Type + "' where Username='" + cmbUName.getSelectedItem().toString() + "'";
                    st.executeUpdate(sql);                    
                    JOptionPane.showMessageDialog(null, "Database successfully updated", "Success", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error,Unable to perform database operation", "Error", JOptionPane.ERROR_MESSAGE);
            }//inner try catch closed
        } catch (Exception ex1) {
            JOptionPane.showMessageDialog(null, "Error on database connection, Cannot perform database operation", "Error", JOptionPane.ERROR_MESSAGE);
        }//outer try catch closed
    }//actionPerformed() closed
}//class closed

