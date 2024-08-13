import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baek_Joon_1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());

            if(input == 0) {
                if(pq.isEmpty()) {
                    sb.append(0).append("\n");
                }
                else sb.append(pq.poll()).append("\n");
            }
            else {
                pq.offer(input);
            }

        }

        System.out.println(sb);

    }
}
