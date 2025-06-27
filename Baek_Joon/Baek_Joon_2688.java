import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_2688 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        long[][] dp = new long[65][10];
        
        for(int i = 1; i < 65; i++) {      
            for(int j = 0; j < 10; j++) {
                if(j == 0) {
                    dp[i][j] = 1;
                }
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];               
                }            
            }
            
        }

        for(int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            
            long sum = 0;
            for(long value : dp[n]) {
                sum += value;
            }
            sb.append(sum).append("\n");
        }

        System.out.println(sb);

    }


}
