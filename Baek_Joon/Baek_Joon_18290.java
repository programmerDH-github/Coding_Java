import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_18290 {
    static int N,M,K;
    static int[][] map;
    static int[][] checked;
    static int max = 0;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_M_K = br.readLine().split(" ");
        N = Integer.parseInt(N_M_K[0]);
        M = Integer.parseInt(N_M_K[1]);
        K = Integer.parseInt(N_M_K[2]);

        map = new int[N][M];
        checked = new int[N][M];
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                checked[i][j]++;
                for(int k = 0; k < 4; k++) {
                    int ni = i + dx[k];
                    int nj = j + dy[k];

                    if(ni >= 0 && ni < N && nj >= 0 && nj < M) checked[ni][nj]++;
                }

                dfs(i, j, 1, map[i][j]);

                for(int k = 0; k < 4; k++) {
                    int ni = i + dx[k];
                    int nj = j + dy[k];

                    if(ni >= 0 && ni < N && nj >= 0 && nj < M) checked[ni][nj]--;
                }
                checked[i][j]--;
            }
        }
        

        System.out.println(max);

    }

    static void dfs(int x, int y, int count, int sum) {
        if(count == K) {
            max = Math.max(max, sum);
            return;
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(checked[i][j] == 0) {
                    checked[i][j]++;
                    for(int k = 0; k < 4; k++) {
                        int ni = i + dx[k];
                        int nj = j + dy[k];

                        if(ni >= 0 && ni < N && nj >= 0 && nj < M) checked[ni][nj]++;
                    }
                    dfs(i, j, count+1, sum+map[i][j]);

                    for(int k = 0; k < 4; k++) {
                        int ni = i + dx[k];
                        int nj = j + dy[k];

                        if(ni >= 0 && ni < N && nj >= 0 && nj < M) checked[ni][nj]--;
                    }
                    checked[i][j]--;
                }
            }
        }
    }

}
