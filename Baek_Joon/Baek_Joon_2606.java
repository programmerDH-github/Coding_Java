import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_Joon_2606 {
    static int n,m;
    static int[][] computers;
    static boolean[] visited;
    static int count = 0;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        visited = new boolean[n+1];
        computers = new int[n+1][n+1];
        for(int i = 0; i < m; i++) {
            String[] connect = br.readLine().split(" ");
            int x = Integer.parseInt(connect[0]);
            int y = Integer.parseInt(connect[1]);

            computers[x][y] = 1;
            computers[y][x] = 1;            
        }

        System.out.println(bfs(1));
    }

    public static int bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(v);
        visited[v] = true;

        while (!queue.isEmpty()) {
            v = queue.poll();

            for(int i = 1; i <= n; i++) {
                if(computers[v][i] == 1 && !visited[i]) {                    
                    visited[i] = true;
                    queue.offer(i);
                    count++;
                }
            }
        }
        
        return count;
    }
}
