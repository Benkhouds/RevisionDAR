package rmi;

import java.rmi.RemoteException;

public class Agent  extends Thread{

    private InterfaceDistributeur distributeur;

    public Agent(InterfaceDistributeur distributeur) {
        this.distributeur = distributeur;
    }

    @Override
    public void run() {
        try {
            distributeur.déposerJouet();
        } catch (InterruptedException | RemoteException e) {
            e.printStackTrace();
        }
    }
}
