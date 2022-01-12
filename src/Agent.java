public class Agent  extends Thread{

    private Distributeur distributeur;

    public Agent(Distributeur distributeur) {
        this.distributeur = distributeur;
    }

    @Override
    public void run() {
        try {
            distributeur.déposerJouet(new Jouet());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
