import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_Joon_2206 {
    static int N,M,min;
    static boolean[][] visited;
    static int[][] maps;
    static boolean wall;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,1,-1}; 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_M = br.readLine().split(" ");
        N = Integer.parseInt(N_M[0]);
        M = Integer.parseInt(N_M[1]);
        visited = new boolean[N][M];
        maps = new int[N][M];

        for(int i = 0; i < N; i++) {
            String[] map = br.readLine().split("");
            for(int j = 0; j < M; j++) {
                maps[i][j] = Integer.parseInt(map[j]);
            }
        }

        visited[0][0] = true;
        min = Integer.MAX_VALUE;
        // dfs(0,0,1);
        // System.out.println(min != Integer.MAX_VALUE ? min : -1);
        System.out.println(bfs(0, 0, 1));

    }

    // 시간 초과
    public static void dfs(int x, int y, int distance) {
        if(x == N-1 && y == M-1) {
            min = Math.min(min, distance);
            return;
        }

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx][ny]) {
                visited[nx][ny] = true;
                if(maps[nx][ny] == 1 && !wall) {
                    wall = true;
                    dfs(nx, ny, distance+1);
                    wall = false;
                }
                if(maps[nx][ny] == 0) {
                    dfs(nx, ny, distance+1);
                }
                visited[nx][ny] = false;
            }
        }
    }

    public static int bfs(int x, int y, int distance) {
        boolean[][][] check = new boolean[N][M][2];
        Queue<Node> queue = new LinkedList<>();

        queue.offer(new Node(x, y, distance, false));
        check[0][0][0] = true;

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if(node.x == N-1 && node.y == M-1) {
                return node.distance;
            }

            for(int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if(node.borken) {
                        if(maps[nx][ny] == 0 && !check[nx][ny][1]) {
                            check[nx][ny][1] = true;
                            queue.offer(new Node(nx, ny, node.distance+1, true));
                        }
                    }
                    else {
                        if(maps[nx][ny] == 1) {
                            check[nx][ny][1] = true;
                            queue.offer(new Node(nx, ny, node.distance+1, true));
                        }
                        else if(!check[nx][ny][0]) {
                            check[nx][ny][0] = true;
                            queue.offer(new Node(nx, ny, node.distance+1, false));
                        }
                    }
                }
            }

        }
        return -1;

    }

    public static class Node {
        int x;
        int y;        
        int distance;
        boolean borken;

        public Node(int x, int y, int distance, boolean borken) {
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.borken = borken;
        }
    }
}
