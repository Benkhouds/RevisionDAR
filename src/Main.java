public class Main {

    public static void main(String[] args) throws InterruptedException {
        Distributeur distributeur = new Distributeur();

        Agent agent1 = new Agent(distributeur);
        Agent agent2 = new Agent(distributeur);

        for (int i=0;i<20;i++)
            new Enfant(distributeur).start();

        agent1.start();
        agent2.start();

        agent1.join();
        agent2.join();
    }
}
