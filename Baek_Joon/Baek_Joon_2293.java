import java.io.*;

public class Baek_Joon_2293 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] n_k = br.readLine().split(" ");
        int n = Integer.parseInt(n_k[0]);
        int k = Integer.parseInt(n_k[1]);

        int[] coin = new int[n+1];
        for (int i = 1; i <= n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        int[] dp = new int[k+1];
        dp[0] = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= k; j++) {
                if(j >= coin[i])
                    dp[j] += dp[j-coin[i]];
            }
        }

        System.out.println(dp[k]);
    }
}
