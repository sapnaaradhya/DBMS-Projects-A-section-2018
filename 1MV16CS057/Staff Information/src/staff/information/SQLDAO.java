/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package staff.information;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ui.AdminUpdate;

/**
 *
 * @author Nasir Basha K
 */
class StaffInformation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, Exception {

        SQLDAO obj = new SQLDAO();

        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        System.out.println(dayOfWeek);

        System.out.println(obj.getSelectedRowFrom("admin", "1001"));
         //obj.getBirthDays();

         new Runnable() {
            @Override
            public void run() {
                
                             
                    System.out.println("haui");
                
            }
        };
         
         new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("haui");
            }
        }).start();
        
         
         
         
        // System.out.println(obj.getTeacherName("101", "P1", "MONDAY"));
    }

    public static void updateTheFields() throws SQLException {
        // System.out.println("updateTheFields");
        SQLDAO obj = new SQLDAO();

        ResultSet rs = obj.checkForResetAdmin("bhanu2018", new Long(1234567890));
        //System.out.println(uName+" "+phone);
        if (rs.next()) {
            System.out.println("Records found");
            System.out.println(rs.getString(2) + rs.getString(3) + rs.getDate(4) + rs.getInt(5) + rs.getString(6) + rs.getString(7) + rs.getString(8));
            while (rs.next()) {
                System.out.println(rs.getString(2) + rs.getString(3) + rs.getDate(4) + rs.getInt(5) + rs.getString(6) + rs.getString(7) + rs.getString(8));
            }
        } else {
            System.out.println("Records not found");
        }

    }

}

//Data-Access-Object Class
public class SQLDAO {

    public Connection con = null;

