import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1189 {
    static int R,C,K;
    static int answer = 0;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static String[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] R_C_K = br.readLine().split(" ");
        R = Integer.parseInt(R_C_K[0]);
        C = Integer.parseInt(R_C_K[1]);
        K = Integer.parseInt(R_C_K[2]);

        map = new String[R][C];
        for(int i = 0; i < R; i++) {
            String[] input = br.readLine().split("");
            for(int j = 0; j < C; j++) {
                map[i][j] = input[j];
            }
        }

        visited = new boolean[R][C];
        dfs(R-1,0,1);

        System.out.println(answer);
        
    }

    static void dfs(int x, int y, int count) {
        visited[x][y] = true;
        
        if(count == K) {
            if(x == 0 && y == C-1) {
                answer++;
            }
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < R && nx >= 0 && ny < C && ny >= 0 && !visited[nx][ny] && map[nx][ny].equals(".")) {
                dfs(nx,ny,count+1);
                visited[nx][ny] = false;
            }

        }


    }
}
