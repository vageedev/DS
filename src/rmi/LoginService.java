package rmi;

import java.rmi.*;

public interface LoginService extends Remote{
    
    public boolean getLogin(String user,String pass) throws RemoteException;
    
}
