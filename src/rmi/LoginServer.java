package rmi;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

//RMI server

public class LoginServer {
    
    public static void main(String[] args){
        
        try{
            
            Registry reg = LocateRegistry.createRegistry(1099);
            LogingImplementation lp = new LogingImplementation();
            reg.rebind("login", lp);
            System.out.println("Server Is Ready!");
            
        }
        catch(Exception ex){
            
            ex.printStackTrace();
            
        }
            
        
    }
    
    
    
    
}
