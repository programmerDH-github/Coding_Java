import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_13301 {
    static long[][] dp;
    static long[] length;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N == 1) {
            System.out.println(4);
            return;
        }
        // if(N == 2) {
        //     System.out.println(6);
        //     return;
        // }

        length = new long[N+1];
        length[0] = 1;
        length[1] = 1;

        for(int i = 2; i <= N; i++) {
            length[i] = length[i-1] + length[i-2];
        }


        dp = new long[N+1][2];
        dp[1][0] = 1;
        dp[1][1] = 1;
        dp[2][0] = 1;
        dp[2][1] = 2;

        for(int i = 3; i <= N; i++) {
            dp[i][0] = dp[i-1][0];
            dp[i][1] = dp[i-1][1];
            if(i % 2 == 0) dp[i][1] += length[i-1];            
            else dp[i][0] += length[i-1];
            
        }        

        long answer = dp[N][0]*2 + dp[N][1]*2;
        System.out.println(answer);

    }



}
