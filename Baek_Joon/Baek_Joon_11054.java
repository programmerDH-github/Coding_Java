import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_11054 {
    static int max = 0;
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
            dp[i] = 1;
            for(int j = 0; j < i; j++) {
                if(A[i] > A[j]) dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }

        int[] pd = new int[N];
        for(int i = N-1; i >= 0; i--) {
            pd[i] = 1;
            for(int j = N-1; j > i; j--) {
                if(A[i] > A[j]) pd[i] = Math.max(pd[i], pd[j]+1);
            }
        }

        int max = 0;
        for(int i = 0; i < N; i++) max = Math.max(max, dp[i]+pd[i]);
        System.out.println(max-1);

    }
}
