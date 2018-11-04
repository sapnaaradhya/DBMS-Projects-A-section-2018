package newpackage;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EditSubjects extends JInternalFrame implements ActionListener {

    private JLabel lblSubcode,  lblSubName,  lblCredit,  lblMaxmark,  lblType,  lblPract;
    private JTextField txtSubName,  txtCredit,  txtMaxmark;
    private JComboBox cmbCode,  cmbType,  cmbPract;
    private JButton btnSave,  btnCancel;

    public EditSubjects() {
        super("Add Subjects", false, true, false, true);
        setSize(200, 200);
        setLocation(400, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Container c = this.getContentPane();
        getContentPane().setLayout(new GridLayout(7, 2));

        lblSubcode = new JLabel("Code");
        lblSubName = new JLabel("Name");
        lblCredit = new JLabel("Credit");
        lblMaxmark = new JLabel("Max.Mark");
        lblType = new JLabel(" Type");
        lblPract = new JLabel("Practical");
        cmbCode = new JComboBox();
        txtSubName = new JTextField();
        txtCredit = new JTextField();
        txtMaxmark = new JTextField();
        cmbType = new JComboBox();
        cmbType.addItem("COUNTING");
        cmbType.addItem("NON COUNTING");
        cmbType.setSelectedIndex(0);
        cmbPract = new JComboBox();
        cmbPract.addItem("YES");
        cmbPract.addItem("NO");
        cmbPract.setSelectedIndex(0);
        btnSave = new JButton("Update");
        btnCancel = new JButton("Cancel");

        c.add(lblSubcode);
        c.add(cmbCode);
        c.add(lblSubName);
        c.add(txtSubName);
        c.add(lblCredit);
        c.add(txtCredit);
        c.add(lblMaxmark);
        c.add(txtMaxmark);
        c.add(lblType);
        c.add(cmbType);
        c.add(lblPract);
        c.add(cmbPract);
        c.add(btnSave);
        c.add(btnCancel);
        btnSave.addActionListener(this);
        btnCancel.addActionListener(this);
        cmbCode.addActionListener(this);
        loadSubjectCodes();
    }//constructor closed

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnSave) {
            try {
                if (cmbCode.getSelectedItem() == null) {
                    return;
                }
                //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                //Connection con = DriverManager.getConnection("jdbc:odbc:student");
                Class.forName("com.mysql.jdbc.Driver");                
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
                String sql = "UPDATE Subject SET Subjectname=?,CreditMark=?,MaxMark=?,Type=?,Practical=? WHERE Subjectcode=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, txtSubName.getText());
                ps.setInt(2, Integer.parseInt(txtCredit.getText()));
                ps.setInt(3, Integer.parseInt(txtMaxmark.getText()));
                ps.setString(4, cmbType.getSelectedItem().toString());
                ps.setString(5, cmbPract.getSelectedItem().toString());
                ps.setString(6, cmbCode.getSelectedItem().toString());

                int retval = ps.executeUpdate();
                if (retval > 0) {
                    JOptionPane.showMessageDialog(null, "Record successfully updated");
                    cmbCode.removeActionListener(this);
                    loadSubjectCodes();
                    txtMaxmark.setText("");
                    txtSubName.setText("");
                    txtCredit.setText("");
                    cmbType.setSelectedIndex(0);
                    cmbCode.addActionListener(this);
                    cmbCode.setSelectedIndex(0);

                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error on updating database", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (ae.getSource() == btnCancel) {
            this.dispose();
        }
        if (ae.getSource() == cmbCode) {
            try {
                //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                //Connection con = DriverManager.getConnection("jdbc:odbc:student");
                Class.forName("com.mysql.jdbc.Driver");                
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
                String sql = "SELECT Subjectname,CreditMark,MaxMark,Type,Practical FROM Subject WHERE Subjectcode=?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setString(1, cmbCode.getSelectedItem().toString());
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    txtSubName.setText(rs.getString(1));
                    txtCredit.setText(String.valueOf(rs.getInt(2)));
                    txtMaxmark.setText(String.valueOf(rs.getString(3)));
                    cmbType.setSelectedItem(rs.getString(4));;
                    cmbPract.setSelectedItem(rs.getString(5));
                }

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.toString());
            }
        }
    }

    private void loadSubjectCodes() {
        try {
            cmbCode.removeAllItems();
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //Connection con = DriverManager.getConnection("jdbc:odbc:student");
            Class.forName("com.mysql.jdbc.Driver");                
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
            String sql = "SELECT Subjectcode FROM Subject";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cmbCode.addItem(rs.getString(1));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
}
