package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Distributeur  extends UnicastRemoteObject implements InterfaceDistributeur {
    private List<Jouet> jouets = new ArrayList<>();
    private int capacité = 20;

    public Distributeur() throws RemoteException {
    }

    @Override
    public void déposerJouet() throws InterruptedException, RemoteException {
        while (true){
            synchronized (this) {
                // attend lorsque le distributeur est plein
                while (jouets.size()==capacité)
                    wait();

                // ajoute un jouet
                System.out.println(" agent ajoute jouet " + jouets.size());
                jouets.add(new Jouet());

                // notifie les enfants
                notify();

                // juste pour voir mieux l execution
                Thread.sleep(500);
            }
        }
    }

    public void retirerJouet() throws InterruptedException, RemoteException {
        while (true){
            synchronized (this) {

                // attend lorsque le distributeur est vide
                while (jouets.size()==0)
                    wait();

                // retire toujours le premier jouet
                System.out.println(" enfant retire jouet " + jouets.size());
                jouets.remove(0);

                // notifie les agents
                notify();

                // juste pour voir mieux l execution
                Thread.sleep(500);
            }
        }
    }

    public static void main(String[] args) throws RemoteException, MalformedURLException {
        Distributeur distributeur = new Distributeur();

        java.rmi.registry.LocateRegistry.createRegistry(1250);

        Naming.rebind("rmi://127.0.0.1:1250/dist", distributeur);
    }
}
