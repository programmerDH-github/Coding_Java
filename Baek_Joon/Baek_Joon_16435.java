import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baek_Joon_16435 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_L = br.readLine().split(" ");
        int N = Integer.parseInt(N_L[0]);
        int L = Integer.parseInt(N_L[1]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) {
            pq.offer(Integer.parseInt(input[i]));
        }

        while(!pq.isEmpty()) {
            if(pq.peek() > L) break;
            else {
                pq.poll();
                L++;
            }
        }

        System.out.println(L);

    }
}
