import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek_Joon_11561 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            long N = Long.parseLong(br.readLine());

            long count = 0;
            long left = 0;
            long right = 1_000_000_000;
            while(left <= right) {
                long mid = (left+right)/2;
                long sum = (mid*(mid+1))/2;

                if(sum <= N) {
                    if(count < mid) count = mid;
                    left = mid+1;
                }
                else right = mid-1;

            }

            sb.append(count).append("\n");

        }

        System.out.println(sb);

    }
}
