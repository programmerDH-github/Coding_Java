import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_9084 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            int[] coin = new int[N+1];
            String[] coins = br.readLine().split(" ");
            for(int j = 1; j <= N; j++) {
                coin[j] = Integer.parseInt(coins[j-1]);
            }

            int M = Integer.parseInt(br.readLine());
            int[][] dp = new int[N+1][M+1];

            for(int j = 0; j <= N; j++) {
                dp[j][0] = 1;
            }
            
            for(int j = 1; j <= N; j++) {
                for(int z = 1; z <= M; z++) {
                    dp[j][z] = dp[j-1][z];
                    if(z-coin[j] >= 0) dp[j][z] += dp[j][z-coin[j]];
                }
            }
           
            System.out.println(dp[N][M]);

        }      
    }
}
