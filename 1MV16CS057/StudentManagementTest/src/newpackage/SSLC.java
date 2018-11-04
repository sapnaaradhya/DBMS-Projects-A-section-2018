package newpackage;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class SSLC extends JInternalFrame implements ActionListener {

    private Container c;
    private JButton btnClose;
    private JButton btnSave;
    private int rollno;
    private JPanel btnPanel,  txtPanel;
    private JTable table;
    private DefaultTableModel model;
    private JComboBox cmbSubjects;
    private JLabel lblSubName,  lblCode,  lblInternal,  lblTheory,  lblPractical;
    private JTextField txtCode,  txtInternal,  txtTheory,  txtPractical,  txtTotal;
    private TableColumn col;
    private JButton btnAdd,  btnDel;
    private int semester;
    private String tablename = "";

    public SSLC(String rno, String title, int semno) {

        super(title, false, true, false, true);
        rollno = Integer.parseInt(rno);
        semester = semno;
        setSize(800, 470);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        c = this.getContentPane();
        setLayout(new BorderLayout(2, 2));

        btnSave = new JButton("Save", new ImageIcon(ClassLoader.getSystemResource("Images/save.png")));
        btnClose = new JButton("close", new ImageIcon(ClassLoader.getSystemResource("Images/cancel.png")));
        btnPanel = new JPanel(new FlowLayout());
        btnPanel.add(btnSave);
        btnPanel.add(btnClose);

        c.add(btnPanel, BorderLayout.SOUTH);

        txtPanel = new JPanel(new FlowLayout());
        lblSubName = new JLabel("Subject");
        cmbSubjects = new JComboBox();
        lblCode = new JLabel("Code");
        txtCode = new JTextField(3);
        lblInternal = new JLabel("Internal");
        txtInternal = new JTextField(3);
        lblTheory = new JLabel("Theory");
        txtTheory = new JTextField(3);
        lblPractical = new JLabel("Practical");
        txtPractical = new JTextField(3);
        btnAdd = new JButton("Add");
        btnDel = new JButton("Delete");
        txtCode.setEditable(false);

        txtPanel.add(lblSubName);
        txtPanel.add(cmbSubjects);
        txtPanel.add(lblCode);
        txtPanel.add(txtCode);
        txtPanel.add(lblInternal);
        txtPanel.add(txtInternal);
        txtPanel.add(lblTheory);
        txtPanel.add(txtTheory);
        txtPanel.add(lblPractical);
        txtPanel.add(txtPractical);
        txtPanel.add(btnAdd);
        txtPanel.add(btnDel);
        c.add(txtPanel, BorderLayout.NORTH);
        setTableName();
        setTable();
        loadMarkDetails();
        loadSubjectNames();
        showSubjectDetails();
        btnSave.addActionListener(this);
        btnClose.addActionListener(this);
        btnAdd.addActionListener(this);
        btnDel.addActionListener(this);
        cmbSubjects.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnClose) {
            setVisible(false);
        }
        if (e.getSource() == btnSave) {
            try {
                Connection con = Settings.getDBConnection();
                Statement st;
                PreparedStatement ps = null;
                String subname, subcode, sql;
                int internal, theory, practical, total;
                int rows = table.getRowCount();
                sql = "DELETE FROM " + tablename + " WHERE RollNo=" + rollno;
                st = con.createStatement();
                st.execute(sql);
                sql = "insert into " + tablename + " values(?,?,?,?,?,?,?)";
                ps = con.prepareStatement(sql);
                if (rows > 0) {
                    for (int i = 0; i < rows; i++) {
                        subname = model.getValueAt(i, 0).toString();
                        subcode = model.getValueAt(i, 1).toString();
                        internal = Integer.parseInt(model.getValueAt(i, 2).toString());
                        theory = Integer.parseInt(model.getValueAt(i, 3).toString());
                        practical = Integer.parseInt(model.getValueAt(i, 4).toString());
                        total = Integer.parseInt(model.getValueAt(i, 5).toString());
                        ps.setInt(1, rollno);
                        ps.setString(2, subname);
                        ps.setString(3, subcode);
                        ps.setInt(4, internal);
                        ps.setInt(5, theory);
                        ps.setInt(6, practical);
                        ps.setInt(7, total);
                        ps.addBatch();
                    }
                    ps.executeBatch();
                    con.commit();
                    JOptionPane.showMessageDialog(null, "Data successfully inserted", "Success", JOptionPane.INFORMATION_MESSAGE);
                    con.close();
                    dispose();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Error:" + ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if (e.getSource() == btnAdd) {
            int internal, theory, practical, total;
            String code;
            if (cmbSubjects.getItemCount() > 0) {
                String sub = cmbSubjects.getSelectedItem().toString();
                if (txtCode.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "Subject code empty,Select a subject");
                    return;
                } else {
                    code = txtCode.getText();
                }
                if (txtInternal.getText().equals("")) {
                    internal = 0;
                } else {
                    internal = Integer.parseInt(txtInternal.getText());
                }
                if (txtTheory.getText().equals("")) {
                    theory = 0;
                } else {
                    theory = Integer.parseInt(txtTheory.getText());
                }
                if (txtPractical.getText().equals("")) {
                    practical = 0;
                } else {
                    practical = Integer.parseInt(txtPractical.getText());
                }
                total = internal + theory + practical;
                if (!isValidRowData()) {
                    return;
                }
                Object[] data = {sub, code, internal, theory, practical, total};
                model.addRow(data);
                txtTheory.setText("");
                txtPractical.setText("");
                cmbSubjects.setSelectedIndex(0);
            }
        }
        if (e.getSource() == btnDel) {
            int row = table.getSelectedRow();
            if (row >= 0) {
                model.removeRow(row);
            }
        }
        if (e.getSource() == cmbSubjects) {
            showSubjectDetails();
        }
    }//actionPerformed() closed

    private void showSubjectDetails() {
        try {
            if (cmbSubjects.getItemCount() > 0) {
                String sub = cmbSubjects.getSelectedItem().toString();
                Connection con = Settings.getDBConnection();
                String sql = "Select Subjectcode,CreditMark from Subject where SubjectName='" + sub + "'";
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
                if (rs.next()) {
                    txtCode.setText(rs.getString(1));
                    txtInternal.setText(String.valueOf(rs.getInt(2)));
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }

    private void setTable() {
        model = new DefaultTableModel();
        model.addColumn("Subject");
        model.addColumn("Code");
        model.addColumn("Internal");
        model.addColumn("Theory");
        model.addColumn("Practical");
        model.addColumn("Total Mark");

        table = new JTable(model) {

            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;   //Disallow the editing of any cell

            }
        };
        col = table.getColumnModel().getColumn(0);
        col.setPreferredWidth(200);
        col = table.getColumnModel().getColumn(1);
        col.setPreferredWidth(50);
        c.add(new JScrollPane(table), BorderLayout.CENTER);
    }

    private void loadSubjectNames() {
        try {
            String sql = "Select SubjectName from SubjectAllocation where Semester=" + semester + " and Batch='SSLC'";
            Connection con = Settings.getDBConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cmbSubjects.addItem(rs.getString(1));
            }
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Erron on loading subject names" + ex.toString());
        }

    }

    private boolean isValidRowData() {
        int rows = table.getRowCount();
        String sub;
        if (rows >= 1) {
            for (int i = 0; i < rows; i++) {
                sub = model.getValueAt(i, 0).toString();
                if (sub.equals(cmbSubjects.getSelectedItem().toString())) {
                    JOptionPane.showMessageDialog(null, "This subject is already entered");
                    return false;
                }
            }
        }//if closed

        return true;
    }

    private void setTableName() {
        switch (semester) {
            case 1:
                tablename = "SSLC1";
                break;
            case 2:
                tablename = "SSLC2";
                break;
            case 3:
                tablename = "SSLC3";
                break;
            case 4:
                tablename = "SSLC4";
                break;
            case 5:
                tablename = "SSLC5";
                break;
            case 6:
                tablename = "SSLC6";
                break;
        }
    }

    private void loadMarkDetails() {
        try {
            String sql = "SELECT * FROM " + tablename + " WHERE RollNo=?";
            String name, code;
            int internal, theory, practical, total;
            Connection con = Settings.getDBConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, rollno);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                name = rs.getString(2);
                code = rs.getString(3);
                internal = rs.getInt(4);
                theory = rs.getInt(5);
                practical = rs.getInt(6);
                total = rs.getInt(7);
                Object[] data = {name, code, internal, theory, practical, total};
                model.addRow(data);
            }
            con.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error on loading mark details");
        }
    }
}//class closed
