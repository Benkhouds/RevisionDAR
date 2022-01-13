package thread;

public class Enfant extends Thread{

    Distributeur distributeur;

    public Enfant(Distributeur distributeur) {
        this.distributeur = distributeur;
    }

    @Override
    public void run() {
        try {
            distributeur.retirerJouet();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
