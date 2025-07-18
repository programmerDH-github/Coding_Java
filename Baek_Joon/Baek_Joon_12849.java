import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_12849 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int D = Integer.parseInt(br.readLine());
        int mod = 1_000_000_007;

        long[][] dp = new long[D+1][8];
        dp[0][0] = 1;

        for(int i = 1; i <= D; i++) {
            dp[i][0] = (dp[i-1][1] + dp[i-1][3]) % mod;
            dp[i][1] = (dp[i-1][0] + dp[i-1][2] + dp[i-1][3]) % mod;
            dp[i][2] = (dp[i-1][1] + dp[i-1][3] + dp[i-1][4] + dp[i-1][5]) % mod;
            dp[i][3] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][2] + dp[i-1][5]) % mod;
            dp[i][4] = (dp[i-1][2] + dp[i-1][5] + dp[i-1][6]) % mod;
            dp[i][5] = (dp[i-1][2] + dp[i-1][3] + dp[i-1][4] + dp[i-1][7]) % mod;
            dp[i][6] = (dp[i-1][4] + dp[i-1][7]) % mod;
            dp[i][7] = (dp[i-1][5] + dp[i-1][6]) % mod;
        }

        System.out.println(dp[D][0]);

    }
}
