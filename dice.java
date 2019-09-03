import java.util.Random;

public class dice {
    private Random rand = new Random();
    int roll(){
        int n1 = rand.nextInt(5); //Random number between 0-5
        return n1+1;
        //return 1;//Used to test doubles
    }

    int random_number(int zero_n_bound){
        int n = rand.nextInt(zero_n_bound); //Random number between 0-5
        return n;
    }
}