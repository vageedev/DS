package rmi;

import static java.lang.Class.forName;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DatabaseConnection {
    
    private DatabaseConnection(){
    
    try {
        
       Class.forName("com.mysql.jdbc.Driver");
       System.out.println("Driver loaded");
       
       
     }
    catch (Exception ex) {
        
             System.out.println(ex);
            
    }
    
  }
    
    public static void main(String[] args){
        
        new DatabaseConnection();
    }
    
}
