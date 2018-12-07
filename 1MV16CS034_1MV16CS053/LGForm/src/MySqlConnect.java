/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Suma
 */
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class MySqlConnect {

    public Connection con = null;

    public MySqlConnect() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lgform", "root", "konda");
            //JOptionPane.showMessageDialog(null,"Connected to Database");
        } catch (Exception ex) {

        }

    }

    public ResultSet verify(String uName, String pass) throws SQLException {

        String Sql = "Select * from login where Username=? and Password=?;";
        PreparedStatement pat = con.prepareStatement(Sql);
        pat.setString(1, uName);
        pat.setString(2, pass);
        ResultSet rs = pat.executeQuery();
        
        return rs;

    }

    public ResultSet displayStudents()
    {
             ResultSet rs=null;
        try{
        String Sql = "Select s.usn,s.student_name from student s, StaffLogin f where f.username=?";
         PreparedStatement pat = con.prepareStatement(Sql);
         rs=pat.executeQuery();
         
        }
        catch(Exception e)
        {
            
        }
        return rs;
    }
    /**
     *
     * @return @throws SQLException
     */
    public int createTableStaffLogin() throws SQLException {
        
        String sql="CREATE TABLE IF NOT EXISTS Login(\n" +
"                 NAME VARCHAR(25) NOT NULL,\n" +
"                 EMAIL VARCHAR(25) NOT NULL,\n" +
"                 DEPARTMET VARCHAR(20) NOT NULL,\n" +
"                 USERNAME VARCHAR(20),\n" +
"                 PASSWORD VARCHAR(20) NOT NULL,\n" +
"                 CONSTRAINT PK_ID PRIMARY KEY(USERNAME)\n" +
"                );";

        Statement st = con.createStatement();
        
        return st.executeUpdate(sql);
    }

   /* public boolean createTableSubject() throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS SUBJECT(\n"
                + "SUBJECT_CODE VARCHAR(5) NOT NULL,\n"
                + "SUBJECT_NAME VARCHAR(20) NOT NULL,\n"
                + "CONSTRAINT PK_SUB PRIMARY KEY(SUBJECT_CODE)"
                + ");";

        Statement st = con.createStatement();

        return st.execute(sql);
    }*/

    public boolean createTableStudent() throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS STUDENT(\n" +
"                STUDENT_NAME VARCHAR(10) NOT NULL,\n" +
"                USN VARCHAR(10),\n" +
"                BRANCH_NAME VARCHAR(99) NOT NULL,\n" +
"                DOB DATE NOT NULL,\n" +
"                EMAIL VARCHAR(25) NOT NULL,\n" +
"                PHONE_NO INT(60) NOT NULL,\n" +
"                LOCAL_GUARDIAN_NAME VARCHAR(10) NOT NULL, \n"+
"                ADDRESS VARCHAR(99) NOT NULL,\n" +
"                STAY_TYPE VARCHAR(15) NOT NULL,\n" +
"                BLOOD_GROUP VARCHAR(15) NOT NULL,\n" +
"                HOBBIES VARCHAR(10) NOT NULL,\n" +
"                ADMISSION_CATEGORY VARCHAR(10) NOT NULL,\n" +
"                FATHER_NAME VARCHAR(20) NOT NULL,\n" +
"                FATHER_NO INT(60) NOT NULL,\n" +
"                MOTHER_NAME VARCHAR(20) NOT NULL,\n" +
"                MOTHER_NO INT(60) NOT NULL,\n" +
"                CONSTRAINT PK_STU PRIMARY KEY(USN)\n" +
"                );";
        Statement st = con.createStatement();
        return st.execute(sql);

    }

    public boolean createTableSemester() throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS SEMESTER(\n"
                + "SEM INT(1) ,\n"
                + "USN VARCHAR(10) NOT NULL,\n"
                + "SGPA FLOAT(5) NOT NULL,\n"
                + "BACKLOGS INT(2) NOT NULL,\n"
                //+ "CONSTRAINT PK_SEMm PRIMARY KEY(SEM),\n"
                + "CONSTRAINT FK_Ss FOREIGN KEY(USN) REFERENCES STUDENT(USN) ON DELETE CASCADE"
                + ");";

        Statement st = con.createStatement();
        return st.execute(sql);
    }

    public boolean createTableMarks() throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS MARKS(\n"
                + "USN VARCHAR(10) NOT NULL,\n"
                + "SUBJECT_CODE VARCHAR(5) NOT NULL,\n"
                + "SEM INT(1)  NULL,\n"
                + "IA1 INT(2)  NULL,\n"
                + "AT1 INT(2)  NULL,\n"
                + "IA2 INT(2)  NULL,\n"
                + "AT2 INT(2)  NULL,\n"
                + "IA3 INT(2)  NULL,\n"
                + "AT3 INT(2)  NULL,\n"
                + "AVERAGE INT(10)  NULL,\n"
                + "CONSTRAINT FK_M FOREIGN KEY(USN) REFERENCES STUDENT(USN) ON DELETE CASCADE,\n"
                //+ "CONSTRAINT FK_A PRIMARY KEY(SUBJECT_CODE)"
                //+ "CONSTRAINT FK_R FOREIGN KEY(SEM) REFERENCES SEMESTER(SEM) ON DELETE CASCADE"
                + ");";

        Statement st = con.createStatement();
        return st.execute(sql);
    }

   /* public boolean creteTableCounseling() throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS COUNSELING(\n"
                + "SEM INT(1) NOT NULL,\n"
                + "USN VARCHAR(10) NOT NULL,\n"
                + "COUNSELING_ID INT(1) NOT NULL,\n"
                + "CONSTRAINT PK_C PRIMARY KEY(COUNSELING_ID),\n"
                + "CONSTRAINT FK_O FOREIGN KEY(SEM) REFERENCES SEMESTER(SEM) ON DELETE CASCADE,\n"
                + "CONSTRAINT FK_U FOREIGN KEY(USN) REFERENCES STUDENT(USN) ON DELETE CASCADE"
                + ");";

        Statement st = con.createStatement();
        return st.execute(sql);
    }*/

   /* public boolean createTableActivities() throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS ACTIVITIES(\n"
                + "SEM INT(1) NOT NULL,\n"
                + "USN VARCHAR(10) NOT NULL,\n"
                + "ACTIVITIES_ID INT(1) NOT NULL,\n"
                + "CONSTRAINT PK_Z PRIMARY KEY(ACTIVITIES_ID),\n"
                + "CONSTRAINT FK_W FOREIGN KEY(SEM) REFERENCES SEMESTER(SEM) ON DELETE CASCADE,\n"
                + "CONSTRAINT FK_X FOREIGN KEY(USN) REFERENCES STUDENT(USN) ON DELETE CASCADE"
                + ");";

        Statement st = con.createStatement();
        return st.execute(sql);
    }*/

    public boolean createTableCounseling_details() throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS COUNSELING_DETAILS(\n"
                + "SEM INT(1) NOT NULL,\n"
                + "USN VARCHAR(10) NOT NULL,\n"
                + "COUNSELING_ID INT(1) NOT NULL,\n"
                + "DATE DATE NOT NULL,\n"
                + "ISSUE VARCHAR(99) NOT NULL,\n"
                + "REMARKS VARCHAR(99) NOT NULL,\n"
                //+ "CONSTRAINT PK_C PRIMARY KEY(COUNSELING_ID),\n"
                + "CONSTRAINT JFK_CD FOREIGN KEY(USN) REFERENCES STUDENT(USN) ON DELETE CASCADE"
                + ");";

        Statement st = con.createStatement();
        return st.execute(sql);

    }

    public boolean createTableACTIVITIES_details() throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS ACTIVITIES_DETAILS(\n"
                + "ACTIVITIES_ID INT(1) NOT NULL,\n"
                + "SEM INT(1) NOT NULL,\n"
                + "USN VARCHAR(10) NOT NULL,\n"
                + "DATE DATE NOT NULL,\n"
                + "DETAILS VARCHAR(99) NOT NULL,\n"
                + "PLACE VARCHAR(99) NOT NULL,\n"
                + "CONSTRAINT FLK_MD FOREIGN KEY(USN) REFERENCES STUDENT(USN) ON DELETE CASCADE\n"
                //+ "CONSTRAINT FK_PD FOREIGN KEY(SEM) REFERENCES SEMESTER(SEM) ON DELETE CASCADE"
                + ");";

        Statement st = con.createStatement();
        return st.execute(sql);

    }

    public int insertIntoStaffLogin(String name, String email, String department, String username, String password) throws SQLException {
        String query = "insert into Login values(?,?,?,?,?)";
        PreparedStatement st = con.prepareStatement(query);

        st.setString(1, name);
        st.setString(2, email);
        st.setString(3, department);
        st.setString(4, username);
        st.setString(5, password);

        int n = st.executeUpdate();

        return n;
    }

    public int insertIntoStudent(String student_name, String usn, String branch_name, String dob, String email, String phone_no, String local_guardian_name, String address, String stay_type, String blood_group, String hobbies, String admission_category, String father_name, String father_no, String mother_name, String mother_no) throws SQLException {
        String query = "insert into Student values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement st = con.prepareStatement(query);

        st.setString(1, student_name);
        st.setString(2, usn);
        st.setString(3, branch_name);
        st.setString(4, dob);
        st.setString(5, email);
        st.setString(6, phone_no);
        st.setString(7, local_guardian_name );
        st.setString(8, address);
        st.setString(9, stay_type);
        st.setString(10, blood_group);
        st.setString(11, hobbies);
        st.setString(12, admission_category);
        st.setString(13, father_name);
        st.setString(14, father_no);
        st.setString(15, mother_name);
        st.setString(16, mother_no);

        int n = st.executeUpdate();

        return n;
    }
    
    public ResultSet getStudentDetails(String usn) throws SQLException{
        
        String sql = "SELECT * FROM STUDENT WHERE USN=?";
        PreparedStatement pst = con.prepareStatement(sql);
        
        pst.setString(1, usn);
        
        return pst.executeQuery();
        
    }

    public int insertIntoSubject(String subject_code, String subject_name) throws SQLException {
        String query = "insert into Subject values(?,?)";
        PreparedStatement st = con.prepareStatement(query);

        st.setString(1, subject_code);
        st.setString(2, subject_name);

        int n = st.executeUpdate();

        return n;
    }

    public int insertIntoSemester(String sem, String usn, String sgpa, String backlogs) throws SQLException {
        String query = "insert into Semester values(?,?,?,?)";
        PreparedStatement st = con.prepareStatement(query);

        st.setString(1, sem);
        st.setString(2, usn);
        st.setString(3, sgpa);
        st.setString(4, backlogs);

        int n = st.executeUpdate();

        return n;
    }

    

   /* public int insertIntoCounseling(int sem, String usn, int counseling_id) throws SQLException {
        String query = "insert into counseling values(?,?,?)";
        PreparedStatement st = con.prepareStatement(query);

        st.setInt(1, sem);
        st.setString(2, usn);
        st.setInt(3, counseling_id);

        int n = st.executeUpdate();

        return n;
    }

    public int insertIntoActivities(int sem, String usn, int activities_id) throws SQLException {
        String query = "insert into Activities values(?,?,?)";
        PreparedStatement st = con.prepareStatement(query);

        st.setInt(1, sem);
        st.setString(2, usn);
        st.setInt(3, activities_id);

        int n = st.executeUpdate();

        return n;
    }*/

    public int insertIntoCounseling_details(String sem,String usn,String counseling_id,String date, String issue, String remarks) throws SQLException {
        String query = "insert into counseling_details values(?,?,?,?,?,?)";
        PreparedStatement st = con.prepareStatement(query);

        st.setString(1, sem);
        st.setString(2, usn);
        st.setString(3, counseling_id);
        st.setString(4, date);
        st.setString(5, issue);
        st.setString(6, remarks);

        int n = st.executeUpdate();

        return n;
    }

    public int insertIntoActivities_details(String activities_id,String sem,String usn, String date, String details, String place) throws SQLException {
        String query = "insert into Activities_details values(?,?,?,?,?,?)";
        PreparedStatement st = con.prepareStatement(query);

        st.setString(1, activities_id);
        st.setString(2, sem);
        st.setString(3, usn);
        st.setString(4, date);
        st.setString(5, details);
        st.setString(6, place);
        

        int n = st.executeUpdate();

        return n;
    }

    public static void main(String[] args) throws SQLException {

        MySqlConnect obj = new MySqlConnect();
        System.out.println(obj);
          
        //System.out.println(obj.getStudentDetails("cv"));
        
        System.out.println(obj.createTableStaffLogin());
        //System.out.println(obj.createTableSubject());
        System.out.println(obj.createTableStudent());
        System.out.println(obj.createTableSemester());
        System.out.println(obj.createTableMarks());
       // System.out.println(obj.creteTableCounseling());
       // System.out.println(obj.createTableActivities());
        System.out.println(obj.createTableCounseling_details());
        System.out.println(obj.createTableACTIVITIES_details());
        System.out.println(obj.getActivityIdFromActivities("1001"));
    }

   public ResultSet getActivities(String usn) throws SQLException {
        
        String sql = "SELECT * FROM activities_details where USN =?";
        
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, usn);
      return pst.executeQuery();
   
    }
   
   public ResultSet getAcademics(String usn) throws SQLException {
        
        String sql = "SELECT * FROM semester where USN =?";
        
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, usn);
      return pst.executeQuery();
   
    }

    int getActivityIdFromActivities(String usn) throws SQLException {
        
        String sql ="select count(*) from activities_details where usn= ?";
        
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, usn);
        
        ResultSet rs = pst.executeQuery();
        if(rs.next())
        return rs.getInt("count(*)");
           
      return 0;
    }
    
    public ResultSet getCounseling(String usn) throws SQLException {
        
        String sql = "SELECT * FROM counseling_details where USN =?";
        
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, usn);
      return pst.executeQuery();
   
    }

    int getCounselingIdFromCounseling(String usn) throws SQLException {
        
        String sql ="select count(*) from counseling_details where usn= ?";
        
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, usn);
        
        ResultSet rs = pst.executeQuery();
        if(rs.next())
        return rs.getInt("count(*)");
           
      return 0;
    }
    
    public ResultSet getStudent(String local_guardian_name) throws SQLException{
      
            String sql = "select usn,student_name from student where LOCAL_GUARDIAN_NAME=?";
            PreparedStatement pat =  con.prepareStatement(sql);
        
            pat.setString(1, local_guardian_name);
            ResultSet rs = pat.executeQuery();
            if (rs.next()) {
                welcome w = new welcome();
                w.setVisible(true);
                w.JTableUsnName.setModel(DbUtils.resultSetToTableModel(rs));
             
            }
        return null;
    
    }

    //int insertIntoMarks(String usn, String sem, String subject_code, String IA1, String AT1, String IA2, String AT2, String IA3, String AT3) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   // }

    public int insertIntMarks(String usn, String subject_code,String sem, String ia1, String at1, String ia2, String at2, String ia3, String at3, String average) throws SQLException {
        String query = "insert into Marks values(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement st = con.prepareStatement(query);

        st.setString(1, usn);
        st.setString(3, subject_code);
        st.setString(2, sem);
        st.setString(4, ia1);
        st.setString(5, at1);
        st.setString(6, ia2);
        st.setString(7, at2);
        st.setString(8, ia3);
        st.setString(9, at3);
        st.setString(10, average);
        
    

        int n = st.executeUpdate();

        return n;
    }

    
    
}
