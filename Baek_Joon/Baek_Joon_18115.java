import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Baek_Joon_18115 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        Deque<Integer> dq = new LinkedList<>();

        String[] skill = br.readLine().split(" ");
        int[] order = new int[N];
        for(int i = N-1; i >= 0; i--) {
            if(skill[i].equals("1")) {
                dq.offerFirst(N-i);
            }
            else if(skill[i].equals("2")){
                int temp = dq.pollFirst();
                dq.offerFirst(N-i);
                dq.offerFirst(temp);
            }
            else {
                dq.offerLast(N-i);
            }

        }

        while(!dq.isEmpty()) {
            sb.append(dq.pollFirst()).append(" ");
        }

        System.out.println(sb);
        
    }
}
