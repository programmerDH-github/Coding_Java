import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_9656 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[1001];
        dp[1] = 2;
        dp[2] = 1;
        dp[3] = 2;

        for(int i = 3; i < 1001; i++) {
            if(dp[i-3] == 2 && dp[i-1] == 2) dp[i] = 1;
            else dp[i] = 2; 
        }

        if(dp[N] == 2) System.out.println("CY");
        else System.out.println("SK");

    }
}
