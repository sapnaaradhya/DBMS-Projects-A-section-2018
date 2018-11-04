package newpackage;
import java.awt.Container;
import java.awt.event.ActionListener;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class AddSubjects extends JInternalFrame implements ActionListener{
    private JLabel lblSubcode,lblSubName,lblCredit,lblMaxmark,lblType,lblPract;
    private JTextField txtSubcode,txtSubName,txtCredit,txtMaxmark;
    private JComboBox cmbType,cmbPract;
    private JButton btnSave,btnCancel;
    public AddSubjects(){
        super("Add Subjects",false,true,false,true);
        setSize(200,200);
        setLocation(400,200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        Container c=this.getContentPane();
        getContentPane().setLayout(new GridLayout(7,2));
        
        lblSubcode=new JLabel(" Code");
        lblSubName=new JLabel(" Name");
        lblCredit=new JLabel(" Credit");
        lblMaxmark=new JLabel(" Max.Mark");
        lblType=new JLabel(" Type");
        lblPract=new JLabel("Practical");
        txtSubcode=new JTextField();
        txtSubName=new JTextField();
        txtCredit=new JTextField();
        txtMaxmark=new JTextField();
        cmbType=new JComboBox();
        cmbPract=new JComboBox();
        cmbType.addItem("COUNTING");
        cmbType.addItem("NON COUNTING");
        cmbType.setSelectedIndex(0);
        cmbPract.addItem("YES");
        cmbPract.addItem("NO");
        cmbPract.setSelectedIndex(0);
        btnSave=new JButton("Save");
        btnCancel=new JButton("Cancel");
                
        c.add(lblSubcode);
        c.add(txtSubcode);
        c.add(lblSubName);
        c.add(txtSubName);
        c.add(lblCredit);
        c.add(txtCredit);
        c.add(lblMaxmark);
        c.add(txtMaxmark);
        c.add(lblType);
        c.add(cmbType);
        c.add(lblPract);
        c.add(cmbPract);
        c.add(btnSave);
        c.add(btnCancel);
        
        btnSave.addActionListener(this);
        btnCancel.addActionListener(this);
    }//constructor closed
    
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==btnSave){
            try{
                //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                Class.forName("com.mysql.jdbc.Driver");                
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
                String sql="INSERT INTO Subject values(?,?,?,?,?,?)";
                PreparedStatement ps=con.prepareStatement(sql);
                ps.setString(1, txtSubcode.getText());
                ps.setString(2, txtSubName.getText());
                ps.setInt(3, Integer.parseInt(txtCredit.getText()));
                ps.setInt(4, Integer.parseInt(txtMaxmark.getText()));
                ps.setString(5,cmbType.getSelectedItem().toString() );
                ps.setString(6, cmbPract.getSelectedItem().toString());
                int retval=ps.executeUpdate();
                if(retval>0){
                    JOptionPane.showMessageDialog(null, "Record successfully added to database");
                    txtCredit.setText("");
                    txtMaxmark.setText("");
                    txtSubName.setText("");
                    txtSubcode.setText("");
                    cmbType.setSelectedIndex(0);
                    cmbPract.setSelectedIndex(0);
                }
            }catch(Exception ex){
                JOptionPane.showMessageDialog(null,"Error connection not established or record already exists","Error",JOptionPane.ERROR_MESSAGE);
            }
        }else if(ae.getSource()==btnCancel){
            this.dispose();
        }
    }
}//class closed
