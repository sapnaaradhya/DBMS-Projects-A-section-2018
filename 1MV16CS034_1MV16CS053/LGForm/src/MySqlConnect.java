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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import lgform.LGForm;

public class MySqlConnect {

    Connection con = null;

    public MySqlConnect() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/LG_FORM", "root", "1234");
            //JOptionPane.showMessageDialog(null,"Connected to Database");
        } catch (Exception ex) {

        }

    }

    public boolean verify(String uName, String pass) throws SQLException {

        String Sql = "Select * from login where Username=? and Password=?";
        PreparedStatement pat = con.prepareStatement(Sql);
        pat.setString(1, uName);
        pat.setString(2, pass);
        ResultSet rs = pat.executeQuery();

        return rs.next();

    }
    public ResultSet displayStudents()
    {
             ResultSet rs=null;
        try{
        String Sql = "Select usn,name from student";
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

    public boolean createTableSubject() throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS SUBJECT(\n"
                + "SUBJECT_CODE VARCHAR(5) NOT NULL,\n"
                + "SUBJECT_NAME VARCHAR(20) NOT NULL,\n"
                + "CONSTRAINT PK_SUB PRIMARY KEY(SUBJECT_CODE)"
                + ");";

        Statement st = con.createStatement();

        return st.execute(sql);
    }

    public boolean createTableStudent() throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS STUDENT(\n" +
"                STUDENT_NAME VARCHAR(10) NOT NULL,\n" +
"                USN VARCHAR(10),\n" +
"                BRANCH_NAME VARCHAR(25) NOT NULL,\n" +
"                DOB DATE NOT NULL,\n" +
"                EMAIL VARCHAR(25) NOT NULL,\n" +
"                PHONE_NO INT(10) NOT NULL,\n" +
                 "LOCAL_GUARDIAN_NAME VARCHAR(10) NOT NULL, \n"+
"                ADDRESS VARCHAR(99) NOT NULL,\n" +
"                STAY_TYPE VARCHAR(15) NOT NULL,\n" +
"                BLOOD_GROUP VARCHAR(15) NOT NULL,\n" +
"                HOBBIES VARCHAR(10) NOT NULL,\n" +
"                ADMISSION_CATEGORY VARCHAR(10) NOT NULL,\n" +
"                FATHER_NAME VARCHAR(20) NOT NULL,\n" +
"                FATHER_NO INT(10) NOT NULL,\n" +
"                MOTHER_NAME VARCHAR(20) NOT NULL,\n" +
"                MOTHER_NO INT(10) NOT NULL,\n" +
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
                + "CONSTRAINT PK_SEMm PRIMARY KEY(SEM),\n"
                + "CONSTRAINT FK_Ss FOREIGN KEY(USN) REFERENCES STUDENT(USN) ON DELETE CASCADE"
                + ");";

        Statement st = con.createStatement();
        return st.execute(sql);
    }

    public boolean createTableMarks() throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS MARKS(\n"
                + "USN VARCHAR(10) NOT NULL,\n"
                + "SUBJECT_CODE VARCHAR(5) NOT NULL,\n"
                + "SEM INT(1) NOT NULL,\n"
                + "IA1 INT(2) NOT NULL,\n"
                + "AT1 INT(2) NOT NULL,\n"
                + "IA2 INT(2) NOT NULL,\n"
                + "AT2 INT(2) NOT NULL,\n"
                + "IA3 INT(2) NOT NULL,\n"
                + "AT3 INT(2) NOT NULL,\n"
                + "AVERAGE INT(4) NOT NULL,\n"
                + "CONSTRAINT FK_M FOREIGN KEY(USN) REFERENCES STUDENT(USN) ON DELETE CASCADE,\n"
                + "CONSTRAINT FK_A FOREIGN KEY(SUBJECT_CODE) REFERENCES SUBJECT(SUBJECT_CODE) ON DELETE CASCADE,\n"
                + "CONSTRAINT FK_R FOREIGN KEY(SEM) REFERENCES SEMESTER(SEM) ON DELETE CASCADE"
                + ");";

        Statement st = con.createStatement();
        return st.execute(sql);
    }

    public boolean creteTableCounseling() throws SQLException {

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
    }

    public boolean createTableActivities() throws SQLException {

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
    }

    public boolean createTableCounseling_details() throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS COUNSELING_DETAILS(\n"
                + "COUNSELING_ID INT(1) NOT NULL,\n"
                + "DATE DATE NOT NULL,\n"
                + "ISSUE VARCHAR(99) NOT NULL,\n"
                + "REMARKS VARCHAR(99) NOT NULL,\n"
                + "CONSTRAINT FK_CD FOREIGN KEY(COUNSELING_ID) REFERENCES COUNSELING(COUNSELING_ID) ON DELETE CASCADE"
                + ");";

        Statement st = con.createStatement();
        return st.execute(sql);

    }

    public boolean createTableACTIVITIES_details() throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS ACTIVITIES_DETAILS(\n"
                + "ACTIVITIES_ID INT(1) NOT NULL,\n"
                + "DATE DATE NOT NULL,\n"
                + "DETAILS VARCHAR(99) NOT NULL,\n"
                + "PLACE VARCHAR(99) NOT NULL,\n"
                + "CONSTRAINT FK_BD FOREIGN KEY(ACTIVITIES_ID) REFERENCES ACTIVITIES(ACTIVITIES_ID) ON DELETE CASCADE"
                + ");";

        Statement st = con.createStatement();
        return st.execute(sql);

    }

    public int insertIntoStaffLogin(String name, String email, String department, String username, String password) throws SQLException {
        String query = "insert into StaffLogin values(?,?,?,?,?)";
        PreparedStatement st = con.prepareStatement(query);

        st.setString(1, name);
        st.setString(2, email);
        st.setString(3, department);
        st.setString(4, username);
        st.setString(5, password);

        int n = st.executeUpdate();

        return n;
    }

    public int insertIntoStudent(String student_name, String usn, String branch_name, String dob, String email, int phone_no, String local_guardian_name, String address, String stay_type, String blood_group, String hobbies, String admission_category, String father_name, int father_no, String mother_name, int mother_no) throws SQLException {
        String query = "insert into Student values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement st = con.prepareStatement(query);

        st.setString(1, student_name);
        st.setString(2, usn);
        st.setString(3, branch_name);
        st.setString(4, dob);
        st.setString(5, email);
        st.setInt(6, phone_no);
        st.setString(7, local_guardian_name );
        st.setString(7, address);
        st.setString(8, stay_type);
        st.setString(9, blood_group);
        st.setString(10, hobbies);
        st.setString(11, admission_category);
        st.setString(12, father_name);
        st.setInt(13, father_no);
        st.setString(14, mother_name);
        st.setInt(15, mother_no);

        int n = st.executeUpdate();

        return n;
    }

    public int insertIntoSubject(String subject_code, String subject_name) throws SQLException {
        String query = "insert into Subject values(?,?)";
        PreparedStatement st = con.prepareStatement(query);

        st.setString(1, subject_code);
        st.setString(2, subject_name);

        int n = st.executeUpdate();

        return n;
    }

    public int insertIntoSemester(int sem, String usn, float sgpa, int backlogs) throws SQLException {
        String query = "insert into Semester values(?,?,?,?)";
        PreparedStatement st = con.prepareStatement(query);

        st.setInt(1, sem);
        st.setString(2, usn);
        st.setFloat(3, sgpa);
        st.setInt(4, backlogs);

        int n = st.executeUpdate();

        return n;
    }

    public int insertIntMarks(String usn, String subject_code, int sem, int ia1, int at1, int ia2, int at2, int ia3, int at3, int average) throws SQLException {
        String query = "insert into Marks values(?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement st = con.prepareStatement(query);

        st.setString(1, usn);
        st.setString(2, subject_code);
        st.setInt(3, sem);
        st.setInt(4, ia1);
        st.setInt(5, at1);
        st.setInt(6, ia2);
        st.setInt(7, at2);
        st.setInt(8, ia3);
        st.setInt(9, at3);
        st.setInt(10, average);

        int n = st.executeUpdate();

        return n;
    }

    public int insertIntoCounseling(int sem, String usn, int counseling_id) throws SQLException {
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
    }

    public int insertIntoCounseling_details(int counseling_id, Date date, String issue, String remarks) throws SQLException {
        String query = "insert into counseling_details values(?,?,?,?)";
        PreparedStatement st = con.prepareStatement(query);

        st.setInt(1, counseling_id);
        st.setDate(2, date);
        st.setString(3, issue);
        st.setString(4, remarks);

        int n = st.executeUpdate();

        return n;
    }

    public int insertIntoActivities_details(int activities_id, Date date, String details, String place) throws SQLException {
        String query = "insert into Activities_details values(?,?,?)";
        PreparedStatement st = con.prepareStatement(query);

        st.setInt(1, activities_id);
        st.setDate(2, date);
        st.setString(3, details);
        st.setString(4, place);

        int n = st.executeUpdate();

        return n;
    }

    public static void main(String[] args) throws SQLException {

        MySqlConnect obj = new MySqlConnect();
        System.out.println(obj);

        System.out.println(obj.createTableStaffLogin());
        System.out.println(obj.createTableSubject());
        System.out.println(obj.createTableStudent());
        System.out.println(obj.createTableSemester());
        System.out.println(obj.createTableMarks());
        System.out.println(obj.creteTableCounseling());
        System.out.println(obj.createTableActivities());
        System.out.println(obj.createTableCounseling_details());
        System.out.println(obj.createTableACTIVITIES_details());

    }

}
