package projet1;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Main {
    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {

        IServices services = (IServices) Naming.lookup("rmi://127.0.0.1:1250/hamza");
        for (int i = 0; i <20 ; i++) {
            new Camera(i+1, services).start();
        }
    }
}
