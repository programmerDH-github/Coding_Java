import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Beak_Joon_12026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split("");

        int[] dp = new int[N+1];        
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[1] = 0;
        
        for(int i = 1; i <= N; i++) { 
            String nowStr = input[i-1];

            if(dp[i] == Integer.MAX_VALUE) continue;
            for(int j = i+1; j <= N; j++) {
                String nextStr = input[j-1];

                if(nowStr.equals("B") && nextStr.equals("O")) {
                    dp[j] = Math.min(dp[j], dp[i]+(j-i)*(j-i));
                }
                else if(nowStr.equals("O") && nextStr.equals("J")) {
                    dp[j] = Math.min(dp[j], dp[i]+(j-i)*(j-i));
                }
                else if(nowStr.equals("J") && nextStr.equals("B")) {
                    dp[j] = Math.min(dp[j], dp[i]+(j-i)*(j-i));
                }

            }
        }

        if(dp[N] == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(dp[N]);

    }
}
