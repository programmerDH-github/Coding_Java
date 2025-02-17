import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baek_Joon_15903 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] n_m = br.readLine().split(" ");
        int n = Integer.parseInt(n_m[0]);
        int m = Integer.parseInt(n_m[1]);
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < n; i++) pq.add(Long.parseLong(input[i]));

        while(m > 0) {
            long first = pq.poll();
            long second = pq.poll();

            pq.add(first+second);
            pq.add(first+second);
            m--;
        }

        long answer = 0;
        while(!pq.isEmpty()) answer += pq.poll();

        System.out.println(answer);

    }
}
