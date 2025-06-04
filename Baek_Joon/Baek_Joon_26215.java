import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Baek_Jook_26215 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < N; i++) pq.add(Integer.parseInt(input[i]));

        int hour = 0;
        while (!pq.isEmpty()) {
            if(pq.size() == 1) {
                hour += pq.poll();
                break;
            }
            
            int first = pq.poll()-1;
            int second = pq.poll()-1;

            hour++;

            if(first > 0) pq.add(first);
            if(second > 0) pq.add(second);
        }

        if(hour > 1440) System.out.println(-1);
        else System.out.println(hour);

    }
}
