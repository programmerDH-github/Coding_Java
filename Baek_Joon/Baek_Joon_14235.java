import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Baek_Joon_14235 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            if(input[0].equals("0")) {
                if(pq.isEmpty()) {
                    sb.append(-1).append("\n");
                }
                else {
                    sb.append(pq.poll()).append("\n");
                }

            }
            else {
                int a = Integer.parseInt(input[0]);
                for(int j = 1; j <= a; j++) {
                    pq.add(Integer.parseInt(input[j]));
                }
            }

        }

        System.out.println(sb);

    }
}
