import java.io.*;

public class Baek_Joon_12865 {
    static int N,K,result;
    static int[] w,v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_K = br.readLine().split(" ");
        N = Integer.parseInt(N_K[0]);
        K = Integer.parseInt(N_K[1]);
        
        w = new int[N+1];
        v = new int[N+1];
        for(int i = 1; i <= N; i++) {
            String[] w_v = br.readLine().split(" ");
            w[i] = Integer.parseInt(w_v[0]);
            v[i] = Integer.parseInt(w_v[1]);
        }
        
        int[][] dp = new int[N+1][K+1];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= K; j++) {
                if(j - w[i] >= 0) dp[i][j] = Math.max(dp[i-1][j], v[i]+dp[i-1][j-w[i]]);
                else dp[i][j] = dp[i-1][j];
            }
        }
        System.out.println(dp[N][K]);
    }
}
