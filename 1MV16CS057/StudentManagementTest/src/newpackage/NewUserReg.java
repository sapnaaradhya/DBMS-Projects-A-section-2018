package newpackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class NewUserReg extends JInternalFrame implements ActionListener {

    private JRadioButton rdoStudent;
    private JRadioButton rdoAdmin;
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JLabel lblCPassword;
    private JTextField txtUsername;
    private JPasswordField txtPassword;
    private JPasswordField txtCPassword;
    private JButton btnSave;
    private ButtonGroup group;

    public NewUserReg() {
        super("User registration", false, true, false, true);
        this.setLayout(null);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocation(300, 175);
        this.setSize(350, 300);
        group = new ButtonGroup();
        rdoStudent = new JRadioButton("Student");
        rdoAdmin = new JRadioButton("Administrator");
        lblUsername = new JLabel("User name");
        lblPassword = new JLabel("Enter the password");
        lblCPassword = new JLabel("Confirm password");
        txtUsername = new JTextField();
        txtPassword = new JPasswordField();
        txtCPassword = new JPasswordField();
        btnSave = new JButton("Save", new ImageIcon(ClassLoader.getSystemResource("Images/save.png")));
        lblUsername.setBounds(30, 30, 100, 30);
        lblPassword.setBounds(30, 80, 150, 30);
        lblCPassword.setBounds(30, 130, 150, 30);
        txtUsername.setBounds(150, 30, 150, 25);
        txtPassword.setBounds(150, 80, 150, 25);
        txtCPassword.setBounds(150, 130, 150, 25);
        rdoStudent.setBounds(60, 170, 100, 30);
        rdoAdmin.setBounds(170, 170, 150, 30);
        btnSave.setBounds(120, 210, 100, 25);
        group.add(rdoAdmin);
        group.add(rdoStudent);
        add(lblUsername);
        add(lblPassword);
        add(lblCPassword);
        add(txtUsername);
        add(txtPassword);
        add(txtCPassword);
        add(rdoStudent);
        add(rdoAdmin);
        add(btnSave);
        btnSave.addActionListener(this);
        rdoStudent.setSelected(true);
    }//constructor closed
    public void actionPerformed(ActionEvent e) {
        String Type;
        try {
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //Connection con = DriverManager.getConnection("jdbc:odbc:student");
            Class.forName("com.mysql.jdbc.Driver");                
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
            Statement st = con.createStatement();
            try {
                if (e.getSource() == btnSave) {
                    String Username = txtUsername.getText();
                    String Password = txtPassword.getText();
                    String CPassword = txtCPassword.getText();
                    if (!CPassword.equals(Password)) {
                        JOptionPane.showMessageDialog(null, "Password and Confirm Password fields does not match", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    String str = "insert into UAD(Username,Password,Type) values(?,?,?)";
                    PreparedStatement ps = con.prepareStatement(str);
                    if (rdoStudent.isSelected()) {
                        Type = "Student";
                    } else {
                        Type = "Admin";
                    }
                    ps.setString(1, Username);
                    ps.setString(2, Password);
                    ps.setString(3, Type);
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Database successfully updated", "Success", JOptionPane.INFORMATION_MESSAGE);
                    txtUsername.setText("");
                    txtPassword.setText("");
                    txtCPassword.setText("");
                }//if Closed
            } catch (Exception x) {
                JOptionPane.showMessageDialog(null, "Error,Unable to perform database operation", "Error", JOptionPane.ERROR_MESSAGE);
            }//inner try catch closed
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error on database connection, Cannot perform database operation", "Error", JOptionPane.ERROR_MESSAGE);
        }//outer try catch closed
    }//actionPerformed() closed
}//class closed

