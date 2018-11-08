package newpackage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class viewMark extends JInternalFrame implements ActionListener {

    JLabel jlreno;
    JButton btnMark = new JButton("Marks");
    private JComboBox cmbregno = new JComboBox();

    public viewMark() {

        super("View Marks", false, true, false, true);
        jlreno = new JLabel("Register no");

        setBounds(350, 200, 300, 200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(null);
        jlreno.setBounds(30, 30, 100, 30);
        cmbregno.setBounds(120, 30, 130, 25);
        btnMark.setBounds(100, 100, 100, 30);
        add(jlreno);
        add(cmbregno);
        add(btnMark);

        btnMark.addActionListener(this);
        try {
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //Connection con = DriverManager.getConnection("jdbc:odbc:student");
            Class.forName("com.mysql.jdbc.Driver");                
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select RollNo from student");
            cmbregno.removeAllItems();
            while (rs.next()) {
                cmbregno.addItem(rs.getString(1));
            }
        } catch (Exception ee) {
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnMark) {
            String regno = (String) cmbregno.getSelectedItem();
            String qlfn;
            try {
                Statement st = Settings.getDBConnection().createStatement();
                int rno = Integer.parseInt(regno);
                ResultSet rs = st.executeQuery("SELECT Qualification from student Where Rollno= " + rno);
                if (rs.next()) {
                    qlfn = rs.getString(1);
                    ViewMarkReport frm = new ViewMarkReport(regno, qlfn);
                    frmAdminMDI.desktop.add(frm);
                    frm.setVisible(true);
                    dispose();
                }
                MarkS frm = new MarkS(regno);
                frm.setVisible(true);
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error on Loading report", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}//class closed
       
    


