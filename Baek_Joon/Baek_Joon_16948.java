import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_Joon_16948 {
    static int[] dx = {-2,-2,0,0,2,2};
    static int[] dy = {-1,1,-2,2,-1,1};
    static boolean[][] visited;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        int r1 = Integer.parseInt(input[0]);
        int c1 = Integer.parseInt(input[1]);
        int r2 = Integer.parseInt(input[2]);
        int c2 = Integer.parseInt(input[3]);

        visited = new boolean[N][N];

        bfs(r1, c1, r2, c2, N);

        if(min == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(min);

    }

    static void bfs(int x1, int y1, int x2, int y2, int N) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x1, y1,1));
        visited[x1][y1] = true;
        
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            
            for(int i = 0; i < 6; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                int count = node.count;

                if(nx == x2 && ny == y2) {
                    min = Math.min(min, count);
                    continue;
                } 

                if(nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx, ny, count+1));
                }

            }

        }

    }

    static class Node {
        int x;
        int y;
        int count;
        
        Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }
    }

}
