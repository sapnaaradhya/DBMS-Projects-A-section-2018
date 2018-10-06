
package srs;

import com.mysql.jdbc.jdbc2.optional.PreparedStatementWrapper;
import java.sql.*;
import java.util.Scanner;
public class SRS {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        
        SqlDao obj = new SqlDao();
        obj.createTableAdmin();

     
    }       
        

        
}

class SqlDao {

    Connection con = null;

    public SqlDao() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/srs", "root", "premi");
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
    }
    
    public boolean createTableAdmin() throws SQLException{
        
        
        String sql="CREATE TABLE IF NOT EXISTS ADMIN"
                + "(NAME VARCHAR(15) NOT NULL,"
                + "USER_NAME VARCHAR(15),"
                + "PASSWORD VARCHAR(8) NOT NULL,"
                + "CONSTRAINT PF_UN PRIMARY KEY(USER_NAME));";
        
        Statement st = con.createStatement();
        st.execute(sql);
        con.close();
        return true;
    }
    
    public int createDB() throws SQLException{
        
        String sql ="Create database srs";
        PreparedStatement ps = con.prepareStatement(sql);
        
        int n=ps.executeUpdate();
        return n;
    }
    
}

    

