import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_14494 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] n_m = br.readLine().split(" ");
        int n = Integer.parseInt(n_m[0]);
        int m = Integer.parseInt(n_m[1]);

        int INF = 1000000007;

        int[][] dp = new int[n+1][m+1];        
        for(int i = 1; i <= n; i++) dp[i][1] = 1;
        for(int i = 1; i <= m; i++) dp[1][i] = 1;
        
        for(int i = 2; i <= n; i++) {
            for(int j = 2; j <= m; j++) {
                dp[i][j] = ((dp[i-1][j] + dp[i][j-1])%INF + dp[i-1][j-1])%INF;
            }
        }

        System.out.println(dp[n][m]);

    }
}