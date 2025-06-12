import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Beak_Joon_2792 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_M = br.readLine().split(" ");
        int N = Integer.parseInt(N_M[0]);
        int M = Integer.parseInt(N_M[1]);

        int[] jewels = new int[M];
        int max = 0;
        for(int i = 0; i < M; i++) {
            String input = br.readLine();
            jewels[i] = Integer.parseInt(input);
            if(max < jewels[i]) max = jewels[i];           
        }

        int left = 1;
        int right = max;
        int answer = 0;
        while(left <= right) {
            int mid = (left+right)/2;

            int count = 0;
            for(int jewel : jewels) {
                count += jewel / mid;
                if(jewel % mid != 0) count++;
            }

            if(count <= N) {
                answer = mid;
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
            
        }

        System.out.println(answer);

    }
}
