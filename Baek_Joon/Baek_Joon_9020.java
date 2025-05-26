import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Baek_Joon_9020 {
    static boolean[] prime = new boolean[10001];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        boolean[] prime = new boolean[10001];
        for(int i = 2; i <= 10000; i++) {
            prime[i] = isPrime(i);
        }
        
        for(int i = 0; i < T; i++) {
            int target = Integer.parseInt(br.readLine());
            int left = target/2;
            int right = target/2;

            while(true) {                
                if(prime[left] && prime[right]) {
                    sb.append(left+" "+right).append("\n");
                    break;
                }
                left--;
                right++;
            }

        }

        System.out.println(sb);

    }

    static boolean isPrime(int n) {
        if(n <= 1) return false;
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

}