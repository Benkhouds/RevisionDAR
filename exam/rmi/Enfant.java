

import java.rmi.RemoteException;

public class Enfant extends Thread{

    private InterfaceDistributeur distributeur;

    public Enfant(InterfaceDistributeur distributeur) {
        this.distributeur = distributeur;
    }

    @Override
    public void run() {
        try {
            distributeur.retirerJouet();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
