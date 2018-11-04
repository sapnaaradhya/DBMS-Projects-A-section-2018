package newpackage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Deletedetails extends JInternalFrame implements ActionListener {

    private JPanel panel;
    private JButton btnDelete,  btnCancel,  btnView;
    private JLabel lblName,  lblAdNo,  lblPhNo,  lblSex,  lblFatherName,  lblOccupation;
    private JLabel lblMotherName,  lblDOB,  lblAge,  lblCaste,  lblReligion,  lblHouseName;
    private JLabel lblCity,  lblDistrict,  lblState,  lblPin,  lblYear,  lblQualification;
    private JTextField txtName,  txtAdNo,  txtPhNo,  txtFatherName,  txtOccupation;
    private JTextField txtMotherName,  txtDOB,  txtAge,  txtCaste,  txtReligion,  txtHouseName;
    private JTextField txtCity,  txtDistrict,  txtState,  txtPin,  txtYear,  txtQualification,  txtSex;
    private Connection con;
    private Statement st;

    public Deletedetails() {
        super("Edit Student Registration", true, true, true, true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(1000, 1000);

        panel = new JPanel();
        lblAdNo = new JLabel("Admission no");
        lblName = new JLabel("Name");
        lblPhNo = new JLabel("Phone no");
        lblSex = new JLabel("Sex");
        lblFatherName = new JLabel("Father's name");
        lblOccupation = new JLabel("Occupation");
        lblMotherName = new JLabel("Mother's name");
        lblDOB = new JLabel("DOB");
        lblAge = new JLabel("Age");
        lblCaste = new JLabel("Caste");
        lblReligion = new JLabel("Religion");
        lblHouseName = new JLabel("House Name");
        lblCity = new JLabel("City");
        lblDistrict = new JLabel("District");
        lblState = new JLabel("State");
        lblPin = new JLabel("Pin");
        lblYear = new JLabel("Year");
        lblQualification = new JLabel("Qualification");

        txtName = new JTextField();
        txtAdNo = new JTextField();
        txtPhNo = new JTextField();
        txtSex = new JTextField();
        txtFatherName = new JTextField();
        txtOccupation = new JTextField();
        txtMotherName = new JTextField();
        txtDOB = new JTextField();
        txtAge = new JTextField();
        txtCaste = new JTextField();
        txtReligion = new JTextField();
        txtHouseName = new JTextField();
        txtCity = new JTextField();
        txtDistrict = new JTextField();
        txtState = new JTextField();
        txtPin = new JTextField();
        txtQualification = new JTextField();
        txtYear = new JTextField();

        txtName.setEditable(false);
        txtPhNo.setEditable(false);
        txtSex.setEditable(false);
        txtFatherName.setEditable(false);
        txtOccupation.setEditable(false);
        txtMotherName.setEditable(false);
        txtDOB.setEditable(false);
        txtAge.setEditable(false);
        txtCaste.setEditable(false);
        txtReligion.setEditable(false);
        txtHouseName.setEditable(false);
        txtCity.setEditable(false);
        txtDistrict.setEditable(false);
        txtState.setEditable(false);
        txtPin.setEditable(false);
        txtQualification.setEditable(false);
        txtYear.setEditable(false);
        btnDelete = new JButton("Delete", new ImageIcon(ClassLoader.getSystemResource("Images/delusr.png")));
        btnDelete.setEnabled(false);
        btnCancel = new JButton("Cancel", new ImageIcon(ClassLoader.getSystemResource("Images/cancel.png")));
        btnView = new JButton("View", new ImageIcon(ClassLoader.getSystemResource("Images/view.png")));
        btnDelete.addActionListener(this);
        btnCancel.addActionListener(this);
        btnView.addActionListener(this);

        panel.setLayout(null);

        lblAdNo.setBounds(100, 50, 150, 25);
        txtAdNo.setBounds(200, 50, 200, 25);
        lblName.setBounds(100, 90, 150, 25);
        txtName.setBounds(200, 90, 200, 25);
        lblPhNo.setBounds(100, 130, 150, 25);
        txtPhNo.setBounds(200, 130, 200, 25);
        lblSex.setBounds(100, 170, 150, 25);
        txtSex.setBounds(200, 170, 200, 25);
        lblFatherName.setBounds(100, 210, 150, 25);
        txtFatherName.setBounds(200, 210, 200, 25);
        lblOccupation.setBounds(100, 250, 100, 25);
        txtOccupation.setBounds(200, 250, 200, 25);
        lblMotherName.setBounds(100, 290, 100, 25);
        txtMotherName.setBounds(200, 290, 200, 25);
        lblDOB.setBounds(100, 330, 150, 25);
        txtDOB.setBounds(200, 330, 200, 25);
        lblCaste.setBounds(100, 370, 150, 25);
        txtCaste.setBounds(200, 370, 200, 25);

        lblAge.setBounds(500, 90, 150, 25);
        txtAge.setBounds(600, 90, 200, 25);
        lblReligion.setBounds(500, 130, 100, 25);
        txtReligion.setBounds(600, 130, 200, 25);
        lblHouseName.setBounds(500, 170, 100, 25);
        txtHouseName.setBounds(600, 170, 200, 25);
        lblCity.setBounds(500, 210, 150, 25);
        txtCity.setBounds(600, 210, 200, 25);
        lblDistrict.setBounds(500, 250, 100, 25);
        txtDistrict.setBounds(600, 250, 200, 25);
        lblState.setBounds(500, 290, 50, 25);
        txtState.setBounds(600, 290, 200, 25);
        lblPin.setBounds(500, 330, 150, 25);
        txtPin.setBounds(600, 330, 200, 25);
        lblYear.setBounds(500, 370, 100, 25);
        txtYear.setBounds(600, 370, 200, 25);
        lblQualification.setBounds(100, 420, 80, 25);
        txtQualification.setBounds(200, 420, 600, 25);
        btnDelete.setBounds(300, 470, 100, 25);
        btnCancel.setBounds(450, 470, 100, 25);
        btnView.setBounds(600, 470, 100, 25);

        panel.add(lblAdNo);
        panel.add(txtAdNo);
        panel.add(lblName);
        panel.add(txtName);
        panel.add(lblPhNo);
        panel.add(txtPhNo);
        panel.add(lblSex);
        panel.add(txtSex);
        panel.add(lblFatherName);
        panel.add(txtFatherName);
        panel.add(lblOccupation);
        panel.add(txtOccupation);
        panel.add(lblMotherName);
        panel.add(txtMotherName);
        panel.add(lblDOB);
        panel.add(txtDOB);
        panel.add(lblAge);

        panel.add(txtAge);
        panel.add(lblCaste);
        panel.add(txtCaste);
        panel.add(lblReligion);
        panel.add(txtReligion);

        panel.add(lblHouseName);
        panel.add(txtHouseName);
        panel.add(lblCity);
        panel.add(txtCity);
        panel.add(lblDistrict);
        panel.add(txtDistrict);
        panel.add(lblState);
        panel.add(txtState);
        panel.add(lblPin);
        panel.add(txtPin);
        panel.add(txtYear);
        panel.add(lblYear);
        panel.add(lblQualification);
        panel.add(txtQualification);
        panel.add(btnDelete);
        panel.add(btnCancel);
        panel.add(btnView);
        add(panel, BorderLayout.CENTER);

        try {
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //con = DriverManager.getConnection("jdbc:odbc:student");
            Class.forName("com.mysql.jdbc.Driver");                
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error on connection to database, cannot continue updation process", "Error", JOptionPane.ERROR_MESSAGE);
        }//outer try catch closed
    }//constructor closed
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equalsIgnoreCase("Delete")) {
            try {
                //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                if (e.getSource() == btnDelete) {
                    String sql = "DELETE FROM student WHERE RollNo=" + txtAdNo.getText();
                    st.executeUpdate(sql);
                    JOptionPane.showMessageDialog(null, "Record successfully deleted", "Success", JOptionPane.INFORMATION_MESSAGE);
                    ClearForm();
                    btnDelete.setEnabled(false);
                }//if closed
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error on database operation", "Error", JOptionPane.ERROR_MESSAGE);
            }//outer try catch closed
        }//if closed
        if (e.getActionCommand().equalsIgnoreCase("View")) {
            try {
                st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM student WHERE RollNo=" + txtAdNo.getText());
                if (rs.next()) {
                    txtName.setText(rs.getString("SName"));
                    txtSex.setText(rs.getString("Sex"));
                    txtFatherName.setText(rs.getString("FName"));
                    txtMotherName.setText(rs.getString("MName"));
                    txtAge.setText(rs.getString("Age"));
                    txtOccupation.setText(rs.getString("Occupation"));
                    txtPhNo.setText(rs.getString("phno"));
                    txtReligion.setText(rs.getString("Religion"));
                    txtHouseName.setText(rs.getString("Hname"));
                    txtCaste.setText(rs.getString("Caste"));
                    txtCity.setText(rs.getString("City"));
                    txtState.setText(rs.getString("State"));
                    txtDOB.setText(rs.getDate("Dob").toString());
                    txtDistrict.setText(rs.getString("District"));
                    txtPin.setText(rs.getString("Pin"));
                    txtYear.setText(rs.getString("Year"));
                    txtQualification.setText(rs.getString("Qualification"));
                    btnDelete.setEnabled(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Roll No not found in database", "Not found", JOptionPane.INFORMATION_MESSAGE);
                    ClearForm();
                    btnDelete.setEnabled(false);
                }//if else closed                
            } catch (Exception x) {
                JOptionPane.showMessageDialog(null, "Error on database operation,Updation failure", "Error", JOptionPane.ERROR_MESSAGE);
            }//inner try catch closed

        }//if closed
        if (e.getActionCommand().equalsIgnoreCase("Cancel")) {
            this.dispose();
        }//if closed
    }

    private void ClearForm() {
        txtAdNo.setText("");
        txtName.setText("");
        txtSex.setText("");
        txtFatherName.setText("");
        txtOccupation.setText("");
        txtMotherName.setText("");
        txtPhNo.setText("");
        txtDOB.setText("");
        txtAge.setText("");
        txtCaste.setText("");
        txtReligion.setText("");
        txtHouseName.setText("");
        txtCity.setText("");
        txtDistrict.setText("");
        txtState.setText("");
        txtPin.setText("");
        txtYear.setText("");
        txtQualification.setText("");
    }//clearform() closed
}//class closed
