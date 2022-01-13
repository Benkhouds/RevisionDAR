package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface InterfaceDistributeur extends Remote {

    void déposerJouet() throws InterruptedException, RemoteException;
    void retirerJouet() throws InterruptedException, RemoteException;
}
