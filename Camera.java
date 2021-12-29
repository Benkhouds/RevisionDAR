package projet1;

import java.rmi.RemoteException;

public class Camera extends Thread{

    private final int id ;
    private final IServices services;

    public Camera(int id, IServices  services){
        this.id = id ;
        this.services = services;
    }

    @Override
    public void run(){
        synchronized (services){
            String[] values = new String[]{ "Rahma","mootez", "saif", "klsqfq", "test", "hamza","rahma5651", "saif54", "klsqfq654", "test3"};
            String s  = values[(int) (Math.random()*10)] + id;
            try {
                services.checkStatus(s);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
        try{
            sleep(60*1000*5);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}
