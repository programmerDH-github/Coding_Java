import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_Joon_1495 {
    static int N,S,M;
    static int[] V;
    static int max = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_S_M = br.readLine().split(" ");
        N = Integer.parseInt(N_S_M[0]);
        S = Integer.parseInt(N_S_M[1]);
        M = Integer.parseInt(N_S_M[2]);

        V = new int[N];
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) V[i] = Integer.parseInt(input[i]);
        
        int[][] dp = new int[N+1][M+1];
        for(int i = 0; i <= N; i++) Arrays.fill(dp[i], -1);
        dp[0][S] = 0;

        for(int i = 1; i <= N; i++) {
            for(int j = 0; j <= M; j++) {
                if(dp[i-1][j] >= 0) {
                    int plus = j + V[i-1];
                    int minus = j - V[i-1];

                    if(plus <= M) dp[i][plus] = i;
                    if(minus >= 0) dp[i][minus] = i;

                }
            }
        }

        int answer = -1;
        for(int i = M; i >= 0; i--) {
            if(dp[N][i] != -1) {
                answer = i;
                break;
            }
        }

        System.out.println(answer);

    }


}
