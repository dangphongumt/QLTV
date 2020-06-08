/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mo_hinh;

import java.sql.DriverManager;
import javax.swing.JOptionPane;
import java.sql.*;
import com.microsoft.sqlserver.jdbc.SQLServerDriver;
import java.util.ArrayList;


public class Connec {
  private Connection conn;
   //private static String DB_URL = "jdbc:sqlserver://127.0.0.1:1433;databaseName=BAITAPLON_p";
    //private static String USER_NAME = "sa";
   // private static String PASSWORD = "1234";
 

    
        
       public static void main(String[] args) {
  try {
            
            Connection conn = getConnection();
            
         
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    
}
       public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;databaseName=qltv;Username=sa;Password = 123");
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }

    

}
