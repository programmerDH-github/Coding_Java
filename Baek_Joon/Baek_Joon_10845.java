import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Baek_Joon_10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < N; i++) {
            String[] order = br.readLine().split(" ");
            if(order[0].equals("push")) {
                dq.add(Integer.parseInt(order[1]));
            }
            else if(order[0].equals("pop")) {
                if(dq.size() == 0) sb.append(-1).append("\n");
                else sb.append(dq.poll()).append("\n");
            }
            else if(order[0].equals("size")) {
                sb.append(dq.size()).append("\n");
            }
            else if(order[0].equals("empty")) {
                if(dq.isEmpty()) sb.append(1).append("\n");
                else sb.append(0).append("\n");
            }
            else if(order[0].equals("front")) {
                if(dq.size() == 0) sb.append(-1).append("\n");
                else sb.append(dq.peekFirst()).append("\n");
            }
            else if(order[0].equals("back")) {
                if(dq.size() == 0) sb.append(-1).append("\n");
                else sb.append(dq.peekLast()).append("\n");
            }
        }

        System.out.println(sb);

    }
}
