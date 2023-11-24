import java.io.*;
import java.util.*;

public class Baek_Joon_1260 {
    static int N,M,V;
    static int[][] graph;
    static boolean[] visited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_M_V = br.readLine().split(" ");
        N = Integer.parseInt(N_M_V[0]);
        M = Integer.parseInt(N_M_V[1]);
        V = Integer.parseInt(N_M_V[2]);
        graph = new int[N+1][N+1];

        for(int i = 0; i < M; i++) {
            String[] x_y = br.readLine().split(" ");
            int x = Integer.parseInt(x_y[0]);
            int y = Integer.parseInt(x_y[1]);
            graph[x][y] = graph[y][x] = 1;            
        }

        visited = new boolean[N+1];
        dfs(V);
        System.out.println(); 
        visited = new boolean[N+1];
        bfs(V);
    }

    public static void dfs(int start) { 
        visited[start] = true;
        System.out.print(start +" ");

        for(int i = 0; i <= N; i++) {
            if(graph[start][i] == 1 && !visited[i]) {
                dfs(i);                
            }
        }
    }

    public static void bfs(int start) {        
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);

        while(!queue.isEmpty()) {            
            start = queue.poll();            
            System.out.print(start + " ");
            
            for(int i = 0; i <= N; i++) {
                if(graph[start][i] == 1 && !visited[i]) {  
                    visited[i] = true;          
                    queue.add(i);
                }
            }
        }
    }
}
