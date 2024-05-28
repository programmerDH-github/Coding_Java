import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_Joon_11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] N_M = br.readLine().split(" ");
        int N = Integer.parseInt(N_M[0]);
        int M = Integer.parseInt(N_M[1]);

        int[][] number = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++) {
                number[i][j] = Integer.parseInt(st.nextToken());                
            }            
        }

        int[][] dp = new int[N+1][N+1];
        for(int i = 1; i <= N; i++) {            
            for(int j = 1; j <= N; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + number[i][j];
            }
        }

        for(int i = 0; i < M; i++) {
            String[] coordinate = br.readLine().split(" ");
            int x1 = Integer.parseInt(coordinate[0]);
            int y1 = Integer.parseInt(coordinate[1]);
            int x2 = Integer.parseInt(coordinate[2]);
            int y2 = Integer.parseInt(coordinate[3]);

            int answer = dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1]; 

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
