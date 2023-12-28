import java.io.*;

public class Baek_Joon_2775 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int[][] dp = new int[15][15];

        for(int i = 0; i < 15; i++) {
            for(int j = 1; j < 15; j++) {
                if(i == 0) dp[i][j] = j;
                else dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        
        for(int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());

            sb.append(dp[k][n] + "\n");         
        }

        System.out.println(sb);
    }
}
