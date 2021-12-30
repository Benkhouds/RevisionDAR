package projet2;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Capteur extends Thread{
    private Socket client;

    public Capteur() throws IOException {
        this.client= new Socket("127.0.0.1", 5056);
    }

    @Override
    public void run(){
        PrintWriter output = null;
        try {
            output = new PrintWriter(new BufferedWriter(new OutputStreamWriter(this.client.getOutputStream())), true);
                double temperature = (float)Math.random()*10;
                output.println(temperature);

            output.close();
            client.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
