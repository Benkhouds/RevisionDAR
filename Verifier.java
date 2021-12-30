package projet2;

public class Verifier {

    private double sum = 0 ;

    public synchronized void addValue(double val){
        this.sum+=val;
    }

    public double getSum(){
        return sum ;
    }


}
