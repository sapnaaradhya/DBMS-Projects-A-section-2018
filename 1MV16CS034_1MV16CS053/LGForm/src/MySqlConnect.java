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
            con = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/Login", "root", "konda");
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
    
    public boolean createTableStudent()throws SQLException{
        
        String sql ="CREATE TABLE IF NOT EXISTS Login("
                + "NAME VARCHAR(25),"
                + "AGE INT(2) NOT NULL,"
                + "CONSTRAINT PK_ID PRIMARY KEY(NAME)"
                + ");";
        
        Statement st = con.createStatement();
       
            return st.execute(sql);
        
        
       
    }
    
    public static void main(String[] args) throws SQLException{
        
        MySqlConnect obj = new MySqlConnect();
        
        System.out.println(obj.createTableStudent());
        
    }

}
