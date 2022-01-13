import java.net.*;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.*;

public class Distributeur extends UnicastRemoteObject implements InterfaceDistributeur {
    private List<Jouet> jouets = new ArrayList<>();
    private int capacité = 20;


    private Distributeur() throws RemoteException {
    }

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        Distributeur distributeur = new Distributeur();
        LocateRegistry.createRegistry(1250);
        Naming.rebind("rmi://localhost:1250/dist", distributeur);
    }

    @Override
    public synchronized void déposerJouet() throws RemoteException {
                while (jouets.size() != 0) {
                    try{
                        wait();
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
                System.out.println(" agent ajoute 20 jouet ");
                for (int i = 0; i <20 ; i++) {
                    jouets.add(new Jouet());
                }
                notify();
    }

    public synchronized void retirerJouet() throws  RemoteException {
                while (jouets.size()==0){
                    try{
                        wait();
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }
                System.out.println(" enfant retire jouet " + jouets.size());
                jouets.remove(0);
                notify();
    }

}
