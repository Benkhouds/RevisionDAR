package projet1;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class Alarme extends UnicastRemoteObject implements IServices {

    private Alarme() throws RemoteException{}

    public static void main(String[] args) throws RemoteException, MalformedURLException {

        Alarme server = new Alarme();
        LocateRegistry.createRegistry(1250);
        Naming.rebind("rmi://127.0.0.1:1250/hamza", server);
    }

    @Override
    public void checkStatus(String s){
        System.out.println(s);
    }
}
