package projet2;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        for (int i = 0; i <30 ; i++) {
            new Capteur().start();
        }
    }
}
