import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_Joon_2225 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_K = br.readLine().split(" ");
        int N = Integer.parseInt(N_K[0]);
        int K = Integer.parseInt(N_K[1]);

        int mod = 1_000_000_000;
        int[][] dp = new int[201][201];

        Arrays.fill(dp[1], 1);
        for(int i = 1; i <= K; i++) dp[i][0] = 1;

        for(int i = 2; i <= K; i++) {
            for(int j = 1; j <= N; j++) {
                dp[i][j] = (dp[i-1][j] + dp[i][j-1])%mod;
            }
        }

        System.out.println(dp[K][N]);

    }
}
