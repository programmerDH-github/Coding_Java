import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1890 {
    static int N;
    static int[][] numbers, dp;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = new int[N][N];
        dp = new int[N][N];
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                numbers[i][j] = Integer.parseInt(input[j]);
            }
        }

        dp[0][0] = -1;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(i == N-1 && j == N-1) break;

                int ni = i+numbers[i][j];
                int nj = j+numbers[i][j];

                if(ni < N) dp[ni][j] = dp[i][j]+1;
                if(nj < N) dp[i][nj] = dp[i][j]+1;
                
            }
        }
        
        System.out.println(dp[N-1][N-1]-1);

    }

}
