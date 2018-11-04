package newpackage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class frmAdminMDI extends JFrame implements ActionListener {

    private JMenuBar menubar;
    private JMenu mnuAccounts;
    private JMenu mnuStdDetails;
    private JMenu mnuView;
    private JMenu mnuOptions;
    private JMenu mnuTools;
    private JMenuItem mnuNewUser;
    private JMenuItem mnuEditUser;
    private JMenuItem mnuDeleteUser;
    private JMenuItem mnuNewReg;
    private JMenuItem mnuEditReg;
    private JMenuItem mnuDelDetails;
    private JMenuItem mnuEditMark;
    private JMenuItem mnuViewStdDetails;
    private JMenuItem mnuMemList;
    private JMenuItem mnuMarkList;
    private JMenuItem mnuAddSubs,mnuEditSubs,mnuDelSubs;
    private JMenuItem mnuSubAlloc;
    private JMenuItem mnuCalc,  mnuNotepad;
    public static JDesktopPane desktop;

    public frmAdminMDI() {
        super("Student management System");
        this.setSize(Settings.getScreenSize().width, Settings.getScreenSize().height - 30);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(ClassLoader.getSystemResource("images/appicon.png")).getImage());
        setExtendedState(MAXIMIZED_BOTH);
        desktop = new JDesktopPane();
        menubar = new JMenuBar();
        mnuAccounts = new JMenu("Accounts");
        mnuStdDetails = new JMenu("Student details");
        mnuView = new JMenu("View");
        mnuOptions=new JMenu("Options");
        mnuTools = new JMenu("Tools");

        mnuNewUser = new JMenuItem("New User");
        mnuEditUser = new JMenuItem("Edit User");
        mnuDeleteUser = new JMenuItem("Delete User");
        mnuNewReg = new JMenuItem("New Registration");
        mnuEditReg = new JMenuItem("Edit Registration");
        mnuDelDetails = new JMenuItem("Delete Details");
        mnuEditMark = new JMenuItem("Edit Mark");
        mnuViewStdDetails = new JMenuItem("Student Details");
        mnuMemList = new JMenuItem("Member List");
        mnuMarkList = new JMenuItem("Mark List");
        mnuAddSubs=new JMenuItem("Add Subjects");
        mnuEditSubs=new JMenuItem("Edit Subjects");
        mnuDelSubs=new JMenuItem("Delete Subjects");
        mnuSubAlloc=new JMenuItem("Subject Allocation");
        mnuNotepad = new JMenuItem("Calculator");
        mnuCalc = new JMenuItem("Calculator");

        mnuAccounts.add(mnuNewUser);
        mnuNewUser.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2, KeyEvent.ALT_MASK));
        mnuNewUser.setIcon(new ImageIcon(ClassLoader.getSystemResource("images/user.png")));
        mnuAccounts.add(mnuEditUser);
        mnuEditUser.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F3, KeyEvent.ALT_MASK));
        mnuEditUser.setIcon(new ImageIcon(ClassLoader.getSystemResource("images/editusr.png")));
        mnuAccounts.addSeparator();
        mnuAccounts.add(mnuDeleteUser);
        mnuDeleteUser.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, KeyEvent.ALT_MASK));
        mnuDeleteUser.setIcon(new ImageIcon(ClassLoader.getSystemResource("images/delusr.png")));
        mnuStdDetails.add(mnuNewReg);
        mnuNewReg.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_MASK));
        mnuNewReg.setIcon(new ImageIcon(ClassLoader.getSystemResource("images/newreg.png")));
        mnuStdDetails.add(mnuEditReg);
        mnuEditReg.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, KeyEvent.CTRL_MASK));
        mnuEditReg.setIcon(new ImageIcon(ClassLoader.getSystemResource("images/editreg.png")));
        mnuStdDetails.add(mnuDelDetails);
        mnuDelDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, KeyEvent.CTRL_MASK));
        mnuDelDetails.setIcon(new ImageIcon(ClassLoader.getSystemResource("images/delreg.png")));
        mnuStdDetails.addSeparator();
        mnuStdDetails.add(mnuEditMark);
        mnuEditMark.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, KeyEvent.CTRL_MASK));
        mnuEditMark.setIcon(new ImageIcon(ClassLoader.getSystemResource("images/editmark.png")));
        mnuView.add(mnuMarkList);
        mnuMarkList.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.CTRL_MASK));
        mnuMarkList.setIcon(new ImageIcon(ClassLoader.getSystemResource("images/marklist.png")));
        mnuView.add(mnuMemList);
        mnuMemList.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_MASK));
        mnuMemList.setIcon(new ImageIcon(ClassLoader.getSystemResource("images/memlist.png")));
        mnuView.add(mnuViewStdDetails);
        mnuViewStdDetails.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, KeyEvent.CTRL_MASK));
        mnuViewStdDetails.setIcon(new ImageIcon(ClassLoader.getSystemResource("images/stddet.png")));
        mnuOptions.add(mnuAddSubs);
        mnuOptions.add(mnuEditSubs);
        mnuOptions.add(mnuDelSubs);
        mnuOptions.addSeparator();
        mnuOptions.add(mnuSubAlloc);        
        mnuTools.add(mnuCalc);
        mnuCalc.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_MASK));
        mnuCalc.setIcon(new ImageIcon(ClassLoader.getSystemResource("images/calc.png")));
        mnuTools.add(mnuNotepad);
        mnuNotepad.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, KeyEvent.CTRL_MASK));
        mnuNotepad.setIcon(new ImageIcon(ClassLoader.getSystemResource("images/notepad.png")));


        menubar.add(mnuAccounts);
        menubar.add(mnuStdDetails);
        menubar.add(mnuView);
        menubar.add(mnuOptions);
        menubar.add(mnuTools);
        mnuNewUser.addActionListener(this);
        mnuEditUser.addActionListener(this);
        mnuDeleteUser.addActionListener(this);
        mnuNewReg.addActionListener(this);
        mnuEditReg.addActionListener(this);
        mnuDelDetails.addActionListener(this);
        mnuEditMark.addActionListener(this);
        mnuMarkList.addActionListener(this);
        mnuMemList.addActionListener(this);
        mnuViewStdDetails.addActionListener(this);
        mnuAddSubs.addActionListener(this);
        mnuEditSubs.addActionListener(this);
        mnuDelSubs.addActionListener(this);
        mnuSubAlloc.addActionListener(this);
        mnuCalc.addActionListener(this);        
        mnuNotepad.addActionListener(this);
        this.setJMenuBar(menubar);
        this.add(desktop);
    }//constructor closed
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == mnuNewUser) {
                NewUserReg frm = new NewUserReg();
                desktop.add(frm);
                frm.setVisible(true);
            }
            if (e.getSource() == mnuEditUser) {
                Edituser frm = new Edituser();
                desktop.add(frm);
                frm.setVisible(true);
            }
            if (e.getSource() == mnuDeleteUser) {
                Deleteuser frm = new Deleteuser();
                desktop.add(frm);
                frm.setVisible(true);
            }
            if (e.getSource() == mnuNewReg) {
                NewStdReg frm = new NewStdReg();
                desktop.add(frm);
                frm.setVisible(true);
            }
            if (e.getSource() == mnuEditReg) {
                EditStdReg frm = new EditStdReg();
                desktop.add(frm);
                frm.setVisible(true);

            }
            if (e.getSource() == mnuDelDetails) {
                Deletedetails frm = new Deletedetails();
                desktop.add(frm);
                frm.setVisible(true);
            }
            if (e.getSource() == mnuMarkList) {
                viewMark frm = new viewMark();
                desktop.add(frm);
                frm.setVisible(true);
            }
            if (e.getSource() == mnuEditMark) {
                EditMark frm = new EditMark();
                desktop.add(frm);
                frm.setVisible(true);
            }
            if (e.getSource() == mnuCalc) {
                Runtime.getRuntime().exec("calc.exe");
            }
            if (e.getSource() == mnuNotepad) {
                Runtime.getRuntime().exec("notepad.exe");
            }
            if (e.getSource() == mnuMemList) {
                MembersList frm = new MembersList();
                desktop.add(frm);
                frm.setVisible(true);
            }
            if (e.getSource() == mnuViewStdDetails) {
                User frm = new User();
                desktop.add(frm);
                frm.setVisible(true);
            }
            if(e.getSource()==mnuAddSubs){
                AddSubjects frm=new AddSubjects();
                desktop.add(frm);
                frm.setVisible(true);
            }
            if(e.getSource()==mnuEditSubs){
                EditSubjects frm=new EditSubjects();
                desktop.add(frm);
                frm.setVisible(true);
            }
             if(e.getSource()==mnuDelSubs){
                DelSubjects frm=new DelSubjects();
                desktop.add(frm);
                frm.setVisible(true);
            }
            if(e.getSource()==mnuSubAlloc){
                SubjectAllocation frm=new SubjectAllocation();
                desktop.add(frm);
                frm.setVisible(true);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Error, Cannot load window" + ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }//try catch closed
    }//actionPerformed() closed
} //class closed

