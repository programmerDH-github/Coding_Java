import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Baek_Joon_13913 {
    static int N,K;
    static int[] time = new int[100001];
    static int[] parent = new int[100001];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] N_K = br.readLine().split(" ");
        N = Integer.parseInt(N_K[0]);
        K = Integer.parseInt(N_K[1]);

        bfs(N);

        Stack<Integer> stack = new Stack<>();        
        int idx = K;
        stack.push(idx);
        while(idx != N) {
            stack.push(parent[idx]);
            idx = parent[idx];
        }

        sb.append(time[K]).append("\n");
        
        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }

        System.out.println(sb);

    }

    static void bfs(int N) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);

        while(!queue.isEmpty()) {
            int now = queue.poll();

            if(now == K) return;

            for(int i = 0; i < 3; i++) {
                int next;            
                if(i == 0) next = now + 1;
                else if(i == 1) next = now - 1;
                else next = now * 2;
                
                if(next < 0 || next > 100000) continue;
                
                if(time[next] == 0) {
                    queue.offer(next);
                    time[next] = time[now] + 1;
                    parent[next] = now;
                }
            }

            

        }
    
    }

}
