package projet2;

import java.io.*;
import java.net.Socket;

public class ClientHandler extends Thread{
    private final int id ;
    private final Verifier verifier;
    private BufferedReader input ;
    public ClientHandler(Socket client, int id, Verifier verifier) throws IOException {
        this.id = id;
        this.input = new BufferedReader(new InputStreamReader(client.getInputStream()));
        this.verifier = verifier;

    }
    @Override
    public void run(){
            try {
                double received = Double.parseDouble(input.readLine());
                System.out.println("received from "+ id +" :"+received);
                verifier.addValue(received);
            } catch (IOException e) {
                e.printStackTrace();
            }



    }
}
