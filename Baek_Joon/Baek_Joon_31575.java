import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_Joon_31575 {
    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {1,0};
    static int[] dy = {0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_M = br.readLine().split(" ");
        N = Integer.parseInt(N_M[0]);
        M = Integer.parseInt(N_M[1]);
        map = new int[M][N];
        visited = new boolean[M][N];

        for(int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        if(bfs(0, 0)) System.out.println("Yes");
        else System.out.println("No");

    }

    static boolean bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(x, y));

        visited[x][y] = true;

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            if(node.x == M-1 && node.y == N-1) return true;
            
            for(int i = 0; i < 2; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx >= 0 && nx < M && ny >= 0 && ny < N && map[nx][ny] == 1 && !visited[nx][ny]) {                    
                    visited[nx][ny] = true;
                    queue.add(new Node(nx, ny));
                }

            }

        }


        return false;
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
