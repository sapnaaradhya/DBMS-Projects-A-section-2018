package newpackage;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;

public class MarkS extends JInternalFrame implements ActionListener {

    Container c = getContentPane();
    int rno;
    JButton jbc = new JButton("Close");
    JButton jb1 = new JButton("Semester1");
    JButton jb2 = new JButton("Semester2");
    JButton jb3 = new JButton("Semester3");
    JButton jb4 = new JButton("Semester4");
    JButton jb5 = new JButton("Semester5");
    JButton jb6 = new JButton("Semester6");
    String regn;

    public MarkS(String reg) {
        super("MARKS OF SSLC BATCH", false, true, false, true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(150, 100, 500, 200);
        setLayout(null);
        regn = reg;

        JLabel jlr = new JLabel("Edit Marks of Student with Regno : " + regn);
        JToolBar jtb = new JToolBar();
        jtb.setBounds(0, 0, 700, 30);

        add(jtb);
        jtb.add(jb1);
        jtb.add(jb2);
        jtb.add(jb3);
        jtb.add(jb4);
        jtb.add(jb5);
        jtb.add(jb6);
        jlr.setBounds(50, 35, 500, 25);
        jbc.setBounds(150, 100, 80, 30);
        add(jlr);
        add(jbc);

        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);
        jb5.addActionListener(this);
        jb6.addActionListener(this);
        jbc.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb1) {
            SSLC frm = new SSLC(regn,"First Semester marks",1);
            frmAdminMDI.desktop.add(frm);
            frm.setVisible(true);
        }
        if (e.getSource() == jb2) {
            SSLC frm = new SSLC(regn,"Second Semester marks",2);
            frmAdminMDI.desktop.add(frm);
            frm.setVisible(true);
        }
        if (e.getSource() == jb3) {
            SSLC frm = new SSLC(regn,"Third Semester marks",3);
            frmAdminMDI.desktop.add(frm);
            frm.setVisible(true);
        }
        if (e.getSource() == jb4) {
            SSLC frm = new SSLC(regn,"Forth Semester marks",4);
            frmAdminMDI.desktop.add(frm);
            frm.setVisible(true);
        }
        if (e.getSource() == jb5) {
            SSLC frm = new SSLC(regn,"Fifth Semester marks",5);
            frmAdminMDI.desktop.add(frm);
            frm.setVisible(true);
        }
        if (e.getSource() == jb6) {
            SSLC frm = new SSLC(regn,"Sixth Semester marks",6);
            frmAdminMDI.desktop.add(frm);
            frm.setVisible(true);
        }
        if (e.getSource() == jbc) {
            dispose();
        }
    }
}


