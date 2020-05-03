package rmi;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class LogingImplementation extends UnicastRemoteObject implements LoginService  {

    public LogingImplementation() throws RemoteException {
        
        
    }
    
    //Implementing the admin logging function. Admin can able to log to the system via below logging credentials
    //Username:admin
    //Password:123
    
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
