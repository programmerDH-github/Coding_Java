import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_12015 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N+1];
        String[] input = br.readLine().split(" ");
        for(int i = 1; i <= N; i++) A[i] = Integer.parseInt(input[i-1]);

        int[] dp = new int[N+1];
        dp[1] = 1;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j < i; j++) {
                if(A[i] > A[j]) dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }

        int max = 0;
        for(int i = 1; i <= N; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);

    }
}
