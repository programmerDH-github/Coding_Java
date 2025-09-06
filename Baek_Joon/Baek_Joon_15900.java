import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_Joon_15900 {
    static ArrayList<ArrayList<Integer>> arraylist = new ArrayList<>();
    static int N;
    static int totalDepth = 0;
    static int[][] map;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i <= N; i++) {
            arraylist.add(new ArrayList<>());
        }

        for(int i = 0; i < N-1; i++) {
            String[] a_b = br.readLine().split(" ");
            int a = Integer.parseInt(a_b[0]);
            int b = Integer.parseInt(a_b[1]);

            arraylist.get(a).add(b);
            arraylist.get(b).add(a);
        }
        
        visited = new boolean[N+1];
        // bfs(1);

        visited[1] = true;
        dfs(1,0);
        
        if(totalDepth % 2 == 0) System.out.println("No");
        else System.out.println("Yes");
    }

    static void dfs(int idx, int depth) {
        boolean checked = false;

        for(int i : arraylist.get(idx)) {
            if(!visited[i]) {
                visited[i] = true;
                checked = true;
                dfs(i, depth+1);
            }
        }

        if(!checked) {
            totalDepth += depth;
        }

    }

    static void bfs(int idx) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(idx, 0));
        visited[idx] = true;

        while(!queue.isEmpty()) {
            boolean checked = false;
            Node node = queue.poll();

            for(int i : arraylist.get(node.idx)) {
                if(!visited[i]) {
                    checked = true;
                    visited[i] = true;
                    queue.offer(new Node(i, node.cost+1));
                }
            }

            if(!checked) {
                totalDepth += node.cost;
            }

        }

        
    }

    static class Node {
        int idx;
        int cost;

        Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }

    }

}
