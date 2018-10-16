/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.sql.*;

import java.util.Scanner;

/**
 *
 * @author Suma
 */
public class MySqlTest {
    
    
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here

        SQLTestDAO obj = new SQLTestDAO();
        
        obj.createNewTable();
        
        System.out.println("Number of rows updated are "+obj.readDetails());
        
        
        System.out.println("Enter a name");

        ResultSet rs2 = obj.search(new Scanner(System.in).next());
/*
        if (!rs2.next()) {
            System.out.println("Record not found");
        } else {
            System.out.println("Success");
            System.out.println("ID " + rs2.getInt(1) + " NAME " + rs2.getString(2) + " SEX " + rs2.getString(3) + " Marks " + rs2.getInt(4));
            while (rs2.next()) {

                System.out.println("ID " + rs2.getInt(1) + " NAME " + rs2.getString(2) + " SEX " + rs2.getString(3) + " Marks " + rs2.getInt(4));

            }
        }
         */  
        //System.out.println("Records Modified " + obj.readDetails());
       // ResultSet rs = obj.viewRecords();
       // while (rs.next()) {

         //   System.out.println("ID " + rs.getInt(1) + " NAME " + rs.getString(2) + " SEX " + rs.getString(3) + " Marks " + rs.getInt(4));

       // }
    }
}

class SQLTestDAO {

    Connection con = null;

    public SQLTestDAO() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lgtesting", "root", "konda");
            
        } catch (Exception ex) {
            System.out.println(ex);
        }

    }
    public  void createNewTable() throws SQLException {
        
        
        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS student (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	name text(15) ,\n"
                + "	sex char(1) ,\n"
                + "	marks int(3)\n"
                + ");";
        
      
           try   {
               Statement stmt = con.createStatement(); 
         
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public int readDetails() throws SQLException {

        Student s = new Student();
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter the Details");

        System.out.println("Enter the ID");
        s.id = scan.nextInt();
        System.out.println("Enter the NAME");
        s.name = scan.next();
        System.out.println("Enter the SEX");
        s.sex = scan.next();
        System.out.println("Enter the MARKS");
        s.marks = scan.nextInt();
        return 0;
        //return (insertIntoStudent(s));

    }

    public ResultSet viewRecords() throws SQLException {

        String query = "SELECT * FROM student";

        PreparedStatement st = con.prepareStatement(query);

        ResultSet rs = (ResultSet) st.executeQuery();

        return rs;

    }

    public int insertIntoStudent(int id,String name ,String sex,int marks) throws SQLException {

        String query = "INSERT INTO student values(?,?,?,?)";

        PreparedStatement st = con.prepareStatement(query);

        st.setInt(1, id);
        st.setString(2, name);
        st.setString(3, sex);
        st.setInt(4, marks);

        int n = st.executeUpdate();

        return n;
    }

    public ResultSet search(String name) throws SQLException {

        String query = "SELECT * FROM student where name=?";
        
        

        PreparedStatement st = con.prepareStatement(query);

        st.setString(1, name);
        
        ResultSet rs = (ResultSet) st.executeQuery();

        return rs;
    }

}

class Student {

    int id;
    String name;
    String sex;
    int marks;

}

