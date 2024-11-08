import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int index;
    int cost;

    public Node(int index, int cost) {
        this.index = index;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.cost, o.cost);
    }

}

public class Baek_Joon_1916 {  
    static int N,M,S,E;
    
    static ArrayList<Node>[] graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        for(int i = 0; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int v = Integer.parseInt(input[0]);
            int w = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);

            graph[v].add(new Node(w, c));
        }

        String[] start_end = br.readLine().split(" ");
        S = Integer.parseInt(start_end[0]);
        E = Integer.parseInt(start_end[1]);
        
        System.out.println(Dijkstra(S,E));

    }

    static int Dijkstra(int start, int end) {
        boolean[] check = new boolean[N+1];
        int[] dist = new int[N+1];
        int INF = Integer.MAX_VALUE;

        Arrays.fill(dist, INF);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            if(!check[now.index]) {
                check[now.index] = true;            

                for(Node next : graph[now.index]) {
                    if(!check[next.index] && dist[next.index] > next.cost + now.cost) {
                        dist[next.index] = next.cost + now.cost;
                        pq.offer(new Node(next.index, dist[next.index]));
                    }
                }
            }

        }

        return dist[end];

    }

}
