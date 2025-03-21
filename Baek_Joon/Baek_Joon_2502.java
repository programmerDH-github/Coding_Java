import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Baek_Joon_2502 {
    static int[][] count;
    static int D,K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] D_K = br.readLine().split(" ");
        D = Integer.parseInt(D_K[0]);
        K = Integer.parseInt(D_K[1]);

        count = new int[D+1][3];
        count[1][1] = 1;
        count[2][2] = 1;
        for(int i = 3; i <= D; i++) {
            count[i][1] = count[i-1][1] + count[i-2][1];
            count[i][2] = count[i-1][2] + count[i-2][2];
        }
        
        Queue<Integer> queue = new LinkedList<>();
        int one = 1;
        while(queue.isEmpty()) {            
            int two = one+1;
            int sum = 0;

            while(queue.isEmpty()) {
                sum = one * count[D][1] + two * count[D][2];
                if(sum == K) {
                    queue.offer(one);
                    queue.offer(two);
                    break;
                }
                else if(sum >= K) {
                    break;
                }

                two++;
            }
            one++;
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
        

    }
}
