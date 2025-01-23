import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_Joon_1743 {
    static int N,M,K;
    static int[][] map;
    static boolean[][] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_M_K = br.readLine().split(" ");
        N = Integer.parseInt(N_M_K[0]);
        M = Integer.parseInt(N_M_K[1]);
        K = Integer.parseInt(N_M_K[2]);

        map = new int[N+1][M+1];
        for(int i = 0; i < K; i++) {
            String[] x_y = br.readLine().split(" ");
            int x = Integer.parseInt(x_y[0]);
            int y = Integer.parseInt(x_y[1]);

            map[x][y] = 1;

        }  

        check = new boolean[N+1][M+1];
        int max = 0;
        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                if(!check[i][j] && map[i][j] == 1) {
                    max = Math.max(max, bfs(i,j));
                }
            }
        }

        System.out.println(max);

    }

    static int bfs(int x, int y) {
        check[x][y] = true;

        Queue<int[]> queue = new LinkedList<>();        
        queue.add(new int[]{x,y});

        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};

        int width = 1;
        while(!queue.isEmpty()) {
            int[] x_y = queue.poll();
            
            for(int i = 0; i < 4; i++) {
                int nx = x_y[0] + dx[i];
                int ny = x_y[1] + dy[i];

                if(nx >= 1 && nx <= N && ny >= 1 && ny <= M && !check[nx][ny] && map[nx][ny] == 1) {
                    check[nx][ny] = true;
                    width++;
                    queue.add(new int[]{nx,ny});
                }
            }            

        }

        return width;
    }

}
