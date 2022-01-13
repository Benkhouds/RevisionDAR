package thread;

import java.util.ArrayList;
import java.util.List;

public class Distributeur {
    private List<Jouet> jouets = new ArrayList<>();
    private int capacité = 20;

    public void déposerJouet() throws InterruptedException {
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

    public void retirerJouet() throws InterruptedException {
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
}
