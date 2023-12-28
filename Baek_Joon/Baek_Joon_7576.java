import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_Joon_7576 {
    static int M,N;
    static int[][] box;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static Queue<int[]> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] M_N = br.readLine().split(" ");
        M = Integer.parseInt(M_N[0]);
        N = Integer.parseInt(M_N[1]);

        box = new int[N][M];

        for(int i = 0; i < N; i++) {
            String[] tomato = br.readLine().split(" ");
            for(int j = 0; j < M; j++) {
                box[i][j] = Integer.parseInt(tomato[j]);
            }
        }

        queue = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(box[i][j] == 1) {
                    queue.add(new int[]{i,j});
                }
            }
        }
        
        bfs();
        System.out.println(min_day(box));
    }

    public static void bfs() {        
        while(!queue.isEmpty()) {
            int cur_x = queue.peek()[0];
            int cur_y = queue.peek()[1];
            queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = cur_x + dx[i];
                int ny = cur_y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M && box[nx][ny] == 0) {
                    box[nx][ny] = box[cur_x][cur_y] + 1;
                    queue.add(new int[]{nx,ny});
                }
            }
        }
    }

    public static int min_day(int[][] arr) {
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 0) return -1;
                if(max < arr[i][j]) max = arr[i][j];
            }
        }

        return max - 1;
    }
}
