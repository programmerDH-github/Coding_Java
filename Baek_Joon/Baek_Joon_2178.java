import java.io.*;
import java.util.*;

public class Baek_Joon_2178 {
    static int N,M;
    static int[][] maps;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        maps = new int[N][M];
        for(int i = 0; i < N; i++) {
            String[] map = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                maps[i][j] = Integer.parseInt(map[j]);
            }
        }
        
        System.out.println(bfs(0, 0, 1));        

    }

    public static int bfs(int x, int y, int distance) {
        Queue<Node> queue = new LinkedList<>();
        visited = new boolean[N][M];

        queue.offer(new Node(x, y, distance));
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            if(node.x == N-1 && node.y == M-1) {
                return node.distance;
            }

            for(int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M && maps[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx, ny, node.distance + 1));
                }
            }

        }
        return 0;
    }

    public static class Node {
        int x, y, distance;
        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}
