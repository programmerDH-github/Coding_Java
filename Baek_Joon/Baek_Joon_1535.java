import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1535 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = 100;

        int[] health = new int[N+1];
        int[] happy = new int[N+1];

        String[] health_arr = br.readLine().split(" ");
        String[] happy_arr = br.readLine().split(" ");
        for(int i = 1; i <= N; i++) {            
            health[i] = Integer.parseInt(health_arr[i-1]);
            happy[i] = Integer.parseInt(happy_arr[i-1]);
        }


        int[][] dp = new int[N+1][K+1];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= K; j++) {
                if(j-health[i] >= 0) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-health[i]]+happy[i]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[N][K-1]);

    }
}