    public SQLDAO() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/STAFF_INFO", "root", "nasir");

        } catch (Exception ex) {
            System.out.println(ex);
        }

    }

    public ResultSet getTables() throws SQLException {

        String sql = "SHOW TABLES;";

        PreparedStatement pst = con.prepareStatement(sql);

        return pst.executeQuery();

    }

    ArrayList<String> bDaysEmail = new ArrayList<String>();
    ArrayList<String> bDaysNames = new ArrayList<String>();

    HashMap<String, String> m = new HashMap<>();

    public void getBirthDays() throws SQLException {

        // ArrayList<String> bDaysEmail = new ArrayList<String>();
        // ArrayList<String> bDaysNames = new ArrayList<String>();
        //  System.out.println(bDays.isEmpty());
        String sql = "SELECT DOB , EMAIL_ID , NAME FROM TEACHER";

        PreparedStatement pst = con.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        Calendar cal = Calendar.getInstance();

        int day = cal.get(Calendar.DAY_OF_MONTH);
        int mon = cal.get(Calendar.MONTH);

        System.out.println(day);
        System.out.println(mon + 1);
        if (rs.next()) {

            if (Integer.parseInt(rs.getString(1).substring(5, 7)) == mon + 1 && Integer.parseInt(rs.getString(1).substring(8, 10)) == day) {
                System.out.println(rs.getString(1));
                bDaysEmail.add(rs.getString(2));
                bDaysNames.add(rs.getString(3));
            }

            while (rs.next()) {

                if (Integer.parseInt(rs.getString(1).substring(5, 7)) == mon + 1 && Integer.parseInt(rs.getString(1).substring(8, 10)) == day) {
                    System.out.println(rs.getString(1));
                    bDaysEmail.add(rs.getString(2));
                    bDaysNames.add(rs.getString(3));
                }

            }
        }

        MailTest mt = new MailTest();

        for (int i = 0; i < bDaysEmail.size(); i++) {
            //System.out.println(bDaysEmail.get(i));
            //System.out.println(bDaysNames.get(i));
            try {
                mt.wisthOnBirthday(bDaysEmail.get(i), bDaysNames.get(i));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Please check your connection!!\n"
                        + "Birthday wishes couldn't send to "+bDaysNames.get(i)+" .");
              

            }
        }
        

    }

    public void getTimeStamp() {

        Random rand = new Random();

        int week = Math.abs(rand.nextInt(6) + 1);//Calendar.DAY_OF_WEEK;//
        String day = null;

        int hr = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);//Math.abs(rand.nextInt(16 - 8) + 9);//
        int minutes = Calendar.getInstance().get(Calendar.MINUTE);// Math.abs(rand.nextInt(60));//

        String P = null;
        int min = hr * 60 + minutes;

        if (min >= 540 && min < 595) {
            P = "P1";
        } else if (min >= 595 && min < 650) {
            P = "P2";
        } else if (min >= 650 && min < 660) {
            P = "SHORT BREAK";
        } else if (min >= 660 && min < 715) {
            P = "P3";
        } else if (min >= 715 && min < 770) {
            P = "P4";
        } else if (min >= 770 && min < 815) {
            P = "LUNCH BREAK";
        } else if (min >= 815 && min < 870) {
            P = "P5";
        } else if (min >= 870 && min < 925) {
            P = "P6";
        } else if (min >= 925 && min < 980) {
            P = "P7";
        } else {
            P = "NOT college Hours";
        }

        //  System.out.println(P);
        switch (week) {

            case 1:
                day = "MONDAY";
                break;
            case 2:
                day = "TUESDAY";
                break;
            case 3:
                day = "WEDNESDAY";
                break;
            case 4:
                day = "THURSDAY";
                break;
            case 5:
                day = "FRIDAY";
                break;
            case 6:
                day = "SATURDAY";
                break;
            case 7:
                day = "SUNDAY";
                break;

        }

        // System.out.println("Week of the month " + day);
        // System.out.println("Current Period is " + P);
    }

    public String getRoomNo(String name, String period, String day) throws SQLException {

        String subCode = "select " + period + " from teacher_timetable where day = ? and staff_id in \n"
                + "(select staff_id from teacher where name like ?)";

        PreparedStatement subPst = con.prepareStatement(subCode);
        subPst.setString(1, day);
        subPst.setString(2, "%" + name + "%");
        ResultSet subRs = subPst.executeQuery();

        if (subRs.next()) {
            //  System.out.println("from Resultset " + subRs.getString(1));
            String SUB_CODE = subRs.getString(1);
            if (SUB_CODE.contains("CPL")) {
                //  System.out.println("LAB " + SUB_CODE);
                return "LAB";
            } else if (SUB_CODE.contains("FREE")) {
                //   System.out.println("FREE HR " + SUB_CODE);
                return "FREE HOUR";

            } else {
                String roomNo = "select room_no from section where sec_id =\n"
                        + "(select sec_id from subject where sub_code=?);";
                PreparedStatement pst = con.prepareStatement(roomNo);
                pst.setString(1, SUB_CODE);

                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    //   System.out.println("Room no " + rs.getInt(1));
                    return String.valueOf(rs.getInt(1));
                } else {
                    //   System.out.println("Room no not found");
                    return "Room no not found";

                }
            }

        } else {
            //  System.out.println("subject code not found");
            return "subject code not found";

        }

    }

    public String getRoomNo(String name) throws SQLException {

        Random rand = new Random();

        Calendar calendar = Calendar.getInstance();
        int week = calendar.get(Calendar.DAY_OF_WEEK);
        String day = null;

        int hr = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);//Math.abs(rand.nextInt(16 - 8) + 9);//
        int minutes = Calendar.getInstance().get(Calendar.MINUTE);// Math.abs(rand.nextInt(60));//

        String P = null;
        int min = hr * 60 + minutes;

        if (min >= 540 && min < 595) {
            P = "P1";
        } else if (min >= 595 && min < 650) {
            P = "P2";
        } else if (min >= 650 && min < 660) {
            P = "SHORT BREAK";
        } else if (min >= 660 && min < 715) {
            P = "P3";
        } else if (min >= 715 && min < 770) {
            P = "P4";
        } else if (min >= 770 && min < 815) {
            P = "LUNCH BREAK";
        } else if (min >= 815 && min < 870) {
            P = "P5";
        } else if (min >= 870 && min < 925) {
            P = "P6";
        } else if (min >= 925 && min < 980) {
            P = "P7";
        } else {
            P = "NOT college Hours";
        }

        switch (week) {

            case 2:
                day = "MONDAY";
                break;
            case 3:
                day = "TUESDAY";
                break;
            case 4:
                day = "WEDNESDAY";
                break;
            case 5:
                day = "THURSDAY";
                break;
            case 6:
                day = "FRIDAY";
                break;
            case 7:
                day = "SATURDAY";
                break;
            case 1:
                day = "SUNDAY";
                break;

        }

        //  System.out.println("Week of the month " + day);
        //  System.out.println("Current Period is " + P);
        if (day.equals("SUNDAY")) {
            return "It's SUNDAY";
        } else if (P.equals("LUNCH BREAK")) {
            return "It's " + P;
        } else if (P.equals("SHORT BREAK")) {
            return "It's " + P;
        } else if (P.equals("NOT college Hours")) {
            return "It's " + P;
        }

        String subCode = "";

        //  System.out.println(P);
        //  System.out.println(day);
        //  System.out.println(name);
        subCode = "select " + P + " from teacher_timetable where day = ? and staff_id in \n"
                + "(select staff_id from teacher where name like ?)";

        PreparedStatement subPst = con.prepareStatement(subCode);
        subPst.setString(1, day);
        subPst.setString(2, "%" + name + "%");
        ResultSet subRs = subPst.executeQuery();

        if (subRs.next()) {
            //  System.out.println("from Resultset " + subRs.getString(1));
            String SUB_CODE = subRs.getString(1);
            if (SUB_CODE.contains("CPL")) {
                //    System.out.println("LAB " + SUB_CODE);
                return "LAB";
            } else if (SUB_CODE.contains("FREE")) {
                //    System.out.println("FREE HR " + SUB_CODE);
                return "FREE HOUR";

            } else {
                String roomNo = "select room_no from section where sec_id =\n"
                        + "(select sec_id from subject where sub_code=?);";
                PreparedStatement pst = con.prepareStatement(roomNo);
                pst.setString(1, SUB_CODE);

                ResultSet rs = pst.executeQuery();
                if (rs.next()) {
                    //   System.out.println("Room no " + rs.getInt(1));
                    return String.valueOf(rs.getInt(1));
                } else {
                    //  System.out.println("Room no not found");
                    return "Room no not found";

                }
            }

        } else {
            //   System.out.println("subject code not found");
            return "subject code not found";

        }

    }

    public void testMultipleCommands(String Period, String day, String name) throws SQLException {

        // System.out.println("Period " + Period);
        // System.out.println("Day " + day);
        //  System.out.println("Name " + name);
        String sql = "select room_no from section where sec_id =\n"
                + "	(select sec_id from subject where sub_code=\n"
                + "		(select p3 from teacher_timetable where day = \"TUESDAY\" and staff_id in \n"
                + "				(select staff_id from teacher where name like \"%sapna%\")));";

        String sql2 = "select p1 from teacher_timetable where day = ? and staff_id in \n"
                + "(select staff_id from teacher where name like ?);";

        PreparedStatement pst = con.prepareStatement(sql);

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            //  System.out.println(rs.getInt("room_no"));

        } else {
            //  System.out.println("Empty set");

        }

    }

    public boolean createTableTeacher() throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS TEACHER(\n"
                + "	STAFF_ID INT(4) NOT NULL AUTO_INCREMENT,\n"
                + "	NAME VARCHAR(30),\n"
                + "	DESIGNATION VARCHAR(10),\n"
                + "	DOB DATE,\n"
                + "	PHONE INT(10) UNIQUE,\n"
                + "	EMAIL_ID VARCHAR(35) UNIQUE,\n"
                + "	USERNAME VARCHAR(20) UNIQUE,\n"
                + "	PASSWORD VARCHAR(20),\n"
                + "	CONSTRAINT PK_ADMINID PRIMARY KEY(STAFF_ID)\n"
                + ");";

        PreparedStatement pst = con.prepareStatement(sql);
        int b = pst.executeUpdate();

        String alter = "ALTER TABLE TEACHER AUTO_INCREMENT=1011";

        Statement ast = con.createStatement();
        boolean n = ast.execute(alter);

        return n;
    }

    public int insertIntoTeacher(String name, String designation, String dob, long phone, String email, String username, String password) throws SQLException {

        String sql = "INSERT INTO TEACHER (NAME,DESIGNATION,DOB,PHONE,EMAIL_ID,USERNAME,PASSWORD)VALUES(?,?,?,?,?,?,?)";

        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, name);
        pst.setString(2, designation);
        pst.setString(3, dob);
        pst.setLong(4, phone);
        pst.setString(5, email);
        pst.setString(6, username);
        pst.setString(7, password);

        int n = pst.executeUpdate();

        return n;
    }

    public boolean createTableAdmin() throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS ADMIN(\n"
                + "	ADMIN_ID INT(4) NOT NULL AUTO_INCREMENT,\n"
                + "	NAME VARCHAR(30) ,\n"
                + "	DESIGNATION VARCHAR(10),\n"
                + "	DOB DATE,\n"
                + "	PHONE INT(10) UNIQUE,\n"
                + "	EMAIL_ID VARCHAR(35) UNIQUE,\n"
                + "	USERNAME VARCHAR(25) UNIQUE,\n"
                + "	PASSWORD VARCHAR(25),\n"
                + "	CONSTRAINT PK_ADMINID PRIMARY KEY(ADMIN_ID)\n"
                + ");";

        Statement st = con.createStatement();
        boolean b = st.execute(sql);

        // System.out.println("Auto increment");
        String alter = "ALTER TABLE ADMIN AUTO_INCREMENT=1001";

        Statement ast = con.createStatement();
        return ast.execute(alter);

    }

    public int insertIntoAdmin(String name, String designation, String dob, long phone, String email, String username, String password) throws SQLException {

        String sql = "INSERT INTO ADMIN (NAME,DESIGNATION,DOB,PHONE,EMAIL_ID,USERNAME,PASSWORD)VALUES(?,?,?,?,?,?,?)";

        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, name);
        pst.setString(2, designation);
        pst.setString(3, dob);
        pst.setLong(4, phone);
        pst.setString(5, email);
        pst.setString(6, username);
        pst.setString(7, password);

        int n = pst.executeUpdate();

        return n;
    }

    public boolean createTableSection() throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS SECTION(\n"
                + "	SEC_ID CHAR(3),\n"
                + "	SEC_NAME CHAR(1),\n"
                + "	YEAR INT(1),\n"
                + "	ROOM_NO VARCHAR(5) UNIQUE,\n"
                + "	SEMESTER CHAR(1),\n"
                + "	CONSTRAINT PK_SECID PRIMARY KEY(SEC_ID)\n"
                + ");";
        Statement st = con.createStatement();

        return st.execute(sql);
    }

    public int insertIntoSection(String secID, String secName, int year, String roomNo, String sem) throws SQLException {

        String sql = "INSERT INTO SECTION VALUES(?,?,?,?,?)";

        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, secID);
        pst.setString(2, secName);
        pst.setInt(3, year);
        pst.setString(4, roomNo);
        pst.setString(5, sem);

        return pst.executeUpdate();
    }

    public boolean createTableTimeTable() throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS TIMETABLE(\n"
                + "	SL_NO INT(4) AUTO_INCREMENT,\n"
                + "	DAY VARCHAR(10),\n"
                + "	SEC_ID CHAR(3),\n"
                + "	P1 VARCHAR(20),\n"
                + "	P2 VARCHAR(20),\n"
                + "	P3 VARCHAR(20),\n"
                + "	P4 VARCHAR(20),\n"
                + "	P5 VARCHAR(20),\n"
                + "	P6 VARCHAR(20),\n"
                + "	P7 VARCHAR(20),\n"
                + "	CONSTRAINT PK_SLNO PRIMARY KEY(SL_NO),\n"
                + "	CONSTRAINT FK_SECID FOREIGN KEY(SEC_ID) REFERENCES SECTION(SEC_ID) ON DELETE CASCADE\n"
                + ");";
        Statement st = con.createStatement();

        return st.execute(sql);

    }

    public int insertIntoTimeTable() {
        throw new UnsupportedOperationException("Not supported yet.Implement to read from text file");

    }

    public boolean createTableSubject() throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS SUBJECT(\n"
                + "	SUB_ID INT(4) AUTO_INCREMENT,\n"
                + "	SUB_CODE VARCHAR(20),\n"
                + "	SEC_ID CHAR(3),\n"
                + "	SUB_NAME VARCHAR(50),\n"
                + "	STAFF_ID INT(4),\n"
                + "	CONSTRAINT PK_SUBID PRIMARY KEY(SUB_ID),\n"
                + "	CONSTRAINT FK_STAFFID FOREIGN KEY(STAFF_ID) REFERENCES TEACHER(STAFF_ID) ON DELETE CASCADE \n"
                + ");";

        Statement st = con.createStatement();
        boolean b = st.execute(sql);

        String alter = "ALTER TABLE SUBJECT AUTO_INCREMENT=2001";

        return st.execute(alter);
    }

    public int insertIntoSubject(String subCode, String secID, String subName, int staffID) throws SQLException {

        String sql = "INSERT INTO SUBJECT (SUB_CODE,SEC_ID,SUB_NAME,STAFF_ID) VALUES (?,?,?,?)";

        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, subCode);
        pst.setString(2, secID);
        pst.setString(3, subName);
        pst.setInt(4, staffID);

        int n = pst.executeUpdate();

        return n;
    }

    public ResultSet viewTable(String tableName) throws SQLException {

        String sql = "SELECT * FROM subject";
        PreparedStatement pst = con.prepareStatement(sql);

        return pst.executeQuery();

    }

    public void createTableAdmin2() throws SQLException {

        String sql = "CREATE TABLE IF NOT EXISTS ADMIN2 ("
                + "USERNAME VARCHAR(10),"
                + "PASSWORD VARCHAR(10)"
                + ");";

        Statement st = con.createStatement();

        st.execute(sql);

    }

    public boolean verify(String name, String pass) throws SQLException {

        String sql = "SELECT * FROM ADMIN2 WHERE USERNAME= ? and PASSWORD= ?";

        PreparedStatement st = con.prepareStatement(sql);
        st.setString(1, name);
        st.setString(2, pass);
        ResultSet rs = st.executeQuery();

        return rs.next();

    }

    public ResultSet verifyAdmin(String uName, String password) throws SQLException {

        String sql = "SELECT * FROM ADMIN WHERE USERNAME = ? AND PASSWORD = ?";

        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, uName);
        pst.setString(2, password);

        ResultSet rs = pst.executeQuery();

        return rs;

    }

    public ResultSet verifyTeacher(String uName, String password) throws SQLException {

        String sql = "SELECT * FROM TEACHER WHERE USERNAME = ? AND PASSWORD = ?";

        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, uName);
        pst.setString(2, password);

        ResultSet rs = pst.executeQuery();

        return rs;

    }

    public ResultSet checkForResetAdmin(String Uname, Long phone) throws SQLException {

        String sql = "SELECT * FROM ADMIN WHERE USERNAME = ? AND PHONE = ?";

        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, Uname);
        pst.setLong(2, phone);

        return pst.executeQuery();

    }

    public ResultSet checkForResetTeacher(String Uname, Long phone) throws SQLException {

        String sql = "SELECT * FROM TEACHER WHERE USERNAME = ? AND PHONE = ?";

        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, Uname);
        pst.setLong(2, phone);

        return pst.executeQuery();

    }

    public int updateAdmin(String uName, String password) throws SQLException {

        String sql = "UPDATE ADMIN SET PASSWORD=? where USERNAME=?";

        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, password);
        pst.setString(2, uName);

        return pst.executeUpdate();

    }

    public int updateTeacher(String uName, String password) throws SQLException {

        String sql = "UPDATE TEACHER SET PASSWORD=? where USERNAME=?";

        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, password);
        pst.setString(2, uName);

        return pst.executeUpdate();

    }

    public boolean checkForUniqueAdmin(String field, String value) throws SQLException, Exception {

        String sql1 = "SELECT * FROM ADMIN WHERE EMAIL_ID =? ";
        String sql2 = "SELECT * FROM ADMIN WHERE USERNAME =? ";
        PreparedStatement pst = null;
        if (field.equalsIgnoreCase("EMAIL_ID")) {
            //  System.out.println("email");
            pst = con.prepareStatement(sql1);
        } else if (field.equalsIgnoreCase("USERNAME")) {
            //    System.out.println("usename");
            pst = con.prepareStatement(sql2);
        } else {
            throw new Exception("Invalid Arguments");
        }

        pst.setString(1, value);
        ResultSet rs = pst.executeQuery();
        return rs.next();
    }

    public boolean checkForUniqueAdmin(long phone) throws SQLException {

        String sql = "SELECT * FROM ADMIN WHERE PHONE =? ";

        PreparedStatement pst = con.prepareStatement(sql);

        pst.setLong(1, phone);
        ResultSet rs = pst.executeQuery();
        return rs.next();

    }

    public boolean checkForUniqueTeacher(String field, String value) throws SQLException, Exception {

        String sql1 = "SELECT * FROM TEACHER WHERE EMAIL_ID =? ";
        String sql2 = "SELECT * FROM TEACHER WHERE USERNAME =? ";
        PreparedStatement pst = null;
        if (field.equalsIgnoreCase("EMAIL_ID")) {
            //  System.out.println("email");
            pst = con.prepareStatement(sql1);
        } else if (field.equalsIgnoreCase("USERNAME")) {
            //  System.out.println("usename");
            pst = con.prepareStatement(sql2);
        } else {
            throw new Exception("Invalid Arguments");
        }

        pst.setString(1, value);
        ResultSet rs = pst.executeQuery();
        return rs.next();
    }

    public boolean checkForUniqueTeacher(long phone) throws SQLException {

        String sql = "SELECT * FROM TEACHER WHERE PHONE =? ";

        PreparedStatement pst = con.prepareStatement(sql);

        pst.setLong(1, phone);
        ResultSet rs = pst.executeQuery();
        return rs.next();

    }

    public ResultSet getTeachersNames() throws SQLException {

        String sql = "SELECT NAME FROM TEACHER";

        PreparedStatement pst = con.prepareStatement(sql);

        return pst.executeQuery();

    }

    public ResultSet getRoomNos() throws SQLException {

        String sql = "SELECT ROOM_NO FROM SECTION";

        PreparedStatement pst = con.prepareStatement(sql);

        return pst.executeQuery();

    }

    public String getTeacherName(String roomNo, String period, String day) throws SQLException {

        String sql = "SELECT NAME FROM TEACHER WHERE STAFF_ID IN \n"
                + "	(SELECT STAFF_ID FROM SUBJECT WHERE SUB_CODE IN \n"
                + "		(SELECT " + period + " FROM CLASS_TIMETABLE WHERE DAY= ? AND SEC_ID IN \n"
                + "			(SELECT SEC_ID FROM SECTION WHERE ROOM_NO = ? )));";

        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, day);
        pst.setString(2, roomNo);

        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            return rs.getString(1);
        } else {
            return "Free Hour";
        }
    }

    public ResultSet getTeacherTimetable(String name) throws SQLException {

        String sql = "SELECT STAFF_ID,DAY,P1,P2,P3,P4,P5,P6,P7 FROM TEACHER_TIMETABLE WHERE STAFF_ID IN \n"
                + "(SELECT STAFF_ID FROM TEACHER WHERE NAME LIKE  ?);";

        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, "%" + name + "%");

        return pst.executeQuery();

    }

    public ResultSet getClassTimetable(String name) throws SQLException {

        String sql = "SELECT DAY,P1,P2,P3,P4,P5,P6,P7 FROM CLASS_TIMETABLE WHERE SEC_ID IN \n"
                + "(SELECT SEC_ID FROM SECTION WHERE SEC_ID = ?);";

        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, name);

        return pst.executeQuery();

    }

    public ResultSet getSecNames() throws SQLException {

        String sql = "select distinct sec_id from class_timetable";
        PreparedStatement pst = con.prepareStatement(sql);

        return pst.executeQuery();

    }

    public ResultSet getListofTeachersFor(String subName) throws SQLException {

        String sql = "SELECT T.NAME,S.SEC_ID,S.SUB_Name FROM TEACHER T , SUBJECT S WHERE T.STAFF_ID = S.STAFF_ID AND SUB_NAME LIKE ?;";

        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, "%" + subName + "%");

        return pst.executeQuery();

    }

    public ResultSet getAllTeachers(String secName) throws SQLException {

        String sql = "SELECT T.STAFF_ID ,T.NAME,S.SUB_NAME FROM SUBJECT S ,TEACHER T WHERE S.STAFF_ID = T.STAFF_ID AND SEC_ID IN \n"
                + "	(SELECT SEC_ID FROM SECTION WHERE SEC_ID = ? );";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, secName);

        return pst.executeQuery();

    }

    public ResultSet getExtraOfTeacher(String name) throws SQLException {

        String sql = "SELECT SEC_ID,SUB_NAME FROM SUBJECT WHERE STAFF_ID IN \n"
                + "(SELECT STAFF_ID FROM TEACHER WHERE NAME LIKE ?);";

        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, "%" + name + "%");

        return pst.executeQuery();

    }

    public ResultSet getTable(String tableName) throws SQLException {

        String sql = "SELECT * FROM " + tableName;

        PreparedStatement pst = con.prepareStatement(sql);

        return pst.executeQuery();

    }

    public ResultSet getSelectedRowFrom(String tableName, String key) throws SQLException {

        String sql1 = "DESC " + tableName;

        PreparedStatement pst1 = con.prepareStatement(sql1);
        // int n = pst1.executeUpdate();
        //System.out.println("Number of rows "+n);

        String columnIndex = null;

        ResultSet rs = pst1.executeQuery();
        if (rs.next()) {
            columnIndex = rs.getString(1);

        }

        String sql = "SELECT * FROM " + tableName + " WHERE " + columnIndex + " = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, key);

        ResultSet rs2 = pst.executeQuery();

        return rs2;
    }

    public int deleteFromTable(String tableName, String key) throws SQLException {

        String sql1 = "DESC " + tableName;

        PreparedStatement pst1 = con.prepareStatement(sql1);

        String columnIndex = null;

        ResultSet rs = pst1.executeQuery();
        if (rs.next()) {
            columnIndex = rs.getString(1);
        }

        String sql = "DELETE FROM " + tableName + " WHERE " + columnIndex + " = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1, key);

        return pst.executeUpdate();

    }

    public int getCountOf(String tableName) throws SQLException {

        String sql1 = "DESC " + tableName;

        PreparedStatement pst1 = con.prepareStatement(sql1);
        return pst1.executeUpdate();

    }

    public ResultSet getTheDescriptionOf(String tableName) throws SQLException {

        String sql = "DESC " + tableName;

        PreparedStatement pst = con.prepareStatement(sql);

        return pst.executeQuery();

    }

    public int updateTheTable(String tableName, String primaryKey, String key, String text1, String text2, String text3, String text4) throws SQLException {

        if (tableName.equalsIgnoreCase("section")) {

            //| SEC_ID | SEC_NAME | YEAR | ROOM_NO | SEMESTER |
            String sql = "UPDATE " + tableName + " SET SEC_NAME = ? , YEAR = ? , ROOM_NO = ? , SEMESTER = ? WHERE " + primaryKey + " = ? ";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, text1);
            pst.setInt(2, Integer.parseInt(text2));
            pst.setString(3, text3);
            pst.setInt(4, Integer.parseInt(text4));
            pst.setString(5, key);

            return pst.executeUpdate();

        } else if (tableName.equalsIgnoreCase("subject")) {

            //| SUB_ID | SUB_CODE  | SEC_ID | SUB_NAME  | STAFF_ID |
            String sql = "UPDATE " + tableName + " SET SUB_CODE = ? , SEC_ID = ? , SUB_NAME = ? , STAFF_ID = ? WHERE " + primaryKey + " = ? ";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, text1);
            pst.setString(2, text2);
            pst.setString(3, text3);
            pst.setInt(4, Integer.parseInt(text4));
            pst.setString(5, key);

            return pst.executeUpdate();

        }

        return 0;
    }

    public int updateTheTable(String tableName, String primaryKey, String key, String text1, String text2, String text3, String text4, String text5, String text6, String text7) throws SQLException {

        // if(tableName.equalsIgnoreCase("admin")){
        //| ADMIN_ID | NAME   | DESIGNATION | DOB| PHONE| EMAIL_ID | USERNAME   | PASSWORD    |
        String sql = "UPDATE " + tableName + " SET NAME = ? , DESIGNATION = ? , DOB = ? , PHONE = ? , EMAIL_ID = ? , USERNAME = ? , PASSWORD = ? WHERE " + primaryKey + " = ? ";
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setString(1, text1);
        pst.setString(2, text2);
        pst.setString(3, text3);
        pst.setLong(4, new Long(text4));
        pst.setString(5, text5);
        pst.setString(6, text6);
        pst.setString(7, text7);
        pst.setString(8, key);

        return pst.executeUpdate();

//        }else if(tableName.equalsIgnoreCase("teacher")){
//            
//            //| SUB_ID | SUB_CODE  | SEC_ID | SUB_NAME  | STAFF_ID |
//            String sql = "UPDATE "+tableName+" SET SUB_CODE = ? , SEC_ID = ? , SUB_NAME = ? , STAFF_ID = ? WHERE "+primaryKey+" = ? ";
//            PreparedStatement pst = con.prepareStatement(sql);
//            
//            pst.setString(1,text1);
//            pst.setString(2,text2);
//            pst.setString(3,text3);
//            pst.setInt(4,Integer.parseInt(text4));
//            pst.setString(5, key);
//            
//            return pst.executeUpdate();
//            
//            
//        }
    }

    public int updateTheTable(String tableName, String primaryKey, String key, String text1, String text2, String text3, String text4, String text5, String text6, String text7, String text8, String text9) throws SQLException {

        if (tableName.equalsIgnoreCase("class_timetable")) {
            //| SL_NO | DAY| SEC_ID | P1| P2| P3| P4 | P5 | P6| P7|
            String sql = "UPDATE " + tableName + " SET DAY = ? , SEC_ID = ? , P1 = ? , P2 = ? , P3 = ? , P4 = ? , P5 = ? , P6 = ? , P7 = ? WHERE " + primaryKey + " = ? ";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, text1);
            pst.setString(2, text2);
            pst.setString(3, text3);
            pst.setString(4, text4);
            pst.setString(5, text5);
            pst.setString(6, text6);
            pst.setString(7, text7);
            pst.setString(8, text8);
            pst.setString(9, text9);
            pst.setInt(10, Integer.parseInt(key));

            return pst.executeUpdate();

        } else if (tableName.equalsIgnoreCase("teacher_timetable")) {
            //| SL_NO | STAFF_ID | DAY| P1| P2| P3| P4| P5| P6| P7|
            String sql = "UPDATE " + tableName + " SET STAFF_ID = ? , DAY = ? , P1 = ? , P2 = ? , P3 = ? , P4 = ? , P5 = ? , P6 = ? , P7 = ? WHERE " + primaryKey + " = ? ";

            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(text1));
            pst.setString(2, text2);
            pst.setString(3, text3);
            pst.setString(4, text4);
            pst.setString(5, text5);
            pst.setString(6, text6);
            pst.setString(7, text7);
            pst.setString(8, text8);
            pst.setString(9, text9);
            pst.setInt(10, Integer.parseInt(key));

            return pst.executeUpdate();

        }

        return 0;

    }

}
