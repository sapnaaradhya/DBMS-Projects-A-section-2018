package newpackage;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class MembersList extends JInternalFrame implements ActionListener {

    private JPanel buttonPanel;
    private JButton btnCancel,  btnRefresh;
    private JPanel rptPanel;
    private JTabbedPane listsTabs;
    private JTextArea listPane;

    public MembersList() {
        super("Users List", false, true, false, true);
        setLayout(new BorderLayout());
        setSize(500, 500);

        buttonPanel = new JPanel(new FlowLayout());
        btnRefresh = new JButton("Refresh", new ImageIcon(ClassLoader.getSystemResource("Images/update.png")));
        btnCancel = new JButton("Cancel", new ImageIcon(ClassLoader.getSystemResource("Images/cancel.png")));

        buttonPanel.add(btnRefresh);
        buttonPanel.add(btnCancel);
        btnCancel.addActionListener(this);
        btnRefresh.addActionListener(this);

        listsTabs = new JTabbedPane();
        rptPanel = new JPanel(new GridLayout(1, 1));
        rptPanel.setBackground(Color.white);
        listsTabs.add(rptPanel);

        listPane = new JTextArea();
        listPane.setEditable(false);
        listPane.setFont(new Font("monospaced", Font.BOLD, 14));
        listPane.setForeground(Color.black);
        listPane.setLineWrap(true);
        listPane.setWrapStyleWord(true);
        rptPanel.add(listPane);

        add(buttonPanel, BorderLayout.PAGE_START);
        add(listsTabs, BorderLayout.CENTER);

        printUsersList();
    }//constructor closed
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == btnCancel) {
            dispose();
        }
        if (ae.getSource() == btnRefresh) {
            printUsersList();
        }
    }

    private void printUsersList() {
        listPane.setText("");
        listPane.append("\n\t\t\tUSERS LIST");
        try {
            Statement st = Settings.getDBConnection().createStatement();
            ResultSet rs = st.executeQuery("SELECT * from UAD");
            listPane.append("\n\n");
            listPane.append("\t\tUSERNAME \t TYPE");
            listPane.append("\n\t\t------------------------");
            while (rs.next()) {
                listPane.append("\n\t\t" + rs.getString(1) + "\t\t" + rs.getString(3));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
}//class closed

