import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_Joon_13549 {
    static boolean[] visited = new boolean[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_K = br.readLine().split(" ");
        int N = Integer.parseInt(N_K[0]);
        int K = Integer.parseInt(N_K[1]);

        if(N == K) {
            System.out.println(0);
            return;
        }
        if(N > K) {
            System.out.println(N-K);
            return;
        }

        System.out.println(bfs(N,K));

    }

    static int bfs(int N, int K) {
        Queue<int[]> queue = new LinkedList<>();
        
        queue.offer(new int[]{N,0});

        int min = K-N;
        while(!queue.isEmpty()) {
            int[] l_m = queue.poll();
            int location = l_m[0];
            int move = l_m[1];

            if(location == K) {
                if(min > move) min = move;
            }

            for(int i = 0; i < 3; i++) {
                int next = location;

                if(i == 0) next += 1;
                else if(i == 1) next -= 1;                
                else next *= 2;
                
                if(next >= 0 && next <= 100000) {
                    if(!visited[next]) {
                        visited[next] = true;
                        if(i == 2) queue.offer(new int[]{next,move});
                        else queue.offer(new int[]{next,move+1});
                    }
                }

            }
        }

        return min;

    }

}
