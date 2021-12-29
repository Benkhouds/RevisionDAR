package projet1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IServices extends Remote {
    void checkStatus(String s) throws RemoteException;
}
