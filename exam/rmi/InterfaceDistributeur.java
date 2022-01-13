

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceDistributeur extends Remote {

    void déposerJouet() throws RemoteException, InterruptedException;
    void retirerJouet() throws  RemoteException;
}
