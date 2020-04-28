package rmi;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class LogingImplementation extends UnicastRemoteObject implements LoginService  {

    public LogingImplementation() throws RemoteException {
        
        
    }
    
    public boolean getLogin(String user, String pass) throws RemoteException {
        
        boolean found = false;
        
        try{
            if(user.equals("admin") && pass.equals("123")){
                
                 
                
                return found = true;
            }
            else{
                return found = false;
            }
        }
        catch(Exception ex){
            
            ex.printStackTrace();
        }
        
        return found;
        
    }
    
    
}
