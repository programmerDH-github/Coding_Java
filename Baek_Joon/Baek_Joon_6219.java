import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_6219 {
    static boolean[] prime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] A_B_D = br.readLine().split(" ");
        int A = Integer.parseInt(A_B_D[0]);
        int B = Integer.parseInt(A_B_D[1]);
        String D = A_B_D[2];

        prime = new boolean[B+1];
        for(int i = 0; i <= B; i++) {
            prime[i] = isPrime(i);
        }

        int count = 0;
        for(int i = A; i <= B; i++) {
            if(prime[i] && (Integer.toString(i)).contains(D)) count++;            
        }

        System.out.println(count);

    }

    static boolean isPrime(int number) {
        if(number <= 1) return false;

        for(int i = 2; i <= Math.sqrt(number); i++) {
            if(number % i == 0) return false; 
        }

        return true;
    }

}
