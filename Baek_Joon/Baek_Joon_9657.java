import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_9657 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;
        dp[4] = 1;

        for(int i = 5; i <= N; i++) {
            dp[i] = 1;
            if((N-1)%2 == 0 || (N-3)%2 == 0 || (N-4)%2 == 0) dp[i] = 2;
        }

        if(dp[N] == 1) System.out.println("CY");
        else System.out.println("SK");

    }
}
