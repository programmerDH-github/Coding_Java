import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_Joon_16564 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_K = br.readLine().split(" ");
        int N = Integer.parseInt(N_K[0]);
        int K = Integer.parseInt(N_K[1]);

        int[] level = new int[N];
        for(int i = 0; i < N; i++) {
            level[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(level);

        int answer = 0;
        int left = level[0];
        int right = level[N-1];
        while(left <= right) {
            int mid = (left+right)/2;
            int sum = 0;

            for(int i = 0; i < N; i++) {
                if(level[i] < mid) sum += (mid-level[i]);
            }

            if(sum <= K) {
                answer = mid;
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }

        System.out.println(answer);

    }
}
