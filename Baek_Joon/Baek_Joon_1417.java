import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baek_Joon_1417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if(N == 1) {
            System.out.println(0);
            return;
        }

        int target = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> o2-o1);
        for(int i = 0; i < N; i++) {
            if(i == 0) target = Integer.parseInt(br.readLine());
            else pq.offer(Integer.parseInt(br.readLine()));
        }

        int min = 0;
        while(pq.peek() >= target) {
            pq.add(pq.poll()-1);
            target++;
            min++;
        }

        System.out.println(min);

    }
}
