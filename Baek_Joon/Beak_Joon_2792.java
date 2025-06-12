import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Beak_Joon_2792 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_M = br.readLine().split(" ");
        int N = Integer.parseInt(N_M[0]);
        int M = Integer.parseInt(N_M[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2) -> o2 - o1);
        int sum = 0;
        for(int i = 0; i < M; i++) {
            String input = br.readLine();
            pq.offer(Integer.parseInt(input));
            sum += Integer.parseInt(input);            
        }

        System.out.println(sum/N + 1);

    }
}
