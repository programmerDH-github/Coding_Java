import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_Joon_7569 {
    static int[] dx = {0,0,-1,1,0,0};
    static int[] dy = {0,0,0,0,-1,1};
    static int[] dh = {1,-1,0,0,0,0};

    static int M,N,H,days;
    static int[][][] box;
    static Queue<int[]> queue;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] M_N_H = br.readLine().split(" ");
        M = Integer.parseInt(M_N_H[0]); 
        N = Integer.parseInt(M_N_H[1]); 
        H = Integer.parseInt(M_N_H[2]);
           
        box = new int[H][N][M];
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                String[] input = br.readLine().split(" ");
                for(int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(input[k]);
                }
            }
        }

        
        queue = new LinkedList<>();

        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    if(box[i][j][k] == 1) {
                        queue.offer(new int[]{i,j,k});
                    }
                }
            }
        }

        bfs();

        int answer = 0;
        for(int i = 0; i < H; i++) {
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    if(box[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    
                    if(answer < box[i][j][k]) answer = box[i][j][k];
                }
            }
        }

        System.out.println(answer-1);

    }

    static void bfs() {
        while(!queue.isEmpty()) {
            int[] h_x_y = queue.poll();

            for(int i = 0; i < 6; i++) {
                int nh = h_x_y[0] + dh[i];
                int nx = h_x_y[1] + dx[i];
                int ny = h_x_y[2] + dy[i];

                if(nh >= 0 && nh < H && nx >= 0 && nx < N && ny >= 0 && ny < M && box[nh][nx][ny] == 0) {
                    queue.offer(new int[]{nh,nx,ny});
                    box[nh][nx][ny] = box[h_x_y[0]][h_x_y[1]][h_x_y[2]] + 1;
                }

            }
        }

        return;
    }

}
