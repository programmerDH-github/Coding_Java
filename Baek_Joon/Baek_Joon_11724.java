import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_Joon_11724 {
    static int N, M;
    static int[][] graph;
    static boolean[] visited;
    static int count = 0;
    public static void main(String[] args) throws IOException{        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_M = br.readLine().split(" ");
        N = Integer.parseInt(N_M[0]);
        M = Integer.parseInt(N_M[1]);
       
        graph = new int[N+1][N+1];
        visited = new boolean[N+1];
        for(int i = 0; i < M; i++) {
            String[] u_v = br.readLine().split(" ");
            int u = Integer.parseInt(u_v[0]);
            int v = Integer.parseInt(u_v[1]);

            graph[u][v] = 1;
            graph[v][u] = 1;
        }

        for(int i = 1; i <= N; i++) {
            if(!visited[i]) {
                count++;
                bfs(i);                
            }
        }

        System.out.println(count);

    }

    public static void bfs(int x) {        
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        visited[x] = true;

        while(!queue.isEmpty()) {
            x = queue.poll();
            
            for(int temp = 1; temp <= N; temp++) {
                if(graph[x][temp] == 1 && !visited[temp]) {
                    visited[temp] = true;
                    queue.offer(temp);
                }
            }
            
        }
    }
}
