import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baek_Joon_1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1,o2) -> o2-o1);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1,o2) -> o1-o2);    
        for(int i = 0; i < N; i++) {
            int number = Integer.parseInt(br.readLine());
            if(maxHeap.size() == minHeap.size()) maxHeap.offer(number);
            else minHeap.offer(number);

            if(!maxHeap.isEmpty() && !minHeap.isEmpty()) {
                if(maxHeap.peek() > minHeap.peek()) {
                    int tmp = maxHeap.poll();
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(tmp);
                }
            }

            sb.append(maxHeap.peek()).append("\n");

        }

        System.out.println(sb);

    }
}
