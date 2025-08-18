import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_4883 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();   

        int k = 1;
        while(true) {
            int N = Integer.parseInt(br.readLine());

            if(N == 0) break;

            int[][] cost = new int[N][3];
            for(int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
            
                for(int j = 0; j < 3; j++) {
                    cost[i][j] = Integer.parseInt(input[j]);
                }
            }


            int[][] dp = new int[N][3];
            for(int i = 0; i < N; i++) {
                if(i == 0) {
                    dp[i][0] = Integer.MAX_VALUE;
                    dp[i][1] = cost[i][1];
                    dp[i][2] = cost[i][1] + cost[i][2];
                    continue;
                }

                // if(i == 1) {
                //     dp[i][0] = cost[i-1][1] + cost[i][0];
                //     dp[i][1] = Math.min(dp[i-1][1]+dp[i-1][2],Math.min(dp[i-1][1]+cost[i][0], dp[i-1][1]+cost[i][1])) + cost[i][1];
                //     dp[i][2] = Math.min(dp[i-1][1]+dp[i-1][2]+dp[i][1],Math.min(dp[i-1][1]+dp[i][1],Math.min(dp[i-1][1], dp[i-1][1]+dp[i-1][2]))) + cost[i][2];
                //     continue;
                // }

                dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]) + cost[i][0];
                dp[i][1] = Math.min(dp[i][0], Math.min(dp[i-1][0], Math.min(dp[i-1][1], dp[i-1][2]))) + cost[i][1];
                dp[i][2] = Math.min(dp[i][1], Math.min(dp[i-1][1], dp[i-1][2])) + cost[i][2];

            }

            sb.append(k+". ").append(dp[N-1][1]).append("\n");
            k++;            

        }
        
        System.out.println(sb);

    }
}
