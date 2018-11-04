package newpackage;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class ViewMarkReport extends JInternalFrame implements ActionListener {

    String rollno, qualification;
    private JPanel buttonPanel;
    private JButton btnCancel,  btnView;
    private JComboBox cmbSem,  cmbType;
    private JTable table;
    private DefaultTableModel model;
    private JLabel lblstdName,  lblType;
    ResultSet rs;
    Statement st;
    String tablenme = "", type = "";

    public ViewMarkReport(String no, String qfn) {
        super("Mark List", true, true, true, true);

        setLayout(new BorderLayout());
        setSize(1000, 1000);

        qualification = qfn;
        rollno = no;
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 5));
        lblstdName = new JLabel();
        btnView = new JButton("View", new ImageIcon(ClassLoader.getSystemResource("Images/view.png")));
        btnCancel = new JButton("Cancel", new ImageIcon(ClassLoader.getSystemResource("Images/cancel.png")));
        lblType = new JLabel("Type");
        cmbType = new JComboBox();
        cmbType.addItem("COUNTING");
        cmbType.addItem("NON COUNTING");
        cmbSem = new JComboBox();
        cmbSem.addItem("Semester 1");
        cmbSem.addItem("Semester 2");
        cmbSem.addItem("Semester 3");
        cmbSem.addItem("Semester 4");
        cmbSem.addItem("Semester 5");
        if (qualification.equalsIgnoreCase("SSLC")) {
            cmbSem.addItem("Semester 6");
        }
        buttonPanel.add(lblstdName);
        buttonPanel.add(cmbSem);
        buttonPanel.add(lblType);
        buttonPanel.add(cmbType);
        buttonPanel.add(btnView);
        buttonPanel.add(btnCancel);
        btnCancel.addActionListener(this);
        btnView.addActionListener(this);

        setTable();
        add(table, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.PAGE_START);
        add(new JScrollPane(table), BorderLayout.CENTER);
        try {
            st = Settings.getDBConnection().createStatement();
            rs = st.executeQuery("SELECT SName from student WHERE RollNo=" + Integer.parseInt(rollno));
            if (rs.next()) {
                lblstdName.setText("Name of Student:" + rs.getString(1));
            }
            rs.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }


    }

    private void setTable() {

        model = new DefaultTableModel();
        table = new JTable(model);
        model.addColumn("Subject");
        model.addColumn("Code");
        model.addColumn("Internal");
        model.addColumn("Theory");
        model.addColumn("Practical");
        model.addColumn("Max.Mark");
        model.addColumn("Total");
        model.addColumn("Result");
        TableColumn col;
        for (int i = 0; i < 7; i++) {
            col = table.getColumnModel().getColumn(i);
            if (i == 0) {
                col.setPreferredWidth(250);
            }
            if (i == 1 || i == 2 || i == 3 || i == 4 || i == 5 || i == 6) {
                col.setPreferredWidth(50);
            }
        }


    }

    public void actionPerformed(ActionEvent ae) {
        ResultSet tmp = null;

        String pr = "";
        if (ae.getSource() == btnView) {
            while (table.getRowCount() > 0) {
                model.removeRow(table.getRowCount() - 1);
            }
            if (qualification.equalsIgnoreCase("SSLC")) {
                tablenme = "SSLC";
            } else {
                tablenme = "PLUSTWO";
            }
            int index = cmbSem.getSelectedIndex();
            tablenme += String.valueOf(index + 1);
            String subname, subcode, result = "";
            int internal, theory, practical, total, grandtotal;
            int maxmark = 0;
            grandtotal = 0;
            type = cmbType.getSelectedItem().toString();
            try {
                Statement st2 = Settings.getDBConnection().createStatement();
                rs = st.executeQuery("SELECT count(*) from " + tablenme + " Where RollNo=" + rollno);
                if (rs.next()) {
                    rs.close();
                    String sql = "SELECT A.SubName, A.SubCode, A.Internal, A.Theory, A.Practical, A.Total, B.MaxMark FROM " +
                            tablenme + " AS A, Subject AS B WHERE A.Subcode=B.Subjectcode and RollNo=" + rollno +
                            " and B.Type='" + type + "'";
                    rs = st.executeQuery(sql);

                    while (rs.next()) {
                        subname = rs.getString(1);
                        subcode = rs.getString(2);
                        internal = rs.getInt(3);
                        theory = rs.getInt(4);
                        practical = rs.getInt(5);
                        total = rs.getInt(6);
                        maxmark = rs.getInt(7);
                        grandtotal = grandtotal + total;
                        if (theory < 40) {
                            result = "FAILED";
                        } else {
                            sql = "SELECT Practical from Subject WHERE Subjectcode='" + subcode + "'";
                            tmp = st2.executeQuery(sql);
                            if (tmp.next()) {
                                pr = tmp.getString(1);
                            }
                            if (pr.equalsIgnoreCase("YES")) {
                                if(practical<20)
                                    result="FAILED";
                                else
                                    result="PASSED";
                            } else {
                                result = "PASSED";
                            }
                            tmp.close();
                        }
                        Object[] data = {subname, subcode, internal, theory, practical, maxmark, total, result};
                        model.addRow(data);
                    }//while closed                

                } else {
                    JOptionPane.showMessageDialog(null, "Mark details not found");
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.toString());
            }
        }
        if (ae.getSource() == btnCancel) {
            dispose();
        }
    }
}//class closed
