
package srs;

import com.mysql.jdbc.jdbc2.optional.PreparedStatementWrapper;
import java.sql.*;
import java.util.Scanner;
public class SRS {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here

     
    }       
        

        
}

class Con {

    Connection con = null;

    public Con() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/srs", "root", "dolly");
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
    }
    
}

    

