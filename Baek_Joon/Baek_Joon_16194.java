import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_16194 {
    static int N,min;
    static int[] card;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        card = new int[N+1];
        String[] input = br.readLine().split(" ");
        for(int i = 1; i <= N; i++) card[i] = Integer.parseInt(input[i-1]);

        int[] dp = new int[N+1];
        
        for(int i = 1; i <= N; i++) {
            dp[i] = card[i];
            for(int j = 1; j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i-j] + card[j]);
            }
        }

        System.out.println(dp[N]);

    }
}
