import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_Joon_12761 {
    static int A,B,N,M;
    static int[] location;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] A_B_N_M = br.readLine().split(" ");
        A = Integer.parseInt(A_B_N_M[0]);
        B = Integer.parseInt(A_B_N_M[1]);
        N = Integer.parseInt(A_B_N_M[2]);
        M = Integer.parseInt(A_B_N_M[3]);

        int[] calculate = {1,-1,A,B,-A,-B,A,B};
        location = new int[100001];
        Arrays.fill(location, Integer.MAX_VALUE);
        bfs(N,calculate);

        System.out.println(location[M]);

    }

    static void bfs(int N, int[] calculate) {
        location[N] = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(N, 0));

        while(!queue.isEmpty()) {
            Node node = queue.poll();

            if(node.location < 0 || node.location > 100000) continue;
            if(node.location == M) {
                if(location[node.location] > M) location[node.location] = M;
                continue;
            }

            for(int i = 0; i < 8; i++) {
                int nextLocation = node.location;
                int nextCost = node.cost + 1;
        
                if(i < 6) {
                    nextLocation += calculate[i];
                }
                else {
                    nextLocation *= calculate[i];
                }

                if(nextLocation == M) {
                    location[M] = Math.min(location[M], nextCost);
                    continue;
                }
                if(nextLocation >= 0 && nextLocation <= 100000 && location[M] > nextCost && location[nextLocation] > nextCost) {
                    location[nextLocation] = nextCost;
                    queue.offer(new Node(nextLocation, nextCost));
                }

            }


        }


    }

    static class Node{
        int location;
        int cost;

        Node(int location, int cost) {
            this.location = location;
            this.cost = cost;
        }
    }

}
