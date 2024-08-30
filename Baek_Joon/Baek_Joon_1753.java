import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Baek_Joon_1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] V_E = br.readLine().split(" ");
        int V = Integer.parseInt(V_E[0]);
        int E = Integer.parseInt(V_E[1]);
        int K = Integer.parseInt(br.readLine());

        ArrayList<Node>[] arraylist = new ArrayList[V+1];
        int[] dp = new int[V+1];
        for(int i = 1; i <= V; i++) {
            arraylist[i] = new ArrayList<>();
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i = 0; i < E; i++) {
            String[] input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            int w = Integer.parseInt(input[2]);

            arraylist[u].add(new Node(v, w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        dp[K] = 0;
        pq.offer(new Node(K, 0));

        while(!pq.isEmpty()) {
            Node now = pq.poll();

            for(int i = 0; i < arraylist[now.end].size(); i++) {
                Node next = arraylist[now.end].get(i);

                if(dp[next.end] > now.weight+next.weight) {
                    dp[next.end] = now.weight+next.weight;
                    pq.offer(new Node(next.end, dp[next.end]));
                }
            }

        }

        for(int i = 1; i <= V; i++) {
            if(dp[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dp[i]);
        }


    }

    static class Node implements Comparable<Node>{
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}
