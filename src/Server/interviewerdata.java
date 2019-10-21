
package javaapplication9;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class interviewerdata {

    
    public static Connection getConnection()  {   
       /* try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(interviewerdata.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        String url = "jdbc:mysql://localhost:3306/logininfo";
        String uname = "root";
        String pass = "neeraj@17";
        Connection con=null;
        try {
           
            con = DriverManager.getConnection(url, uname, pass);
             System.out.println("success");
             
             
        } catch (SQLException ex) {
            Logger.getLogger(interviewerdata.class.getName()).log(Level.SEVERE, null, ex);
        }
       return con;
       
    }
    
}
