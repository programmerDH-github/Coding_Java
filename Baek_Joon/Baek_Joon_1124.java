import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Baek_Joon_1124 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] A_B = br.readLine().split(" ");
        int A = Integer.parseInt(A_B[0]);
        int B = Integer.parseInt(A_B[1]);

        int answer = 0;
        for(int i = A; i <= B; i++) {
            int number = i;
            int count = 0;
            for(int j = 2; j <= Math.sqrt(i); j++) {                                  
                while(number % j == 0) {
                    count++;
                    number /= j;
                }
            }
            if(number > 1) count++;
            if(isPrime(count)) answer++;
        }

        System.out.println(answer);

    }

    static boolean isPrime(int n) {
        if(n <= 1) return false;

        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }


        return true;
    }

}
