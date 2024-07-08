import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Baek_Joon_1202 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_K = br.readLine().split(" ");
        int N = Integer.parseInt(N_K[0]);
        int K = Integer.parseInt(N_K[1]);

        int[][] jewelries = new int[N][2];
        for(int i = 0; i < N; i++) {    
            String[] str = br.readLine().split(" ");
            jewelries[i][0] = Integer.parseInt(str[0]);
            jewelries[i][1] = Integer.parseInt(str[1]);
        }

        Arrays.sort(jewelries, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o2[0] == o1[0]) return o2[1] - o1[1];
                return o1[0] - o2[0];
            }
        });

        

        
        int[] bag = new int[K];
        for(int i = 0; i < K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bag);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int idx = 0;
        long answer = 0;
        for(int i = 0; i < K; i++) {

            while(idx < N) {
                if(jewelries[idx][0] <= bag[i]) {
                    pq.offer(jewelries[idx][1]);
                    idx++;
                }
                else {
                    break;
                }
            }

            if(!pq.isEmpty()) {
                answer += pq.poll();
            }

        }

        System.out.println(answer);

    }
}
