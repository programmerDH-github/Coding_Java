import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_Joon_12851 {
    static int[] visited = new int[100001];
    static int count = 0, min = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_K = br.readLine().split(" ");
        int N = Integer.parseInt(N_K[0]);
        int K = Integer.parseInt(N_K[1]);
        
        if(N > K) {
            System.out.println(N-K);
            System.out.println(1);
            return;
        }

        bfs(N,K);
        System.out.println(visited[K]);
        System.out.println(count);

    }

    static void bfs(int N, int K) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);

        min = K-N;
        while(!queue.isEmpty()) {
            int loaction = queue.poll();

            if(loaction == K) {
                if(min >= visited[loaction]) {
                    min = visited[loaction];
                    count++;
                }
            }
            
            for(int i = 0; i < 3; i++) {
                int next = 0;
                if(i == 0) next = loaction + 1;
                else if(i == 1) next = loaction - 1;
                else next = loaction * 2;

                if(next < 0 || next > 100000) continue;

                if(visited[next] == 0 || visited[next] >= visited[loaction]+1) {
                    queue.offer(next);
                    visited[next] = visited[loaction] + 1;
                }

            }
        }
    }
}
