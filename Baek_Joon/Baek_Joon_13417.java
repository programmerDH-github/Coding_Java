import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Baek_Joon_13417 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
    
        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            String[] alphabet = br.readLine().split(" ");

            Deque<Character> dq = new LinkedList<>();
            for(int j = 0; j < N; j++) {
                
                if(dq.isEmpty()) dq.offer(alphabet[j].charAt(0));
                else {
                    if((int)dq.peekFirst() >= (int)alphabet[j].charAt(0)) {
                        dq.offerFirst(alphabet[j].charAt(0));
                    }
                    else dq.offerLast(alphabet[j].charAt(0));
                }
            }

            while(!dq.isEmpty()) {
                sb.append(dq.poll());
            }
            sb.append("\n");

        }        

        System.out.println(sb);

    }
}
