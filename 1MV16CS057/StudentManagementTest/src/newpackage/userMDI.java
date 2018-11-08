package newpackage;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class userMDI extends JFrame implements ActionListener {

    private JMenuBar menubar;
    private JMenu mnuView;
    private JMenuItem mnuViewStdDetails;
    private JMenuItem mnuMarkList;
    public static JDesktopPane desktop;

    public userMDI() {
        super("Student management System");
        this.setSize(Settings.getScreenSize().width, Settings.getScreenSize().height - 30);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setExtendedState(MAXIMIZED_BOTH);
        desktop = new JDesktopPane();
        menubar = new JMenuBar();

        mnuView = new JMenu("View");
        mnuViewStdDetails = new JMenuItem("Student Details");
        mnuMarkList = new JMenuItem("Mark List");
        mnuView.add(mnuMarkList);
        mnuView.add(mnuViewStdDetails);
        menubar.add(mnuView);
        
        mnuMarkList.addActionListener(this);
        mnuViewStdDetails.addActionListener(this);
        this.setJMenuBar(menubar);
        this.add(desktop);
    }//constructor closed
    public void actionPerformed(ActionEvent e) {
        try {

            if (e.getSource() == mnuMarkList) {
                viewStdMark frm = new viewStdMark();
                desktop.add(frm);
                frm.setVisible(true);
            }
            if (e.getSource() == mnuViewStdDetails) {
                User frm = new User();
                desktop.add(frm);
                frm.setVisible(true);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(new JFrame(), "Error, Cannot load window" + ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }//try catch closed
    }//actionPerformed() closed
} //class closed



