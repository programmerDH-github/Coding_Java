import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_3896 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        boolean[] prime = new boolean[1299710];
        for(int i = 2; i < prime.length; i++) prime[i] = isPrime(i);

        for(int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            
            int count = 0;

            int left = k;
            int right = k;
            while(!prime[left] || !prime[right]) {
                if(!prime[left] && !prime[right]) {
                    left--;
                    right++;
                    count += 2;
                }
                else if(!prime[left]) {
                    left--;
                    count += 1;
                }
                else {
                    right++;
                    count += 1;
                }

            }

            sb.append(count).append("\n");

        }

        System.out.println(sb);

    }

    static boolean isPrime(int n) {
        for(int i = 2; i <= Math.sqrt(n); i++) {
            if(n % i == 0) return false;
        }
        return true; 
    }

}
