import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] K_N = br.readLine().split(" ");
        int K = Integer.parseInt(K_N[0]);
        int N = Integer.parseInt(K_N[1]);

        long left = 1;
        long right = 0;
        long[] cable = new long[K];
        for(int i = 0; i < K; i++) {
            cable[i] = Long.parseLong(br.readLine());
            if(cable[i] > right) right = cable[i];
        }

        while(left <= right) {
            long mid = (left+right) / 2;
            long answer = 0;

            if(mid == 0) {
                right = 0;
                break;
            }

            for(int i = 0; i < K; i++) {
                answer += cable[i] / mid;
            }

            if(answer >= N) left = mid + 1;
            else right = mid - 1;

        }

        System.out.println(right);

    }
}
