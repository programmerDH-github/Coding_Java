import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Baek_Joon_5052 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());

            PriorityQueue<String> pq = new PriorityQueue<>();
            String[] nubmers = new String[n];
            for(int j = 0; j < n; j++) {
                nubmers[j] = br.readLine();
                // pq.offer(br.readLine());
            }

            Arrays.sort(nubmers);

            boolean consistency = true;
            for(int j = 0; j < nubmers.length-1; j++) {
                if(nubmers[j+1].startsWith(nubmers[j])) {
                    consistency = false;
                    break;
                }
            }

            if(consistency) {
                sb.append("YES").append("\n");
            }
            else sb.append("NO").append("\n");

        }

        System.out.println(sb);
    
    }
}
