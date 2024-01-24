import java.io.*;

public class Baek_Joon_1932 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] triangle = new int[N][N];
        int[][] dp = new int[N][N];

        for(int i = 0; i < N; i++) {
            String[] number = br.readLine().split(" ");
            for(int j = 0; j < number.length; j++) {
                triangle[i][j] = Integer.parseInt(number[j]);
            }
        }

        dp[0][0] = triangle[0][0];

        for(int i = 1; i < N; i++) {
            for(int j = 0; j <= i; j++) {
                if(j == 0) dp[i][j] = dp[i-1][j] + triangle[i][j];
                else if(j == i) dp[i][j] = dp[i-1][j-1] + triangle[i][j];                
                else dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];                
            }
        }

        int max = 0;
        for(int i = 0; i < N; i++) {
            max = dp[N-1][i] > max ? dp[N-1][i] : max;
        }
        System.out.println(max);
    }
}
