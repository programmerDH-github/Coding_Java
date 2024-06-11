import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Baek_Joon_1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        String[] A_arr = br.readLine().split(" ");
        String[] B_arr = br.readLine().split(" ");
        int[] A = new int[N];
        Integer[] B = new Integer[N];
        for(int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(A_arr[i]);
            B[i] = Integer.parseInt(B_arr[i]);
        }

        Arrays.sort(A);
        Arrays.sort(B,Collections.reverseOrder());

        int S = 0;
        for(int i = 0; i < N; i++) {
            S += A[i]*B[i];
        }

        System.out.println(S);

    }
}
