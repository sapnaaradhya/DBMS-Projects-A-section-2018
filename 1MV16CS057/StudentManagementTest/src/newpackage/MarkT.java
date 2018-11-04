package newpackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JToolBar;

public class MarkT extends JInternalFrame implements ActionListener {

    JButton jb1 = new JButton("Semester1");
    JButton jb2 = new JButton("Semester2");
    JButton jb3 = new JButton("Semester3");
    JButton jb4 = new JButton("Semester4");
    JButton jb5 = new JButton("Semester5");
    JButton jbc = new JButton("Close");
    String regno;

    public MarkT(String reg) {
        super("MARKS OF PLUS TWO BATCH",false,true,false,true);
        regno = reg;
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setBounds(150, 100, 500, 200);
        setLayout(null);

        JLabel jlr = new JLabel("Edit Marks of Student with Regno : " + regno);
        JToolBar jtb = new JToolBar();        
        jtb.setBounds(0, 0, 700, 30);                           
        add(jtb);
        jtb.add(jb1);
        jtb.add(jb2);
        jtb.add(jb3);
        jtb.add(jb4);
        jtb.add(jb5);
        
        jlr.setBounds(50, 35,500,25);
        jbc.setBounds(150, 100, 80, 30);
        add(jlr);        
        add(jbc);
        
        jb1.addActionListener(this);        
        jb2.addActionListener(this);        
        jb3.addActionListener(this);        
        jb4.addActionListener(this);        
        jb5.addActionListener(this);                
        jbc.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == jb1) {
            PLUSTWO ps = new PLUSTWO(regno,"First Semester marks",1);
            frmAdminMDI.desktop.add(ps);
            ps.setVisible(true);
        }
        if (e.getSource() == jb2) {
            PLUSTWO ps = new PLUSTWO(regno,"Second Semester marks",2);
            frmAdminMDI.desktop.add(ps);
            ps.setVisible(true);
        }
        if (e.getSource() == jb3) {
            PLUSTWO ps = new PLUSTWO(regno,"Third Semester marks",3);
            frmAdminMDI.desktop.add(ps);
            ps.setVisible(true);
        }
        if (e.getSource() == jb4) {
            PLUSTWO ps = new PLUSTWO(regno,"Fourth Semester marks",4);
            frmAdminMDI.desktop.add(ps);
            ps.setVisible(true);
        }
        if (e.getSource() == jb5) {
            PLUSTWO ps = new PLUSTWO(regno,"Fifth Semester marks",5);
            frmAdminMDI.desktop.add(ps);
            ps.setVisible(true);
        }
        if (e.getSource() == jbc) {
            dispose();
        }

    }
}
    
