import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1520 {
    static int M,N;
    static int[][] dp;
    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {1,-1,0,0,};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] M_N = br.readLine().split(" ");
        M = Integer.parseInt(M_N[0]);
        N = Integer.parseInt(M_N[1]);

        map = new int[M][N];
        for(int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        dp = new int[M][N];
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(dfs(0,0)); 

    }

    static int dfs(int x, int y) {
        if(x == M-1 && y == N-1) {
            return 1;
        }

        if(dp[x][y] != -1) return dp[x][y];

        dp[x][y] = 0;
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < M && nx >= 0 && ny < N && ny >= 0 && map[x][y] > map[nx][ny]) {
                dp[x][y] += dfs(nx,ny);
                
            }
        }

        return dp[x][y];

    }

}
