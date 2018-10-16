/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lgform;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;import com.mysql.jdbc.Connection;


/**
 *
 * @author Suma
 */
public class LGForm {

    Connection con=null;
    /**
     * @param args the command line arguments
     */
    public LGForm() throws SQLException{//soooooooooooooooooooper
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/LGTesting","root","konda");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LGForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public int createTableStudent()throws SQLException{
        
        String sql ="CREATE TABLE IF NOT EXISTS TEST("
                + "NAME VARCHAR(25),"
                + "AGE INT(2) NOT NULL,"
                + "CONSTRAINT PK_ID PRIMARY KEY(NAME)"
                + ");";
        
        Statement st = con.createStatement();
        
      int b=  st.executeUpdate(sql);
        
        
        return b;
    }
    
}
