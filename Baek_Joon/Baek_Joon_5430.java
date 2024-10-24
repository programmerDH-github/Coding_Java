import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Baek_Joon_5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            String order = br.readLine();
            int n = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().split(",");

            Deque<Integer> dq = new ArrayDeque<>();
            if(n == 1) {              
                arr[0] = arr[0].substring(1,arr[0].length()-1);
            }
            else if(n > 1){
                arr[0] = arr[0].substring(1);
                arr[arr.length-1] = arr[arr.length-1].substring(0,arr[arr.length-1].length()-1);
            }

            for(int j = 0; j < n; j++) {
                dq.offer(Integer.parseInt(arr[j]));
            }

            boolean start = true;
            boolean error_check = false;
            for(int j = 0; j < order.length(); j++) {
                if(order.charAt(j) == 'R') {
                    start = !start;
                }
                else {
                    if(dq.isEmpty()){
                        sb.append("error").append("\n");
                        error_check = true;
                        break;
                    }

                    if(start) {
                        dq.pollFirst();
                    }
                    else {
                        dq.pollLast();
                    }

                }

            }

            if(error_check) continue;

            sb.append("[");
            while(!dq.isEmpty()) {
                if(start) sb.append(dq.pollFirst());
                else sb.append(dq.pollLast());

                if(dq.isEmpty()) {
                    break;
                }

                sb.append(",");
            }

            
            sb.append("]");
            sb.append("\n");
        }
        
        System.out.println(sb);

    }
}
