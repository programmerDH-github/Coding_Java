import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_Joon_17484 {
    static int N,M,answer;
    static int[][] arr;
    static int[] dx = {1,1,1};
    static int[] dy = {-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_M = br.readLine().split(" ");
        N = Integer.parseInt(N_M[0]);
        M = Integer.parseInt(N_M[1]);

        arr = new int[N][M];
        for(int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            } 
        }

        answer = Integer.MAX_VALUE;
        for(int i = 0; i < M; i++) {
            dfs(0,i,arr[0][i],Integer.MAX_VALUE);
        }

        System.out.println(answer);

    }

    static void dfs(int x, int y, int sum, int visited) {
        if(x == N-1) {
            if(answer > sum) answer = sum;
            return;
        }

        for(int i = 0; i < 3; i++) {
            if(i == visited) continue;

            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < N && ny >= 0 && ny < M) {
                dfs(nx, ny, sum+arr[nx][ny], i);
            }
        }
        
    }
}