import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_Joon_2583 {
    static int M,N,K,count;
    static ArrayList<Integer> arraylist = new ArrayList<>();
    static boolean[][] visited;
    static int[][] arr;
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] M_N_K = br.readLine().split(" ");
        M = Integer.parseInt(M_N_K[0]);
        N = Integer.parseInt(M_N_K[1]);
        K = Integer.parseInt(M_N_K[2]);

        arr = new int[N][M];
        visited = new boolean[N][M];
        for(int i = 0; i < K; i++) {
            String[] x1_y1_x2_y2 = br.readLine().split(" ");
            int x1 = Integer.parseInt(x1_y1_x2_y2[0]);
            int y1 = Integer.parseInt(x1_y1_x2_y2[1]);
            int x2 = Integer.parseInt(x1_y1_x2_y2[2]);
            int y2 = Integer.parseInt(x1_y1_x2_y2[3]);

            for(int j = x1; j < x2; j++) {
                for(int z = y1; z < y2; z++) {
                    arr[j][z] = 1;
                }
            }

        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(arr[i][j] == 0 && !visited[i][j]) {
                    count = 1;
                    visited[i][j] = true;
                    bfs(i,j);
                    arraylist.add(count);
                }
            }
        }

        Collections.sort(arraylist);
        
        sb.append(arraylist.size()).append("\n");
        for(int count : arraylist) sb.append(count).append(" ");
        sb.append("\n");

        System.out.println(sb);


    }

    static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x,y});

        while(!queue.isEmpty()) {
            int[] x_y = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = x_y[0] + dx[i];
                int ny = x_y[1] + dy[i];

                if(nx < N && nx >= 0 && ny < M && ny >= 0 && arr[nx][ny] == 0 && !visited[nx][ny]) {
                    visited[nx][ny] = true;            
                    queue.offer(new int[]{nx,ny});
                    count++;
                }
            }

        }

    }

}
