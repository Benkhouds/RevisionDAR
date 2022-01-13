package rmi;

import java.rmi.RemoteException;

public class Enfant extends Thread{

    InterfaceDistributeur distributeur;

    public Enfant(InterfaceDistributeur distributeur) {
        this.distributeur = distributeur;
    }

    @Override
    public void run() {
        try {
            distributeur.retirerJouet();
        } catch (InterruptedException | RemoteException e) {
            e.printStackTrace();
        }
    }
}
