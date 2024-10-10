import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_11055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(input[i]);
        }

        int[] dp = new int[N];
        
        for(int i = 0; i < N; i++) {
            dp[i] = A[i];
            for(int j = 0; j < i; j++) {
                if(A[i] > A[j]) dp[i] = Math.max(dp[i], dp[j]+A[i]);
            }
        }

        int max = 0;
        for(int i = 0; i < N; i++) {
            System.out.print(dp[i] + " ");
            if(max < dp[i]) max = dp[i];
        }

        // System.out.println(max);

    }
}
