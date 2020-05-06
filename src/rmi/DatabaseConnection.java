package rmi;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;


public class DatabaseConnection {
    
    private Connection con;
    private static DatabaseConnection db;
    
    private DatabaseConnection(){
    
    try {
        
        //Connecting to the MySQL Database
        
       Class.forName("com.mysql.jdbc.Driver");
       System.out.println("Driver loaded");
       con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/firealarmdb","root","");
       System.out.println("Connection Established");
     }
     catch (Exception ex) {
        
             System.out.println(ex);
            
    }
    
  }
    
    public static DatabaseConnection getDatabaseConnection(){
        
        if(db == null){
           db =  new DatabaseConnection();
        }
        return db;
    }
    
    public Connection getConnection(){
        return con;
    }
    
   
}
