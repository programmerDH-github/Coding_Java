import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_Joon_14916 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] coin = {2,5};

        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        for(int i = 1; i <= n; i++) {
            if(i == 2) dp[i] = 1;
            if(i == 4) dp[i] = 2;
            if(i == 5) dp[i] = 1;
            if(i > 5) dp[i] = Math.min(dp[i-coin[0]], dp[i-coin[1]]) + 1;
        }

        if(dp[n] == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(dp[n]);

    }
}
