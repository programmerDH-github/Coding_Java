import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Baek_Joon_11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(Math.abs(o1) == Math.abs(o2)) return o1 - o2;
                return Math.abs(o1) - Math.abs(o2);
            }
        });

        for(int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            if(number == 0) {
                if(priorityQueue.isEmpty()) {
                    sb.append(0).append("\n");
                }
                else {
                    sb.append(priorityQueue.poll()).append("\n");
                }
            }
            else {
                priorityQueue.offer(number);
            }
        }

        System.out.println(sb);

    }
}
