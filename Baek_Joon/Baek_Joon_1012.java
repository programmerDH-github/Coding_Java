import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_Joon_1012 {
    static int[][] farms;
    static boolean[][] visited;
    static int worm = 0;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static int M,N,K;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            String[] M_N_K = br.readLine().split(" ");
            M = Integer.parseInt(M_N_K[0]);
            N = Integer.parseInt(M_N_K[1]);
            K = Integer.parseInt(M_N_K[2]);
            worm = 0;

            farms = new int[N][M];
            visited = new boolean[N][M];
            for(int j = 0; j < K; j++) {
                String[] X_Y = br.readLine().split(" ");
                int X = Integer.parseInt(X_Y[0]);
                int Y = Integer.parseInt(X_Y[1]);

                farms[Y][X] = 1;
            }

            for(int j = 0; j < N; j++) {
                for(int k = 0; k < M; k++) {
                    if(farms[j][k] == 1 && !visited[j][k]) {
                        worm++;
                        bfs(j,k);
                    }
                }
            }
            System.out.println(worm);
        }

    }

    public static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            for(int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M && farms[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx, ny));
                }
            }
        }

    }

    public static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
