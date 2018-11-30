
import com.mysql.jdbc.jdbc2.optional.PreparedStatementWrapper;
import java.sql.*;
import java.util.Scanner;
import javax.swing.JTextField;

public class SRS {

    public static void main(String[] args) throws Exception {
        // TODO code application logic here

        SqlDao obj = new SqlDao(); 

        obj.createTableAdmin();
        obj.createTableCourse();
        obj.createTableBranch();
        obj.createTableStudent();
        obj.createTableFaculty();
        obj.createTableFees();
        obj.createTableExams();
       // obj.insertCourse("1","B.E");
      //  obj.insertBranch("1","11","CSE","Bhanuprakash","5678");
    }       
        


}


class SqlDao {

    Connection con = null;

    public SqlDao() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=(com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","dolly");

        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    public boolean createTableAdmin() throws Exception {

        String sql = "CREATE TABLE IF NOT EXISTS ADMIN\n"
                + "(NAME VARCHAR(15) NOT NULL,\n"
                + "USER_NAME VARCHAR(15),\n"
                + "PASSWORD VARCHAR(15) NOT NULL,\n"
                + "CONSTRAINT PF_UN PRIMARY KEY(USER_NAME));";

        Statement st = con.createStatement();
        st.execute(sql);
        
        return true;
    }


    
   public int insertAdmin(String name,String uname ,String pass) throws Exception{
       
       
       String sql = "INSERT INTO ADMIN VALUES(?,?,?)";
       
       PreparedStatement ps = con.prepareStatement(sql);
       
       ps.setString(1, name);
       ps.setString(2, uname);
       ps.setString(3, pass);
       
       int n=ps.executeUpdate();
       
       return n;
   } 
    
    
   
    


    public boolean createTableCourse() throws Exception {
        String sql2 = "CREATE TABLE IF NOT EXISTS COURSE(\n"
                + "COURSE_ID INT(2)NOT NULL,\n"
                + "COURSE_NAME VARCHAR(9) NOT NULL,\n"
                + "CONSTRAINT PK_L PRIMARY KEY(COURSE_ID)"
                + ");";
        Statement st2 = con.createStatement();
        st2.execute(sql2);
        // con.close();
        return true;

    }

    public boolean createTableBranch() throws Exception {
        String sql3 = "CREATE TABLE IF NOT EXISTS BRANCH(\n"
                + "COURSE_ID INT(2) NOT NULL,\n"
                + "BRANCH_ID INT(3),\n"
                + "BRANCH_NAME VARCHAR(27) NOT NULL,\n"
                + "HOD VARCHAR(51) NOT NULL ,\n"
                + "CONTACT_NO INT(10) NOT NULL,\n"
                + "CONSTRAINT PK_N PRIMARY KEY(BRANCH_ID),\n"
                + "CONSTRAINT FK_k FOREIGN KEY(COURSE_ID)REFERENCES COURSE(COURSE_ID) ON DELETE CASCADE"
                + ");";
        Statement sto = con.createStatement();
        sto.execute(sql3);
        // con.close();
        return true;

    }

    public boolean createTableStudent() throws Exception {

        String sql56 = "CREATE TABLE IF NOT EXISTS STUDENT(\n"
                + "USN VARCHAR(10) NOT NULL,\n"
                + "S_NAME VARCHAR(51) NOT NULL,\n"
                + "GENDER CHAR(1) NOT NULL,\n"
                + "DOB DATE DEFAULT '00-00-0000',\n"
                + "ADDRESS VARCHAR(99) NOT NULL,\n"
                + "S_PHONE INT(10) NOT NULL,\n"
                + "PARENT_NAME VARCHAR(51) NOT NULL,\n"
                + "P_PHONE INT(10) NOT NULL,\n"
                + "GUARDIAN_NAME VARCHAR(51),\n"
                + "G_PHONE INT(10) NOT NULL,\n"
                + "BRANCH_ID INT(3) NOT NULL,\n"
                + "COURSE_ID INT(3) NOT NULL,\n"
                + "AADHAR_NO INT(12) NOT NULL,\n"
                + "STAY_TYPE VARCHAR(9) NOT NULL,\n"
                + "AGE INT(2) NOT NULL,\n"
                + "YEAR_OF_JOIN INT(4) NOT NULL,\n"
                + "PRESENT_SEM INT(1) NOT NULL,\n"
                + "CATEGORY_OF_EXAM VARCHAR(20) NOT NULL,\n"
                + "CET_COMEDK_OTHER_RANK INT(8) NOT NULL,\n"
                + "PUC FLOAT(4) NOT NULL,\n"
                + "TENTH FLOAT(4) NOT NULL,\n"
                + "CONSTRAINT PK_P PRIMARY KEY(USN),\n"
                + " CONSTRAINT FK_I FOREIGN KEY(BRANCH_ID) REFERENCES BRANCH(BRANCH_ID)ON DELETE CASCADE,\n"
                + "CONSTRAINT FK_C FOREIGN KEY(COURSE_ID) REFERENCES COURSE(COURSE_ID)ON DELETE CASCADE\n"
                + ");";
        Statement stl = con.createStatement();
        stl.execute(sql56);
        //con.close();
        return true;
    }

    public int createTableFees() throws Exception {
        String sql4 = "CREATE TABLE IF NOT EXISTS FEES(\n"
                + "RECEIPT_ID INT(9),\n"
                + "USN VARCHAR(10),\n"
                + "TOTAL_AMTPAID INT(9) NOT NULL,\n"
                + "PAID_BY VARCHAR(51) NOT NULL,\n"
                + "DUE_AMT INT(9) NOT NULL,\n"
                + "CONSTRAINT PK_Ok PRIMARY KEY(RECEIPT_ID),\n"
                + "CONSTRAINT FK_Ka FOREIGN KEY(USN) REFERENCES STUDENT(USN) ON DELETE CASCADE\n"
                + ");";
        PreparedStatement st4 = con.prepareStatement(sql4);

        //con.close();
        return st4.executeUpdate();

    }

    public boolean createTableFaculty() throws Exception {
        String sql5 = "CREATE TABLE IF NOT EXISTS FACULTY\n"
                + "(FACULTY_ID INT(2)NOT NULL,\n"
                + "FACULTY_NAME INT(2)NOT NULL,\n"
                + "COURSE_ID INT(2)NOT NULL,\n"
                + "BRANCH_ID INT(3)NOT NULL,\n"
                + "FACULTY_SALARY INT(9)NOT NULL,\n"
                + "QUALIFICATION VARCHAR(9) NOT NULL,\n"
                + "PHONE_NO INT(10) NOT NULL,\n"
                + "ADDRESS VARCHAR(90) NOT NULL,\n"
                 + "CONSTRAINT PK_PPk PRIMARY KEY(FACULTY_ID),\n"
                + "CONSTRAINT PK_N FOREIGN KEY(BRANCH_ID)REFERENCES BRANCH(BRANCH_ID)ON DELETE CASCADE\n ,"
                +"CONSTRAINT PK_NP FOREIGN KEY(COURSE_ID)REFERENCES COURSE(COURSE_ID)ON DELETE CASCADE\n"
                + ");";
        Statement st5 = con.createStatement();
        st5.execute(sql5);
        //con.close();
        return true;
    }

    public boolean createTableExams() throws Exception {
        String sql0 = "CREATE TABLE IF NOT EXISTS EXAMS\n"
                + "(BRANCH_ID INT(3)NOT NULL,\n"
                + "USN VARCHAR(10),\n"
                + "SGPA1 FLOAT(4),\n"
                + "SGPA2 FLOAT(4),\n"
                + "SGPA3 FLOAT(4),\n"
                + "SGPA4 FLOAT(4),\n"
                + "SGPA5 FLOAT(4),\n"
                + "SGPA6 FLOAT(4),\n"
                + "SGPA7 FLOAT(4),\n"
                + "SGPA8 FLOAT(4),\n"
                + "CGPA FLOAT(4),\n"
                + "CONSTRAINT FK_N FOREIGN KEY(USN)REFERENCES STUDENT(USN) ON DELETE CASCADE\n ,"
                +"CONSTRAINT FK_NN FOREIGN KEY(BRANCH_ID)REFERENCES BRANCH(BRANCH_ID)ON DELETE CASCADE\n"
                + ");";
       Statement st6 = con.createStatement();
        st6.execute(sql0);
        return true;
        //con.close();
        
    }
    
  public int insertStudent(String usn, String s_name, String gender,String dob,String address,String s_phone,String parent_name,String p_phone,
             String guardian_name,String g_phone,String branch_id,String course_id,String aadhar_no,String stay_type,String age,String year_of_join,String present_sem,
             String category_of_exam,String cet_comedk_other_rank,String puc,String tenth) throws Exception {

        String sql = "INSERT INTO STUDENT VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, usn);
        ps.setString(2, s_name);
        ps.setString(3, gender);
        ps.setString(4, dob);
        ps.setString(5, address);
        ps.setString(6, s_phone);
        ps.setString(7, parent_name);
        ps.setString(8, p_phone);
        ps.setString(9, guardian_name);
        ps.setString(10, g_phone);
        ps.setString(11, branch_id);
        ps.setString(12, course_id);
        ps.setString(13, aadhar_no);
        ps.setString(14, stay_type);
        ps.setString(15, age);
        ps.setString(16, year_of_join);
        ps.setString(17, present_sem);
        ps.setString(18, category_of_exam);
        ps.setString(19, cet_comedk_other_rank);
        ps.setString(20, puc);
        ps.setString(21, tenth);

        int n = ps.executeUpdate();
       // con.close();
        return n;
    }
      public int insertFees(String receipt_id, String usn, String total_amtpaid,String paid_by,String due_amt) throws Exception {

        String sql = "INSERT INTO FEES VALUES(?,?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, receipt_id);
        ps.setString(2, usn);
        ps.setString(3, total_amtpaid);
        ps.setString(4, paid_by);
        ps.setString(5, due_amt);


        int n = ps.executeUpdate();
        //con.close();
        return n;
    }
       public int insertFaculty(String faculty_id, String faculty_name, String course_id,String branch_id,String faculty_salary,String qualification,String phone_no,
               String address) throws Exception {

        String sql = "INSERT INTO FACULTY VALUES(?,?,?,?,?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, faculty_id);
        ps.setString(2, faculty_name);
        ps.setString(3, course_id);
        ps.setString(4, branch_id);
        ps.setString(5, faculty_salary);
        ps.setString(6, qualification);
        ps.setString(7, phone_no);
        ps.setString(8, address);

        

        int n = ps.executeUpdate();
        //con.close();
        return n;
    }
        public int insertExams(String branch_id, String usn, String sgpa1, String sgpa2, String sgpa3, String sgpa4, String sgpa5, String sgpa6,
                 String sgpa7, String sgpa8, String cgpa) throws Exception {

        String sql = "INSERT INTO EXAMS VALUES(?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, branch_id);
        ps.setString(2, usn);
        ps.setString(3, sgpa1);
        ps.setString(4, sgpa2);
        ps.setString(5, sgpa3);
        ps.setString(6, sgpa4);
        ps.setString(7, sgpa5);
        ps.setString(8, sgpa6);
        ps.setString(9, sgpa7);
        ps.setString(10, sgpa8);
        ps.setString(11, cgpa);
        int n = ps.executeUpdate();
        //con.close();
        return n;
    }

 public int insertCourse(String course_id,String course_name) throws Exception{
       
       
       String sql = "INSERT INTO COURSE VALUES(?,?)";
       
       PreparedStatement ps = con.prepareStatement(sql);
       
       ps.setString(1, course_id);
       ps.setString(2, course_name);
      
       
       int n=ps.executeUpdate();
       
       return n;
   } 
  public int insertBranch(String course_id,String branch_id ,String branch_name ,String hod ,String contact_no) throws Exception    {
       String sql = "INSERT INTO BRANCH VALUES(?,?,?,?,?)";
       
       PreparedStatement ps = con.prepareStatement(sql);
       
       ps.setString(1,course_id );
       ps.setString(2, branch_id);
       ps.setString(3, branch_name);
       ps.setString(4, hod);
       ps.setString(5, contact_no);
       
       int n=ps.executeUpdate();
       
       return n;
   } 

   
   
}
   







