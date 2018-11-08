package newpackage;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {

    Container c = getContentPane();
    private JButton btnLogin, btnCancel;
    private JLabel lblUName, lblPasswd;
    private JTextField txtUName;
    private JPasswordField txtPasswd;

    public Login() {
        super("Login ...");
        this.setSize(350, 200);
        this.setLayout(null);
        this.setResizable(false);
        this.setLocation((Settings.getScreenSize().width / 2) - 175, (Settings.getScreenSize().height / 2) - 150);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        lblUName = new JLabel("Username");
        lblPasswd = new JLabel("Password");
        txtUName = new JTextField();
        txtPasswd = new JPasswordField();
        btnLogin = new JButton("Login", new ImageIcon(ClassLoader.getSystemResource("images/login.PNG")));
        btnCancel = new JButton("Cancel", new ImageIcon(ClassLoader.getSystemResource("images/cancel.PNG")));
        lblUName.setBounds(50, 40, 140, 25);
        txtUName.setBounds(150, 40, 130, 25);
        lblPasswd.setBounds(50, 80, 140, 25);
        txtPasswd.setBounds(150, 80, 130, 25);
        btnLogin.setBounds(50, 120, 100, 25);
        btnCancel.setBounds(180, 120, 100, 25);
        btnLogin.addActionListener(this);
        btnCancel.addActionListener(this);
        this.add(lblUName);
        this.add(lblPasswd);
        this.add(txtUName);
        this.add(txtPasswd);
        this.add(btnLogin);
        this.add(btnCancel);
    }//constructor closed

    /**
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnLogin) {
            try {
                //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                //Connection con = DriverManager.getConnection("jdbc:odbc:student");
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
                try {
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery("SELECT * FROM UAD WHERE Username='" + txtUName.getText()
                            + "' and Password='" + txtPasswd.getText() + "'");
                    if (rs.next()) {
                        if (rs.getString(3).equals("Student")) {
                            userMDI frm = new userMDI();
                            frm.setVisible(true);
                        } else {
                            new frmAdminMDI().setVisible(true);
                        }
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid username or password", "Invalid", JOptionPane.ERROR_MESSAGE);
                    }
                    con.close();

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Invalid username or password", "Invalid", JOptionPane.ERROR_MESSAGE);
                    txtUName.setText("");
                    txtPasswd.setText("");
                }//inner try catch closed
            } catch (Exception x) {
                JOptionPane.showMessageDialog(null, "Unable to connect to the database", "Connection error", JOptionPane.ERROR_MESSAGE);
            }//outer try catch closed
        }//if closed

        if (e.getSource() == btnCancel) {
            System.exit(0);
        }//if closed
    }//actionPerformed() closed

    public static void main(String args[]) {
        new Login().setVisible(true);
    }
}//class closed

