import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Baek_Joon_18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Deque<String> dq = new LinkedList<>();
        for(int i = 0; i < N; i ++) {
            String[] input = br.readLine().split(" ");
            
            if(input[0].equals("push")) {
                dq.offer(input[1]);
            }
            else if(input[0].equals("pop")) {
                if(dq.isEmpty()) {
                    sb.append("-1").append("\n");
                    continue;
                }
                sb.append(dq.pollFirst()).append("\n");
            }
            else if(input[0].equals("size")) {
                sb.append(dq.size()).append("\n");
            }
            else if(input[0].equals("empty")) {
                if(dq.isEmpty()) {
                    sb.append("1").append("\n");
                }
                else {
                    sb.append("0").append("\n");
                }
            }
            else if(input[0].equals("front")) {
                if(dq.isEmpty()) {
                    sb.append("-1").append("\n");
                    continue;
                }
                sb.append(dq.peekFirst()).append("\n");
            }
            else if(input[0].equals("back")) {
                if(dq.isEmpty()) {
                    sb.append("-1").append("\n");
                    continue;
                }
                sb.append(dq.peekLast()).append("\n");
            }

        }
        
        System.out.println(sb);

    }
}
