import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Baek_Joon_2346 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        Deque<int[]> deque = new ArrayDeque<>();
        String[] input = br.readLine().split(" ");
        for(int i = 0; i < input.length; i++) {
            int arr[] = {i+1,Integer.parseInt(input[i])};
            deque.offer(arr);
        }

        while(deque.size() > 1) {
            int[] arr = deque.pollFirst();
            sb.append(arr[0]).append(" ");
            int move = arr[1];

            if(move > 0) {
                for(int i = 1; i < move; i++) {
                    deque.offerLast(deque.pollFirst());
                }
            }
            else {
                for(int i = move; i != 0; i++) {
                    deque.offerFirst(deque.pollLast());
                }
            }
        }
        
        sb.append(deque.poll()[0]);
        System.out.println(sb);

    }
}