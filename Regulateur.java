package projet2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Regulateur {
    private static final int seuil = 7;
    private static final int nombreDesCapteurs = 20;

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(5056);

        int counter = 0 ;
        Verifier instance = new Verifier();
        //noinspection InfiniteLoopStatement
        while(counter < nombreDesCapteurs){
            Socket client  = null;
            try{
                System.out.println("Waiting for client to connect");
                client = server.accept();
                counter++;
                Thread t = new ClientHandler(client, counter+1, instance);
                t.start();
                t.join();

            }catch(Exception e){
                server.close();
                e.printStackTrace();
            }
        }
        System.out.println(instance.getSum() / 20);
        if(instance.getSum() /20 <= seuil){
            System.out.println("arrosage");
        }

    }
}
