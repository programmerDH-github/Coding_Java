import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Baek_Joon_12845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        String[] input = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(input[i]));
        }

        int max = 0;
        while(pq.size() >= 2) {
            int first = pq.poll();
            int second = pq.poll();
            
            max += first + second;
            
            pq.add(Math.max(first,second));
        }

        System.out.println(max);
        
    }
}
