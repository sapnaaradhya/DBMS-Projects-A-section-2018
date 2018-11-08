package newpackage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Deleteuser extends JInternalFrame implements ActionListener {

    private JLabel lblUName = new JLabel("User name");
    private JComboBox cmbUName = new JComboBox();
    private JButton btnDelete = new JButton("Delete", new ImageIcon(ClassLoader.getSystemResource("Images/delusr.png")));

    public Deleteuser() {
        super("Delete user accounts", false, true, false, true);
        setBounds(350, 200, 300, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        lblUName.setBounds(30, 30, 100, 30);
        cmbUName.setBounds(120, 30, 130, 25);
        btnDelete.setBounds(100, 90, 100, 25);
        add(lblUName);
        add(cmbUName);
        add(btnDelete);
        btnDelete.addActionListener(this);
        LoadUserames();
    }

    public void actionPerformed(ActionEvent e) {
        try {
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //Connection con = DriverManager.getConnection("jdbc:odbc:student");
            Class.forName("com.mysql.jdbc.Driver");                
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
            Statement st = con.createStatement();
            String Type;
            try {
                if (e.getSource() == btnDelete) {
                    String sql = "delete from UAD where Username='" + cmbUName.getSelectedItem().toString() + "'";
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Database successfully updated", "Success", JOptionPane.INFORMATION_MESSAGE);
                    LoadUserames();
                }
            } catch (Exception x) {
                JOptionPane.showMessageDialog(null, "Error,Unable to perform database operation", "Error", JOptionPane.ERROR_MESSAGE);
            }//inner try catch closed
        } catch (Exception ex1) {
            JOptionPane.showMessageDialog(null, "Error on database connection, Cannot perform database operation", "Error", JOptionPane.ERROR_MESSAGE);
        }//outer try catch closed
    }//actionPerformed() closed
    private void LoadUserames() {
        String name;
        try {
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //Connection con = DriverManager.getConnection("jdbc:odbc:student");
            Class.forName("com.mysql.jdbc.Driver");                
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select Username from UAD");
            cmbUName.removeAllItems();
            while (rs.next()) {
                name=rs.getString(1);
                if (!(name.equalsIgnoreCase("admin"))) {
                    cmbUName.addItem(name);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error while loading users list, Closing window" + ex.toString());
            this.dispose();
        }//try catch clsoed
    }
}//class closed
