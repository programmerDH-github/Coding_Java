import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Baek_Joon_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] N_M = br.readLine().split(" ");
        int N = Integer.parseInt(N_M[0]);
        int M = Integer.parseInt(N_M[1]);

        String[] input = br.readLine().split(" ");
        Integer[] trees = new Integer[N];
        for(int i = 0; i < N; i++) {
            trees[i] = Integer.parseInt(input[i]);
        }
        
        Arrays.sort(trees, Collections.reverseOrder());

        int left = 0;
        int right = trees[0];

        while(left <= right) {
            int mid = (left+right) / 2;
            long answer = 0;
            for(int i = 0; i < N; i++) {
                if(trees[i] <= mid) break;
                answer += trees[i] - mid;
            }

            if(answer >= M) left = mid + 1;
            else right = mid - 1;

        }

        System.out.println(right);

    }
}
