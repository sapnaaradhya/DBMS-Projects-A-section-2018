


import com.mysql.jdbc.jdbc2.optional.PreparedStatementWrapper;
import java.sql.*;
import java.util.Scanner;
public class SRS {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // TODO code application logic here
        
        SqlDao obj = new SqlDao();
        obj.createTableAdmin();
        int n=new SqlDao().insertAdmin("Drith", "drithika21", "dolly");
        if(n==0){
            System.out.print("Error");
        }else{
            System.out.print("Successful");
        }
     
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
        
        
        String sql="CREATE TABLE IF NOT EXISTS ADMIN\n"
                + "(NAME VARCHAR(15) NOT NULL,\n"
                + "USER_NAME VARCHAR(15),\n"
                + "PASSWORD VARCHAR(8) NOT NULL,\n"
                + "CONSTRAINT PF_UN PRIMARY KEY(USER_NAME));";
        
        Statement st = con.createStatement();
        st.execute(sql);
        con.close();
        return true;
    }
    
    
   public int insertAdmin(String name,String uname ,String pass) throws SQLException{
       
       
       String sql = "INSERT INTO ADMIN VALUES(?,?,?)";
       
       PreparedStatement ps = con.prepareStatement(sql);
       
       ps.setString(1, name);
       ps.setString(2, uname);
       ps.setString(3, pass);
       
       int n=ps.executeUpdate();
       con.close();
       return n;
   } 
   
    
}

    

