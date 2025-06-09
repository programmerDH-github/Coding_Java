import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_Joon_14716 {
    static int M,N;
    static int[][] letter;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1,-1,1,-1,1};
    static int[] dy = {-1,1,0,0,-1,1,1,-1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] M_N = br.readLine().split(" ");
        
        M = Integer.parseInt(M_N[0]);
        N = Integer.parseInt(M_N[1]);

        letter = new int[M][N];
        for(int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                letter[i][j] = Integer.parseInt(input[j]);
            }
        }

        visited = new boolean[M][N];
        int count = 0;
        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                if(letter[i][j] == 1 && !visited[i][j]) {
                    count++;
                    bfs(i,j);
                }
            }
        }

        System.out.println(count);

    }

    static void bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        
        queue.offer(new Node(x, y));
        visited[x][y] = true;

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            for(int i = 0; i < 8; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if(nx >= 0 && nx < M && ny >= 0 && ny < N && letter[nx][ny] == 1 && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx, ny));
                }

            }
        }

    }

    static class Node{
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

    }

}
