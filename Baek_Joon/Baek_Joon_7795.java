import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Baek_Joon_7795 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {
            String[] N_M = br.readLine().split(" ");
            int N = Integer.parseInt(N_M[0]);
            int M = Integer.parseInt(N_M[1]);

            String[] A_arr = br.readLine().split(" ");
            Integer[] A = new Integer[N];
            for(int j = 0; j < N; j++) {
                A[j] = Integer.parseInt(A_arr[j]);
            }
            Arrays.sort(A, Collections.reverseOrder());

            String[] B_arr = br.readLine().split(" ");
            Integer[] B = new Integer[M];
            for(int j = 0; j < M; j++) {
                B[j] = Integer.parseInt(B_arr[j]);
            }
            Arrays.sort(B);

            int count = 0;
            for(int j = 0; j < A.length; j++) {
                if(A[j] <= B[0]) break;

                int start = 0;
                int end = B.length - 1;
                int index = 0;
                while(start <= end) {
                    int mid = (start + end)/2;

                    if(B[mid] < A[j]) {
                        start = mid + 1;
                        index = mid + 1;
                    }
                    else {
                        end = mid - 1;
                    }
                }
                count += index;
            }

            sb.append(count).append("\n");

        }

        System.out.println(sb);

    }
}
