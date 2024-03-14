import java.io.*;

public class Baek_Joon_1904 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[1000001];

        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i < 1000001; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 15746;
        }

        System.out.println(dp[N]);

    }
}
