import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1446 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_D = br.readLine().split(" ");
        int N = Integer.parseInt(N_D[0]);
        int D = Integer.parseInt(N_D[1]);

        int[][] shortcut = new int[N][3];
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            shortcut[i][0] = Integer.parseInt(input[0]);
            shortcut[i][1] = Integer.parseInt(input[1]);
            shortcut[i][2] = Integer.parseInt(input[2]);
        }

        int[] dp = new int[D+1];

        for(int i = 1; i <= D; i++) {
            dp[i] = dp[i-1] + 1;

            for(int j = 0; j < N; j++) {
                if(shortcut[j][1] == i) {
                    if(shortcut[j][2] > D) continue;
                    dp[i] = Math.min(dp[i], shortcut[j][2] + dp[shortcut[j][0]]);
                }
            }


        }

        System.out.println(dp[D]);

    }
}
