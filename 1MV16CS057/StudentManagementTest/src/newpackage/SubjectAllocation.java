package newpackage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class SubjectAllocation extends JInternalFrame implements ActionListener {

    private JLabel lblCourse,  lblSem,  lblSubject;
    private JComboBox cmbSem,  cmbSubect,  cmbCourse;
    private JButton btnSave,  btnDelete;
    private JTable subjtable;
    private JPanel panel;
    String tableheading = "subject";
    DefaultTableModel tablemodel;

    public SubjectAllocation() {
        super("Subject Allocation", false, true, false, true);
        setSize(700, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new BorderLayout(2, 2));
        Container c = getContentPane();

        lblCourse = new JLabel("Batch");
        lblSem = new JLabel("Semester");
        lblSubject = new JLabel("Subjects");
        cmbSem = new JComboBox();
        cmbSubect = new JComboBox();
        cmbCourse = new JComboBox();
        btnSave = new JButton("Add");
        btnDelete = new JButton("Delete");
        cmbCourse.addItem("SSLC");
        cmbCourse.addItem("PLUS TWO");

        tablemodel = new DefaultTableModel();
        tablemodel.addColumn(tableheading);
        subjtable = new JTable(tablemodel) {

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell

            }
        };

        JTableHeader header = subjtable.getTableHeader();
        header.setBackground(Color.LIGHT_GRAY);

        panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 5, 5));
        panel.add(lblCourse);
        panel.add(cmbCourse);
        panel.add(lblSem);
        panel.add(cmbSem);
        panel.add(lblSubject);
        panel.add(cmbSubect);
        panel.add(btnSave);
        panel.add(btnDelete);

        cmbSem.addActionListener(this);
        cmbCourse.addActionListener(this);
        btnSave.addActionListener(this);
        btnDelete.addActionListener(this);
        c.add(panel, BorderLayout.NORTH);
        c.add(new JScrollPane(subjtable), BorderLayout.CENTER);
        loadCombovalues();
    }

    private void loadCombovalues() {
        cmbSubect.removeAllItems();
        cmbSem.addItem("1");
        cmbSem.addItem("2");
        cmbSem.addItem("3");
        cmbSem.addItem("4");
        cmbSem.addItem("5");
        cmbSem.addItem("6");

        try {
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //Connection con = DriverManager.getConnection("jdbc:odbc:student");
            Class.forName("com.mysql.jdbc.Driver");                
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
            String sql = "SELECT  Subjectname FROM Subject";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cmbSubect.addItem(rs.getString(1));
            }
            con.close();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == cmbSem || ae.getSource() == cmbCourse) {
            loadTableValues();
        }//if closed

        if (ae.getSource() == btnSave) {
            int sem = Integer.parseInt(cmbSem.getSelectedItem().toString());
            String batch = cmbCourse.getSelectedItem().toString();
            String subject = cmbSubect.getSelectedItem().toString();
            String sql;
            PreparedStatement ps;
            try {
                //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                //Connection con = DriverManager.getConnection("jdbc:odbc:student");
                Class.forName("com.mysql.jdbc.Driver");                
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
                sql = "SELECT SubjectName FROM SubjectAllocation WHERE Batch=? AND Semester= ? AND SubjectName=?";
                ps = con.prepareStatement(sql);
                ps.setString(1, batch);
                ps.setInt(2, sem);
                ps.setString(3, subject);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "This subject is alredy allocated to this Semester for thi batch");
                    con.close();
                    return;
                }
                sql = "INSERT INTO SubjectAllocation VALUES(?,?,?)";
                ps = con.prepareStatement(sql);
                ps.setString(1, subject);
                ps.setInt(2, sem);
                ps.setString(3, batch);
                int retval = ps.executeUpdate();
                if (retval > 0) {
                }
                con.close();
                loadTableValues();
            } catch (Exception ex) {
                System.out.println(ex.toString());
            }
        }
        if (ae.getSource() == btnDelete) {
            int row = subjtable.getSelectedRow();
            String sql;
            PreparedStatement ps;
            if (row >= 0) {
                String sub = tablemodel.getValueAt(row, 0).toString();
                int sem = Integer.parseInt(cmbSem.getSelectedItem().toString());
                String batch = cmbCourse.getSelectedItem().toString();
                int retval = JOptionPane.showConfirmDialog(null, "Do you really want to delete the Subject?", "Confirm", JOptionPane.YES_NO_OPTION);
                if (retval == JOptionPane.YES_OPTION) {
                    try {
                        //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                        //Connection con = DriverManager.getConnection("jdbc:odbc:student");
                        Class.forName("com.mysql.jdbc.Driver");                
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
                        sql = "DELETE FROM SubjectAllocation WHERE Batch=? AND Semester= ? AND SubjectName=?";
                        ps = con.prepareStatement(sql);
                        ps.setString(1, batch);
                        ps.setInt(2, sem);
                        ps.setString(3, sub);
                        int val = ps.executeUpdate();
                        con.close();
                        loadTableValues();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, ex.toString() + "Unable to delete the value");
                    }
                }//if closed

            }//outer if closed

        }//action if closed

    }//actionPerformed() clsoed

    private void loadTableValues() {
        while (subjtable.getRowCount() > 0) {
            tablemodel.removeRow(subjtable.getRowCount() - 1);
        }
        int sem = Integer.parseInt(cmbSem.getSelectedItem().toString());
        String batch = cmbCourse.getSelectedItem().toString();
        try {
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            //Connection con = DriverManager.getConnection("jdbc:odbc:student");
            Class.forName("com.mysql.jdbc.Driver");                
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
            String sql = "SELECT SubjectName FROM SubjectAllocation WHERE Batch='" +
                    batch + "' and Semester= " + sem;
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String str = rs.getString(1);
                String[] data = {str};
                tablemodel.addRow(data);
            }
            con.close();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
    }
}//class closed


