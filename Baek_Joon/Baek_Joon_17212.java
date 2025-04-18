import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_Joon_17212 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] coin = {1,2,5,7};

        int[] dp = new int[N+1];
        Arrays.fill(dp, 100001);
        dp[0] = 0;

        for(int i = 1; i <= N; i++) {
            for(int j = 0; j < 4; j++) {
                if(i-coin[j] >= 0) dp[i] = Math.min(dp[i], dp[i-coin[j]]+1);
            }
        }

        System.out.println(dp[N]);

    }
}
