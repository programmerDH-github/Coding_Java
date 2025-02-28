import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_2302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        boolean[] check = new boolean[41];
        for(int i = 0; i < M; i++) {
            int n = Integer.parseInt(br.readLine());
            check[n] = true;
        }

        int[] dp = new int[41];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= 40; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        int answer = 1;
        int count = 0;
        for(int i = 1; i <= N; i++) {
            if(check[i]) {
                if(count == 0) continue;
                
                answer *= dp[count];
                count = 0;
            }
            else {
                count++;
            }
        }

        if(count > 0) answer *= dp[count];
        
        System.out.println(answer);
        

    }
}
