package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class Main {

    public static void main(String[] args) throws InterruptedException, RemoteException, MalformedURLException, NotBoundException {
        InterfaceDistributeur distributeur = (InterfaceDistributeur) Naming.lookup("rmi://127.0.0.1:1250/dist");

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
