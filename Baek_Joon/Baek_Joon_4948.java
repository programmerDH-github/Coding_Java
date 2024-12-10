import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_4948 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while(true) {
            String input = br.readLine();
            if(input.equals("0")) break;

            int n = Integer.parseInt(input);

            boolean[] prime = new boolean[n*2+1];
            prime[0] = prime[1] = true;
            for(int i = 2; i*i <= n*2; i++) {
                if(!prime[i]) {
                    for(int j = i*i; j <= n*2; j += i) prime[j] = true;
                }
            }
        
            int prime_number = 0;
            for(int i = n+1; i <= n*2; i++) {
                if(!prime[i]) prime_number++;
            }

            sb.append(prime_number).append("\n");

        }

        System.out.println(sb);

    }
}
