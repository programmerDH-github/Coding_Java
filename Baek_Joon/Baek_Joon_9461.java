import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_9461 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[101];

        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        dp[5] = 2;
        for(int i = 6; i < dp.length; i++) {
            dp[i] = dp[i-5] + dp[i-1];
        }

        for(int i = 1; i < 17; i++) {
            System.out.println("dp["+i+"] : " + dp[i]);
        }

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine()); 
            System.out.println(dp[N]);
        }
        
    }
}
