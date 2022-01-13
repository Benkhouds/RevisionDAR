

import java.rmi.RemoteException;

public class Agent  extends Thread{

    private InterfaceDistributeur distributeur;
    private int id ;
    public Agent(InterfaceDistributeur distributeur, int id) {
        this.id = id;
        this.distributeur = distributeur;
    }

    @Override
    public void run() {
        try {
            System.out.println(id);
            distributeur.déposerJouet();
        } catch (InterruptedException | RemoteException e) {
            e.printStackTrace();
        }
    }
}
