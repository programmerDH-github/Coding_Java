import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_11051 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_K = br.readLine().split(" ");
        int N = Integer.parseInt(N_K[0]);
        int K = Integer.parseInt(N_K[1]);
        int mod = 10_007;

        int[][] dp = new int[N+1][K+1];

        for(int i = 0; i <= N; i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= K; j++) {
                if(i == j) dp[i][j] = 1;
                else dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % mod;
            }
        }

        System.out.println(dp[N][K]);

    }
}
