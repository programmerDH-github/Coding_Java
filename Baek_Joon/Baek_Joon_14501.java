import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_14501 {
    static int N;
    static int result = 0;
    static int[][] consulting;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        consulting = new int[N][2];
        dp = new int[N+1];
        
        for(int i = 0; i < N; i++) {
            String[] T_P = br.readLine().split(" ");
            consulting[i][0] = Integer.parseInt(T_P[0]);
            consulting[i][1] = Integer.parseInt(T_P[1]);
        }

        // dp 풀이법
        dp_result();

        // 백트래킹 풀이법
        dfs_result();
    }

    public static void dp_result() {
        for(int i = 0; i < N; i++) {
            if(i + consulting[i][0] <= N) {
                dp[i + consulting[i][0]] = Math.max(dp[i + consulting[i][0]], dp[i] + consulting[i][1]);
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }
        System.out.println(dp[N]);
    }

    public static void dfs_result() {
        dfs(0,0);
        System.out.println(result);
    }

    public static void dfs(int idx, int cost) {
        if(idx >= N) {
            result = Math.max(result, cost);
            return;
        }

        if(idx + consulting[idx][0] > N) {
            dfs(idx + consulting[idx][0], cost);
        }
        else {
            dfs(idx + consulting[idx][0], cost + consulting[idx][1]);
        }

        dfs(idx+1, cost);
    }
}
