import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Baek_Joon_11497 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        Deque<Integer> dq;

        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            String[] input = br.readLine().split(" ");
            Integer[] tree = new Integer[N];
            for(int j = 0; j < N; j++) {
                tree[j] = Integer.parseInt(input[j]);
            }

            Arrays.sort(tree, (o1,o2) -> o2-o1);

            dq = new LinkedList<>();
            for(int j = 0; j < N; j++) {
                if(j % 2 == 0)dq.offerFirst(tree[j]);
                else dq.offerLast(tree[j]);
            }

            int max = Math.abs(dq.peekFirst()-dq.peekLast());
            while(true) {
                int number = dq.pollFirst();
                
                if(dq.isEmpty()) break;
                max = Math.max(max, Math.abs(dq.peekFirst()-number));

            }
            
            sb.append(max).append("\n");

        }

        System.out.println(sb);

    }
}
