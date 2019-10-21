
package javaapplication9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class intervieweedata {
    public static Connection getConnection()  {   
      
        String url = "jdbc:mysql://localhost:3306/logininfo2";
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
