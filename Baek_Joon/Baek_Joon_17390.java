import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek_Joon_17390 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] A_N = br.readLine().split(" ");
        int A = Integer.parseInt(A_N[0]);
        int N = Integer.parseInt(A_N[1]);

        int[] arr = new int[A+1];
        String[] input = br.readLine().split(" ");
        for(int i = 1; i <= A; i++) {
            arr[i] = Integer.parseInt(input[i-1]);
        }
        
        Arrays.sort(arr);

        int[] prefix = new int[A+1];
        for(int i = 1; i <= A; i++) {
            prefix[i] = prefix[i-1] + arr[i];
        }

        for(int i = 0; i < N; i++) {
            String[] L_R = br.readLine().split(" ");
            int L = Integer.parseInt(L_R[0]);
            int R = Integer.parseInt(L_R[1]);

            sb.append(prefix[R]-prefix[L-1]).append("\n");

        }

        System.out.println(sb);

    }
}
